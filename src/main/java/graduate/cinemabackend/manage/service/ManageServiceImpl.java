package graduate.cinemabackend.manage.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import graduate.cinemabackend.common.dto.ResponseDTO;
import graduate.cinemabackend.manage.dao.ManageMapper;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    ManageMapper manageMapper;

    @Override
    public ResponseDTO answerQna(Map<String, Object> reqMap) { // 문의사항 답변
        ResponseDTO res = new ResponseDTO();

        int updateRow = manageMapper.answerQna(reqMap);

        if (updateRow > 0) {
            res.setResCode(200);
            res.setResMsg("문의사항 답변 성공");
        } else {
            res.setResCode(300);
            res.setResMsg("문의사항 답변 실패");
        }

        return res;
    }

    @Override
    @Transactional
    public ResponseDTO createNoti(Map<String, Object> reqMap) { // 공지사항 쓰기
        ResponseDTO res = new ResponseDTO();

        int insertRow = manageMapper.createNoti(reqMap);

        if (insertRow > 0) {
            res.setResCode(200);
            res.setResMsg("공지사항 쓰기 성공");
        } else {
            res.setResCode(300);
            res.setResMsg("공지사항 쓰기 실패");
        }

        return res;
    }

    @Override
    @Transactional
    public ResponseDTO deleteNoti(String noti_no) { // 공지사항 삭제
        ResponseDTO res = new ResponseDTO();

        int deleteRow = manageMapper.deleteNoti(noti_no);

        if (deleteRow > 0) {
            res.setResCode(200);
            res.setResMsg("공지글 삭제 성공");
        } else {
            res.setResCode(300);
            res.setResMsg("공지글 삭제 실패");
        }
        return res;
    }

    @Override
    @Transactional
    public ResponseDTO manageReview(String rev_no) { // 리뷰 삭제
        ResponseDTO res = new ResponseDTO();

        int deleteRow = manageMapper.manageReview(rev_no);

        if (deleteRow > 0) {
            res.setResCode(200);
            res.setResMsg("리뷰 삭제 성공");
        } else {
            res.setResCode(300);
            res.setResMsg("리뷰 삭제 실패");
        }
        return res;
    }
}
