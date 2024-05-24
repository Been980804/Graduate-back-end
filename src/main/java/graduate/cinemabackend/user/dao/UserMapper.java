package graduate.cinemabackend.user.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    // 로그인
    Map<String, String> selectUserInfo(Map<String, String> reqBody);
    // 회원가입
    int join(Map<String, Object> reqBody);
    // 아이디 중복체크
    boolean idCheck(String mem_id);
}
