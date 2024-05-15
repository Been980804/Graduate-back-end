package graduate.cinemabackend.main.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MainMapper {

    // 영화리스트 가져오기
    List<Map<String, Object>> getMovieList();
}
