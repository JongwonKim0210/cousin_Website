package board.service;

import board.board.Board;
import board.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    //공지사항 페이징 처리
    public Page<Board> findNoticList(Pageable pageable){
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize());
        return boardRepository.findAll(pageable);
    }

    public Board findNoticByIdx(Long idx){
        return boardRepository.findById(idx).orElse(new Board());
    }

    //자유게시판 페이징 처리
    public Page<Board> findFreeList(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize());
        return boardRepository.findAll(pageable);
    }

    public Board findFreeByIdx(Long idx){
        return boardRepository.findById(idx).orElse(new Board());
    }

    //Q&A 페이징 처리
    public Page<Board> findQnAList(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize());
        return boardRepository.findAll(pageable);
    }

    public Board findQnAByIdx(Long idx){
        return boardRepository.findById(idx).orElse(new Board());
    }

}
