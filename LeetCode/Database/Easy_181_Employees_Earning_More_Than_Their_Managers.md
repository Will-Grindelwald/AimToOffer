# Database_Easy_181_Employees_Earning_More_Than_Their_Managers

Date: 2016.9.14

[题目在这](https://leetcode.com/problems/employees-earning-more-than-their-managers/)

The Employee table holds all employees including their managers. Every employee has an Id, and there is also a column for the manager Id.

| Id | Name  | Salary | ManagerId |
| --- | --- | --- | --- |
| 1  | Joe   | 70000  | 3         |
| 2  | Henry | 80000  | 4         |
| 3  | Sam   | 60000  | NULL      |
| 4  | Max   | 90000  | NULL      |
Given the Employee table, write a SQL query that finds out employees who earn more than their managers. For the above table, Joe is the only employee who earns more than his manager.

| Employee |
| ----- | ----- |
| Joe      |

Accepted result:

```sql
# Write your MySQL query statement below
select a.Name as Employee
from Employee a join Employee b
on a.ManagerId = b.Id
where a.Salary > b.Salary
```
