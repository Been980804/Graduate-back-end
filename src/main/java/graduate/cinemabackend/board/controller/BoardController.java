package graduate.cinemabackend.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import graduate.cinemabackend.board.service.BoardService;
import graduate.cinemabackend.common.dto.ResponseDTO;



@RestController
@RequestMapping("/board")
public class BoardController {
    
    @Autowired
    BoardService boardService;

    @GetMapping(value="/notiList")
    public ResponseDTO notiList() { // 공지사항 목록
        ResponseDTO res = boardService.notiList();

        return res;
    }
    
    @GetMapping(value="/qnaList")
    public ResponseDTO getMethodName() { // 문의사항 목록
        ResponseDTO res = boardService.qnaList();

        return res;
    }
    
}
