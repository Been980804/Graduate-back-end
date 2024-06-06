package graduate.cinemabackend.detail.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import graduate.cinemabackend.common.dto.ResponseDTO;

@Service
public interface DetailService {
    // 영화 상세정보 가져오기
    ResponseDTO getDetailInfo(String mov_no);

    // 영화 리뷰 가져오기
    ResponseDTO getReview(String mov_no);

    // 영화 리뷰 작성
    ResponseDTO createReview(Map<String, Object> reqMap);

    // 영화 리뷰 삭제
    ResponseDTO deleteReview(Map<String, Object> reqMap);

    // 영화 좋아요
    ResponseDTO likeMovie(Map<String, Object> reqMap);
}
