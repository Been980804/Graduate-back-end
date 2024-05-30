package graduate.cinemabackend.board.service;

import org.springframework.stereotype.Service;

import graduate.cinemabackend.common.dto.ResponseDTO;

@Service
public interface BoardService {
    // 공지사항 목록
    ResponseDTO notiList();
    // 문의사항 목록
    ResponseDTO qnaList();
}
