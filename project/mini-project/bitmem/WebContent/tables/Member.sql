create table bit_member(
	no			number(9)		not null,
	class_no	number(9),		default 0,
	permission	number(9)		default 0,
	birth		varchar2(300)	not null,
	phone_no	varchar2(300)	not null,
	gender		varchar2(10)	not null,
	id			varchar2(300)	primary key,
	auth		varchar2(10)	default 'U',
	name		varchar2(30)	not null,
	email		varchar2(300)	not null,
	password	varchar2(300)	not null,
	reg_date	date			default sysdate
);

create sequence seq_bit_member;

insert into BIT_MEMBER (
	no, class_no, permission, birth, phone_no, gender, id, auth, name, email, password, reg_date
) values (
	seq_bit_member.nextVal, 0, 1, '2000-01-01', '010-1234-1234', 'M', 'joyikr', 'S', '조영일', 'joyikr@gamil.com', '1111', sysdate	
)

insert into BIT_MEMBER (
	no, class_no, permission, birth, phone_no, gender, id, auth, name, email, password, reg_date
) values (
	seq_bit_member.nextVal, 0, 1, '2000-01-01', '010-1234-1234', 'M', 'master1', 'S', '나진철', 'master1@gamil.com', '1111', sysdate	
);

insert into BIT_MEMBER (
	no, class_no, permission, birth, phone_no, gender, id, auth, name, email, password, reg_date
) values (
	seq_bit_member.nextVal, 0, 1, '2000-01-01', '010-1234-1234', 'M', 'master2', 'S', '장용근', 'master2@gamil.com', '1111', sysdate	
);

insert into BIT_MEMBER (
	no, class_no, permission, birth, phone_no, gender, id, auth, name, email, password, reg_date
) values (
	seq_bit_member.nextVal, 0, 1, '2000-01-01', '010-1234-1234', 'M', 'master3', 'S', '김대오', 'master3@gamil.com', '1111', sysdate	
)

insert into BIT_MEMBER (
	no, class_no, permission, birth, phone_no, gender, id, auth, name, email, password, reg_date
) values (
	seq_bit_member.nextVal, 0, 1, '2000-01-01', '010-1234-1234', 'M', 'master4', 'S', '최승완', 'master4@gamil.com', '1111', sysdate	
)

insert into BIT_MEMBER (
	no, class_no, permission, birth, phone_no, gender, id, auth, name, email, password, reg_date
) values (
	seq_bit_member.nextVal, 0, 1, '2000-01-01', '010-1234-1234', 'M', 'master5', 'S', '이연주', 'master5@gamil.com', '1111', sysdate	
)

insert into BIT_MEMBER (
	no, class_no, permission, birth, phone_no, gender, id, auth, name, email, password, reg_date
) values (
	seq_bit_member.nextVal, 1, 1, '1980-01-11', '010-1234-1234', 'M', 'tester1', 'U', '홍길동', 'tester1@gamil.com', '1111', sysdate	
)
insert into BIT_MEMBER (
	no, class_no, permission, birth, phone_no, gender, id, auth, name, email, password, reg_date
) values (
	seq_bit_member.nextVal, 2, 1, '1980-02-12', '010-1234-1234', 'M', 'tester2', 'U', '성춘향', 'tester2@gamil.com', '1111', sysdate	
)
insert into BIT_MEMBER (
	no, class_no, permission, birth, phone_no, gender, id, auth, name, email, password, reg_date
) values (
	seq_bit_member.nextVal, 2, 1, '1980-03-13', '010-1234-1234', 'M', 'tester3', 'U', '이몽룡', 'tester3@gamil.com', '1111', sysdate	
)
insert into BIT_MEMBER (
	no, class_no, permission, birth, phone_no, gender, id, auth, name, email, password, reg_date
) values (
	seq_bit_member.nextVal, 3, 1, '1980-04-14', '010-1234-1234', 'M', 'tester4', 'U', '김철수', 'tester4@gamil.com', '1111', sysdate	
)
insert into BIT_MEMBER (
	no, class_no, permission, birth, phone_no, gender, id, auth, name, email, password, reg_date
) values (
	seq_bit_member.nextVal, 3, 1, '1980-05-15', '010-1234-1234', 'M', 'tester5', 'U', '김창완', 'tester5@gamil.com', '1111', sysdate	
)
insert into BIT_MEMBER (
	no, class_no, permission, birth, phone_no, gender, id, auth, name, email, password, reg_date
) values (
	seq_bit_member.nextVal, 4, 1, '1920-02-21', '010-1234-1234', 'M', 'tester6', 'U', '뷁뷁뷁', 'tester6@gamil.com', '1111', sysdate	
)
insert into BIT_MEMBER (
	no, class_no, permission, birth, phone_no, gender, id, auth, name, email, password, reg_date
) values (
	seq_bit_member.nextVal, 4, 1, '1999-09-21', '010-1234-1234', 'M', 'tester7', 'U', '제이슨', 'tester7@gamil.com', '1111', sysdate	
)
insert into BIT_MEMBER (
	no, class_no, permission, birth, phone_no, gender, id, auth, name, email, password, reg_date
) values (
	seq_bit_member.nextVal, 5, 1, '2000-09-21', '010-1234-1234', 'M', 'tester8', 'U', '은도끼', 'tester8@gamil.com', '1111', sysdate	
)
insert into BIT_MEMBER (
	no, class_no, permission, birth, phone_no, gender, id, auth, name, email, password, reg_date
) values (
	seq_bit_member.nextVal, 5, 1, '1979-09-11', '010-1234-1234', 'M', 'tester9', 'U', '금도끼', 'tester9@gamil.com', '1111', sysdate	
)
select * from BIT_MEMBER ORDER BY PERMISSION;

drop table bit_member;
drop sequence seq_bit_member;

update BIT_MEMBER
   set permission = 1

   
delete from bit_member where email='2222@naver.com';

UPDATE BIT_MEMBER set CLASS_NO=0 WHERE NAME='성춘향';

SELECT RNUM, LAST_NAME, SALARY
  FROM (SELECT ROWNUM RNUM, LAST_NAME, SALARY
		  FROM (SELECT LAST_NAME, SALARY
				  FROM EMPLOYEES
				 ORDER BY SALARY DESC)
		)
 WHERE RNUM BETWEEN 1 AND 10;
 
 SELECT *
   FROM BIT_MEMBER;