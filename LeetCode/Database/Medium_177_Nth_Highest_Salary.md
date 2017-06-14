# Database_Medium_177_Nth_Highest_Salary

Date: 2016.9.16

[题目在这](https://leetcode.com/problems/nth-highest-salary/)

Write a SQL query to get the nth highest salary from the Employee table.

| Id | Salary |
| --- | --- |
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
For example, given the above Employee table, the nth highest salary where n = 2 is 200. If there is no nth highest salary, then the query should return null.

Accepted result:

```sql
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
DECLARE M INT;
SET M = N - 1;
  RETURN (
      # Write your MySQL query statement below.
        select (
            select distinct Salary from Employee order by Salary Desc limit M, 1
        )as NthHighestSalary
  );
END
```
