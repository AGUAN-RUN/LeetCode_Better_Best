/*SQL架构
Write a SQL query to get the second highest salary from the Employee table.

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
For example, given the above Employee table, the query should return 200 as the second highest salary. If there is no second highest salary, then the query should return null.

+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+*/
# Write your MySQL query statement below
#利用MySql数据库提供了分页的函数limit m,n   从第m(索引从0开始)条记录开始，一共n条记录

#以下sql在只有一条工资记录时,查询结果无，但实际要求要返回一个 null 值
SELECT SALARY AS SecondHighestSalary FROM EMPLOYEE WHERE 1=1 ORDER BY SALARY LIMIT 1,1;

#更正后  但是可能存在多个记录工资都是一样的且都是第一高，导致统计错误 所以还要加上 distinct记录;
#由于mysql排序默认是升序排序，从高到低降序排序需要加上 desc 关键字
SELECT
IFNULL((SELECT SALARY AS SecondHighestSalary FROM EMPLOYEE WHERE 1=1 ORDER BY SALARY LIMIT 1,1),NULL)
AS SecondHighestSalary;

#更正
SELECT
IFNULL((SELECT DISTINCT  SALARY AS SecondHighestSalary FROM EMPLOYEE WHERE 1=1 ORDER BY SALARY DESC LIMIT 1,1),NULL)
AS SecondHighestSalary;


# Write your PL/SQL query statement below   同样适用于MYSQL
select max(salary) as SecondHighestSalary  from employee where salary != (select Max(salary) from employee);
