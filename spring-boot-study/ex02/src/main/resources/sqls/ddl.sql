create sequence seq_board;

create table tbl_board (
  bno number(10,0),
  title varchar2(200) not null,
  content varchar2(2000) not null,
  writer varchar2(50) not null,
  regdate date default sysdate, 
  updatedate date default sysdate
);

alter table tbl_board add constraint pk_board 
primary key (bno);


-- 게시판 댓글
create sequence seq_reply
;

create table tbl_reply (
    rno number(10,0),                   -- 댓글 번호
    bno number(10,0) not null,          -- 댓글에 연계된 게시판 번호
    reply varchar2(1000) not null,      -- 댓글 내용
    replyer varchar2(50) not null,      -- 댓글 작성자
    replyDate date default sysdate,     -- 댓글 작성 날짜
    updateDate date default sysdate     -- 댓글 수정 날짜
);

alter table tbl_reply add constraint pk_reply primary key (rno);

alter table tbl_reply add constraint fk_reply_board
foreign key (bno) reference tbl_board (bno);
