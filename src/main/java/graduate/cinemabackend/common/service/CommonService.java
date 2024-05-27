package graduate.cinemabackend.common.service;

import org.springframework.stereotype.Service;

import graduate.cinemabackend.common.dto.ResponseDTO;

@Service
public interface CommonService {
    // 영화 db 크롤링
    ResponseDTO movieCrawling();
}
