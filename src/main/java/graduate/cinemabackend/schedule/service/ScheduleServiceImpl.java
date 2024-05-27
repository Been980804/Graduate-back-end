package graduate.cinemabackend.schedule.service;

import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import graduate.cinemabackend.common.dto.ResponseDTO;
import graduate.cinemabackend.schedule.dao.ScheduleMapper;

@Service
public class ScheduleServiceImpl implements ScheduleService{
    
    @Autowired
    ScheduleMapper scheduleMapper;

    @Override
    @Transactional
    public ResponseDTO compare(Map<String, Object> reqMap) {
        ResponseDTO res = new ResponseDTO();

        List<Map<String, Object>> scheduleList = scheduleMapper.compare(reqMap);

        if(!scheduleList.isEmpty()){
            res.setResCode(200);
            res.setResMsg("영화 스케쥴 조회 성공");
            res.setData("scheduleList", scheduleList);
        } else{
            res.setResCode(300);
            res.setResMsg("영화 스케쥴 조회 실패");
        }

        return res;
    }
}
