
-- ��å
CREATE TABLE `java_ncs_exam`.`Title` (
	`tno`   int        NOT NULL COMMENT '��å�ڵ�', -- ��å�ڵ�
	`tname` VARCHAR(20) NULL     COMMENT '��å��' -- ��å��
)
COMMENT '��å';

-- ��å
ALTER TABLE `java_ncs_exam`.`Title`
	ADD CONSTRAINT `PK_Title` -- ��å �⺻Ű
		PRIMARY KEY (
			`tno` -- ��å�ڵ�
		);
show tables;
drop table title;
