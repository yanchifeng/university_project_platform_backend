create database university_project_platform_db default character set utf8mb4 collate utf8mb4_unicode_ci;
use university_project_platform_db;
create table mentor(
    mentor_id  bigint(11) auto_increment not null primary key comment '导师ID',
    mentor_name varchar(30) not null comment '导师姓名',
    mentor_Professional_id tinyint(1) not null  comment '导师职称(辅导员1 教师2 系副主任3 系主任4 副院长5 院长6)',
    mentor_sex tinyint(1) not null comment '导师性别(男1 女2)',
    mentor_phone_number varchar(11) comment '导师手机号码',
    mentor_email varchar(255) comment '导师邮箱(固定格式:xxx@graduation)'
);

INSERT INTO mentor(mentor_id,mentor_name, mentor_Professional_id,mentor_sex,mentor_phone_number,mentor_email) VALUES(11001000001,'猴赛雷', 2, 1,'13750401663','housailei@graduation');
INSERT INTO mentor(mentor_id,mentor_name, mentor_Professional_id,mentor_sex,mentor_phone_number,mentor_email) VALUES(11001000002,'铺该', 2, 1,'13321401663','pugai@graduation');
INSERT INTO mentor(mentor_id,mentor_name, mentor_Professional_id,mentor_sex,mentor_phone_number,mentor_email) VALUES(11001000003,'丢雷楼母', 2, 1,'13420432663','diuleiloumu@graduation');
INSERT INTO mentor(mentor_id,mentor_name, mentor_Professional_id,mentor_sex,mentor_phone_number,mentor_email) VALUES(11001000004,'索嗨', 1, 2,'13421301663','suohai@graduation');
INSERT INTO mentor(mentor_id,mentor_name, mentor_Professional_id,mentor_sex,mentor_phone_number,mentor_email) VALUES(11001000011,'导师测试1', 1, 2,'13421301000','test@graduation');
INSERT INTO mentor(mentor_id,mentor_name, mentor_Professional_id,mentor_sex,mentor_phone_number,mentor_email) VALUES(11001000012,'导师测试2', 1, 2,'13421301000','test@graduation');
INSERT INTO mentor(mentor_id,mentor_name, mentor_Professional_id,mentor_sex,mentor_phone_number,mentor_email) VALUES(11001000013,'导师测试3', 1, 2,'13421301000','test@graduation');


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

INSERT INTO student(student_id,student_name, student_sex,student_Admission_time,student_age,student_phone_number,student_email,student_class)
VALUES(12240020001,'张三', 1,'2024-03-02 19:30:00',24,'13323211663','zhangsan@graduation','软件工程2班');
INSERT INTO student(student_id,student_name, student_sex,student_Admission_time,student_age,student_phone_number,student_email,student_class)
VALUES(12240020002,'李四', 1,'2024-03-02 19:30:00',23,'13376711663','lisi@graduation','软件工程2班');
INSERT INTO student(student_id,student_name, student_sex,student_Admission_time,student_age,student_phone_number,student_email,student_class)
VALUES(12240110001,'王五', 2,'2024-03-02 19:30:00',24,'13323978663','wangwu@graduation','计算机技术应用1班');
INSERT INTO student(student_id,student_name, student_sex,student_Admission_time,student_age,student_phone_number,student_email,student_class)
VALUES(12240120001,'赵六', 2,'2024-03-02 19:30:00',22,'13323098663','zhaoliu@graduation','计算机技术应用2班');
INSERT INTO student(student_id,student_name, student_sex,student_Admission_time,student_age,student_phone_number,student_email,student_class)
VALUES(12240120002,'测试2', 1,'2024-03-02 19:30:00',24,'10000000000','test@graduation','计算机技术应用2班');
INSERT INTO student(student_id,student_name, student_sex,student_Admission_time,student_age,student_phone_number,student_email,student_class)
VALUES(12240120003,'测试3', 1,'2024-03-02 19:30:00',24,'10000000000','test@graduation','计算机技术应用2班');
INSERT INTO student(student_id,student_name, student_sex,student_Admission_time,student_age,student_phone_number,student_email,student_class)
VALUES(12240120004,'测试3', 1,'2024-03-02 19:30:00',24,'10000000000','test@graduation','计算机技术应用2班');

create table project(
    project_id bigint(11) auto_increment not null  primary key comment '项目id',
    project_name varchar(30) not null comment '项目姓名',
    project_Introduction varchar(2000) comment '项目简介',
    project_create_time datetime default now() comment '项目创建时间',
    project_proposal_link varchar(255) comment '项目连接',
    project_Creator bigint(11) not null comment '创建者ID',
    project_Scope varchar(100) comment '项目范围',
    project_tag varchar(100) comment '项目标签',
    project_belong varchar(100) comment '项目归属地'
);

