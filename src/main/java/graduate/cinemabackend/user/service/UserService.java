package graduate.cinemabackend.user.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import graduate.cinemabackend.common.dto.ResponseDTO;

@Service
public interface UserService {
    
    // 로그인
    ResponseDTO login(Map<String, String> reqBody);
    // 회원가입
    ResponseDTO join(Map<String, Object> reqBody);
    // 아이디 중복체크
    ResponseDTO idCheck(String mem_id);
}
