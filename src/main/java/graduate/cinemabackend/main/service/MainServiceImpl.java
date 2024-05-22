package graduate.cinemabackend.main.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import graduate.cinemabackend.common.dto.ResponseDTO;
import graduate.cinemabackend.main.dao.MainMapper;
import graduate.cinemabackend.main.dto.MovieDTO;

@Service
public class MainServiceImpl implements MainService {

    @Autowired
    MainMapper mainMapper;

    @Value("${app.cinema.key}")
    private String key;

    @Value("${app.cinema.boxoffice.url}")
    private String boxOfficeURL;

    @Value("${app.cinema.detail.url}")
    private String detailURL;

    LocalDate yesterday = LocalDate.now().minusDays(1);
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
    String date = yesterday.format(format);

    String boxOffice_result = "";
    String detail_result = "";

    @Override
    @Transactional
    public ResponseDTO getMovieApi() { // api 불러오기 
        ResponseDTO res = new ResponseDTO();
       
        List<MovieDTO> dtoList = new ArrayList<>();
        try {

            URL boxOfficeUrl = new URL(boxOfficeURL + "?key=" + key + "&targetDt=" + date);

            BufferedReader boxOffice_bf;

            boxOffice_bf = new BufferedReader(new InputStreamReader(boxOfficeUrl.openStream(), "UTF-8"));

            boxOffice_result = boxOffice_bf.readLine();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(boxOffice_result);

            JSONObject boxOfficeResult = (JSONObject) jsonObject.get("boxOfficeResult");

            JSONArray dailyBoxOfficeList = (JSONArray) boxOfficeResult.get("dailyBoxOfficeList");

            for (Object movie : dailyBoxOfficeList) {
                MovieDTO dto = new MovieDTO();
                JSONObject movieList = (JSONObject) movie;

                URL detailUrl = new URL(detailURL + "?key=" + key + "&movieCd=" + movieList.get("movieCd"));

                BufferedReader detail_bf = new BufferedReader(new InputStreamReader(detailUrl.openStream(), "UTF-8"));

                String detail_result = detail_bf.readLine();

                JSONObject movieDetailJSON = (JSONObject) jsonParser.parse(detail_result);
                JSONObject movieInfoResult = (JSONObject) movieDetailJSON.get("movieInfoResult");
                JSONObject movieInfo = (JSONObject) movieInfoResult.get("movieInfo");

                JSONArray directors = (JSONArray) movieInfo.get("directors");
                JSONArray actors = (JSONArray) movieInfo.get("actors");
                JSONArray nations = (JSONArray) movieInfo.get("nations");
                JSONArray companys = (JSONArray) movieInfo.get("companys");
                JSONArray audits = (JSONArray) movieInfo.get("audits");
                JSONArray genres = (JSONArray) movieInfo.get("genres");

                dto.setMov_rank(movieList.get("rank"));
                dto.setMov_title( movieList.get("movieNm"));
                dto.setMov_titleEng( movieInfo.get("movieNmEn"));
                if (!directors.isEmpty()) {
                    JSONObject director = (JSONObject) directors.get(0);
                    dto.setMov_director( director.get("peopleNm"));
                }
                if (!actors.isEmpty()) {
                    String actorsName = "";
                    int cnt = 0; // 최대 6명의 배우만 출력
                    for (Object actor : actors) {
                        if (cnt < 7) {
                            JSONObject actorNm = (JSONObject) actor;
                            cnt++;
                            actorsName += (actorNm.get("peopleNm") + " ");
                        } else {
                            dto.setMov_actor(actorsName);
                            break;
                        }
                        dto.setMov_actor(actorsName);
                    }
                }
                dto.setMov_date(movieInfo.get("openDt"));
                dto.setMov_state(movieInfo.get("prdtStatNm"));
                if(!nations.isEmpty()){
					JSONObject nation = (JSONObject) nations.get(0);
                    dto.setMov_nation(nation.get("nationNm"));
                }
                if(!companys.isEmpty()){
                    JSONObject company = (JSONObject) companys.get(0);
                    dto.setMov_company(company.get("companyNm"));
                }
                dto.setMov_runtime(movieInfo.get("showTm"));
                if(!audits.isEmpty()){
					JSONObject audit = (JSONObject) audits.get(0);
                    dto.setMov_rating(audit.get("watchGradeNm"));
                }
                if(!genres.isEmpty()){
                    String genreList = "";
                    for(Object genre : genres){
                        JSONObject genreInfo = (JSONObject) genre;
                        genreList += (genreInfo.get("genreNm") + " ");
                    }
                    dto.setMov_genre(genreList);
                }
                dtoList.add(dto);
            }

            res.setResCode(200);
            res.setResMsg("영화정보 불러오기");
            res.setData("movieList", dtoList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            res.setResCode(300);
            res.setResMsg("영화정보 불러오기 실패");
        }
        return res;
    }

    @Override
    @Transactional
    public ResponseDTO getTheaterList() {
        ResponseDTO res = new ResponseDTO();

        List<Map<String, Object>> theaterList = mainMapper.getTheaterList();

        if (theaterList != null) {
            res.setResCode(200);
            res.setResMsg("극장리스트 불러오기 성공");
            res.setData("theaterList", theaterList);
        } else {
            res.setResCode(300);
            res.setResMsg("극장리스트 불러오기 실패");
        }

        return res;
    }
}
