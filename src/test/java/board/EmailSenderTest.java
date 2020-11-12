package board;

import board.service.MailService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailSenderTest {

    @Autowired
    private MailService mailService;

    @Test
    @DisplayName("AWS SES 이메일 전송 테스트")
    public void sesSendTest(){

        ArrayList<String> to = new ArrayList<>();
        to.add("ruineriaelysion@gmail.com");
        String subject = "[AWS SES] 테스트 발송";
        String content = "SES 메일발송 테스트 입니다.";

        mailService.send(subject, content, to);

    }

}
