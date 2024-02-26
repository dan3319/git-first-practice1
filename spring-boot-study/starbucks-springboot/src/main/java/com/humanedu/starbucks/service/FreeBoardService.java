package com.humanedu.starbucks.service;

import com.humanedu.starbucks.domain.FreeBoardVO;

import java.util.List;

public interface FreeBoardService {
    List<FreeBoardVO> getFreeBoardList(String search);

    int insertFreeBoard(String korname,
                        String subject,
                        String content,
                        List<String> fileNameList);
}
