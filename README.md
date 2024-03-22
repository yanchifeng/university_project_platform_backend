# university_project_platform_backend

* [university\_project\_platform\_backend](#university_project_platform_backend)
* [接口文档](#接口文档)
  * [端口说明](#端口说明)
  * [User](#user)
    * [/user/show](#usershow)
    * [/user/login](#userlogin)
    * [/user/register](#userregister)
  * [Student](#student)
    * [/student/show](#studentshow)
    * [/student/add](#studentadd)
    * [/student/del](#studentdel)
    * [/student/change](#studentchange)
  * [Mentor](#mentor)
    * [/mentor/show &amp; add &amp; del &amp; change](#mentorshow--add--del--change)
    * [/mentor/studentGroupShow](#mentorstudentgroupshow)
    * [/mentor/studentGroupSearch](#mentorstudentgroupsearch)
    * [/mentor/studentGroupAdd](#mentorstudentgroupadd)
    * [/mentor/studentGroupDel](#mentorstudentgroupdel)
    * [/mentor/studentGroupChange](#mentorstudentgroupchange)
    * [/mentor/projectManagementAdd](#mentorprojectmanagementadd)
  * [StudentGroup](#studentgroup)
    * [/studentGroup/show &amp; add &amp; del &amp; change](#studentgroupshow--add--del--change)



# 接口文档

## 端口说明

| 设备           | 端口 | 说明                 |
| -------------- | ---- | -------------------- |
| IP地址         | *    | IP地址               |
| Springboot端口 | 8408 | 后端端口，数据用json |
| mysql数据库    | 3306 | 数据库端口           |
| Redis          | 6379 | localhost            |

## User

```mysql
create table user(
    user_id  bigint(11) auto_increment primary key comment '用户id',
    user_name VARCHAR(30) not null comment '用户姓名',
    user_password VARCHAR(16) not null comment '用户密码',
    user_Permission TINYINT(1) not null comment '用户权限(管理员0 代表导师1 代表学生2)'
);
```

### /user/show

`get`

测试用，显示User所有数据，后续会**删除**

```json
{
  "code": 200,
  "message": "Success",
  "data": [
    {
      "userId": 1,
      "userName": "admin",
      "userPassword": "admin",
      "userPermission": 0
    },
    {
      "userId": 2,
      "userName": "11001000001",
      "userPassword": "123456",
      "userPermission": 1
    },
    {
      "userId": 3,
      "userName": "11001000002",
      "userPassword": "123456",
      "userPermission": 1
    },
    {
      "userId": 4,
      "userName": "11001000003",
      "userPassword": "123456",
      "userPermission": 1
    },
    {
      "userId": 5,
      "userName": "11001000004",
      "userPassword": "123456",
      "userPermission": 1
    },
    {
      "userId": 6,
      "userName": "12240020001",
      "userPassword": "123456",
      "userPermission": 2
    },
    {
      "userId": 7,
      "userName": "12240020002",
      "userPassword": "123456",
      "userPermission": 2
    },
    {
      "userId": 8,
      "userName": "12240110001",
      "userPassword": "123456",
      "userPermission": 2
    },
    {
      "userId": 9,
      "userName": "12240110002",
      "userPassword": "123456",
      "userPermission": 2
    }
  ]
}
```



### /user/login

`post`

登录请求，必须携带Permission

```json
{
  "userName": "11001000001",
  "userPassword": "123456",
  "userPermission": 1
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": {
      "userId": 2,
      "userName": "11001000001",
      "userPassword": "123456",
      "userPermission": 1
    },
    "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxMTAwMTAwMDAwMSIsInBhc3N3b3JkIjoiMTIzNDU2IiwiZXhwIjoxNzA5NTQ4NDc0LCJpYXQiOjE3MDk1NDQ4NzQsImFjY291bnQiOiIxMTAwMTAwMDAwMSJ9.tUR4ED-31b-GSa7XMJQMTFlcmpLdW5zDTGFP7a-6Q68"
  }
}
```



### /user/register

`post`

注册无需携带Permission，注册的ID必须在Mentor和Student数据表中有数据，后续权限分级时由Mentor或者Student配置数据表内数据

目前测试数据

```mysql
导师测试
(11001000011,'导师测试1', 1, 2,'13421301000','test@graduation');
(11001000012,'导师测试2', 1, 2,'13421301000','test@graduation');
(11001000013,'导师测试3', 1, 2,'13421301000','test@graduation');

学生测试
(12240120002,'测试2', 1,'2024-03-02 19:30:00',24,'10000000000','test@graduation','计算机技术应用2班');
(12240120003,'测试3', 1,'2024-03-02 19:30:00',24,'10000000000','test@graduation','计算机技术应用2班');
(12240120004,'测试3', 1,'2024-03-02 19:30:00',24,'10000000000','test@graduation','计算机技术应用2班');
```



```json
{
  "userName": "11001000003",
  "userPassword": "654321"
}

```

导师返回ID是1，学生是2


```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": {
      "userId": 10,
      "userName": "11001000011",
      "userPassword": "654321",
      "userPermission": 1
    }
  }
}
```

```json
{
  "code": 403,
  "message": "信息录入失败，学生和教师数据中没有该用户，或者管理员数据冲突",
  "data": null
}
```

## Student

```mysql
create table student(
    student_id bigint(11) auto_increment not null primary key comment '学生id',
    student_name varchar(30) not null comment '学生姓名',
    student_sex tinyint(1) not null default 0 comment '学生性别(男1 女2)',
    student_Admission_time DATETIME comment '入学年份' not null  ,
    student_age int(3) not null comment '学生年龄',
    student_phone_number varchar(11) comment '手机号码',
    student_email varchar(255) comment '学生邮箱(固定格式:xxx@graduation)',
    student_class varchar(255) comment '学生班级'
);
```

### /student/show

`get`

```json
{
  "code": 200,
  "message": "Success",
  "data": [
    {
      "studentId": 12240020001,
      "studentName": "张三",
      "studentSex": true,
      "studentAdmissionTime": "2024-03-02T19:30:00",
      "studentAge": 24,
      "studentPhoneNumber": "13323211663",
      "studentEmail": "zhangsan@graduation",
      "studentClass": "软件工程2班"
    },
    {
      "studentId": 12240020002,
      "studentName": "李四",
      "studentSex": true,
      "studentAdmissionTime": "2024-03-02T19:30:00",
      "studentAge": 23,
      "studentPhoneNumber": "13376711663",
      "studentEmail": "lisi@graduation",
      "studentClass": "软件工程2班"
    },
    {
      "studentId": 12240110001,
      "studentName": "王五",
      "studentSex": true,
      "studentAdmissionTime": "2024-03-02T19:30:00",
      "studentAge": 24,
      "studentPhoneNumber": "13323978663",
      "studentEmail": "wangwu@graduation",
      "studentClass": "计算机技术应用1班"
    },
    {
      "studentId": 12240120001,
      "studentName": "赵六",
      "studentSex": true,
      "studentAdmissionTime": "2024-03-02T19:30:00",
      "studentAge": 22,
      "studentPhoneNumber": "13323098663",
      "studentEmail": "zhaoliu@graduation",
      "studentClass": "计算机技术应用2班"
    },
    {
      "studentId": 12240120002,
      "studentName": "测试2",
      "studentSex": true,
      "studentAdmissionTime": "2024-03-02T19:30:00",
      "studentAge": 24,
      "studentPhoneNumber": "10000000000",
      "studentEmail": "test@graduation",
      "studentClass": "计算机技术应用2班"
    },
    {
      "studentId": 12240120003,
      "studentName": "测试3",
      "studentSex": true,
      "studentAdmissionTime": "2024-03-02T19:30:00",
      "studentAge": 24,
      "studentPhoneNumber": "10000000000",
      "studentEmail": "test@graduation",
      "studentClass": "计算机技术应用2班"
    },
    {
      "studentId": 12240120004,
      "studentName": "测试3",
      "studentSex": true,
      "studentAdmissionTime": "2024-03-02T19:30:00",
      "studentAge": 24,
      "studentPhoneNumber": "10000000000",
      "studentEmail": "test@graduation",
      "studentClass": "计算机技术应用2班"
    },
    {
      "studentId": 12240120005,
      "studentName": "东风",
      "studentSex": true,
      "studentAdmissionTime": "2024-03-02T19:30:00",
      "studentAge": 25,
      "studentPhoneNumber": null,
      "studentEmail": null,
      "studentClass": null
    }
  ]
}
```



### /student/add

`post`

```json
{
  "studentId": "12240120005",
  "studentName":"东风",
  "studentSex":1,
  "studentAdmissionTime": "2024-03-02T19:30:00",
  "studentAge":25
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "studentId": 12240120005,
        "studentName": "东风",
        "studentSex": true,
        "studentAdmissionTime": "2024-03-02T19:30:00",
        "studentAge": 25,
        "studentPhoneNumber": null,
        "studentEmail": null,
        "studentClass": null
      }
    ]
  }
}
```

### /student/del

`post`

```json
{
  "studentId": "12240120005"
}
```

```json
{
  "code": 200,
  "message": "删除成功 [ 12240120005 ]",
  "data": null
}
```

```json
{
  "code": 204,
  "message": "删除失败 [ 12240120005 ] 找不到ID或数据冲突",
  "data": null
}
```

### /student/change

`post`

原本数据 studentName 由**东风**改为**北风**

```json
{
  "studentId": "12240120005",
  "studentName":"北风",
  "studentSex":1,
  "studentAdmissionTime": "2024-03-02T19:30:00",
  "studentAge":25
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "studentId": 12240120005,
        "studentName": "北风",
        "studentSex": true,
        "studentAdmissionTime": "2024-03-02T19:30:00",
        "studentAge": 25,
        "studentPhoneNumber": null,
        "studentEmail": null,
        "studentClass": null
      }
    ]
  }
}
```

>此处判断逻辑待修改

## Mentor

已经完成

```mysql
create table mentor(
    mentor_id  bigint(11) auto_increment not null primary key comment '导师ID',
    mentor_name varchar(30) not null comment '导师姓名',
    mentor_Professional_id tinyint(1) not null  comment '导师职称(辅导员1 教师2 系副主任3 系主任4 副院长5 院长6)',
    mentor_sex tinyint(1) not null comment '导师性别(男1 女2)',
    mentor_phone_number varchar(11) comment '导师手机号码',
    mentor_email varchar(255) comment '导师邮箱(固定格式:xxx@graduation)'
);
```

### /mentor/show & add & del & change

```
/mentor/show
/mentor/add
/mentor/del
/mentor/change
接口与Student同理 
```

### /mentor/studentGroupShow

该接口主要用于再列表中显示该导师包含多少个学生组，并不提供查询报错的功能，如需要查询报错，请使用/mentor/studentGroupSearch

`post`

```json
{
  "groupMentorId": 11001000001
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "groupId": 22000000001,
        "groupName": "一窝咸鱼",
        "groupMentorId": 11001000001,
        "groupCaptainId": 12240020001,
        "groupStudentId": 12240020001,
        "groupCreateTime": "2024-03-19T00:10:07"
      },
      {
        "groupId": 22000000002,
        "groupName": "一窝咸鱼",
        "groupMentorId": 11001000001,
        "groupCaptainId": 12240020001,
        "groupStudentId": 12240020002,
        "groupCreateTime": "2024-03-19T00:10:07"
      }
    ]
  }
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": []
  }
}
```

### /mentor/studentGroupSearch

`post`

[0.1.7]: 目前的版本是采用Json限制对mentor搜索的限制，为了安全性，后续会采用JWT的token鉴权限制。即 "groupMentorId" 字段会在后续会被<删除>

```json
//注意：[0.1.7]版本 groupMentorId 会在后续修改为 Param("token") 获取 MentorId
//groupCaptainId 可被替换为 #投标的任意一个或多个字段（类Mysql or）
{
  "groupMentorId": 11001000001,
  "groupId": 22000000003,
  "#groupName": "一窝咸鱼",
  "#groupCaptainId": 12240020001,
  "#groupStudentId": 12240020003,
  "#groupCreateTime": "2024-03-19T00:10:07"
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "groupId": 22000000001,
        "groupName": "一窝咸鱼",
        "groupMentorId": 11001000001,
        "groupCaptainId": 12240020001,
        "groupStudentId": 12240020001,
        "groupCreateTime": "2024-03-19T00:10:07"
      },
      {
        "groupId": 22000000002,
        "groupName": "一窝咸鱼",
        "groupMentorId": 11001000001,
        "groupCaptainId": 12240020001,
        "groupStudentId": 12240020002,
        "groupCreateTime": "2024-03-19T00:10:07"
      }
    ]
  }
}
```

```json
{
  "code": 204,
  "message": "查询不到该导师存在导师组",
  "data": null
}
```

### /mentor/studentGroupAdd

`post`

[0.1.7]: 目前的版本是采用Json限制对mentor搜索的限制，为了安全性，后续会采用JWT的token鉴权限制。即 "groupMentorId" 字段会在后续会被<删除>

 ```json
 //注意：[0.1.7]版本 groupMentorId 会在后续修改为 Param("token") 获取 MentorId
 {
   "groupId": 22000000011,
   "groupName": "测试学生组1",
   "groupMentorId": 11001000002,
   "groupCaptainId": 12240020001,
   "groupStudentId": 12240020001,
   "groupCreateTime": "2024-03-19T00:10:07"
 }
 ```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "groupId": 22000000011,
        "groupName": "测试学生组1",
        "groupMentorId": 11001000002,
        "groupCaptainId": 12240020001,
        "groupStudentId": 12240020001,
        "groupCreateTime": "2024-03-19T00:10:07"
      }
    ]
  }
}
```

### /mentor/studentGroupDel

`post`

[0.1.7]: 目前的版本是采用Json限制对mentor搜索的限制，为了安全性，后续会采用JWT的token鉴权限制。即 "groupMentorId" 字段会在后续会被<删除>

```json
//注意：[0.1.7]版本 groupMentorId 会在后续修改为 Param("token") 获取 MentorId
{
  "groupId": 22000000011,
  "groupMentorId": 11001000002
}
```

```json
{
  "code": 200,
  "message": "删除成功 [ 22000000011 ]",
  "data": null
}
```

### /mentor/studentGroupChange

`post`

原本数据 studentName 由**测试学生组1**改为**测试学生组2**

[0.1.7]: 目前的版本是采用Json限制对mentor搜索的限制，为了安全性，后续会采用JWT的token鉴权限制。即 "groupMentorId" 字段会在后续会被<删除>

```json
//注意：[0.1.7]版本 groupMentorId 会在后续修改为 Param("token") 获取 MentorId
{
  "groupId": 22000000011,
  "groupName": "测试学生组2",
  "groupMentorId": 11001000002,
  "groupCaptainId": 12240020001,
  "groupStudentId": 12240020001,
  "groupCreateTime": "2024-03-19T00:10:07"
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": {
      "groupId": 22000000011,
      "groupName": "测试学生组2",
      "groupMentorId": 11001000002,
      "groupCaptainId": 12240020001,
      "groupStudentId": 12240020001,
      "groupCreateTime": "2024-03-19T00:10:07"
    }
  }
}
```



### /mentor/projectManagementAdd

`post`

该接口主要用于教师端创建项目申请流程表具体流程如下：

1. 教师创建项目（project）表，将json所需要的project数据导入
2. 并自动生成学生组，若学生组（group）ID为未使用的用户，则默认生成新的学生组，有则直接调用已有学生组
3. 并将选定好主键数据封装到竞赛处组（competition），提交竞赛处信息申请
4. [0.1.8]: 目前的版本是采用Json限制对mentor搜索的限制，为了安全性，后续会采用JWT的token鉴权限制。即 "mentorId" 字段会在后续会被<删除>

```json
//注意：
//[0.1.8]版本 groupId 会在后续修改为 Param("token") 获取 MentorId
//[0.1.8]前四个字段为必须字段
{
  "projectId": 31000000105,
  "mentorId": 11001000001,
  "competitionId": 41001000001,
  "groupId": 22000000105,
  
  "projectName": "项目测试",
  "projectIntroduction": "111",
  "projectCreateTime": "2024-03-22T00:54:49",
  "projectEndTime": "2024-06-20T16:38:40",
  "projectProposalLink": "C:\\graduation\\大学生创新创业服务平台.doc",
  "projectCreator": 10001001001,
  "projectScope": "高校服务",
  "projectTag": false,
  "projectBelong": "阳光学院"
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "projectId": 31000000105,
    "projectName": "项目测试",
    "projectIntroduction": "111",
    "projectCreateTime": "2024-03-22T00:54:49",
    "projectEndTime": "2024-06-20T16:38:40",
    "projectProposalLink": "C:\\graduation\\大学生创新创业服务平台.doc",
    "projectCreator": 10001001001,
    "projectScope": "高校服务",
    "projectTag": false,
    "projectBelong": "阳光学院",
    "mentorId": 11001000001,
    "competitionId": 41001000001,
    "groupId": 22000000105
  }
}
```



## StudentGroup

已经完成

```mysql
create table student_group(
                              group_id bigint(11) auto_increment not null  primary key  comment '小组id',
                              group_name varchar(40) comment '小组队名',
                              group_mentor_id bigint(11) comment '创建老师ID',
                              group_captain_id bigint(11)  comment '小组队长ID',
                              group_student_id bigint(11)  comment  '组员ID',
                              group_create_time datetime default now() comment '小组创建时间'
);

INSERT INTO student_group(group_id,group_name,group_mentor_id, group_captain_id,group_student_id)
VALUES(22000000001,'一窝咸鱼',11001000001 ,12240020001,12240020001),
      (22000000002,'一窝咸鱼', 11001000001 ,12240020001,12240020002),
      (22000000003,'一窝咸鱼', 11001000002,12240020001,12240020003),
      (22000000004,'烂泥扶不上墙', 11001000002,12240020004,12240020004);


```

### /studentGroup/show & add & del & change

目前调试用，**Mentor的调试studentGroup接口请见Mentor接口说明**。

```
/studentGroup/show
/studentGroup/add
/studentGroup/del
/studentGroup/change
接口与Student同理 
```

> 接口与Student同理 等待权限分级
