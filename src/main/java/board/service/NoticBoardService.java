package board.service;

import board.board.NoticBoard;
import board.repository.NoticBoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NoticBoardService {

    private final NoticBoardRepository noticBoardRepository;

    public NoticBoardService(NoticBoardRepository noticBoardRepository){
        this.noticBoardRepository = noticBoardRepository;
    }

    //공지사항 페이징 처리
    public Page<NoticBoard> findNoticList(Pageable pageable){
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize());
        return noticBoardRepository.findAll(pageable);
    }

    public NoticBoard findNoticByIdx(Long idx){
        return noticBoardRepository.findById(idx).orElse(new NoticBoard());
    }

}
