# Write your MySQL query statement below
Select * from Cinema Where mod(ID,2)=1 AND
description not like 'boring'
order by rating desc