DROP TABLE IF EXISTS `rested_users` CASCADE; 

CREATE TABLE `rested_users` (
	`id` binary(16) NOT NULL, 
	`dob` date NOT NULL,
	`age` integer NOT NULL,
	`sleep_quality` integer NOT NULL,
	`email` varchar(100) NOT NULL,
	`password` varchar(100),
	`first_name` varchar(20) NOT NULL, 
	`last_name` varchar(20) NOT NULL,	
	PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `daily_sleep` CASCADE; 

CREATE TABLE `daily_sleep` (
	`id` binary(16) NOT NULL, 
	`user_id` COLLATE utf8_bin NOT NULL,
	`journal_id` COLLATE utf8_bin NOT NULL,
	`date` date NOT NULL,
	`hours` integer NOT NULL,
	`minutes` integer NOT NULL,	
	PRIMARY KEY (`id`)
); ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS `dream_journal` CASCADE; 

CREATE TABLE `dream_journal` (
	`id` binary(16) NOT NULL, 
	`sleep_rating` integer(2) NOT NULL,
	`description` varchar(500),	
	PRIMARY KEY (`id`)
);