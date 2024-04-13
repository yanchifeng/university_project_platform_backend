# university_project_platform_backend

* [university\_project\_platform\_backend](#university_project_platform_backend)
* [接口文档](#接口文档)
  * [端口说明](#端口说明)
  * [版本说明](#版本说明)
  * [User](#user)
    * [/user/show](#usershow)
    * [/user/login](#userlogin)
    * [/user/register](#userregister)
  * [Student](#student)
    * [/student/show](#studentshow)
    * [/student/add](#studentadd)
    * [/student/del](#studentdel)
    * [/student/change](#studentchange)
    * [/student/showStudentMentor](#studentshowstudentmentor)
  * [Mentor](#mentor)
    * [/mentor/show &amp; add &amp; del &amp; change](#mentorshow--add--del--change)
    * [/mentor/studentGroupShow](#mentorstudentgroupshow)
    * [/mentor/studentGroupSearch](#mentorstudentgroupsearch)
    * [/mentor/studentGroupAdd](#mentorstudentgroupadd)
    * [/mentor/studentGroupDel](#mentorstudentgroupdel)
    * [/mentor/studentGroupChange](#mentorstudentgroupchange)
    * [/mentor/projectManagementAdd](#mentorprojectmanagementadd)
    * [/mentor/projectManagementDel](#mentorprojectmanagementdel)
    * [/mentor/projectManagementUpdate](#mentorprojectmanagementupdate)
    * [/mentor/projectManagementShow](#mentorprojectmanagementshow)
    * [/mentor/projectDel](#mentorprojectdel)
    * [/mentor/projectUpdate](#mentorprojectupdate)
    * [/mentor/showMentorStudent](#mentorshowmentorstudent)
    * [/mentor/projectManagementSearch](#mentorprojectmanagementsearch)
  * [StudentGroup](#studentgroup)
    * [/studentGroup/show &amp; add &amp; del &amp; change](#studentgroupshow--add--del--change)
  * [Competition](#competition)
    * [/competition/projectManagementAdd](#competitionprojectmanagementadd)
    * [/competition/projectManagementShow](#competitionprojectmanagementshow)
    * [/competition/projectManagementReview](#competitionprojectmanagementreview)
    * [/competition/projectUpdate](#competitionprojectupdate)
  * [Project](#project)
    * [/project/show](#projectshow)
    * [/project/projectSearch](#projectprojectsearch)
    * [/project/getProjectNew](#projectgetprojectnew)
    * [/project/showWithData](#projectshowwithdata)
  * [Credits](#credits)
    * [/credits/show](#creditsshow)
    * [/credits/getCredits](#creditsgetcredits)
  * [ProjectManagementOperation](#projectmanagementoperation)
    * [/projectManagementOperation/show](#projectmanagementoperationshow)
  * [CreditsOperation](#creditsoperation)
    * [/creditsOperation/show](#creditsoperationshow)
  * [ChatService](#chatservice)
    * [/chatService/\{loginName\}](#chatserviceloginname)
    * [/chatServer/sendForUser](#chatserversendforuser)
    * [/chatServer/sendForUserList](#chatserversendforuserlist)
    * [/chatServer/getMessage](#chatservergetmessage)
  * [HomePage](#homepage)
    * [/studentGroup/show &amp; add &amp; del &amp; change](#studentgroupshow--add--del--change-1)

Created by [gh-md-toc](https://github.com/ekalinin/github-markdown-toc.go)

# 接口文档

## 端口说明

| 设备           | 端口 | 说明                 |
| -------------- | ---- | -------------------- |
| IP地址         | *    | IP地址               |
| Springboot端口 | 8408 | 后端端口，数据用json |
| mysql数据库    | 3306 | 数据库端口           |
| Redis          | 6379 | localhost            |

| 设备       | 版本     | 说明 |
| ---------- | -------- | ---- |
| JDK        | 21       |      |
| Maven      | 3.9.5    |      |
| Springboot | 3.1.0    |      |
| Redis      | 5.0.14.1 |      |
| Mysql      | 5.7.36   |      |
|            |          |      |

## 版本说明





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

### /student/showStudentMentor

`post`

与/mentor/showMentorStudent逻辑同理

```json
{
  "studentId": 12240020001
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "studentId": 12240020001,
        "studentName": "张三",
        "studentSex": null,
        "studentAdmissionTime": null,
        "studentAge": null,
        "studentPhoneNumber": null,
        "studentEmail": null,
        "studentClass": null,
        "mentorId": 11001000001,
        "mentorName": "猴赛雷"
      }
    ]
  }
}
```



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

### /mentor/projectManagementDel

`post`

用于项目管理组（ProjectManagement）的删除

[0.2.0]:后续看是否整合project字段的删除

```json
{
    "projectCreator": 10001001001,
    "projectId":31000000105
}
```

```json
{
  "code": 200,
  "message": "删除成功 [ 31000000109 ]",
  "data": null
}
```

### /mentor/projectManagementUpdate

`post`

[0.2.0]:由于权限分级关系，该接口可能在后续会被删除

```json
{
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

### /mentor/projectManagementShow

`post`

[0.1.9]:版本 mentorId 会在后续修改为 Param(token) 获取 mentorId

```json
//[0.1.9] 后续会换成 Param(&quot;token&quot;) 获取ID
{
  "mentorId": 41001000001
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "projectId": 31000000001,
        "projectName": "大学生创新创业服务平台",
        "projectIntroduction": "大学生创业创意公共服务平台是是由政府主导并投资建设的以帮助大学生就业创业为主导的公益性服务机构，是依托各级政府优惠政策及数娱广场园区资源、高校、产业、研究机构和金融机构为中心致力于打造全方位服务大学生、企业的网络服务平台。",
        "projectCreateTime": "2024-03-24T17:46:26",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\大学生创新创业服务平台.doc",
        "projectCreator": 10001001001,
        "projectScope": "高校服务",
        "projectTag": false,
        "projectBelong": "阳光学院",
        "mentorId": 11001000001,
        "competitionId": 41001000001,
        "groupId": 22000000001
      },
      {
        "projectId": 31000000002,
        "projectName": "花园宝宝电影制作",
        "projectIntroduction": "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
        "projectCreateTime": "2024-03-24T17:46:26",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\花园宝宝电影制作.doc",
        "projectCreator": 10001001001,
        "projectScope": "电影制作",
        "projectTag": false,
        "projectBelong": "阳光学院",
        "mentorId": 11001000001,
        "competitionId": 41001000001,
        "groupId": 22000000001
      },
      {
        "projectId": 31000000003,
        "projectName": "小熊维尼图像设计",
        "projectIntroduction": "sbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsb",
        "projectCreateTime": "2024-03-24T17:46:26",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\小熊维尼图像设计.doc",
        "projectCreator": 10001001002,
        "projectScope": "图像设计",
        "projectTag": false,
        "projectBelong": "北京大学",
        "mentorId": 11001000001,
        "competitionId": 41001000001,
        "groupId": 22000000001
      },
      {
        "projectId": 31000000004,
        "projectName": "灰太狼大战变形金刚模型设计",
        "projectIntroduction": "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh",
        "projectCreateTime": "2024-03-24T17:46:26",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\灰太狼大战变形金刚模型设计.doc",
        "projectCreator": 10001001003,
        "projectScope": "模型设计",
        "projectTag": true,
        "projectBelong": "上海交通大学",
        "mentorId": 11001000001,
        "competitionId": 41001000001,
        "groupId": 22000000004
      },
      {
        "projectId": 31000000109,
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
        "groupId": 22000000001
      }
    ]
  }
}
```

### /mentor/projectDel

```json
{
    "mentorId": 11001000001,
    "projectId":31000000109
}
```

```json
{
  "code": 200,
  "message": "删除成功 [ 12240120005 ]",
  "data": null
}
```



### /mentor/projectUpdate

`post`

```json
{
  "projectId": 31000000001,
  "projectName": "大学生创新创业服务平台测试版",
  "projectIntroduction": "大学生创业创意公共服务平台是是由政府主导并投资建设的以帮助大学生就业创业为主导的公益性服务机构，是依托各级政府优惠政策及数娱广场园区资源、高校、产业、研究机构和金融机构为中心致力于打造全方位服务大学生、企业的网络服务平台。",
  "projectCreateTime": "2024-03-26T17:09:25",
  "projectEndTime": "2024-03-19T00:10:07",
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
    "data": {
      "projectId": 31000000001,
      "projectName": "大学生创新创业服务平台测试版",
      "projectIntroduction": "大学生创业创意公共服务平台是是由政府主导并投资建设的以帮助大学生就业创业为主导的公益性服务机构，是依托各级政府优惠政策及数娱广场园区资源、高校、产业、研究机构和金融机构为中心致力于打造全方位服务大学生、企业的网络服务平台。",
      "projectCreateTime": "2024-03-26T17:09:25",
      "projectEndTime": "2024-03-19T00:10:07",
      "projectProposalLink": "C:\\graduation\\大学生创新创业服务平台.doc",
      "projectCreator": 10001001001,
      "projectScope": "高校服务",
      "projectTag": false,
      "projectBelong": "阳光学院"
    }
  }
}
```

### /mentor/showMentorStudent

`post`

```json
{
  "studentId": "12240020001"
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "studentId": 12240020001,
        "studentName": "张三",
        "studentSex": null,
        "studentAdmissionTime": null,
        "studentAge": null,
        "studentPhoneNumber": null,
        "studentEmail": null,
        "studentClass": null,
        "mentorId": 11001000001,
        "mentorName": "猴赛雷"
      }
    ]
  }
}

```

### /mentor/projectManagementSearch

`post`

```json
//还可以使用
//还可以结合 CompetitionId  GroupId   ProjectId 等限制条件混合查询
{
  "mentorId": 11001000001,
  "projectStatusId": 2
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "projectManagementId": 2,
        "projectId": 31000000002,
        "mentorId": 11001000001,
        "competitionId": 41001000001,
        "groupId": 22000000001,
        "projectStatusId": 2,
        "projectStatusDescription": "暂无"
      },
      {
        "projectManagementId": 3,
        "projectId": 31000000003,
        "mentorId": 11001000001,
        "competitionId": 41001000001,
        "groupId": 22000000001,
        "projectStatusId": 2,
        "projectStatusDescription": "暂无"
      }
    ]
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

## Competition

### /competition/projectManagementAdd

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



### /competition/projectManagementShow

`post`

[0.1.9]:版本 competitionId 会在后续修改为 Param(token) 获取 competitionId

```json
//[0.1.9] 后续会换成 Param(&quot;token&quot;) 获取ID
{
  "competitionId": 41001000001
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "projectId": 31000000001,
        "projectName": "大学生创新创业服务平台",
        "projectIntroduction": "大学生创业创意公共服务平台是是由政府主导并投资建设的以帮助大学生就业创业为主导的公益性服务机构，是依托各级政府优惠政策及数娱广场园区资源、高校、产业、研究机构和金融机构为中心致力于打造全方位服务大学生、企业的网络服务平台。",
        "projectCreateTime": "2024-03-24T17:46:26",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\大学生创新创业服务平台.doc",
        "projectCreator": 10001001001,
        "projectScope": "高校服务",
        "projectTag": false,
        "projectBelong": "阳光学院",
        "mentorId": 11001000001,
        "competitionId": 41001000001,
        "groupId": 22000000001
      },
      {
        "projectId": 31000000002,
        "projectName": "花园宝宝电影制作",
        "projectIntroduction": "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
        "projectCreateTime": "2024-03-24T17:46:26",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\花园宝宝电影制作.doc",
        "projectCreator": 10001001001,
        "projectScope": "电影制作",
        "projectTag": false,
        "projectBelong": "阳光学院",
        "mentorId": 11001000001,
        "competitionId": 41001000001,
        "groupId": 22000000001
      },
      {
        "projectId": 31000000003,
        "projectName": "小熊维尼图像设计",
        "projectIntroduction": "sbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsb",
        "projectCreateTime": "2024-03-24T17:46:26",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\小熊维尼图像设计.doc",
        "projectCreator": 10001001002,
        "projectScope": "图像设计",
        "projectTag": false,
        "projectBelong": "北京大学",
        "mentorId": 11001000001,
        "competitionId": 41001000001,
        "groupId": 22000000001
      },
      {
        "projectId": 31000000004,
        "projectName": "灰太狼大战变形金刚模型设计",
        "projectIntroduction": "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh",
        "projectCreateTime": "2024-03-24T17:46:26",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\灰太狼大战变形金刚模型设计.doc",
        "projectCreator": 10001001003,
        "projectScope": "模型设计",
        "projectTag": true,
        "projectBelong": "上海交通大学",
        "mentorId": 11001000001,
        "competitionId": 41001000001,
        "groupId": 22000000004
      },
      {
        "projectId": 31000000109,
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
        "groupId": 22000000001
      }
    ]
  }
}
```

### /competition/projectManagementReview

`post`

[0.1.9]:版本 competitionId 会在后续修改为 Param(token) 获取 competitionId

该接口主要用于提交项目审批

```json
{
  "competitionId": 41001000001,
  "projectId":31000000109,
  "projectStatusId": 0,
  "projectStatusDescription": "【未通过】：项目状态状态描述：0代表未通过 1代表通过 2代表审核中 "
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "projectManagementId": 5,
        "projectId": 31000000109,
        "mentorId": 11001000001,
        "competitionId": 41001000001,
        "groupId": 22000000001,
        "projectStatusId": false,
        "projectStatusDescription": "【未通过】：项目状态状态描述：0代表未通过 1代表通过 2代表审核中 "
      }
    ]
  }
}
```

### /competition/projectUpdate

`post`

```json
{
  "projectId": 31000000001,
  "projectName": "大学生创新创业服务平台测试版",
  "projectIntroduction": "大学生创业创意公共服务平台是是由政府主导并投资建设的以帮助大学生就业创业为主导的公益性服务机构，是依托各级政府优惠政策及数娱广场园区资源、高校、产业、研究机构和金融机构为中心致力于打造全方位服务大学生、企业的网络服务平台。",
  "projectCreateTime": "2024-03-26T17:09:25",
  "projectEndTime": "2024-03-19T00:10:07",
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
    "data": {
      "projectId": 31000000001,
      "projectName": "大学生创新创业服务平台测试版",
      "projectIntroduction": "大学生创业创意公共服务平台是是由政府主导并投资建设的以帮助大学生就业创业为主导的公益性服务机构，是依托各级政府优惠政策及数娱广场园区资源、高校、产业、研究机构和金融机构为中心致力于打造全方位服务大学生、企业的网络服务平台。",
      "projectCreateTime": "2024-03-26T17:09:25",
      "projectEndTime": "2024-03-19T00:10:07",
      "projectProposalLink": "C:\\graduation\\大学生创新创业服务平台.doc",
      "projectCreator": 10001001001,
      "projectScope": "高校服务",
      "projectTag": false,
      "projectBelong": "阳光学院"
    }
  }
}
```



## Project

```mysql
create table project(
                        project_id bigint(11) auto_increment not null  primary key comment '项目id',
                        project_name varchar(30) not null comment '项目姓名',
                        project_Introduction varchar(2000) comment '项目简介',
                        project_create_time datetime default now() comment '项目创建时间',
                        project_end_time datetime comment '项目结束时间',
                        project_proposal_link varchar(255) comment '项目连接',
                        project_Creator bigint(11) not null comment '创建者ID',
                        project_Scope varchar(100) comment '项目范围',
                        project_tag tinyint(1) comment '项目标签',
                        project_belong varchar(100) comment '项目归属地'
);

INSERT INTO project(project_id,project_name, project_Introduction,project_end_time,project_proposal_link,project_Creator,project_Scope,project_tag,project_belong)
VALUES(31000000001,'大学生创新创业服务平台', '大学生创业创意公共服务平台是是由政府主导并投资建设的以帮助大学生就业创业为主导的公益性服务机构，是依托各级政府优惠政策及数娱广场园区资源、高校、产业、研究机构和金融机构为中心致力于打造全方位服务大学生、企业的网络服务平台。','2024-03-19 00:10:07','C:\\graduation\\大学生创新创业服务平台.doc','10001001001','高校服务',0,'阳光学院')
,(31000000002,'花园宝宝电影制作', 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx','2024-03-19 00:10:07','C:\\graduation\\花园宝宝电影制作.doc','10001001001','电影制作',0,'阳光学院')
,(31000000003,'小熊维尼图像设计', 'sbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsb','2024-03-19 00:10:07','C:\\graduation\\小熊维尼图像设计.doc','10001001002','图像设计',0,'北京大学')
,(31000000004,'灰太狼大战变形金刚模型设计', 'hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh','2024-03-19 00:10:07','C:\\graduation\\灰太狼大战变形金刚模型设计.doc','10001001003','模型设计',1,'上海交通大学');

```



### /project/show

`get`

```json
{
  "code": 200,
  "message": "Success",
  "data": [
    {
      "projectId": 31000000001,
      "projectName": "大学生创新创业服务平台",
      "projectIntroduction": "大学生创业创意公共服务平台是是由政府主导并投资建设的以帮助大学生就业创业为主导的公益性服务机构，是依托各级政府优惠政策及数娱广场园区资源、高校、产业、研究机构和金融机构为中心致力于打造全方位服务大学生、企业的网络服务平台。",
      "projectCreateTime": "2024-03-26T17:09:25",
      "projectEndTime": "2024-03-19T00:10:07",
      "projectProposalLink": "C:\\graduation\\大学生创新创业服务平台.doc",
      "projectCreator": 10001001001,
      "projectScope": "高校服务",
      "projectTag": false,
      "projectBelong": "阳光学院"
    },
    {
      "projectId": 31000000002,
      "projectName": "花园宝宝电影制作",
      "projectIntroduction": "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
      "projectCreateTime": "2024-03-26T17:09:25",
      "projectEndTime": "2024-03-19T00:10:07",
      "projectProposalLink": "C:\\graduation\\花园宝宝电影制作.doc",
      "projectCreator": 10001001001,
      "projectScope": "电影制作",
      "projectTag": false,
      "projectBelong": "阳光学院"
    },
    {
      "projectId": 31000000003,
      "projectName": "小熊维尼图像设计",
      "projectIntroduction": "sbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsb",
      "projectCreateTime": "2024-03-26T17:09:25",
      "projectEndTime": "2024-03-19T00:10:07",
      "projectProposalLink": "C:\\graduation\\小熊维尼图像设计.doc",
      "projectCreator": 10001001002,
      "projectScope": "图像设计",
      "projectTag": false,
      "projectBelong": "北京大学"
    },
    {
      "projectId": 31000000004,
      "projectName": "灰太狼大战变形金刚模型设计",
      "projectIntroduction": "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh",
      "projectCreateTime": "2024-03-26T17:09:25",
      "projectEndTime": "2024-03-19T00:10:07",
      "projectProposalLink": "C:\\graduation\\灰太狼大战变形金刚模型设计.doc",
      "projectCreator": 10001001003,
      "projectScope": "模型设计",
      "projectTag": true,
      "projectBelong": "上海交通大学"
    }
  ]
}
```



### /project/projectSearch

`post`

```json
//以下展示的为搜索项，可随意删改
{
      "projectId": 31000000001,
      "projectName": "大学生创新创业服务平台",
      "projectCreator": 10001001001,
      "projectScope": "高校服务",
      "projectTag": false,
      "projectBelong": "阳光学院"
    }
```



### /project/getProjectNew

`get` 获取记录最新的10条数据

### /project/showWithData

`get`

显示项目详情的接口 添加个学生 老师信息名字

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "projectId": 31000000001,
        "projectName": "大学生创新创业服务平台",
        "projectIntroduction": "大学生创业创意公共服务平台是是由政府主导并投资建设的以帮助大学生就业创业为主导的公益性服务机构，是依托各级政府优惠政策及数娱广场园区资源、高校、产业、研究机构和金融机构为中心致力于打造全方位服务大学生、企业的网络服务平台。",
        "projectCreateTime": "2024-04-13T02:00:40",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\大学生创新创业服务平台.doc",
        "projectCreator": 10001001001,
        "projectScope": "高校服务",
        "projectTag": false,
        "projectBelong": "阳光学院",
        "groupId": 22000000001,
        "groupName": "一窝咸鱼",
        "mentorId": 11001000001,
        "mentorName": "猴赛雷",
        "studentId": null,
        "studentName": null
      },
      {
        "projectId": 31000000002,
        "projectName": "花园宝宝电影制作",
        "projectIntroduction": "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
        "projectCreateTime": "2024-04-13T02:00:40",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\花园宝宝电影制作.doc",
        "projectCreator": 10001001001,
        "projectScope": "电影制作",
        "projectTag": false,
        "projectBelong": "阳光学院",
        "groupId": 22000000001,
        "groupName": "一窝咸鱼",
        "mentorId": 11001000001,
        "mentorName": "猴赛雷",
        "studentId": null,
        "studentName": null
      },
      {
        "projectId": 31000000003,
        "projectName": "小熊维尼图像设计",
        "projectIntroduction": "sbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsb",
        "projectCreateTime": "2024-04-13T02:00:40",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\小熊维尼图像设计.doc",
        "projectCreator": 10001001002,
        "projectScope": "图像设计",
        "projectTag": false,
        "projectBelong": "北京大学",
        "groupId": 22000000001,
        "groupName": "一窝咸鱼",
        "mentorId": 11001000001,
        "mentorName": "猴赛雷",
        "studentId": null,
        "studentName": null
      },
      {
        "projectId": 31000000004,
        "projectName": "灰太狼大战变形金刚模型设计",
        "projectIntroduction": "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh",
        "projectCreateTime": "2024-04-13T02:00:40",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\灰太狼大战变形金刚模型设计.doc",
        "projectCreator": 10001001003,
        "projectScope": "模型设计",
        "projectTag": true,
        "projectBelong": "上海交通大学",
        "groupId": 22000000004,
        "groupName": "烂泥扶不上墙",
        "mentorId": 11001000001,
        "mentorName": "猴赛雷",
        "studentId": null,
        "studentName": null
      }
    ]
  }
}
```



## Credits

```json
create table credits(
    credits_id bigint(11) primary key  auto_increment comment '学分记录',
    student_id bigint(11) comment '学生id',
    credits_value int(5) not null default 0 comment '学分',
    credits_Description varchar(255) comment '学分描述',
    foreign key (student_id) references student(student_id)
);

insert into credits( student_id, credits_value)
VALUES (12240020001,2),(12240020002,1),(12240110001,1),(12240120001,0);
```



### /credits/show

`get`

```json
{
  "code": 200,
  "message": "Success",
  "data": [
    {
      "creditsId": 1,
      "studentId": 12240020001,
      "creditsValue": 2,
      "creditsDescription": null
    },
    {
      "creditsId": 2,
      "studentId": 12240020002,
      "creditsValue": 1,
      "creditsDescription": null
    },
    {
      "creditsId": 3,
      "studentId": 12240110001,
      "creditsValue": 1,
      "creditsDescription": null
    },
    {
      "creditsId": 4,
      "studentId": 12240120001,
      "creditsValue": 0,
      "creditsDescription": null
    }
  ]
}
```



### /credits/getCredits

`post`

```json
{
  "studentId": "12240020001"
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "creditsId": 1,
        "studentId": 12240020001,
        "creditsValue": 2,
        "creditsDescription": null
      }
    ]
  }
}
```

## ProjectManagementOperation

### /projectManagementOperation/show

`get`

显示操作projectManagement的数据记录

## CreditsOperation

### /creditsOperation/show

`get`

显示操作creditsOperation的数据记录

## ChatService

### /chatService/{loginName}

参考自【[杨不易呀](https://blog.csdn.net/GenuineYangbuyi)】https://blog.csdn.net/fisherish/article/details/129188244

和 https://www.jb51.net/article/271607.htm

具体调用逻辑看文件APP.HTML

### /chatServer/sendForUser

**具体调用逻辑看文件APP.HTML**

`post`

```java
//具体调用逻辑看文件APP.HTML
//本主要逻辑是userId向forId发送消息，内容是contentText
const websocketUser = {
            websocketUserId : userId,
            websocketForuser: forId,
            websocketMessage: contentText // Assuming 'massage' is the correct property name in your WebSocketUser class
        };
        $.ajax({
            method: 'POST',
            url: 'http://localhost:8408/chatServer/sendForUser', // Adjust the URL according to your actual endpoint
            contentType: 'application/json',
            data: JSON.stringify(websocketUser),
            success: function(response) {
                alert('Message sent successfully!');
            },
            error: function(xhr, status, error) {
                alert('Error sending message: ' + error);
            }
        });

```

```json
//与此同时forId账号端收到消息
//其中的11是UserId（发送方） 10为（接收方）
{
  "websocketId": null,
  "websocketUserId": 11,
  "websocketForuser": "10",
  "websocketMessage": "hello websocket",
  "websocketTime": "2024-04-11T02:18:02.7112744",
  "userList": null
}
```

```json
//发送方收到接口放回数据（用于聊天记录展示）
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "websocketId": 20,
        "websocketUserId": 10,
        "websocketForuser": "11",
        "websocketMessage": "hello websocket",
        "websocketTime": "2024-04-11T02:21:12.4894101",
        "userList": null
      },
      {
        "websocketId": 20,
        "websocketUserId": 10,
        "websocketForuser": "11",
        "websocketMessage": "hello websocket",
        "websocketTime": "2024-04-11T02:21:12.4894101",
        "userList": null
      }
    ]
  }
}
```

### /chatServer/sendForUserList

`post`

与 /chatServer/sendForUser 接口同理

将其中发送的forId修改为以逗号为分界的字符串 `,` ，如下

```
11,12
```

后端通过，分割账号id数据，发送给账号11和12

```json
//与此同时forId账号端收到消息
//其中的11是UserId（发送方） 10,12为（接收方）
{
  "websocketId": null,
  "websocketUserId": 11,
  "websocketForuser": "10,12",
  "websocketMessage": "hello websocket",
  "websocketTime": "2024-04-11T02:18:02.7112744",
  "userList": null
}
```

```json
//发送方收到接口放回数据（用于聊天记录展示）
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "websocketId": 20,
        "websocketUserId": 10,
        "websocketForuser": "11,12",
        "websocketMessage": "hello websocket",
        "websocketTime": "2024-04-11T02:21:12.4894101",
        "userList": null
      },
      {
        "websocketId": 20,
        "websocketUserId": 10,
        "websocketForuser": "11,12",
        "websocketMessage": "hello websocket",
        "websocketTime": "2024-04-11T02:21:12.4894101",
        "userList": null
      }
    ]
  }
}
```

### /chatServer/getMessage

`post`

用户获取当前聊天数据

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "websocketId": 9,
        "websocketUserId": 10,
        "websocketForuser": "11",
        "websocketMessage": "hello websocket",
        "websocketTime": "2024-04-10T02:50:32.0011129"
      },
      {
        "websocketId": 10,
        "websocketUserId": 11,
        "websocketForuser": "10",
        "websocketMessage": "hello websocket",
        "websocketTime": "2024-04-10T02:50:35.3171622"
      }
    ]
  }
}
```

## HomePage

```mysql
create table home_page(
    home_page_id int auto_increment primary key ,
    home_page_title varchar(255) not null ,
    home_page_context text ,
    home_page_create_time datetime default now(),
    home_page_Creator bigint(11),
    home_page_Creator_name varchar(255),
    home_page_tag varchar(20)
)
```



### /studentGroup/show & add & del & change

```
/homePage/show
/homePage/add
/homePage/del
/homePage/change
接口与Student同理 
```

> 接口与Student同理 无需权限分级
