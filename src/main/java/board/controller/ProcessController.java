package board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProcessController {

    @GetMapping("/update")
    public String update(){
        return "/form/update";
    }

    @GetMapping("/updateOk")
    public String updateOk(){
        return "/form/update";
    }

    @GetMapping("/delete")
    public String delete(){
        return "/";
    }

}
