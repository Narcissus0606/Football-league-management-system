create database footballSample
go

USE FOOTBALLsample



if exists(select * from sysobjects where name='GOALSCORE')
DROP TABLE GOALSCORE

if exists(select * from sysobjects where name='SCORE')
 DROP TABLE SCORE

if exists(select * from sysobjects where name='GOAL')
drop table goal

if exists(select * from sysobjects where name='COURSE')
drop table course

if exists(select * from sysobjects where name='MEMBER')
drop table member


if exists(select * from sysobjects where name='TEAM')
drop table team

GO

CREATE TABLE TEAM (
NAME VARCHAR(20) PRIMARY KEY ,
HOME VARCHAR(30) ,
COACH VARCHAR(20) )


CREATE TABLE MEMBER(
NAME VARCHAR(20) NOT NULL,
TEAMNAME VARCHAR(20) NOT NULL FOREIGN KEY REFERENCES TEAM(NAME),
NUMBER   INT NOT NULL ,
POSITION VARCHAR(6) check(position in('守门员','后卫','前卫','前锋')) ,
HEIGHT  INT ,
WEIGHT INT ,
BIRTHDATE DATETIME ,
PRIMARY KEY(TEAMNAME,NUMBER)
)

create table course(
  home varchar(20) not null references team(name),
  away varchar(20) not null references team(name),
  turn int not null,
  matchdate  datetime not null,
  homescore  int not null,
  awayscore  int not null,
  primary key (home,away)
)


create table goal(
teamname varchar(20) not null,
number   int         not null,
turn     int         not null,
goaltime datetime    not null,
foreign key(teamname,number) references member(teamname,number),
primary key (teamname,number,turn,goaltime)
)

create table score(
 place int not null default 0,
 name  varchar(20)  primary key,
 turn  int  not null,
 won int not null,
 even int not null,
 beaten int not null,
goal   int not null,
lost   int not null,
net int not null,
point  int not null 
)


create table goalscore(
  place int not null default 0,
  name  varchar(20) not null ,
  teamname varchar(20),
  number  int not null,
  goals  int  not null,
  foreign key (teamname,number) references member(teamname,number),
  primary key(teamname,number)
)
go















