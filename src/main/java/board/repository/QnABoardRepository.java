package board.repository;

import board.board.QnABoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QnABoardRepository extends JpaRepository<QnABoard, Long> {

    QnABoard findByTitle(String name);

}
