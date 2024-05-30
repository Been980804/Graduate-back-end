package graduate.cinemabackend.manage.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import graduate.cinemabackend.common.dto.ResponseDTO;
import graduate.cinemabackend.manage.service.ManageService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    ManageService manageService;

    @PostMapping(value="/answerQna")
    public ResponseDTO answerQna(@RequestBody Map<String, Object> reqMap, HttpServletRequest httpServletRequest) { // 문의사항 답변
        ResponseDTO res = manageService.answerQna(reqMap, httpServletRequest);
                
        return res;
    }

    @PostMapping("/createNoti")
    public ResponseDTO createNoti(@RequestBody Map<String, Object> reqMap, HttpServletRequest httpServletRequest) { // 공지사항 쓰기
        ResponseDTO res = manageService.createNoti(reqMap, httpServletRequest);
        
        return res;
    }
    
    @PostMapping("/manageReview")
    public ResponseDTO manageReview(@PathVariable("rev_no") String rev_no){ // 관리자 리뷰 삭제
        ResponseDTO res = manageService.manageReview(rev_no);

        return res;
    }
}
