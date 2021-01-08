/*
SQL架构
Write a SQL query to rank scores. If there is a tie between two scores, both should have the same ranking. Note that after a tie, the next ranking number should be the next consecutive integer value. In other words, there should be no "holes" between ranks.

+----+-------+
| Id | Score |
+----+-------+
| 1  | 3.50  |
| 2  | 3.65  |
| 3  | 4.00  |
| 4  | 3.85  |
| 5  | 4.00  |
| 6  | 3.65  |
+----+-------+
For example, given the above Scores table, your query should generate the following report (order by highest score):

+-------+------+
| Score | Rank |
+-------+------+
| 4.00  | 1    |
| 4.00  | 1    |
| 3.85  | 2    |
| 3.65  | 3    |
| 3.65  | 3    |
| 3.50  | 4    |*/
+-------+------+
# Write your MySQL query statement below
#使用关联子查询  count(*)当一条记录都没有查询时也会返回0
select t.score,(select count(*) from (select distinct sc2.score from Scores sc2)v where v.score>=t.score) Rank from Scores t order by score desc;

#Oracle 查询
#内层查询分数降序排列，使用distinct去重  外层使用rownum得到排序去重后的行号(行号就是这个分数的排名) 最外层通过分数关联内层得到其排名
select sc1.score,
(select v.rn from
(select x.score,rownum rn from (select distinct score from scores sc2 order by sc2.score desc)x)v
 where v.score=sc1.score)Rank from scores sc1 where 1=1 order by sc1.score desc