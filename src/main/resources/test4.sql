create database if not exists test4;
USE test4;

create table `user`(
id int primary key auto_increment,
fullname varchar(50),
email varchar(50),
`password` varchar(50),
expInYear int,
 proSkill varchar(50),
projectId varchar(50),
`role` varchar(50)
);
INSERT INTO  `user`(fullname,email,`password`,expInYear,proSkill,projectId,`role`)
values('tu','tu24@gmail.com','Qaz123123',4,null,'VTI1','Manager');

INSERT INTO  `user`(fullname,email,`password`,expInYear,proSkill,projectId,`role`)
values('tudz','tudz@gmail.com','Qaz123123',6,null,'VTI2','Manager');

INSERT INTO  `user`(fullname,email,`password`,expInYear,proSkill,projectId,`role`)
values('tu1','tu1@gmail.com','Qaz123123',null,'Java','VTI1','Employee');

INSERT INTO  `user`(fullname,email,`password`,expInYear,proSkill,projectId,`role`)
values('tu2','tu2@gmail.com','Qaz123123',null,'C#','VTI2','Employee');
