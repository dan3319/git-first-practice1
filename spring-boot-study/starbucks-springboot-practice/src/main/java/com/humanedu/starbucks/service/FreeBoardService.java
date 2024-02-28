package com.humanedu.starbucks.service;

import com.humanedu.starbucks.domain.FreeBoardVO;

import java.sql.Date;
import java.util.List;

public interface FreeBoardService {
    // 공지사항 리스트
    List<FreeBoardVO> getFreeBoardList(String search);

    // 공지사항 등록
    int insertFreeBoard(String writer,
                        String subject,
                        String content);

    // 제목 눌렀을 때 공지사항 수정
    FreeBoardVO selectFreeBoardOne(int num);
    // 공지사항 수정
    int updateFreeBoard(int num,
                        String writer,
                        String title,
                        String content,
                        Date update_date);
    // 공지사항 삭제
    int deleteFreeBoard(int num);

    // 조회수 증가
    int updateViewCount(int num);

}
