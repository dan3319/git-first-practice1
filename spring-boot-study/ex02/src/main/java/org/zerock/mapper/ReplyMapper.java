package org.zerock.mapper;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import java.util.List;

public interface ReplyMapper {
    public int insert(ReplyVO vo);      // 댓글 작성
    public ReplyVO read(Long rno);      // 특정 댓글 읽기
    public int delete (Long rno);        // 댓글 삭제
    public int update(ReplyVO reply);   // 댓글 수정

    // 댓글 목록 페이징 처리
    public List<ReplyVO> getListWithPaging(
            @Param("cri")Criteria cri,
            @Param("bno") Long bno);

}
