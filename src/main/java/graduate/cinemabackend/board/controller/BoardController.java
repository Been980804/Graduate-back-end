package graduate.cinemabackend.board.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import graduate.cinemabackend.board.service.BoardService;
import graduate.cinemabackend.common.dto.ResponseDTO;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping(value = "/notiList")
    public ResponseDTO notiList() { // 공지사항 목록
        ResponseDTO res = boardService.notiList();

        return res;
    }

    @GetMapping(value = "/detailNoti/{noti_no}")
    public ResponseDTO detailNoti(@PathVariable("noti_no") String noti_no) { // 공지사항 상세보기
        ResponseDTO res = boardService.detailNoti(noti_no);

        return res;
    }

    @GetMapping(value = "/qnaList")
    public ResponseDTO getMethodName() { // 문의사항 목록
        ResponseDTO res = boardService.qnaList();

        return res;
    }

    @GetMapping(value = "/detailQna/{qna_no}")
    public ResponseDTO detailQna(@PathVariable("qna_no") String qna_no) { // 문의사항 상세보기
        ResponseDTO res = boardService.detailQna(qna_no);

        return res;
    }

    @PostMapping(value = "/createQna")
    public ResponseDTO createQna(@RequestBody Map<String, Object> reqMap) { // 문의사항 등록하기
        ResponseDTO res = boardService.createQna(reqMap);

        return res;
    }

    @PostMapping(value = "deleteQna")
    public ResponseDTO deleteQna(@RequestBody Map<String, Object> reqMap) { // 문의사항 삭제
        ResponseDTO res = boardService.deleteQna(reqMap);

        return res;
    }

}
