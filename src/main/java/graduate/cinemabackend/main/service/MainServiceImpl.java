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
    public ResponseDTO screening() {
        ResponseDTO res = new ResponseDTO();

        List<Map<String, Object>> screeningList = mainMapper.screening();

        if(!screeningList.isEmpty()){
            res.setResCode(200);
            res.setResMsg("현재상영중인 영화 조회 성공");
            res.setData("screeningList", screeningList);
        } else{
            res.setResCode(300);
            res.setResMsg("현재상영중인 영화 조회 실패");
        }
        return res;
    }

    @Override
    @Transactional
    public ResponseDTO toBeScreened() {
        ResponseDTO res = new ResponseDTO();

        List<Map<String, Object>> toBeScreenedList = mainMapper.toBeScreened();

        if(!toBeScreenedList.isEmpty()){
            res.setResCode(200);
            res.setResMsg("상영예정작 조회 성공");
            res.setData("toBeScreenedList", toBeScreenedList);
        } else{
            res.setResCode(300);
            res.setResMsg("상영예정작 조회 실패");
        }

        return res;
    }
}
