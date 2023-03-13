create database project1;

create table Person(
    id int GENERATED by DEFAULT as IDENTITY PRIMARY key,
    fullname varchar(200) UNIQUE not null,  
    year_birth int not null CHECK (year_birth>1900)
);

create table book (
    id int GENERATED by DEFAULT as IDENTITY PRIMARY key,
    title varchar(200) not null,
    author varchar(200) not null,
    year_of_publication int CHECK(year_of_publication>0),
    person_id int references Person(id) on delete set null
);