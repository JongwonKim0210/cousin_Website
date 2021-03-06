package board.controller.menuController;

import board.service.FreeBoardService;
import board.service.NoticBoardService;
import board.service.QnABoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    NoticBoardService noticBoardService;

    @Autowired
    FreeBoardService freeBoardService;

    @Autowired
    QnABoardService qnABoardService;

    @GetMapping({"", "/notic"})
    public String notic(@PageableDefault Pageable pageable, Model model){
        model.addAttribute("noticList", noticBoardService.findNoticList(pageable));
        return "/customer/notic";
    }

    @GetMapping("/free")
    public String free(@PageableDefault Pageable pageable, Model model){
        model.addAttribute("freeList", freeBoardService.findFreeList(pageable));
        return "/customer/free";
    }

    @GetMapping("/qna")
    public String qna(@PageableDefault Pageable pageable, Model model){
        model.addAttribute("qnaList", qnABoardService.findQnAList(pageable));
        return "/customer/qna";
    }

}
