package graduate.cinemabackend.user.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    // 로그인
    Map<String, String> selectUserInfo(Map<String, String> reqMap);
    // 회원가입
    int signup(Map<String, Object> reqMap);
    // 아이디 중복체크
    boolean idCheck(String mem_id);
    // 회원정보 조회
    Map<String, Object> userInfo(String mem_id);
    // 회원정보 수정
    int modifyUserInfo(Map<String, Object> reqMap);
}
