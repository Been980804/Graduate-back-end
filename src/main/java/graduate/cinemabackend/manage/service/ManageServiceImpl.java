package graduate.cinemabackend.manage.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import graduate.cinemabackend.common.dto.ResponseDTO;
import graduate.cinemabackend.manage.dao.ManageMapper;
import graduate.cinemabackend.user.dao.UserMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    ManageMapper manageMapper;

    @Autowired
    UserMapper userMapper; // 현재 로그인한 관리자 정보 받아오기 위함

    @Override
    public ResponseDTO answerQna(Map<String, Object> reqMap, HttpServletRequest httpServletRequest) { // 문의사항 답변
        ResponseDTO res = new ResponseDTO();

        HttpSession session = httpServletRequest.getSession(false);

        if (session != null) {
            String mem_id = (String) session.getAttribute("mem_id"); // 현재 아이디

            Map<String, Object> getMemNo = userMapper.getMemNo(mem_id); // 아이디에 해당하는 mem_no값

            if (!getMemNo.isEmpty()) {
                reqMap.put("mem_no", getMemNo.get("mem_no"));

                int updateRow = manageMapper.answerQna(reqMap);

                if (updateRow > 0) {
                    res.setResCode(200);
                    res.setResMsg("문의사항 답변 성공");
                } else {
                    res.setResCode(300);
                    res.setResMsg("문의사항 답변 실패");
                }
            } else {
                res.setResCode(300);
                res.setResMsg("Don't Exist");
            }
        } else {
            res.setResCode(300);
            res.setResMsg("로그인 후 이용해 주세요.");
        }

        return res;
    }
}
