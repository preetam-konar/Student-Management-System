drop schema if exists `student_directory`;

create schema `student_directory`;

use `student_directory`;


create table `department` (
	`id` int primary key not null auto_increment,
    `dept_name` varchar(30) not null,
    unique `dept_name_unique` (`dept_name`)
);

create table `student`(
	`id` int not null auto_increment primary key,
    `register_number` varchar(15) unique not null,
    `first_name` varchar(20),
    `last_name` varchar(20),
    `email` varchar(20) unique,
    `college_email` varchar(20) unique,
    `age` int,
    `gender` varchar(15),
    `dept_id` int default null,
    `semester` int default null,
    key `fk_dept_idx` (`dept_id`),
    constraint `fk_dept` foreign key (`dept_id`) references `department` (`id`)
);

insert into department(`dept_name`) values
('CTECH'),
('DSBS'),
('AIML'),
('CLOUD');
