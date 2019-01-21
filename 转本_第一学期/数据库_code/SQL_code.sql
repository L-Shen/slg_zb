create database temp_zqg;
use temp_zqg;

-- 主键约束  pk
-- 唯一性约束 uq
-- check 约束 ck
-- 外键约束 fk

-- 创建学生表
 create table 学生(
	学号 char(8) not null unique,
	姓名 char(8) not null,
	年龄 smallint default 20,
	性别 char(2) check(性别 in ('男','女')),
	所在系 char(20)	)
	
 

-- 创建 课程表
create table 课程(
	课程号 char(8),
	课程名 varchar(20) NOT NULL,
	先行课 char(8),
	constraint pk_课程号 primary key(课程号)
)

create table 选课(
 学号 char(8),
 课程号 char(8),
 成绩 int,
 constraint pk_选课 primary key(学号,课程号),
 constraint fk_学号 foreign key(学号) references 学生(学号),
 constraint fk_课程号 foreign key(课程号) references 课程(课程号)
 )
 
 
 
 -- 尾部 shift + home 选中当前行
 -- ctrl + k,c 注释
 -- ctrl + k,u 取消注释
 
--- 
 insert into dbo.学生 values('20181','zqg',20,'男','电信院');
 insert into dbo.学生 values('20180','zqg_test',20,'男','电信院');
 insert into dbo.学生 values('108','张三',20,'男','电信院'); 
 insert into dbo.学生 values('109','李09',21,'女','生物工程学院'); 
 insert into dbo.学生 values('110','张10',20,'男','英语学院'); 
 insert into dbo.学生 values('111','李11',20,'女','电信院'); 
 insert into dbo.学生 values('112','张12',20,'男','国际关系学院'); 
 insert into dbo.学生 values('113','张13',20,'女','电信院'); 
 insert into dbo.学生 values('114','张14',20,'男','商学院'); 
 insert into dbo.学生 values('115','张15',20,'女','电信院'); 
 
 ---
 insert into dbo.课程 values('ZQG_01','数据结构','c++');
 insert into dbo.课程 values('ZQG_02','英语','英语');
 insert into dbo.课程 values('ZQG_03','软件概论','软件管理');
 insert into dbo.课程 values('ZQG_04','企业实训','java');
 insert into dbo.课程 values('ZQG_05','离散数学','高等数学');
 insert into dbo.课程 values('ZQG_06','语文','现代史');
 insert into dbo.课程 values('ZQG_07','算法','c');
 insert into dbo.课程 values('ZQG_08','移动开发','安卓');
 
----
 insert into dbo.选课 values('108','ZQG_02',70);
 insert into dbo.选课 values('109','ZQG_03',80);
 insert into dbo.选课 values('110','ZQG_02',90);
 insert into dbo.选课 values('111','ZQG_03',60);
 insert into dbo.选课 values('112','ZQG_08',50);
 insert into dbo.选课 values('114','ZQG_07',40);
 insert into dbo.选课 values('115','ZQG_04',80);
 insert into dbo.选课 values('20181','ZQG_05',60);
 insert into dbo.选课 values('20180','ZQG_06',80);
 
 sp_help 学生   -- 查看 表结构
  
 --
 select * from dbo.学生;
 select * from dbo.课程
 select * from dbo.选课
 
 --
 update 学生 set 学号='2018' where 学号=''
 
 --
 drop table 选课