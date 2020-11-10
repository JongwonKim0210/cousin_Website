package board.board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table
public class NoticBoard implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String title;

    @Column
    private LocalDateTime createdDate;

    @Column
    private String content;

    @Column
    private boolean secret;

    @Column
    private int readCnt;

    @Builder
    public NoticBoard(Long idx, String password, String name, String title, LocalDateTime createdDate, String content, boolean secret, int readCnt){
        this.idx = idx;
        this.password = password;
        this.name = name;
        this.title = title;
        this.createdDate = createdDate;
        this.content = content;
        this.secret = secret;
        this.readCnt = readCnt;
    }


}
