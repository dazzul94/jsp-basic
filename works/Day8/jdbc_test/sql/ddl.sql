-- 회원 테이블
CREATE TABLE member_tbl (
	id varchar(20) PRIMARY KEY,
	pw varchar(20) NOT NULL,
	name varchar(50) NOT NULL,
	address varchar(500),
	joindate date DEFAULT now()
);

