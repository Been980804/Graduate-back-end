package graduate.cinemabackend.detail.service;

import org.springframework.stereotype.Service;

import graduate.cinemabackend.common.dto.ResponseDTO;

@Service
public interface DetailService {
    // 영화 상세정보 가져오기
    ResponseDTO getDetailInfo(String mov_no);
}
