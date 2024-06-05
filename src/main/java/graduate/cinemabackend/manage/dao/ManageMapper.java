package graduate.cinemabackend.manage.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ManageMapper {
    // 문의사항 답변
    int answerQna(Map<String, Object> reqMap);
    // 공지사항 쓰기
    int createNoti(Map<String, Object> reqMap);
    // 공지사항 삭제
    int deleteNoti(Map<String, Object> reqMap);
    // 리뷰 삭제
    int manageReview(Map<String, Object> reqMap);
}
