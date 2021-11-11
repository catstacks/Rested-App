drop table if exists `rested_users` CASCADE; 
create table 
	`rested_user` 
(
	id long AUTO_INCREMENT, 
	firstName varchar(255), 
	lastName varchar(255), 
	age integer not null,
	email varchar(255),
	primary key (id)
);