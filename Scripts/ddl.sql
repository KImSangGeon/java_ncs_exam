
-- 직책
CREATE TABLE `java_ncs_exam`.`Title` (
	`tno`   int        NOT NULL COMMENT '직책코드', -- 직책코드
	`tname` VARCHAR(20) NULL     COMMENT '직책명' -- 직책명
)
COMMENT '직책';

-- 직책
ALTER TABLE `java_ncs_exam`.`Title`
	ADD CONSTRAINT `PK_Title` -- 직책 기본키
		PRIMARY KEY (
			`tno` -- 직책코드
		);
show tables;
drop table title;
