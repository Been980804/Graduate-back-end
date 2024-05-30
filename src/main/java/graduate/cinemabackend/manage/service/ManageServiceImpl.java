package graduate.cinemabackend.manage.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import graduate.cinemabackend.common.dto.ResponseDTO;
import graduate.cinemabackend.manage.dao.ManageMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    ManageMapper manageMapper;

    @Override
    public ResponseDTO answerQna(Map<String, Object> reqMap, HttpServletRequest httpServletRequest) { // 문의사항 답변
        ResponseDTO res = new ResponseDTO();

        HttpSession session = httpServletRequest.getSession(false);

        if (session != null) {
            String mem_no = (String) session.getAttribute("mem_no");

            reqMap.put("mem_no", mem_no);

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
            res.setResMsg("로그인 후 이용해 주세요.");
        }

        return res;
    }
}
