package graduate.cinemabackend.detail.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DetailMapper {
    // 영화 상세정보 가져오기
    Map<String, Object> getDetailInfo(String mov_no);
    // 영화 리뷰 가져오기
    List<Map<String, Object>> getReview(String mov_no);
    // 리뷰 작성
    int createReview(Map<String, Object> reqMap);
    // 리뷰 삭제
    int deleteReview(Map<String, Object> reqMap);
    // 좋아요 유무체크
    boolean checkLike(Map<String, Object> reqMap);
    // 좋아요 취소
    int deleteLike(Map<String, Object> reqMap);
    // 좋아요 삽입
    int insertLike(Map<String, Object> reqMap);

}
