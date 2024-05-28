package graduate.cinemabackend.schedule.service;

import java.util.Map;


import org.springframework.stereotype.Service;

import graduate.cinemabackend.common.dto.ResponseDTO;

@Service
public interface ScheduleService {
    // 영화 시간표 비교
    ResponseDTO compare(Map<String, Object> reqMap);
}
