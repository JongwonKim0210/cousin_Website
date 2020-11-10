package board.repository;

import board.board.FreeBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreeBoardRepository extends JpaRepository<FreeBoard, Long> {

    FreeBoard findByTitle(String name);

}
