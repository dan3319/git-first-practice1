package com.humanedu.starbucks.domain;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class FreeBoardVO {
    private int num;                    // 게시판 번호
    private  String id;                 // 게시판 id
    private  String pw;                 // 게시판 비밀번호
    private  String name;               // 게시판 비밀번호
    private  String hp;
    private  String email;
    private  String hompy;
    private  String subject;
    private  String content;
    private  Integer hit;
    private String regdate;
    private  String file1Path;
    private String file2Path;
}
