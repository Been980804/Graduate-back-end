package graduate.cinemabackend.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import graduate.cinemabackend.common.dto.ResponseDTO;
import graduate.cinemabackend.common.service.CommonService;



@RestController
@RequestMapping("/common")
public class CommonController { //공통으로 처리할거

    @Autowired
    CommonService commonService;

    @GetMapping(value="/crawling") // 크롤링으로 영화 정보 DB에 넣기
    // @Scheduled(cron = "0 0 10 * * ?") // 매일 아침 10시에 자동으로 실행
    public ResponseDTO movieCrawling() {
       ResponseDTO res = commonService.movieCrawling();

       return res;
    }
    
    @GetMapping(value="/search/{search}") // header 검색 기능
    public ResponseDTO search(@PathVariable("search") String search) {
        ResponseDTO res = commonService.search(search);

        return res;
    }
    
    @GetMapping(value="/currentNoti")
    public ResponseDTO currentNoti() { // footer 공지사항 목록
        ResponseDTO res = commonService.currentNoti();

        return res;
    }
    
    @GetMapping(value="/currentQna")
    public ResponseDTO currentQna() { // footer 문의사항 목록
        ResponseDTO res = commonService.currentQna();

        return res;
    }
    
}
