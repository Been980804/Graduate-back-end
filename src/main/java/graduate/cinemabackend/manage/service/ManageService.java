package graduate.cinemabackend.manage.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import graduate.cinemabackend.common.dto.ResponseDTO;
import jakarta.servlet.http.HttpServletRequest;

@Service
public interface ManageService {
    // 문의사항 답변
    ResponseDTO answerQna(Map<String, Object> reqMap, HttpServletRequest httpServletRequest);
}
