select * from t77_mini_board_file;

create table t77_mini_board_file (
	file_no number(6) primary key,
	no number(6),
	ori_file_name varchar2(200),
	real_file_name varchar2(200),
	file_size number,
	file_path varchar2(200)
);

create sequence seq_mini_board_file_no;

update t77_mini_board_file
   set file_path = '/2015/12/29'
 where no = 82;  


