package graduate.cinemabackend.main.service;

import org.springframework.stereotype.Service;

import graduate.cinemabackend.common.dto.ResponseDTO;

@Service
public interface MainService {
    // 영화 포스터 가져오기
    ResponseDTO getPosterURL();

    // 현재상영중인 영화 포스터 가져오기
    ResponseDTO screening();

    // 상영예정작
    ResponseDTO toBeScreened();
}
