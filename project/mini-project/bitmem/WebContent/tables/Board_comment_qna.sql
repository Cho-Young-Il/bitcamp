create table board_comment_qna (
	comment_no number (10) primary key,
	no number (10),
	nick_name varchar2(50),
	content varchar2(200),
	reg_date date default sysdate
);

create sequence seq_board_comment_qna_no;

select * from board_comment_qna;

drop table board_comment_qna;