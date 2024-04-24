-- create tables
create database if not exists my_db;

use my_db;

drop table if exists SC;
drop table if exists Student;
drop table if exists Teacher;

create table if not exists Student
(
    id    int not null unique auto_increment,
    SId   varchar(10),
    Sname varchar(10),
    Sage  datetime,
    Ssex  varchar(10),
    primary key (id)
);

create table if not exists Course
(
    id    int not null auto_increment,
    CId   varchar(10),
    Cname nvarchar(10),
    TId   varchar(10),
    primary key (id)
);

create table if not exists Teacher
(
    id    int not null unique auto_increment,
    TId   varchar(10),
    Tname varchar(10),
    primary key (id)
);

create table if not exists SC
(
    id    int not null unique auto_increment,
    SId   varchar(10),
    CId   varchar(10),
    score decimal(18, 1),
    primary key (id)
);

insert into Student(SId, Sname, Sage, Ssex)
values ('01', '赵雷', '1990-01-01', '男'),
       ('02', '钱电', '1990-12-21', '男'),
       ('03', '孙风', '1990-12-20', '男'),
       ('04', '李云', '1990-12-06', '男'),
       ('05', '周梅', '1991-12-01', '女'),
       ('06', '吴兰', '1992-01-01', '女'),
       ('07', '郑竹', '1989-01-01', '女'),
       ('09', '张三', '2017-12-20', '女'),
       ('10', '李四', '2017-12-25', '女'),
       ('11', '李四', '2012-06-06', '女'),
       ('12', '赵六', '2013-06-13', '女'),
       ('13', '孙七', '2014-06-01', '女');

insert into Course(CId, Cname, TId)
values ('01', '语文', '02'),
       ('02', '数学', '01'),
       ('03', '英语', '03');

insert into Teacher(TId, Tname)
values ('01', '张三'),
       ('02', '李四'),
       ('03', '王五');


insert into SC(SId, CId, score)
values ('01', '01', 80),
       ('01', '02', 90),
       ('01', '03', 99),
       ('02', '01', 70),
       ('02', '02', 60),
       ('02', '03', 80),
       ('03', '01', 80),
       ('03', '02', 80),
       ('03', '03', 80),
       ('04', '01', 50),
       ('04', '02', 30),
       ('04', '03', 20),
       ('05', '01', 76),
       ('05', '02', 87),
       ('06', '01', 31),
       ('06', '03', 34),
       ('07', '02', 89),
       ('07', '03', 98);

-- 统计男性和女性的数量
select Ssex, count(*)
from Student
group by Ssex;

-- 根据性别进行分组统计其平均年龄
select Ssex, avg(Sage)
from Student
group by Ssex;


--  用一条SQL语句查询出每门课都大于80分的学生姓名
-- my solve
select s.*
from Student as s
where s.SId = (select sc.SId from SC as sc group by sc.SId having min(sc.score > 80));
-- gpt4 solve
SELECT s.Sname
FROM Student s
         JOIN
     SC sc ON s.SId = sc.SId
GROUP BY s.SId, s.Sname
HAVING MIN(sc.score) > 80;

-- 查询" 01 "课程比" 02 "课程成绩高的学生的信息及课程分数
-- my solve:
select s.*, a.score '01 score', b.score '02 score'
from Student as s,
     (select SId, CId, score from SC where CId = '01') as a,
     (select SId, CId, score from SC where CId = '02') as b
where s.SId = a.SId
  and s.SId = b.SId
  and a.score > b.score;
-- gpt4 solve
SELECT s.id      AS StudentID,
       s.SId     AS StudentSId,
       s.Sname   AS Name,
       s.Sage    AS Age,
       s.Ssex    AS Sex,
       sc1.score AS Score_in_Course_01
FROM Student s
         JOIN
     SC sc1 ON s.SId = sc1.SId
         JOIN
     SC sc2 ON s.SId = sc2.SId
WHERE sc1.CId = '01'
  AND sc2.CId = '02'
  AND sc1.score > sc2.score;


