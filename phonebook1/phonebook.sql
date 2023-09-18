/******************************
 phonebook
*******************************/
drop table person;
drop sequence seq_person_id;

--person테이블 생성
create table person(
    person_id   number(5),
    name        varchar2(30) not null,
    hp          varchar2(20),
    company     varchar2(20),
    primary key(person_id)
);

--person시퀀스 생성
CREATE SEQUENCE seq_person_id
INCREMENT BY 1 
START WITH 1 
NOCACHE;

--insert문
insert into person
values(seq_person_id.nextval, '정우성', '010-2222-2222', '02-222-2222');

--delete문
delete from person
where person_id = 1;

--update문
update person
set name = '박명수',
    hp = '010-567-9088',
    company = '02-3252-3234'
where person_id = 2;

--전체select
select  person_id,
        name,
        hp,
        company
from person;

--특정번호select
select  person_id,
        name,
        hp,
        company
from person
where person_id = 2;

--제목검색select
select  person_id,
        name,
        hp,
        company
from person
where name like '%성%';
