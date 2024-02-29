package org.zerock.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {
  //@Select("select * from tbl_board where bno > 0")
  List<BoardVO> getList();        // 게시판 전체 목록 조회

  void insert(BoardVO board);     // 게시판 등록

  void insertSelectKey(BoardVO board);    // 게시판 등록

  BoardVO read(Long bno);

  int delete(Long bno);

  int update(BoardVO board);
}
