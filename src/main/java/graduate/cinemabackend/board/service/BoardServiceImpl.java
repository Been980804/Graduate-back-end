package graduate.cinemabackend.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import graduate.cinemabackend.board.dao.BoardMapper;
import graduate.cinemabackend.common.dto.ResponseDTO;

@Service
public class BoardServiceImpl implements BoardService{
    
    @Autowired
    BoardMapper boardMapper;

    @Override
    @Transactional
    public ResponseDTO notiList() {
        ResponseDTO res = new ResponseDTO();

        List<Map<String, Object>> notiList = boardMapper.notiList();

        if(!notiList.isEmpty()){
            res.setResCode(200);
            res.setResMsg("공지사항 목록 가져오기 성공");
            res.setData("notiList", notiList);
        } else{
            res.setResCode(300);
            res.setResMsg("공지사항 목록 가져오기 실패");
        }
        return res;
    }
}
