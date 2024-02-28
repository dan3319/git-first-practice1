package com.humanedu.starbucks.service;

import com.humanedu.starbucks.domain.FreeBoardVO;
import com.humanedu.starbucks.mapper.BoardMapper;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.util.List;

@Log4j
@Service
public class FreeBoardServiceImpl implements FreeBoardService {
    @Autowired
    private BoardMapper boardMapper;

    // 게시물 목록 조회 서비스
    @Override
    public List<FreeBoardVO> getFreeBoardList(String search) {
        List<FreeBoardVO> freeBoardVOList = null;

        // search 파라미터가 없으면 -> null
        // search 파라미터 값이 없으면 -> ''
        if(search == null) {
            freeBoardVOList = boardMapper.getFreeBoardList(search);
        } else {
            if (!search.equals("")) {
                freeBoardVOList = boardMapper.getFreeBoardList(search);
            }
        }
        // 다른 예
        // search검색어가 있으면 boardMapper.getFreeBoardList(search);
        // search검색어가 없으면 boardMapper.getFreeBoardList2();

        return freeBoardVOList;
    }

    // 공지사항 작성
    @Override
    public int insertFreeBoard(
            String writer,
            String title,
            String content
    ) {
        FreeBoardVO freeBoardVO = new FreeBoardVO();
        freeBoardVO.setWriter(writer);
        freeBoardVO.setTitle(title);
        freeBoardVO.setContent(content);

        int rtn = boardMapper.putFreeBoard(freeBoardVO);
        return rtn;
    }

    // 제목 눌렀을 때 공지사항 상세 화면
    @Override
    public FreeBoardVO selectFreeBoardOne(int num) {
        return boardMapper.getFreeBoardOne(num);
    }

    // 공지사항 수정
    @Override
    public int updateFreeBoard(int num,
                               String writer,
                               String title,
                               String content,
                               Date update_date) {
        FreeBoardVO freeBoardVO = new FreeBoardVO();
        freeBoardVO.setNum(num);
        freeBoardVO.setWriter(writer);
        freeBoardVO.setTitle(title);
        freeBoardVO.setContent(content);
        freeBoardVO.setUpdate_date(update_date);

        return boardMapper.updateFreeBoard(freeBoardVO);
    }

    // 공지사항 삭제
    @Override
    public int deleteFreeBoard(int num) {
        return boardMapper.delFreeBoard(num);
    }

    // 조회수 증가
    @Override
    public int updateViewCount(int num) {
        return boardMapper.updateViewCount(num);
    }



}
