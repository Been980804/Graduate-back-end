package graduate.cinemabackend.manage.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ManageMapper {
    // 문의사항 답변
    int answerQna(Map<String, Object> reqMap);
}
