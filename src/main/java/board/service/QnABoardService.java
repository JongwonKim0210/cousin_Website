package board.service;

import board.board.QnABoard;
import board.repository.QnABoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class QnABoardService {

    private final QnABoardRepository qnABoardRepository;

    public QnABoardService(QnABoardRepository qnABoardRepository){
        this.qnABoardRepository = qnABoardRepository;
    }

    //Q&A 페이징 처리
    public Page<QnABoard> findQnAList(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize());
        return qnABoardRepository.findAll(pageable);
    }

    public QnABoard findQnAByIdx(Long idx){
        return qnABoardRepository.findById(idx).orElse(new QnABoard());
    }

}
