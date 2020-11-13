package board;

import board.board.dto.SenderDto;
import board.service.Sender;
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
        Sender sender = new Sender();
        SenderDto dto = new SenderDto("test", Lists.newArrayList("test"), "테스트", "안녕하세요");

        sender.send(dto);
    }

}
