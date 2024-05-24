package graduate.cinemabackend.main.service;

import org.springframework.stereotype.Service;

import graduate.cinemabackend.common.dto.ResponseDTO;

@Service
public interface MainService {
    // 영화 포스터 가져오기
        ResponseDTO getPosterURL();
    // 극장목록 가져오기
    ResponseDTO getTheaterList();
}
