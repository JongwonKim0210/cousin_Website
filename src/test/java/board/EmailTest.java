package board;

import board.board.dto.OnlineMailDto;
import board.service.MailService;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailTest {

    @Test
    public void sendMail() {
        MailService mailService = new MailService();
        OnlineMailDto dto = new OnlineMailDto("test", Lists.newArrayList("test"), "테스트", "안녕하세요");

        mailService.send(dto);
    }

}
