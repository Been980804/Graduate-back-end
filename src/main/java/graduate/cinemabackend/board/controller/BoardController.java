package graduate.cinemabackend.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import graduate.cinemabackend.board.service.BoardService;
import graduate.cinemabackend.common.dto.ResponseDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/board")
public class BoardController {
    
    @Autowired
    BoardService boardService;

    // @GetMapping(value="/notiList")
    // public ResponseDTO notiList() {
    //     ResponseDTO res = boardService.notiList();

    //     return res;
    // }
    
}
