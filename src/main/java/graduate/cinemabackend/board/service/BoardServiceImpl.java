package graduate.cinemabackend.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import graduate.cinemabackend.board.dao.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
    
    @Autowired
    BoardMapper boardMapper;
}
