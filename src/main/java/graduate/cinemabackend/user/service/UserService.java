package graduate.cinemabackend.user.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import graduate.cinemabackend.common.dto.ResponseDTO;
import jakarta.servlet.http.HttpServletRequest;

@Service
public interface UserService {

    // 로그인
    ResponseDTO login(Map<String, String> reqMap, HttpServletRequest httpServletRequest);

    // 회원가입
    ResponseDTO signup(Map<String, Object> reqMap);

    // 아이디 중복체크
    ResponseDTO idCheck(String mem_id);

    // 로그아웃
    ResponseDTO logout(HttpServletRequest httpServletRequest);

    // auth check
    ResponseDTO auth(HttpServletRequest httpServletRequest);

    // 회원정보 조회
    ResponseDTO userInfo(HttpServletRequest httpServletRequest);

    // 회원정보 수정
    ResponseDTO modifyUserInfo(Map<String, Object> reqMap, HttpServletRequest httpServletRequest);

    // 회원탈퇴
    ResponseDTO deleteAccount(HttpServletRequest httpServletRequest);

    // 선호 영화 조회
    ResponseDTO likeMovie(HttpServletRequest httpServletRequest);
}
