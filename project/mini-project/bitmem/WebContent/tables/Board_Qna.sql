create table board_qna(
no number(5) primary key,
title varchar2 (30) not null,
writer varchar2 (30) not null,
content varchar2(300) not null,
reg_date date default sysdate,
view_cnt number(6) default 0
);

create sequence seq_board_qna_no;

select * from board_qna;
drop board_qna;


delete board_qna 
 where no=28;