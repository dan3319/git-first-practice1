package org.zerock.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {
	//@Select("select * from tbl_board where bno > 0")
	List<BoardVO> getList();

	void insert(BoardVO board);

	void insertSelectKey(BoardVO board);
}
