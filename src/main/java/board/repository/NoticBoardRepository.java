package board.repository;

import board.board.NoticBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticBoardRepository extends JpaRepository<NoticBoard, Long> {

    NoticBoard findByTitle(String name);

}
