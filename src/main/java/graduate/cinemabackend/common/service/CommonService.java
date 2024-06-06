package graduate.cinemabackend.common.service;

import org.springframework.stereotype.Service;

import graduate.cinemabackend.common.dto.ResponseDTO;

@Service
public interface CommonService {
    // 영화 db 크롤링
    ResponseDTO movieCrawling();

    // Header 검색기능
    ResponseDTO search(String search);

    // footer 공지사항 목록
    ResponseDTO currentNoti();

    // footer 문의사항 목록
    ResponseDTO currentQna();
}
