package graduate.cinemabackend.main.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import graduate.cinemabackend.common.dto.ResponseDTO;
import graduate.cinemabackend.main.dao.MainMapper;

@Service
public class MainServiceImpl implements MainService {

    @Autowired
    MainMapper mainMapper;

    @Override
    @Transactional
    public ResponseDTO getPosterURL() {
        ResponseDTO res = new ResponseDTO();

        List<Map<String, Object>> posterURLList = mainMapper.getPosterURL();

        if(!posterURLList.isEmpty()){
            res.setResCode(200);
            res.setResMsg("배너 가져오기 성공");
            res.setData("posterURLList", posterURLList);
        }else{
            res.setResCode(300);
            res.setResMsg("배너 가져오기 실패");
        }

        return res;
    }

    @Override
    @Transactional
    public ResponseDTO getTheaterList() {
        ResponseDTO res = new ResponseDTO();

        List<Map<String, Object>> theaterList = mainMapper.getTheaterList();

        if (!theaterList.isEmpty()) {
            res.setResCode(200);
            res.setResMsg("극장리스트 불러오기 성공");
            res.setData("theaterList", theaterList);
        } else {
            res.setResCode(300);
            res.setResMsg("극장리스트 불러오기 실패");
        }

        return res;
    }
}
