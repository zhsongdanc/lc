### 1.命令行用法

```postgresql
# 连接数据库
psql
# 创建数据库
CREATE DATABASE dbname;
# 使用数据库
\c database1；
# 查看有哪些数据库
\l
# 创建表
create table department(
id int primary key not null,
dept char(50) not null,
emp_id int not null);
# 查看有哪些表
\d
# 删除表
drop table table3；
```

### 2.select

(加分号)

```postgresql
# 查询4条
SELECT * FROM COMPANY LIMIT 4;
# 从第2条记录开始，查询4条数据
SELECT * FROM COMPANY LIMIT 4 offset 2；
# orderby
SELECT * FROM COMPANY ORDER BY NAME DESC;
```
