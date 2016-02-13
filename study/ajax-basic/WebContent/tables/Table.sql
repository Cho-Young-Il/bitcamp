create table tb_code(
	code   varchar2(10),
	name   varchar2(20), 
	lev    varchar2(8) ,
	g_code varchar2(10)
);

select * from tb_code;

Insert into TB_CODE
   (CODE, NAME, LEV)
 Values
   ('0001', '서울시', '01');
Insert into TB_CODE
   (CODE, NAME, LEV)
 Values
   ('0002', '경기도', '01');
Insert into TB_CODE
   (CODE, NAME, LEV)
 Values
   ('0003', '인천시', '01');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0004', '강남구', '02', '0001');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0005', '강서구', '02', '0001');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0006', '용산구', '02', '0001');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0007', '포천시', '02', '0002');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0008', '부천시', '02', '0002');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0009', '남구', '02', '0003');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0010', '중구', '02', '0003');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0011', '남동구', '02', '0003');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0012', '개포동', '03', '0004');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0013', '논현동', '03', '0004');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0014', '대치동', '03', '0004');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0015', '삼성동', '03', '0004');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0016', '가양동', '03', '0005');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0017', '개화동', '03', '0005');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0018', '공항동', '03', '0005');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0019', '등촌동', '03', '0005');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0020', '갈월동', '03', '0006');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0021', '남영동', '03', '0006');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0022', '도원동', '03', '0006');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0023', '동빙고동', '03', '0006');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0024', '동교동', '03', '0007');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0025', '선단동', '03', '0007');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0026', '설운동', '03', '0007');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0027', '신읍동', '03', '0007');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0028', '소사구', '03', '0008');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0029', '오정구', '03', '0008');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0030', '원미구', '03', '0008');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0031', '관교동', '03', '0009');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0032', '도화동', '03', '0009');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0033', '숭의동', '03', '0009');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0034', '경동', '03', '0010');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0035', '관동', '03', '0010');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0036', '내동', '03', '0010');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0037', '간석동', '03', '0011');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0038', '고잔동', '03', '0011');
Insert into TB_CODE
   (CODE, NAME, LEV, G_CODE)
 Values
   ('0039', '구월동', '03', '0011');
COMMIT;


