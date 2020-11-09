package board.repository;

import board.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Board findByTitle(String name);
}
