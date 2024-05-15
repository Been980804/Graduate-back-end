package graduate.cinemabackend.user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import graduate.cinemabackend.common.dto.ResponseDTO;
import graduate.cinemabackend.user.service.UserService;



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
    
}
