package graduate.cinemabackend.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import graduate.cinemabackend.common.dto.ResponseDTO;
import graduate.cinemabackend.main.service.MainService;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("/main")
@CrossOrigin
public class MainController {
    
    @Autowired
    MainService mainService;
    
    // mov_no, mov_posterURL 받아오기
    @GetMapping(value="/posterURL")
    public ResponseDTO getPosterURL() {
        ResponseDTO res = mainService.getPosterURL();

        return res;
    }
    
    // 현재상영중인 영화 
    @GetMapping(value="/screening")
    public ResponseDTO screening(){
        ResponseDTO res = mainService.screening();

        return res;
    }

    // 상영예정작
    @GetMapping(value="/toBeScreened")
    public ResponseDTO toBeScreened() {
        ResponseDTO res = mainService.toBeScreened();

        return res;
    }
    
}