-- 查询平均成绩大于等于60分的同学的学生编号和学生姓名和平均成绩
-- my solve
SELECT s.SId, s.Sname, AVG(sc.score) AS AverageScore
FROM Student AS s
         JOIN SC AS sc ON s.SId = sc.SId
GROUP BY s.SId, s.Sname
having AverageScore > 60
order by AverageScore desc;
-- standard solve
select s.sid, sname, avg(score) as avg_score
from student as s,
     sc
where s.sid = sc.sid
group by s.sid
having avg_score > 60;

-- 查询在 SC 表存在成绩的学生信息
-- my solve 1
select *
from Student
where SId in (select SId from SC as sc where sc.score is not null);
-- my solve 2
select DISTINCT s.*
from Student as s
         left join SC as sc on s.SId = sc.SId
where sc.score is not null;
-- standard solve
select *
from student
where sid in (select sid from sc where score is not null);

-- 查询所有同学的学生编号、学生姓名、选课总数、所有课程的总成绩(没成绩的显示为 null)
-- my solve
select s.SId, s.Sname, count(sc.CId), sum(sc.score)
from Student as s
         left join SC as sc on s.SId = sc.SId
group by s.SId, s.Sname;
-- standard solve
select s.sid, s.sname, count(cid) as 选课总数, sum(score) as 总成绩
from student as s
         left join sc
                   on s.sid = sc.sid
group by s.sid, s.sname;

-- 查询「李」姓老师的数量
select count(*)
from Teacher
where Tname like '李%';

-- 查询学过「张三」老师授课的同学的信息
-- my solve
select DISTINCT a.*
from Student as a,
     Teacher as b,
     Course as c,
     SC as d
where a.SId = d.SId
  and b.TId = c.TId
  and c.CId = d.CId
  and b.Tname = '张三';
-- standard solve
select *
from student
where sid in (select sid
              from sc,
                   course,
                   teacher
              where sc.cid = course.cid
                and course.tid = teacher.tid
                and tname = '张三');
-- standard solve 2
select *
from Student
where sid in (select distinct Sid
              from SC
              where cid in (select Cid
                            from Course
                            where Tid = (select Tid from Teacher where Tname = '张三')));

-- 查询没有学全所有课程的同学的信息
-- my solve
select *
from Student
where SId in (select sc.SId from SC as sc group by sc.SId having count(sc.CId) > 2);
-- standard solve
select *
from student
where sid in (select sid from sc group by sid having count(cid) < 3);

-- 查询和" 01 "号的同学学习的课程完全相同的其他同学的信息
-- my solve
select CId
from SC
where SId = '01';

select *
from Student
where SId in (select DISTINCT a.SId
              from (select SId from SC where CId = '01') as a,
                   (select SId from SC where CId = '02') as b,
                   (select SId from SC where CId = '03') as c
              where a.SId = b.SId
                and b.SId = c.SId
                and a.SId = c.SId)
  and SId <> '01';

-- gpt4 solve
SELECT DISTINCT s1.SId, s1.Sname, s1.Sage, s1.Ssex
FROM Student AS s1
WHERE s1.SId <> '01' -- Exclude the student "01"
  AND NOT EXISTS (
    -- Select any course that student "01" is taking that the other student is not
    SELECT CId
    FROM SC
    WHERE SId = '01'
    EXCEPT
    SELECT CId
    FROM SC
    WHERE SId = s1.SId)
  AND NOT EXISTS (
    -- Select any course that the other student is taking that student "01" is not
    SELECT CId
    FROM SC
    WHERE SId = s1.SId
    EXCEPT
    SELECT CId
    FROM SC
    WHERE SId = '01');

-- 查询至少有一门课与学号为" 01 "的同学所学相同的同学的信息
-- my solve
select SId, Sname, Ssex, Sage
from Student
where SId in (select DISTINCT SId from SC where CId in (select CId from SC where SId = '01'))
  and SId <> '01';

