package graduate.cinemabackend.board.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import graduate.cinemabackend.common.dto.ResponseDTO;
import jakarta.servlet.http.HttpServletRequest;

@Service
public interface BoardService {
    // 공지사항 목록
    ResponseDTO notiList();
    // 공지사항 상세보기
    ResponseDTO detailNoti(String noti_no);
    // 문의사항 목록
    ResponseDTO qnaList();
    // 문의사항 상세보기
    ResponseDTO detailQna(String qna_no);
    // 문의사항 등록
    ResponseDTO createQna(Map<String, Object> reqMap, HttpServletRequest httpServletRequest);
}
