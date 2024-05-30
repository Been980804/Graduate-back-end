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
    // 공지사항 조회수 증가
    int increaseCnt(String noti_no);
    // 공지사항 상세보기
    Map<String, Object> detailNoti(String noti_no);
    // 문의사항 목록
    List<Map<String, Object>> qnaList();
}
