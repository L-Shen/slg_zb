
use zqg_test;

sp_help 学生

select 学号,姓名 from 学生

select 学号,姓名 from 学生 where 所在系 = '软件工程'

select distinct 学号 from 选课  -- distinct 关键字  去除重复列

select top 1 * from 选课     --  top 1 代表的是 第一行  top 5 percent:代表总行数的 5%

select 学号,成绩 from 选课 where 课程号 = 'ZQG_02 ' order by 成绩 desc
     --  ASC 升序
     
     
     
SELECT 姓名,YEAR(GETDATE())-年龄 AS 出生年 FROM dbo.学生
  --
  
  SELECT *
   FROM dbo.学生 
   WHERE (所在系='软件工程' OR 所在系='商学院') AND 姓名 LIKE '张%' 
   -- 优先级 and > or
   
   SELECT *
   FROM dbo.学生 
   WHERE (所在系 IN ('软件工程','商学院')) AND 姓名 LIKE '张%'
   -- IN ('','');
   
   --通配符
   /*
     LIKE :
     % 任意长度
     _ 只能匹配一个 
   */
   
   /*
     转义字符 ：[转换成别的意思]
     在 sql 中 _表 任意一个
     
     当某个字段出现  _  这个如果出现 _ 在语句中 那么就会被当作通配符看待 
     加入 \ 即可止转义成其原本意思    尾部申明 escape '\'
     -- 如下：
     SELECT * FROM xxx WHERE name ="DB\_design" ESCAPE '\'
   */
   
   --SELECT * FROM
   --dbo.课程
   --WHERE
   --先行课 ='DB\_design' EXCEPT '\';
   
   /*
     is null;  为空
     is not null; 不为空
     
     not like :不是
     
   */
   
  SELECT 学号
   INTO 学号_tab 
   FROM dbo.学生   -- 建立一张新表 学号_tab 存储学号
   
   SELECT 学号
   INTO #学号_tab 
   FROM dbo.学生    -- # 表名  建立的是一张暂时表
  
  DROP TABLE dbo.学号_tab
   
   
   
   
   
  

     
     

     
     



