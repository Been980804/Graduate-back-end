package graduate.cinemabackend.common.service;

import org.springframework.stereotype.Service;

import graduate.cinemabackend.common.dto.ResponseDTO;

@Service
public interface CommonService {
    // 영화 db 크롤링
    ResponseDTO movieCrawling();
    //  Header 검색기능
    ResponseDTO search(String search);
    // 최신 공지사항 목록 가져오기
    ResponseDTO currentNoti();
}
