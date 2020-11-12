package board;

import board.board.FreeBoard;
import board.board.NoticBoard;
import board.board.QnABoard;
import board.repository.FreeBoardRepository;
import board.repository.NoticBoardRepository;
import board.repository.QnABoardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.time.LocalDateTime;
import java.util.Properties;
import java.util.stream.IntStream;

@SpringBootApplication
public class BoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}

	//게시판 테스트글 생성
	@Bean
	public CommandLineRunner runner(NoticBoardRepository noticBoardRepository,
									FreeBoardRepository freeBoardRepository,
									QnABoardRepository qnABoardRepository) throws Exception {
		return (args) -> {
			IntStream.rangeClosed(1, 40).forEach(index ->
					noticBoardRepository.save(NoticBoard.builder()
							.title("공지사항 제목" + index)
							.name("공지사항 관리자")
							.content("공지사항 게시글" + index)
							.createdDate(LocalDateTime.now())
							.secret(false)
							.readCnt(0)
							.build()));

			IntStream.rangeClosed(1, 40).forEach(index ->
					freeBoardRepository.save(FreeBoard.builder()
							.title("자유게시판 제목" + index)
							.name("자유게시판 관리자")
							.content("자유게시판 게시글" + index)
							.createdDate(LocalDateTime.now())
							.secret(false)
							.readCnt(0)
							.build()));

			IntStream.rangeClosed(1, 40).forEach(index ->
					qnABoardRepository.save(QnABoard.builder()
							.title("QnA 제목" + index)
							.name("QnA 관리자")
							.content("QnA 게시글" + index)
							.createdDate(LocalDateTime.now())
							.secret(false)
							.readCnt(0)
							.build()));
		};
	}

}
