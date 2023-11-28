### SQLExpr
1. SQLIdentifierExpr
2. SQLPropertyExpr
3. SQLBinaryOpExpr
4. SQLVariantRefExpr
5. SQLIntegerExpr
6. SQLCharExpr

...后续需要把基本所有的SQLExpr能测试一些有哪些，因为这些SQLExpr构成了AST
举例：
```java
package com.alibaba.druid.sql.ast.expr;

// SQLName是一种的SQLExpr的Expr，包括SQLIdentifierExpr、SQLPropertyExpr等
public interface SQLName extends SQLExpr {}

// 例如 ID = 3 这里的ID是一个SQLIdentifierExpr
class SQLIdentifierExpr implements SQLExpr, SQLName {
    String name;
} 

// 例如 A.ID = 3 这里的A.ID是一个SQLPropertyExpr
class SQLPropertyExpr implements SQLExpr, SQLName {
    SQLExpr owner;
    String name;
} 

// 例如 ID = 3 这是一个SQLBinaryOpExpr
// left是ID (SQLIdentifierExpr)
// right是3 (SQLIntegerExpr)
class SQLBinaryOpExpr implements SQLExpr {
    SQLExpr left;
    SQLExpr right;
    SQLBinaryOperator operator;
}

// 例如 select * from where id = ?，这里的?是一个SQLVariantRefExpr，name是'?'
class SQLVariantRefExpr extends SQLExprImpl { 
    String name;
}

// 例如 ID = 3 这里的3是一个SQLIntegerExpr
public class SQLIntegerExpr extends SQLNumericLiteralExpr implements SQLValuableExpr { 
    Number number;

    // 所有实现了SQLValuableExpr接口的SQLExpr都可以直接调用这个方法求值
    @Override
    public Object getValue() {
        return this.number;
    }
}

// 例如 NAME = 'jobs' 这里的'jobs'是一个SQLCharExpr
public class SQLCharExpr extends SQLTextLiteralExpr implements SQLValuableExpr{
    String text;
}
```

### AST构成
![img.png](img.png)
思考遍历AST是前序？中序？
### 几个Visitor
#### 1.SqlRemoveNullParameterConditionScriptArgsVisitor
+ 将非必填，且前端未传值的参数对应的where条件从sql语句中 删除
2、如果配置了参数的reformat语句，则使用reformat直接替换参数占位符
3、对于IN操作符的参数设置了reformat，则每一个参数都替换成reformat并替换到占位符中
#### 2.SQLLineageVisitor
#### 3.InterfaceSQLStructureVisitor
### other
#### 判断是否在where字句中



### todo
整体流程
sql-json
分页查询
多版本
加解密
血缘用来做什么？

(1)json->sql
```json
{
  "summary": {
    "pub_code": "vqhizhang-test",
    "pub_name": "vqhizhang-test",
    "pub_desc": "vqhizhang-test",
    "sql": "SELECT id, count(1) as cnt FROM staff_basic group by id order by cnt limit 1000"
  },
  "query": {
    "main_table": {
      "select": [
        {
          "column_code": "staff_basic.id",
          "column_name": "id",
          "as": "id",
          "description": null,
          "encrypt_flag": 0,
          "primary_key_flag": 0,
          "query_operator": [],
          "data_type": "int4",
          "basic_flag": 1,
          "encrypt_salt_type": "no",
          "sample_data": [
            "",
            ""
          ],
          "order": 10,
          "source_need_decrypt": null,
          "obsolete_flag": 0
        }
      ],
      "as": null,
      "from": {
        "set_code": "qps-test",
        "table_code": "staff_basic",
        "set_alias": "staff_basic"
      }
    },
    "right_tables": null,
    "where": "1=1",
    "args": null,
    "group_by_field": "GROUP BY id",
    "order_by_field": null,
    "limit_order_by": "cnt",
    "limit": 1000,
    "with_list": null,
    "union_list": null
  }
}

model json
[
  {
    "code": "qps-test",
    "ds_config": {
      "ds_type": "postgresql"

    },
    "table_name": null,
    "table_define": {
      "set": {
        "table_name": "staff_basic"
      }
    }
  }
]
```
```sql
SELECT staff_basic.id AS id, count(1) AS cnt
FROM staff_basic staff_basic
WHERE 1 = 1
GROUP BY id
ORDER BY cnt
LIMIT 1000
```
1.处理with list;2.处理各个select table alias;3.from(可能是子查询);4.join(可能是子查询，join.getOn);
5.where;6.groupby;7.union;8.order by;9.limit

(2)sql->json
1.endVisit(SQLSelectStatement)
(i)如果是union,第一个union作为main,setUnion.无论是否union，fill limit,groupby, order by
(ii)看是什么类型的table,join,expr,subQuery,union,将select中的字段信息从model拷贝到selects中
(iii)填充默认select
(iv)填充where
2.endVisit(SQLVariantRefExpr) 添加一个必填参数到args里面（仅限于二元或in）
3.endVisit(SQLCharExpr) 添加一个必填参数或非必填
4.endVisit(SQLBinaryOpExpr)
5.endVisit(SQLInListExpr)
5.endVisit(SQLWithSubqueryClause) 添加with list
使用Visitor
(3)remove null

(4)lineage
填充真实的select字段中的内容
