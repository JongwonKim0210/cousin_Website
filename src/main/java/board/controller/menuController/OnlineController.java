package board.controller.menuController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/online")
public class OnlineController {

    @GetMapping({"", "/mail"})
    public String mail(){
        return "/online/mail";
    }
}
