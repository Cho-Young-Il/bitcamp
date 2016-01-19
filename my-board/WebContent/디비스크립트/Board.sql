create table t77_mini_board(
	no number(6) primary key,
	writer varchar2(30) not null,
	title varchar2(300) not null,
	content varchar2(4000) not null,
	reg_date date default sysdate,
	view_cnt number(6) default 0
);

drop table t77_mini_board;

create sequence seq_t77_mini_board_no;

-- 게시판 테이블 추천수 컬럼 추가
alter table t77_mini_board
add (recom_cnt number(6) default 0);


select * from t77_mini_board;
