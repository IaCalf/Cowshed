--楼栋信息表-----------------
create table t_dormbuild(
dormBuildId number(11) primary key,--ID
dormBuildName varchar2(20),--楼栋号
dormBuildDetail varchar2(50)--描述
);

--创建序列
create sequence sq_t_dormbuild
start with 1 increment by 1;
select sq_t_dormbuild.nextval from dual;

--管理员信息表-----------------------
create table t_admin(
adminId number(11) primary key,--ID
userName varchar2(20),--登录帐号
password varchar2(20),--登录密码'
name varchar2(20),--姓名
sex varchar2(10),--性别
tel varchar2(20)--电话
);

--创建序列
create sequence sq_t_admin
start with 1 increment by 1;
select sq_t_admin.nextval from dual;

--寝室信息表---------------------
create table t_dorm(
dormId number(11) primary key,--ID
dormBuildId number(11),--寝室所在的楼ID
dormName varchar2(20),--房间号
dormType varchar2(20),--房间类型[男生寝室/女生寝室]'
dormNumber number(11),--房间能够住多少人
dormTel varchar2(20)--联系电话
);

--寝室信息表关联所在楼栋--
alter table t_dorm add constraint fk_t_dorm_dormbuild foreign key(dormBuildId)
references t_dormbuild(dormBuildId);

--创建序列
create sequence sq_t_dorm
start with 1 increment by 1;
select sq_t_dorm.nextval from dual;


--楼层管理员信息[宿管员]表----------------------
create table t_dormmanager(
dormManId number(11) primary key,--ID
userName varchar2(20),--账号
password varchar2(20),--密码
dormBuildId number(11),--所管楼栋
name varchar2(20),--姓名
sex varchar2(20),--性别
tel varchar2(20)--电话
);

--管理员信息表关联所管楼栋--
alter table t_dormmanager add constraint fk_t_dormmanager_dormbuild foreign key(dormBuildId)
references t_dormbuild(dormBuildId);

--创建序列
create sequence sq_t_dormmanager
start with 1 increment by 1;
select sq_t_dormmanager.nextval from dual;


--学生违规记录表-------------------------------
create table t_record(
recordId number(11) primary key,--ID
studentNumber varchar2(20),--学号
studentName varchar2(20),--姓名
dormBuildId number(11),--楼栋
dormName varchar2(20),--房间号
tdate date,--违规时间
detail varchar2(20)--违规描述
);

--学生违规记录表关联所属楼栋--
alter table t_record add constraint fk_t_record_dormbuild foreign key(dormBuildId)
references t_dormbuild(dormBuildId);

--创建序列
create sequence sq_t_record
start with 1 increment by 1;
select sq_t_record.nextval from dual;

--学生违规记录表关联所属寝室--
--alter table t_record add constraint fk_t_record_dormbuild foreign key(dormName)
--references t_dorm(dormId);


--学生信息表----------------------------------------
create table t_student(
studentId number(11) primary key,--ID
stuNum varchar2(20),--学号[登录帐号]
password varchar2(20),--登录密码'
name varchar2(20),--姓名
dormBuildId number(11),--所在楼栋
dormName varchar2(20),--房间号
sex varchar2(10),--性别
tel varchar2(20)--电话
);

--学生违规记录表关联所管楼栋--
alter table t_student add constraint fk_t_student_dormbuild foreign key(dormBuildId)-------------------出错
references t_dormbuild(dormBuildId);

--创建序列
create sequence sq_t_student
start with 1 increment by 1;
select sq_t_student.nextval from dual;



--创建触发器--
create or replace trigger t_dormbuild_trigger
before insert on t_dormbuild
for each row
begin
    select sq_t_dormbuild.nextval into:new.dormBuildId from sys.dual;
end;

--创建触发器--
create or replace trigger t_admin_trigger
before insert on t_admin
for each row
begin
    select sq_t_admin.nextval into:new.adminId from sys.dual;
end;

--创建触发器--
create or replace trigger t_dorm_trigger
before insert on t_dorm
for each row
begin
    select sq_t_dorm.nextval into:new.dormId from sys.dual;
end;

--创建触发器--
create or replace trigger t_dormmanager_trigger
before insert on t_dormmanager
for each row
begin
    select sq_t_dormmanager.nextval into:new.dormManId from sys.dual;
end;

--创建触发器--
create or replace trigger t_record_trigger
before insert on t_record
for each row
begin
    select sq_t_record.nextval into:new.recordId from sys.dual;
end;

--创建触发器--
create or replace trigger t_student_trigger
before insert on t_student
for each row
begin
    select sq_t_student.nextval into:new.studentId from sys.dual;
end;
