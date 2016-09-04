--图书信息表
create table book_info(
book_id number(10) primary key,--图书ID
book_code varchar2(50) not null,--图书编号
book_name varchar2(50) not null,--图书名称
book_type number(10) not null,--图书类型
book_author varchar2(50) not null,--图书作者
publish_press varchar2(200) not null,--出版社
publish_date date not null,--出版日期
is_borrow number not null,--1表示已借阅 0未借阅
createdBy varchar2(50) not null,--创建人
creation_time date not null,--创建时间
last_updatetime date not null);--更新时间

--图书类型表
create table book_type(
id number(10) primary key,--id
type_name varchar2(20)not null--图书类型名称
);
--给book_info添加外键
alter table book_info add constraint fk_book_info_book_type foreign key(book_type)
references book_type(id);
--创建book_info序列
create sequence sq_book_info
start with 1 increment by 1;
select sq_book_info.nextval from dual;
--创建book_type序列
create sequence sq_book_type
start with 1 increment by 1;
select sq_book_type.nextval from dual;

--创建book_info触发器
create or replace trigger book_info_trigger
before insert on book_info
for each row
begin
    select sq_book_info.nextval into:new.book_id from sys.dual;
end;

--创建book_type触发器
create or replace trigger book_type_trigger
before insert on book_type
for each row
begin
    select sq_book_type.nextval into:new.id from sys.dual;
end;
--book_info插入数据
 insert into book_info (book_code,book_name,book_type,book_autho) values();
--book_type插入数据
 insert into book_type (type_name) values('推理小说');
