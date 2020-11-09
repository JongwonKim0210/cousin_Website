package board;

import board.board.Board;
import board.repository.BoardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class BoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(BoardRepository boardRepository) throws Exception {
		return (args) -> {
			IntStream.rangeClosed(1,40).forEach(index ->
					boardRepository.save(Board.builder()
							.title("게시글" + index)
							.name("관리자")
							.content("게시글" + index)
							.createdDate(LocalDateTime.now())
							.secret(false)
							.readCnt(0)
							.build()));
		};
	}

}
