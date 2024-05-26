package graduate.cinemabackend.detail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import graduate.cinemabackend.common.dto.ResponseDTO;
import graduate.cinemabackend.detail.service.DetailService;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/detail")
@CrossOrigin
public class DetailController {
    
    @Autowired
    DetailService detailService;

    // 영화 상세정보 가져오기
    @GetMapping(value="/getDetailInfo/{mov_no}")
    public ResponseDTO getDetailInfo(@PathVariable("mov_no") String mov_no) {
        ResponseDTO res = detailService.getDetailInfo(mov_no);

        return res;
    }
    
    // 영화 리뷰정보 가져오기
    @GetMapping(value="/getReview/{mov_no}")
    public ResponseDTO getReview(@PathVariable("mov_no") String mov_no) {
        ResponseDTO res = detailService.getReview(mov_no);

        return res;
    }
    
}
