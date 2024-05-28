package graduate.cinemabackend.schedule.controller;

import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import graduate.cinemabackend.common.dto.ResponseDTO;
import graduate.cinemabackend.schedule.service.ScheduleService;



@CrossOrigin
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    
    @Autowired
    ScheduleService scheduleService;
    
    //영화 스케줄 비교 - test
    // http://localhost:8080/schedule/compare/mov0000002/2024-05-29/부평구
    @GetMapping(value="/compare/{mov_no}/{sch_date}/{th_region}")
    public ResponseDTO compare(@PathVariable("mov_no") String mov_no, 
                                @PathVariable("sch_date") String sch_date,
                                @PathVariable("th_region") String th_region) {
        Map<String, Object> reqMap = new HashMap<>();
        reqMap.put("mov_no", mov_no);
        reqMap.put("sch_date", sch_date);
        reqMap.put("th_region", th_region);

        ResponseDTO res = scheduleService.compare(reqMap);

        return res;
    }
    
}
