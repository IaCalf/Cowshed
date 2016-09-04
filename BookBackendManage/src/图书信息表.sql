--ͼ����Ϣ��
create table book_info(
book_id number(10) primary key,--ͼ��ID
book_code varchar2(50) not null,--ͼ����
book_name varchar2(50) not null,--ͼ������
book_type number(10) not null,--ͼ������
book_author varchar2(50) not null,--ͼ������
publish_press varchar2(200) not null,--������
publish_date date not null,--��������
is_borrow number not null,--1��ʾ�ѽ��� 0δ����
createdBy varchar2(50) not null,--������
creation_time date not null,--����ʱ��
last_updatetime date not null);--����ʱ��

--ͼ�����ͱ�
create table book_type(
id number(10) primary key,--id
type_name varchar2(20)not null--ͼ����������
);
--��book_info������
alter table book_info add constraint fk_book_info_book_type foreign key(book_type)
references book_type(id);
--����book_info����
create sequence sq_book_info
start with 1 increment by 1;
select sq_book_info.nextval from dual;
--����book_type����
create sequence sq_book_type
start with 1 increment by 1;
select sq_book_type.nextval from dual;

--����book_info������
create or replace trigger book_info_trigger
before insert on book_info
for each row
begin
    select sq_book_info.nextval into:new.book_id from sys.dual;
end;

--����book_type������
create or replace trigger book_type_trigger
before insert on book_type
for each row
begin
    select sq_book_type.nextval into:new.id from sys.dual;
end;
--book_info��������
 insert into book_info (book_code,book_name,book_type,book_autho) values();
--book_type��������
 insert into book_type (type_name) values('����С˵');
