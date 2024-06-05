package graduate.cinemabackend.manage.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import graduate.cinemabackend.common.dto.ResponseDTO;

@Service
public interface ManageService {
    // 문의사항 답변
    ResponseDTO answerQna(Map<String, Object> reqMap);
    // 공지사항 쓰기
    ResponseDTO createNoti(Map<String, Object> reqMap);
    // 공지사항 삭제
    ResponseDTO deleteNoti(String noti_no);
    // 리뷰 삭제
    ResponseDTO manageReview(String rev_no);
}
