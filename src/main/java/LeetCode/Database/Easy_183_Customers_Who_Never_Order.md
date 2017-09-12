# Database_Easy_183_Customers_Who_Never_Order

Date: 2016.9.17

[题目在这](https://leetcode.com/problems/customers-who-never-order/)

Suppose that a website contains two tables, the Customers table and the Orders table. Write a SQL query to find all customers who never order anything.

Table: Customers.

| Id | Name  |
| --- | --- |
| 1  | Joe   |
| 2  | Henry |
| 3  | Sam   |
| 4  | Max   |
Table: Orders.

| Id | CustomerId |
| --- | --- |
| 1  | 3          |
| 2  | 1          |
Using the above tables as example, return the following:

| Customers |
| --- |
| Henry     |
| Max       |

Accepted result:

```sql
# Write your MySQL query statement below
select A.Name as Customers
from Customers A
where A.id not in (select B.CustomerId from Orders B)
```
