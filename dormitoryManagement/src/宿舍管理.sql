--¥����Ϣ��-----------------
create table t_dormbuild(
dormBuildId number(11) primary key,--ID
dormBuildName varchar2(20),--¥����
dormBuildDetail varchar2(50)--����
);

--��������
create sequence sq_t_dormbuild
start with 1 increment by 1;
select sq_t_dormbuild.nextval from dual;

--����Ա��Ϣ��-----------------------
create table t_admin(
adminId number(11) primary key,--ID
userName varchar2(20),--��¼�ʺ�
password varchar2(20),--��¼����'
name varchar2(20),--����
sex varchar2(10),--�Ա�
tel varchar2(20)--�绰
);

--��������
create sequence sq_t_admin
start with 1 increment by 1;
select sq_t_admin.nextval from dual;

--������Ϣ��---------------------
create table t_dorm(
dormId number(11) primary key,--ID
dormBuildId number(11),--�������ڵ�¥ID
dormName varchar2(20),--�����
dormType varchar2(20),--��������[��������/Ů������]'
dormNumber number(11),--�����ܹ�ס������
dormTel varchar2(20)--��ϵ�绰
);

--������Ϣ���������¥��--
alter table t_dorm add constraint fk_t_dorm_dormbuild foreign key(dormBuildId)
references t_dormbuild(dormBuildId);

--��������
create sequence sq_t_dorm
start with 1 increment by 1;
select sq_t_dorm.nextval from dual;


--¥�����Ա��Ϣ[�޹�Ա]��----------------------
create table t_dormmanager(
dormManId number(11) primary key,--ID
userName varchar2(20),--�˺�
password varchar2(20),--����
dormBuildId number(11),--����¥��
name varchar2(20),--����
sex varchar2(20),--�Ա�
tel varchar2(20)--�绰
);

--����Ա��Ϣ���������¥��--
alter table t_dormmanager add constraint fk_t_dormmanager_dormbuild foreign key(dormBuildId)
references t_dormbuild(dormBuildId);

--��������
create sequence sq_t_dormmanager
start with 1 increment by 1;
select sq_t_dormmanager.nextval from dual;


--ѧ��Υ���¼��-------------------------------
create table t_record(
recordId number(11) primary key,--ID
studentNumber varchar2(20),--ѧ��
studentName varchar2(20),--����
dormBuildId number(11),--¥��
dormName varchar2(20),--�����
tdate date,--Υ��ʱ��
detail varchar2(20)--Υ������
);

--ѧ��Υ���¼���������¥��--
alter table t_record add constraint fk_t_record_dormbuild foreign key(dormBuildId)
references t_dormbuild(dormBuildId);

--��������
create sequence sq_t_record
start with 1 increment by 1;
select sq_t_record.nextval from dual;

--ѧ��Υ���¼�������������--
--alter table t_record add constraint fk_t_record_dormbuild foreign key(dormName)
--references t_dorm(dormId);


--ѧ����Ϣ��----------------------------------------
create table t_student(
studentId number(11) primary key,--ID
stuNum varchar2(20),--ѧ��[��¼�ʺ�]
password varchar2(20),--��¼����'
name varchar2(20),--����
dormBuildId number(11),--����¥��
dormName varchar2(20),--�����
sex varchar2(10),--�Ա�
tel varchar2(20)--�绰
);

--ѧ��Υ���¼���������¥��--
alter table t_student add constraint fk_t_student_dormbuild foreign key(dormBuildId)-------------------����
references t_dormbuild(dormBuildId);

--��������
create sequence sq_t_student
start with 1 increment by 1;
select sq_t_student.nextval from dual;



--����������--
create or replace trigger t_dormbuild_trigger
before insert on t_dormbuild
for each row
begin
    select sq_t_dormbuild.nextval into:new.dormBuildId from sys.dual;
end;

--����������--
create or replace trigger t_admin_trigger
before insert on t_admin
for each row
begin
    select sq_t_admin.nextval into:new.adminId from sys.dual;
end;

--����������--
create or replace trigger t_dorm_trigger
before insert on t_dorm
for each row
begin
    select sq_t_dorm.nextval into:new.dormId from sys.dual;
end;

--����������--
create or replace trigger t_dormmanager_trigger
before insert on t_dormmanager
for each row
begin
    select sq_t_dormmanager.nextval into:new.dormManId from sys.dual;
end;

--����������--
create or replace trigger t_record_trigger
before insert on t_record
for each row
begin
    select sq_t_record.nextval into:new.recordId from sys.dual;
end;

--����������--
create or replace trigger t_student_trigger
before insert on t_student
for each row
begin
    select sq_t_student.nextval into:new.studentId from sys.dual;
end;
