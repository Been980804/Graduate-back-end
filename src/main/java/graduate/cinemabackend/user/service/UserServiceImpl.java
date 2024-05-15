package graduate.cinemabackend.user.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import graduate.cinemabackend.common.dto.ResponseDTO;
import graduate.cinemabackend.user.dao.UserMapper;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    UserMapper userMapper;

    @Override
    @Transactional
    public ResponseDTO login(Map<String, String> reqBody) {
        ResponseDTO res = new ResponseDTO();

        Map<String, String> resMap = userMapper.selectUserInfo(reqBody);

        if(resMap != null){
            String pwd = reqBody.get("pwd");

            if(pwd.equals(resMap.get("mem_pwd"))){
                res.setResCode(200);
                res.setResMsg("Login Success");
                res.setData("userInfo", resMap);
                resMap.remove("mem_pwd");
            } else{
                res.setResCode(300);
                res.setResMsg("ID 또는 PW가 일치하지 않습니다.");
            }
        } else{
            res.setResCode(300);
            res.setResMsg("ID 또는 PW가 일치하지 않습니다.");
        }
        return res;
    }
}
