package graduate.cinemabackend.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BoardMapper {
    // 공지사항 목록
    List<Map<String, Object>> notiList();
    // 문의사항 목록
    List<Map<String, Object>> qnaList();
}
