/*Write a SQL query to delete all duplicate email entries in a table named Person, keeping only unique emails based on its smallest Id.

+----+------------------+
| Id | Email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
| 3  | john@example.com |
+----+------------------+
Id is the primary key column for this table.
For example, after running your query, the above Person table should have the following rows:

+----+------------------+
| Id | Email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
+----+------------------+
*/
# Write your MySQL query statement below
#NOTE mysql 删表语句别名使用 和  oracle有区别
#for instance：DELETE 别名 FROM 表名称 别名 WHERE 列名称 = 值
#里层如果子查询查的是要删删除的表中记录，子查询需要作为内嵌视图加别名再外面包裹一层查询。 否则报错误码: 1093 原因：所删除表的在子查询中出现
delete  from person  where id not in (select t.id from (select min(id) id from person group by email)t);