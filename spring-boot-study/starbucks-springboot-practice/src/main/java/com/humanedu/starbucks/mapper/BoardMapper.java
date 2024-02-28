package com.humanedu.starbucks.mapper;

import com.humanedu.starbucks.domain.FreeBoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BoardMapper {
    // 공지사항 리스트
    public List<FreeBoardVO> getFreeBoardList(String search);

    // 공지사항 작성
    int putFreeBoard(FreeBoardVO freeBoardVO);

    // 제목 눌렀을 때 공지사항 상세 화면
    FreeBoardVO getFreeBoardOne(int num);
    // 공지사항 수정
    int updateFreeBoard(FreeBoardVO freeBoardVO);

    // 공지사항 삭제
    int delFreeBoard(int num);

    // 조회수 증가
    int updateViewCount(int num);
}
