drop table t77_mini_board_comment;

create table t77_mini_board_comment (
	comment_no number(6) primary key,
	no number(6),
	nick_name varchar2(30),
	content varchar2(300),
	reg_date date default sysdate
);

create sequence seq_mini_board_comment_no;


select to_char(reg_date, 'hh:mi') from t77_mini_board_comment;

select * from t77_mini_board_comment order by comment_no asc;