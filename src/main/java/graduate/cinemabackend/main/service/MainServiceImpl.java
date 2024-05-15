package graduate.cinemabackend.main.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import graduate.cinemabackend.common.dto.ResponseDTO;
import graduate.cinemabackend.main.dao.MainMapper;

@Service
public class MainServiceImpl implements MainService{
    
    @Autowired
    MainMapper mainMapper;

    @Override
    @Transactional
    public ResponseDTO getMovieList() {
        ResponseDTO res = new ResponseDTO();

        List<Map<String, Object>> movieList = mainMapper.getMovieList();

        if(movieList != null){
            res.setResCode(200);
            res.setResMsg("영화리스트 불러오기 성공");
            res.setData("movieList", movieList);
        } else{
            res.setResCode(300);
            res.setResMsg("영화리스트 불러오기 실패");
        }
        return res;
    }
}
