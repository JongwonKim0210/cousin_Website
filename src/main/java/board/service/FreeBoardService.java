package board.service;


import board.board.FreeBoard;
import board.repository.FreeBoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FreeBoardService {

    private final FreeBoardRepository freeBoardRepository;

    public FreeBoardService(FreeBoardRepository freeBoardRepository){
        this.freeBoardRepository = freeBoardRepository;
    }

    //자유게시판 페이징 처리
    public Page<FreeBoard> findFreeList(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize());
        return freeBoardRepository.findAll(pageable);
    }

    public FreeBoard findFreeByIdx(Long idx){
        return freeBoardRepository.findById(idx).orElse(new FreeBoard());
    }

}
