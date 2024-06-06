package graduate.cinemabackend.schedule.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ScheduleMapper {
    // 영화 스케줄 가져오기
    List<Map<String, Object>> compare(Map<String, Object> reqMap);
}
