# Database_Easy_176_Second_Highest_Salary

Date: 2016.9.13

[题目在这](https://leetcode.com/problems/second-highest-salary/)

Write a SQL query to get the second highest salary from the Employee table.

| Id | Salary |
| --- | --- |
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
For example, given the above Employee table, the second highest salary is 200. If there is no second highest salary, then the query should return null.

Accepted result:

```sql
# Write your MySQL query statement below
select (
  select distinct Salary from Employee order by Salary Desc limit 1,1
)as SecondHighestSalary
```
