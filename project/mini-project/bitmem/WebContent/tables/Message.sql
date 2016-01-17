create table bit_send_message(
	no			number(9)		primary key,
	sender		varchar2(30)	not null,
	receiver	varchar2(30)	not null,
	content		varchar2(300)	not null,
	reg_date	date			default sysdate
);

create table bit_receive_message(
	no			number(9)		primary key,
	sender		varchar2(30)	not null,
	receiver	varchar2(30)	not null,
	content		varchar2(300)	not null,
	reg_date	date			default sysdate
);

create sequence seq_send_message_no;
create sequence seq_receive_message_no;


select * from bit_send_message;
select * from bit_receive_message;

delete bit_receive_message where no = 33;

drop table bit_send_message;
drop table bit_receive_message;
