create table week6_admin(
a_email varchar(60),
a_password varchar(60)
);

insert into week6_admin(a_email,a_password)
values ('admin','admin');

select * from week6_admin;
------------------------------------------------------------
create table week6_user (
u_id number(11),
u_name varchar(60) primary key,
u_email varchar(60),
u_password varchar(60)
);

select * from week6_user;
------------------------------------------------------------
create table week6_Warehouse(
p_id number(11) primary key,
u_name varchar(60),
p_type varchar(60),
no_of_boxes number(11),
no_of_days number(11)
);

CREATE SEQUENCE seq_user
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 100;

select * from week6_warehouse;

drop table week6_warehouse;

drop sequence seq_user;

------------------------------------------------------------
create table week6_billing(
b_id number(11) primary key,
u_name varchar(60),
p_id number(11),
p_type varchar(60),
no_of_boxes number,
no_of_days number,
t_amount number
);

CREATE SEQUENCE seq_billing
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 100;

select * from week6_billing;

drop table week6_billing;

drop sequence seq_billing;
------------------------------------------------------------
create table week6_Storage(
s_total number,
s_occupied number,
s_free number
);

insert into week6_storage(s_total,s_occupied,s_free)
VALUES(500,0,500);

select * from week6_storage;
-----------------------------------------------------------
update week6_storage set s_total=500, s_occupied=0,s_free=500;

select * from week6_storage;