-- gpt4 solve
SELECT DISTINCT Student.id, Student.SId, Student.Sname, Student.Sage, Student.Ssex
FROM Student
         JOIN SC ON Student.SId = SC.SId
WHERE SC.CId IN (SELECT CId FROM SC WHERE SId = '01')
  AND Student.SId <> '01';
-- Exclude student "01" from the results

-- 查询没学过"张三"老师讲授的任一门课程的学生姓名
-- my solve1
select *
from Student
where SId not in (select DISTINCT SId
                  from SC
                  where CId in (select CId
                                from Course
                                where TId in (select TId
                                              from Teacher
                                              where Tname = '张三')));

-- my solve2
select s.SId
from Student as s
EXCEPT
select distinct sc.SId
from SC as sc
         left join (select distinct c.CId
                    from Teacher as t
                             left join Course as c on t.TId = c.TId
                    where t.Tname = '张三') as a on sc.CId = a.CId
order by SId;

-- my solve2
select *
from Student
where SId not in (select DISTINCT sc.SId
                  from SC as sc
                           left join Course as c on sc.CId = c.CId
                           left join Teacher as t on c.TId = t.TId
                  where t.Tname = '张三');

-- gpt4 solve
SELECT DISTINCT Student.*
FROM Student
WHERE NOT EXISTS (SELECT 1
                  FROM SC
                           JOIN Course ON SC.CId = Course.CId
                           JOIN Teacher ON Course.TId = Teacher.TId
                  WHERE Teacher.Tname = '张三'
                    AND SC.SId = Student.SId);

-- author solve
select *
from student
where sname not in (select s.sname
                    from student as s,
                         course as c,
                         teacher as t,
                         sc
                    where s.sid = sc.sid
                      and sc.cid = c.cid
                      and c.tid = t.tid
                      and t.tname = '张三');

-- 查询两门及其以上不及格课程的同学的学号，姓名及其平均成绩
-- my solve
select s.SId, s.Sname, avg(sc.score)
from Student as s
         left join
     SC as sc on sc.SId = s.SId
where sc.score < 60.0
group by sc.SId, s.Sname
having count(*) >= 2;

-- gpt solve
SELECT Student.SId,
       Student.Sname,
       AVG(SC.score) as AvgScore
FROM Student
         JOIN SC ON Student.SId = SC.SId
WHERE Student.SId IN (SELECT SC.SId
                      FROM SC
                      WHERE SC.score < 60
                      GROUP BY SC.SId
                      HAVING COUNT(*) >= 2)
GROUP BY Student.SId, Student.Sname;

--  检索" 01 "课程分数小于 60，按分数降序排列的学生信息
-- my solve1
select *
from Student
where SId in (select SId from SC where score < 60 and CId = '01' order by score desc);

-- my solve2
select s.*, sc.score
from Student as s,
     SC as sc
where s.SId = sc.SId
  and sc.score < 60
  and sc.CId = '01'
order by sc.score desc;

-- author solve
select s.*, score
from student as s,
     sc
where cid = 01
  and score < 60
  and s.sid = sc.sid
order by score desc;

-- 按平均成绩从高到低显示所有学生的所有课程的成绩以及平均成绩
select s.*, a.avg
from Student as s
         right join
         (select SId, avg(score) as avg from SC group by SId) as a on s.SId = a.SId
order by a.avg desc;

--  统计各科成绩各分数段人数：课程编号，课程名称，[100-85]，[85-70]，[70-60]，[60-0] 及所占百分比
-- my solve
select DISTINCT c.CId, c.Cname, a.*
from Course as c
         left join
     (select CId,
             count(case when score between 85 and 100 then 1 end)                 as '100-85',
             sum(case when score between 85 and 100 then 1 else 0 end) / count(*) as '[100-85]',
             sum(case when score between 70 and 85 then 1 else 0 end) / count(*)  as '[85-70]',
             sum(case when score between 60 and 70 then 1 else 0 end) / count(*)  as '[70-60]',
             sum(case when score between 0 and 60 then 1 else 0 end) / count(*)   as '[60-0]'
      from SC as sc
      group by sc.CId) as a on c.CId = a.CId;

