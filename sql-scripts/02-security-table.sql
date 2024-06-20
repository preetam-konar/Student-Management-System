use `student_directory`;

drop table if exists `users`;
drop table if exists `roles`;

create table `users` (
	`user_id` varchar(50) not null,
    `pw` char(68) not null,
    `active` tinyint not null,
    primary key (`user_id`)
);

create table `roles` (
	`user_id` varchar(50) not null,
    `role` varchar(50) not null,
    key `fk_user_id_idx` (`user_id`),
    constraint `fk_user_id` foreign key (`user_id`) references `users` (`user_id`)
)