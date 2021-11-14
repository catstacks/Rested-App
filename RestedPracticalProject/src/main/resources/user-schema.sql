DROP TABLE IF EXISTS `RESTED_USER` CASCADE; 

CREATE TABLE `RESTED_USER` (
	`id` integer NOT NULL, 
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
	`id` integer NOT NULL, 
	`user_id` integer NOT NULL,
	`journal_id` integer NOT NULL,
	`date` date NOT NULL,
	`hours` integer NOT NULL,
	`minutes` integer NOT NULL,	
	PRIMARY KEY (`id`)
); 

DROP TABLE IF EXISTS `dream_journal` CASCADE; 

CREATE TABLE `dream_journal` (
	`id` integer NOT NULL, 
	`sleep_rating` integer(2) NOT NULL,
	`description` varchar(500),	
	PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `screen_time` CASCADE; 

CREATE TABLE `screen_time` (
	`id` integer NOT NULL, 
	`user_id` integer NOT NULL,
	`date` date NOT NULL,
	`hours` integer NOT NULL,
	`minutes` integer NOT NULL,	
	PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `water` CASCADE; 

CREATE TABLE `water` (
	`id` integer NOT NULL, 
	`user_id` integer NOT NULL,
	`name` varchar(50) NOT NULL,
	`default_serving` varchar(10) NOT NULL,
	`serving_size_amount` double NOT NULL,
	PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `water_consumed` CASCADE; 

CREATE TABLE `water_consumed` (
	`id` integer NOT NULL, 
	`user_id` integer NOT NULL,
	`water_id` integer NOT NULL,
	`date` date NOT NULL,
	`serving_size` varchar(10) NOT NULL,
	`serving_amount` double NOT NULL,
	PRIMARY KEY (`id`)
); 

DROP TABLE IF EXISTS `weekly_report_data` CASCADE; 

CREATE TABLE `weekly_report_data` (
	`id` integer NOT NULL, 
	`user_id` integer NOT NULL,
	`date` date NOT NULL,
	`weekly_sleep` double NOT NULL,
	`weekly_water` double NOT NULL,
	`weekly_screen_time` double NOT NULL,
	PRIMARY KEY (`id`)
);