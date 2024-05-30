package graduate.cinemabackend.common.service;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import graduate.cinemabackend.common.dao.CommonMapper;
import graduate.cinemabackend.common.dto.ResponseDTO;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    CommonMapper commonMapper;

    @Value("${app.cgv.url}")
    private String cgvURL;

    @Value("${app.cgv.detail.url}")
    private String getDetailURL;

    private String goDetailURL;

    @Override
    @Transactional
    public ResponseDTO movieCrawling() { // 영화데이터 크롤링 이후 DB에 저장
        try {
            ResponseDTO res = new ResponseDTO();
            List<Map<String, Object>> movieList = new ArrayList<>(); // 추후 삭제(확인용)
            try {
                Document cgvDoc = Jsoup.connect(cgvURL).get();

                Elements movieInfo = cgvDoc.getElementsByClass("box-image");
                for (int i = 0; i < movieInfo.size(); i++) {
                    Map<String, Object> movieMap = new HashMap<>();
                    // 영화 순위
                    String rankString = movieInfo.get(i).getElementsByClass("rank").text().substring(3);
                    int rank = Integer.parseInt(rankString);
                    movieMap.put("mov_rank", rank);
                    // 영화 제목(국문), 포스터URL
                    Elements titleAndPosterURLs = movieInfo.get(i).getElementsByClass("thumb-image");
                    for (Element titleAndPosterURL : titleAndPosterURLs) {
                        Element titleAndPosterURLInfo = titleAndPosterURL.getElementsByTag("img").get(0);
                        String title = titleAndPosterURLInfo.attr("alt").substring(0,
                                titleAndPosterURLInfo.attr("alt").length() - 4);
                        String posterURL = titleAndPosterURLInfo.attr("src");

                        movieMap.put("mov_title", title);
                        movieMap.put("mov_posterURL", posterURL);
                    }
                    // 상세정보 URL
                    Elements detailURLs = movieInfo.get(i).getElementsByTag("a");
                    for (Element detailURL : detailURLs) {
                        String href = detailURL.attr("href");
                        goDetailURL = getDetailURL + href;
                        break;
                    }

                    // 상세보기 view로 이동
                    Document detailDoc = Jsoup.connect(goDetailURL).get();

                    // 영화 제목(영문), 상영 상태, 개봉 예정일
                    Elements stateAndDdays = detailDoc.getElementsByClass("box-contents");
                    for (Element stateAndDday : stateAndDdays) {
                        String titleEng = detailDoc.getElementsByTag("p").get(0).text();
                        movieMap.put("mov_titleEng", titleEng);

                        Elements states = stateAndDday.getElementsByClass("round");
                        int stateInt = 0;
                        String dday = "";

                        for (Element state : states) {
                            String stateInfo = state.text();

                            if (stateInfo.contains("예매중")) {
                                stateInt = 2; // 상영 예정작
                            } else if (stateInfo.matches("D-\\d+")) {
                                dday = stateInfo;
                            } else {
                                stateInt = 1; // 상영중
                            }

                            movieMap.put("mov_state", stateInt);
                            movieMap.put("mov_dday", dday);
                        }
                    }

                    // 감독, 배우, 장르, 기본정보, 개봉일
                    Elements detailInfos = detailDoc.getElementsByClass("spec");
                    for (Element detailInfo : detailInfos) {
                        Elements directors = detailInfo.getElementsByTag("dd");
                        for (Element director : directors) {
                            String directorNm = director.getElementsByTag("a").text();
                            movieMap.put("mov_director", directorNm);   // 감독명 구분을 위한 , 추가 
                            break;
                        }

                        Elements ons = detailInfo.getElementsByClass("on");

                        String actorNm = ons.get(0).text();
                        String[] basicInfo = ons.get(1).text().split(",", 3);
                        String openDate = ons.get(2).text();

                        movieMap.put("mov_actor", actorNm);
                        movieMap.put("mov_date", openDate);

                        String nation = basicInfo[2].trim();
                        String runtime = basicInfo[1].trim();
                        String rating = basicInfo[0].trim();

                        movieMap.put("mov_nation", nation);
                        movieMap.put("mov_runtime", runtime);
                        movieMap.put("mov_rating", rating);

                        Elements dts = detailInfo.getElementsByTag("dt");
                        String genre = "";
                        for (Element dt : dts) {
                            String dtText = dt.text();
                            if (dtText.contains("장르 :")) {
                                genre = dtText.replace("장르 :", "").trim();
                                movieMap.put("mov_genre", genre);
                            }
                        }
                    }

                    String intro = detailDoc.getElementsByClass("sect-story-movie").text();
                    movieMap.put("mov_intro", intro);

                    movieList.add(movieMap); // 추후 삭제(확인용)

                    boolean checkMovieExist = commonMapper.checkMovieExist((String) movieMap.get("mov_title"));
                    if (checkMovieExist) {
                        commonMapper.updateMovie(movieMap);

                        res.setResCode(200);
                        res.setResMsg("크롤링 데이터 DB update 성공");
                        res.setData("movieList", movieList);

                    } else {
                        commonMapper.insertMovie(movieMap);

                        res.setResCode(200);
                        res.setResMsg("크롤링 데이터 insert 성공");
                        res.setData("movieList", movieList);

                    }
                }

                return res;
            } catch (Exception e) {
                e.printStackTrace();
                res.setResCode(300);
                res.setResMsg("크롤링 데이터 DB삽입 실패");
                return res;
            }

        } catch (DataIntegrityViolationException e) {
            ResponseDTO res = new ResponseDTO();
            res.setResCode(500);
            res.setResMsg("이미 존재하는 영화정보 입니다.");
            return res;
        }
    }

    @Override
    @Transactional
    public ResponseDTO search(String search) { // Header 검색
        ResponseDTO res = new ResponseDTO();

        List<Map<String, Object>> searchList = commonMapper.search(search);
        
        if(!searchList.isEmpty()){
            res.setResCode(200);
            res.setResMsg("검색 성공");
            res.setData("searchList", searchList);
        } else{
            res.setResCode(300);
            res.setResMsg("검색 실패");
        }

        return res;
    }

    // footer 공지사항 목록
    @Override
    @Transactional
    public ResponseDTO currentNoti() {
        ResponseDTO res = new ResponseDTO();
        
        List<Map<String, Object>> notiList = commonMapper.currentNoti();

        if(!notiList.isEmpty()){
            res.setResCode(200);
            res.setResMsg("최신 공지사항 목록 가져오기 성공");
            res.setData("notiList", notiList);
        } else{
            res.setResCode(300);
            res.setResMsg("최신 공지사항 목록 가져오기 실패");
        }

        return res;
    }
}
