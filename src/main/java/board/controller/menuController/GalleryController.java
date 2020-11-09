package board.controller.menuController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gallery")
public class GalleryController {

    @GetMapping({"", "/gallery"})
    public String gallery(){
        return "/gallery/gallery";
    }


}
