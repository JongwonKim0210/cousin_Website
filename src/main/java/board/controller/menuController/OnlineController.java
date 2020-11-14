package board.controller.menuController;

import board.board.dto.OnlineMailDto;
import board.service.MailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/online")
public class OnlineController {

    @GetMapping({"", "/mail"})
    public String mail(){
        return "/online/mail";
    }

    @GetMapping("/sendMail")
    public String sandmail(List<String> to, String subject, String content) {
        MailService mailService = new MailService();
        OnlineMailDto dto = new OnlineMailDto("lunaelysion@naver.com", to, subject, content);

        mailService.send(dto);

        return "/index";
    }


}
