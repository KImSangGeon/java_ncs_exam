	-- ���� ���� �ο�
	grant all 
	on java_ncs_exam.* 
	to 'user_javancs'@'localhost'identified by 'rootroot';

grant File 
on *.*
to 'user_javancs'@'localhost';

select user(), database();
create database if not exists java_ncs_exam;
use java_ncs_exam;
