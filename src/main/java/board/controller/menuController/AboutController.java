package board.controller.menuController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/about")
public class AboutController {

    @GetMapping({"", "/welcome"})
    public String welcome(){
        return "/about/welcome";
    }

    @GetMapping("/location")
    public String location(){
        return "/about/location";
    }

}
