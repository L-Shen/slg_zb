USE zqg_test;

-- 
SELECT 学号,姓名
FROM 学生
WHERE 学号 IN (SELECT 学号 FROM 选课 WHERE 课程号 IN
(SELECT 课程号 FROM dbo.课程 WHERE 课程名='ZQG_01'))

-- 查询即选修一号 又 选修 二号 学生信息
SELECT 学号,课程号
FROM dbo.选课
WHERE  课程号 ='zqg_01' AND 学号 IN
(SELECT 学号 FROM dbo.选课 WHERE 课程号='zqg_02')

-- 求某人c1课程的成绩 大于张三的成绩
SELECT dbo.选课.学号,dbo.选课.成绩
FROM 学生,选课
WHERE 课程号 = 'zqg_02' AND 成绩 > 
(SELECT 成绩 FROM dbo.选课 WHERE 课程号='zqg_02' AND 学号 IN
(SELECT 学号 FROM dbo.学生 WHERE 姓名 = '张三'))

--  查找成绩大于 学号为 108的 平均成绩 的学生学号 和成绩信息
SELECT 学号,成绩
FROM 选课 AS xkA
WHERE 成绩 > (SELECT AVG(成绩) FROM 选课 AS xkB WHERE xkB.学号='108')


-- 查询 不是软件工程 且 年龄大于 任何一个软件工程的学生年龄的学生信息
SELECT 姓名,年龄,所在系
FROM dbo.学生 
WHERE 所在系 <>'软件工程'
AND 年龄 > ANY (SELECT 年龄 FROM dbo.学生 WHERE 所在系='软件工程')


-- 多用嵌套查询 in > < ()

--exits关键字
-- 选修 zqg_01 但是没有选修 zqg_02 的学生信息
SELECT * 
FROM 选课  
WHERE 课程号='zqg_01'AND 学号 NOT IN(SELECT 学号 FROM dbo.选课 WHERE 课程号 = 'zqg_02' )


---
SELECT * FROM dbo.课程
SELECT * FROM dbo.选课
SELECT * FROM dbo.学生
SELECT AVG(成绩) AS 平均成绩  FROM dbo.选课 WHERE 学号='108'

sp_help 选课

INSERT INTO dbo.选课
        ( 学号, 课程号, 成绩 )
VALUES  ( '108', -- 学号 - char(5)
          'zqg_02', -- 课程号 - char(8)
          80  -- 成绩 - int
          )