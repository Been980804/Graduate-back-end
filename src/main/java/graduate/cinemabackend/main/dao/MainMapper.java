package graduate.cinemabackend.main.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MainMapper {
    // 포스터URL 가져오기
    List<Map<String, Object>> getPosterURL();
    // 현재상영중인 영화 가져오기
    List<Map<String, Object>> screening();
    // 상영예정작 가져오기
    List<Map<String, Object>> toBeScreened();
}
