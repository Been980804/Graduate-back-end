package graduate.cinemabackend.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import graduate.cinemabackend.common.dto.ResponseDTO;
import graduate.cinemabackend.main.service.MainService;



@RestController
@RequestMapping("/main")
public class MainController {
    
    @Autowired
    MainService mainService;

    // 영화목록 가져오기
    @GetMapping(value="/movie")
    public ResponseDTO getMovieList() {
        ResponseDTO res = mainService.getMovieList();

        return res;
    }
    
}
