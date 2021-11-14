 DROP TABLE IF EXISTS `rested_users` CASCADE; 

CREATE TABLE `rested_users` (
	`id` binary(16) NOT NULL, 
	`dob` date NOT NULL,
	`age` integer NOT NULL,
	`sleep_quality` integer NOT NULL,
	`email` varchar(255) NOT NULL,
	`password` varchar(255),
	`first_name` varchar(255) NOT NULL, 
	`last_name` varchar(255) NOT NULL,	
	PRIMARY KEY (`id`)
);