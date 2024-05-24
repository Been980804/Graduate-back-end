package graduate.cinemabackend.detail.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DetailMapper {
    // 영화 상세정보 가져오기
    Map<String, Object> getDetailInfo(String mov_no);
}
