package graduate.cinemabackend.manage.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import graduate.cinemabackend.common.dto.ResponseDTO;
import graduate.cinemabackend.manage.service.ManageService;

@RestController
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    ManageService manageService;

    @PostMapping(value="/answerQna")
    public ResponseDTO answerQna(@RequestBody Map<String, Object> reqMap) { // 문의사항 답변
        ResponseDTO res = manageService.answerQna(reqMap);
                
        return res;
    }

    @PostMapping(value="/createNoti")
    public ResponseDTO createNoti(@RequestBody Map<String, Object> reqMap) { // 공지사항 쓰기
        ResponseDTO res = manageService.createNoti(reqMap);
        
        return res;
    }
    
    @PostMapping(value="/deleteNoti")
    public ResponseDTO postMethodName(@RequestBody Map<String, Object> reqMap) { // 공지사항 삭제
        ResponseDTO res = manageService.deleteNoti(reqMap);

        return res;
    }
    
    @PostMapping(value="/manageReview")
    public ResponseDTO manageReview(@RequestBody Map<String, Object> reqMap){ // 관리자 리뷰 삭제
        ResponseDTO res = manageService.manageReview(reqMap);

        return res;
    }
}
