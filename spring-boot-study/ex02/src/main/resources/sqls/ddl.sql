DROP SEQUENCE seq_board;

create sequence seq_board;

DROP TABLE TBl_BOARD ;


CREATE TABLE tbl_board(
   bno number(10,0) default seq_board.nextval PRIMARY KEY ,
   title varchar2(200) NOT NULL,
   content varchar2(2000) NOT NULL,
   writer varchar2(50) NOT NULL,
   regdate DATE DEFAULT sysdate,
   updatedate DATE DEFAULT sysdate
);