INSERT INTO project(project_id,project_name, project_Introduction,project_proposal_link,project_Creator,project_Scope,project_tag,project_belong)
VALUES(31000000001,'大学生创新创业服务平台', '大学生创业创意公共服务平台是是由政府主导并投资建设的以帮助大学生就业创业为主导的公益性服务机构，是依托各级政府优惠政策及数娱广场园区资源、高校、产业、研究机构和金融机构为中心致力于打造全方位服务大学生、企业的网络服务平台。','C:\\graduation\\大学生创新创业服务平台.doc','10001001001','高校服务','校园','阳光学院');
INSERT INTO project(project_id,project_name, project_Introduction,project_proposal_link,project_Creator,project_Scope,project_tag,project_belong)
VALUES(31000000002,'花园宝宝电影制作', 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx','C:\\graduation\\花园宝宝电影制作.doc','10001001001','电影制作','校园','阳光学院');
INSERT INTO project(project_id,project_name, project_Introduction,project_proposal_link,project_Creator,project_Scope,project_tag,project_belong)
VALUES(31000000003,'小熊维尼图像设计', 'sbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsb','C:\\graduation\\小熊维尼图像设计.doc','10001001002','图像设计','校园','北京大学');
INSERT INTO project(project_id,project_name, project_Introduction,project_proposal_link,project_Creator,project_Scope,project_tag,project_belong)
VALUES(31000000004,'灰太狼大战变形金刚模型设计', 'hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh','C:\\graduation\\灰太狼大战变形金刚模型设计.doc','10001001003','模型设计','校园','上海交通大学');

create table student_group(
    group_id bigint(11) auto_increment not null  primary key  comment '小组id',
    group_name varchar(40) comment '小组队名',
    group_captain_id bigint(11)  comment '小组队长ID',
    group_student_id bigint(11)  comment  '组员ID',
    group_create_time datetime default now() comment '小组创建时间'
);

INSERT INTO student_group(group_id,group_name, group_captain_id,group_student_id)
VALUES(22000000001,'一窝咸鱼', 12240020001,12240020001);
INSERT INTO student_group(group_id,group_name, group_captain_id,group_student_id)
VALUES(22000000002,'一窝咸鱼', 12240020001,12240020002);
INSERT INTO student_group(group_id,group_name, group_captain_id,group_student_id)
VALUES(22000000003,'一窝咸鱼', 12240020001,12240020003);
INSERT INTO student_group(group_id,group_name, group_captain_id,group_student_id)
VALUES(22000000004,'烂泥扶不上墙', 12240020004,12240020004);

create table  project_Management(
    project_management_id int(10) primary key auto_increment,
    project_id bigint(11) comment '项目编号',
    mentor_id bigint(11) comment '导师编号',
    Group_id bigint(11) comment '小组编号',
    project_status_id TINYINT(1) not null comment '项目状态id 0代表未通过 1代表通过 2代表审核中 ',
    project_status_Description varchar(50) not null  comment '项目状态状态描述 注释/备注',
    foreign key (project_id) references project(project_id),
    foreign key (mentor_id) references  mentor(mentor_id),
    foreign key  (Group_id) references  student_group(group_id)
);
INSERT INTO project_Management(project_id,mentor_id, Group_id,project_status_id,project_status_Description)
VALUES(31000000001,11001000001, 22000000001,1,'暂无');
INSERT INTO project_Management(project_id,mentor_id, Group_id,project_status_id,project_status_Description)
VALUES(31000000002,11001000001, 22000000001,2,'暂无');
INSERT INTO project_Management(project_id,mentor_id, Group_id,project_status_id,project_status_Description)
VALUES(31000000003,11001000001, 22000000001,2,'暂无');
INSERT INTO project_Management(project_id,mentor_id, Group_id,project_status_id,project_status_Description)
VALUES(31000000004,11001000001, 22000000004,0,'缺少材料');

create table user(
    user_id  bigint(11) auto_increment primary key comment '用户id',
    user_name VARCHAR(30) not null comment '用户姓名',
    user_password VARCHAR(16) not null comment '用户密码',
    user_Permission TINYINT(1) not null comment '用户权限(管理员0 代表导师1 代表学生2)'
);

INSERT INTO user(user_name, user_password,user_Permission)
VALUES('admin', 'admin',0);
INSERT INTO user(user_name, user_password,user_Permission)
VALUES(11001000001,123456,1);
INSERT INTO user(user_name, user_password,user_Permission)
VALUES(11001000002, 123456,1);
INSERT INTO user(user_name, user_password,user_Permission)
VALUES(11001000003, 123456,1);
INSERT INTO user(user_name, user_password,user_Permission)
VALUES(11001000004, 123456,1);
INSERT INTO user(user_name, user_password,user_Permission)
VALUES(12240020001, 123456,2);
INSERT INTO user(user_name, user_password,user_Permission)
VALUES(12240020002,123456,2);
INSERT INTO user(user_name, user_password,user_Permission)
VALUES(12240110001,123456,2);
INSERT INTO user(user_name, user_password,user_Permission)
VALUES(12240110002, 123456,2);
