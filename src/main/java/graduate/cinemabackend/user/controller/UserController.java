package graduate.cinemabackend.user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import graduate.cinemabackend.common.dto.ResponseDTO;
import graduate.cinemabackend.user.service.UserService;



@CrossOrigin
@RestController
@RequestMapping("/user")

public class UserController {
    
    @Autowired
    UserService userService;

    // 로그인
    @PostMapping(value="/login")
    public ResponseDTO login(@RequestBody Map<String, String> reqBody) {
        ResponseDTO res = userService.login(reqBody);
        
        return res;
    }
    
    // 회원가입
    @PostMapping(value="/join")
    public ResponseDTO join(@RequestBody Map<String, Object> reqBody) {
        ResponseDTO res = userService.join(reqBody);

        return res;
    }
    
    // 아이디 중복체크
    @GetMapping(value="/idCheck/{mem_id}")
    public ResponseDTO idCheck(@PathVariable("mem_id") String mem_id) {
        ResponseDTO res = userService.idCheck(mem_id);

        return res;
    }
    
}
