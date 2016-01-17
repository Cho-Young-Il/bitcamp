create table board(
	title 	varchar2(300)	not null,
	writer_name	varchar2(300)	not null,
	writer_id varchar2(300) not null,
	content	varchar2(3000)	not null,
	no		number(6)		primary key,
	view_cnt	number(6)	default 0,
	comment_cnt	number(6)	default	0,
	recom_cnt	number(6)	default 0,
	reg_date	date		default sysdate
)

select rnum, title
  from (select rownum rnum, title
  		  from (select title  
  		  		  from board 
  		  		 order by no desc)
  )
where rnum between 1 and 10;

create sequence seq_board_no;

create table board_comment(
	comment_no	number(6)	primary key,
	no			number(6),
	name	varchar2(30),
	id		varchar2(30),
	content		varchar2(300),
	reg_date	date	default sysdate
)

select * 
  from board_comment;

create sequence seq_board_comment_no;

create table board_file(
	file_no		number(6)	primary key,
	no			number(6),
	file_size	number,
	ori_file_name	varchar2(200),
	real_file_name	varchar2(200),
	file_path		varchar2(200)
)

create sequence seq_board_file_no;


create table board_sort_flag(
	sort_title_flag varchar2(20),
	sort_writer_flag varchar2(20)
)

insert into board_sort_flag(
	sort_title_flag, sort_writer_flag
) values (
	'true', 'true'
)

select * from board_sort_flag

select rnum, no, writer_name, writer_id, title, view_cnt, recom_cnt
					from (select rownum rnum, no, writer_name, writer_id, title, view_cnt, recom_cnt 
							from (select no, writer_name, writer_id, title, view_cnt, recom_cnt		   
									from board
								   where writer_name like '%조%'
								   order by no desc)
						)
					where rnum between 1 and 30
					

drop table board;
drop table board_comment;
drop table board_file;
drop sequence seq_board_no;
drop sequence seq_board_comment_no;
drop sequence seq_board_file_no;