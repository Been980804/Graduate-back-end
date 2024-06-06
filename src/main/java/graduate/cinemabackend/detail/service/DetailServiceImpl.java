package graduate.cinemabackend.detail.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import graduate.cinemabackend.common.dto.ResponseDTO;
import graduate.cinemabackend.detail.dao.DetailMapper;

@Service
public class DetailServiceImpl implements DetailService {

    @Autowired
    DetailMapper detailMapper;

    @Override
    @Transactional
    public ResponseDTO getDetailInfo(String mov_no) { // 영화 상세정보 가져오기
        ResponseDTO res = new ResponseDTO();

        Map<String, Object> detailInfo = detailMapper.getDetailInfo(mov_no);

        if (!detailInfo.isEmpty()) {
            res.setResCode(200);
            res.setResMsg("상세정보 가져오기 성공");
            res.setData("detailInfo", detailInfo);
        } else {
            res.setResCode(300);
            res.setResMsg("상세정보 가져오기 실패");
        }

        return res;
    }

    @Override
    @Transactional
    public ResponseDTO getReview(String mov_no) { // 리뷰 조회
        ResponseDTO res = new ResponseDTO();

        List<Map<String, Object>> reviewList = detailMapper.getReview(mov_no);

        if (!reviewList.isEmpty()) {
            res.setResCode(200);
            res.setResMsg("영화 리뷰 가져오기 성공");
            res.setData("reviewList", reviewList);
        } else {
            res.setResCode(300);
            res.setResMsg("영화 리뷰 가져오기 실패");
        }

        return res;
    }

    @Override
    @Transactional
    public ResponseDTO createReview(Map<String, Object> reqMap) { // 리뷰 작성
        ResponseDTO res = new ResponseDTO();

        int result = detailMapper.createReview(reqMap);

        if (result == 1) {
            res.setResCode(200);
            res.setResMsg("리뷰 작성 성공");
        } else {
            res.setResCode(300);
            res.setResMsg("리뷰 작성 실패");
        }

        return res;
    }

    @Override
    @Transactional
    public ResponseDTO deleteReview(Map<String, Object> reqMap) {
        ResponseDTO res = new ResponseDTO();

        int deleteRow = detailMapper.deleteReview(reqMap);

        if (deleteRow > 0) {
            res.setResCode(200);
            res.setResMsg("리뷰 삭제 성공");
        } else {
            res.setResCode(300);
            res.setResMsg("리뷰 삭제 실패");
        }

        return res;
    }

    @Override
    @Transactional
    public ResponseDTO likeMovie(Map<String, Object> reqMap) { // 영화 좋아요 기능
        ResponseDTO res = new ResponseDTO();

        // 선호 영화 테이블에 유무 확인
        boolean result = detailMapper.checkLike(reqMap);

        if (result) {
            int deleteRow = detailMapper.deleteLike(reqMap);

            if (deleteRow > 0) {
                res.setResCode(200);
                res.setResMsg("좋아요 취소 성공");
            } else {
                res.setResCode(300);
                res.setResMsg("좋아요 취소 실패");
            }
        } else {
            int insertRow = detailMapper.insertLike(reqMap);

            if (insertRow > 0) {
                res.setResCode(200);
                res.setResMsg("좋아요 삽입 성공");
            } else {
                res.setResCode(300);
                res.setResMsg("좋아요 삽입 실패");
            }
        }

        return res;
    }
}