-- gpt4 solve
SELECT Course.CId,
       Course.Cname,
       COUNT(CASE WHEN SC.score BETWEEN 85 AND 100 THEN 1 END)                                       AS "[100-85]",
       COUNT(CASE WHEN SC.score BETWEEN 70 AND 84.99 THEN 1 END)                                     AS "[85-70]",
       COUNT(CASE WHEN SC.score BETWEEN 60 AND 69.99 THEN 1 END)                                     AS "[70-60]",
       COUNT(CASE WHEN SC.score < 60 THEN 1 END)                                                     AS "[60-0]",
       ROUND(100.0 * COUNT(CASE WHEN SC.score BETWEEN 85 AND 100 THEN 1 END) / COUNT(SC.score), 2)   AS "Pct[100-85]",
       ROUND(100.0 * COUNT(CASE WHEN SC.score BETWEEN 70 AND 84.99 THEN 1 END) / COUNT(SC.score), 2) AS "Pct[85-70]",
       ROUND(100.0 * COUNT(CASE WHEN SC.score BETWEEN 60 AND 69.99 THEN 1 END) / COUNT(SC.score), 2) AS "Pct[70-60]",
       ROUND(100.0 * COUNT(CASE WHEN SC.score < 60 THEN 1 END) / COUNT(SC.score), 2)                 AS "Pct[60-0]"
FROM SC
         JOIN Course ON SC.CId = Course.CId
GROUP BY Course.CId, Course.Cname
ORDER BY Course.CId;


-- author solve
select distinct c.cid as 课程编号, c.cname as 课程名称, A.*
from course as c,
     (select cid,
             sum(case when score >= 85 then 1 else 0 end) / count(*)                as 100_85,
             sum(case when score >= 70 and score < 85 then 1 else 0 end) / count(*) as 85_70,
             sum(case when score >= 60 and score < 70 then 1 else 0 end) / count(*) as 70_60,
             sum(case when score < 60 then 1 else 0 end) / count(*)                 as 60_0
      from sc
      group by cid) as A
where c.cid = A.cid;

-- 查询各科成绩前三名的记录
-- my solve
select *
from (select CId, SId, score, rank() over (partition by CId order by score desc ) as CourseRank from SC) as RankScore
where RankScore.CourseRank <= 3;

-- author solve
select *
from (select *, rank() over (partition by cid order by score desc) as graderank from sc) A
where A.graderank <= 3;

-- 查询出只选修两门课程的学生学号和姓名
-- my solve
select SId, Sname
from Student
where SId in (select SId
              from SC
              group by SId
              having count(*) = 2);

-- author solve
select s.sid, s.sname, count(cid)
from student s,
     sc
where s.sid = sc.sid
group by s.sid, Sname
having count(cid) = 2;

-- 查询名字中含有「风」字的学生信息
-- my solve
select *
from Student
where Sname like '%风%';

-- 查询 1990 年出生的学生名单
select *
from Student
where year(Sage) = 1990;

-- 成绩不重复，查询选修「张三」老师所授课程的学生中，成绩最高的学生信息及其成绩
-- my solve
select s.*, a.score
from Student as s,
     (select sc.score, sc.SId
      from SC as sc
               left join Course as c on sc.CId = c.CId
               left join Teacher T on c.TId = T.TId
      where t.Tname = '张三'
      order by sc.score desc
      limit 1) as a
where s.SId = a.SId;

-- 查询各学生的年龄，只按年份来算
-- my solve
select *, year(now()) - year(Sage) as age
from Student
order by year(Sage) asc;

-- 查询本周过生日的学生
-- my solve
select Sname, year(Sage) as age
from Student
where week(now()) = week(Sage);

-- 查询下周过生日的学生
-- my solve
select Sname, year(Sage) as age
from Student
where (week(now()) + 1) = week(Sage);