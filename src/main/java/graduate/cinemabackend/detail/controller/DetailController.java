package graduate.cinemabackend.detail.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import graduate.cinemabackend.common.dto.ResponseDTO;
import graduate.cinemabackend.detail.service.DetailService;

@RestController
@RequestMapping("/detail")
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
    
    // 영화 리뷰작성
    @PostMapping(value="/createReview")
    public ResponseDTO createReview(@RequestBody Map<String, Object> reqMap) { // mov_no, mem_no
        ResponseDTO res= detailService.createReview(reqMap);
        
        return res;
    }
    
    // 영화 좋아요
    @PostMapping(value="/likeMovie")
    public ResponseDTO likeMovie(@RequestBody Map<String, Object> reqMap) { // mov_no, mem_no
        ResponseDTO res = detailService.likeMovie(reqMap);
        
        return res;
    }
    
}
