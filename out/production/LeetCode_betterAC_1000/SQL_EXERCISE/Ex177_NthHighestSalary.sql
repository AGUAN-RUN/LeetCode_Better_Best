/*Write a SQL query to get the nth highest salary from the Employee table.

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
For example, given the above Employee table, the nth highest salary where n = 2 is 200. If there is no nth highest salary, then the query should return null.

+------------------------+
| getNthHighestSalary(2) |
+------------------------+
| 200                    |
+------------------------+*/
#定义一个函数,设置参数个数以及类型 以及定义返回值的类型
#MYSQL 定义函数格式如下
/*
create function 函数名([参数列表]) returns 数据类型
begin
 sql语句;
 return 值;
end;
*/
#MYSQL 函数定义变量以及给变量赋值的方式
#定义变量1 declare var1 int default 0;
#定义变量2  set @var=1;
#设置变量   set var=2;
#mysql可以使用concat拼接多个字符串(ORACLE只能拼接两个，但是oracle可以使用 || 来拼接字符串)
#注意要改变参数
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  set N=N-1;
  RETURN (
      # Write your MySQL query statement below.
      select ifnull((select distinct salary from employee order by salary desc limit num,1),null)
  );
END

#ORACLE 函数
#通过ORACLE rownum来实现排序选取的效果，rownum同时也是ORACLE实现分页的手段
CREATE FUNCTION getNthHighestSalary(N IN NUMBER) RETURN NUMBER IS
result NUMBER;
BEGIN
    /* Write your PL/SQL query statement below */
    select nvl((select x.salary from (select t.salary,rownum rn from (select distinct salary  from Employee  where 1=1 order by salary desc)t)x where x.rn=N),null) into result from dual;
    RETURN result;
END;
