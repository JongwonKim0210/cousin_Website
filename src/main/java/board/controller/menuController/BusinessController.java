package board.controller.menuController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/business")
public class BusinessController {

    //BUSINESS Mapping
    @GetMapping({"", "/spac"})
    public String spac(){
        return "/business/spac";
    }

    @GetMapping("/business")
    public String business() {
        return "/business/business";
    }

}
