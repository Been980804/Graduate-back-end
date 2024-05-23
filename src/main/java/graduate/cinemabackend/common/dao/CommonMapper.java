package graduate.cinemabackend.common.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CommonMapper {
    // 영화 제목으로 DB 유무 체크
    boolean checkMovieExist(@Param("mov_title") String mov_title);
    // DB에 있을시 : update
    void updateMovie(Map<String, Object> movieMap);
    // DB에 없을시 : insert
    void insertMovie(Map<String, Object> movieMap);
}
