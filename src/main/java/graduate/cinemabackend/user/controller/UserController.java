package graduate.cinemabackend.user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import graduate.cinemabackend.common.dto.ResponseDTO;
import graduate.cinemabackend.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    // 로그인
    @PostMapping(value="/login")
    public ResponseDTO login(@RequestBody Map<String, String> reqMap, HttpServletRequest httpServletRequest) {
        ResponseDTO res = userService.login(reqMap, httpServletRequest);
        
        return res;
    }
    
    // 회원가입
    @PostMapping(value="/signup")
    public ResponseDTO signup(@RequestBody Map<String, Object> reqMap) {
        ResponseDTO res = userService.signup(reqMap);

        return res;
    }
    
    // 아이디 중복체크
    @GetMapping(value="/idCheck/{mem_id}")
    public ResponseDTO idCheck(@PathVariable("mem_id") String mem_id) {
        ResponseDTO res = userService.idCheck(mem_id);

        return res;
    }

    // logout
    @PostMapping(value = "/logout")
    public ResponseDTO logout(HttpServletRequest httpServletRequest) {
        ResponseDTO res = userService.logout(httpServletRequest);

        return res;

    }

    // authCheck
    @GetMapping(value = "/auth")
    public ResponseDTO auth(HttpServletRequest httpServletRequest) {
        ResponseDTO res = userService.auth(httpServletRequest);

        return res;
    }

    // 회원정보 조회
    @GetMapping(value="/userInfo")
    public ResponseDTO userInfo(HttpServletRequest httpServletRequest) {
        ResponseDTO res = userService.userInfo(httpServletRequest);

        return res;
    }
    
    // 회원정보 수정
    @PutMapping(value="/modifyUserInfo")
    public ResponseDTO modifyUserInfo(@RequestBody Map<String, Object> reqMap, HttpServletRequest httpServletRequest) {
        ResponseDTO res = userService.modifyUserInfo(reqMap, httpServletRequest);
        
        return res;
    }
    
    // 회원탈퇴
    @PostMapping(value="/deleteAccount")
    public ResponseDTO postMethodName(HttpServletRequest httpServletRequest) {
        ResponseDTO res = userService.deleteAccount(httpServletRequest);

        return res;
    }
    
    // 선호 영화 리스트 가져오기
    @GetMapping(value="likeMovie")
    public ResponseDTO likeMovie(HttpServletRequest httpServletRequest) {
        ResponseDTO res = userService.likeMovie(httpServletRequest);

        return res;
    }
    
}
