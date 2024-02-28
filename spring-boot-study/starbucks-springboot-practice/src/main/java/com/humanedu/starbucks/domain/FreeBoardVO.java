package com.humanedu.starbucks.domain;

import lombok.Getter;
import lombok.Setter;
import java.sql.Date;

@Getter
@Setter
public class FreeBoardVO {
    private int num;                // 게시판 번호
    private String writer;          // 게시판 작성자
    private String title;           // 게시판 제목
    private String content;         // 게시판 내용
    private int VIEW_count;         // 게시글 조회수
    private Date create_date;     // 게시글 작성일
    private Date update_date;     // 게시글 수정일
}
