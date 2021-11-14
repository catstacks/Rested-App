DROP TABLE IF EXISTS `RESTED_USER` CASCADE; 

CREATE TABLE `RESTED_USER` (
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

DROP TABLE IF EXISTS `screen_time` CASCADE; 

CREATE TABLE `screen_time` (
	`id` binary(16) NOT NULL, 
	`user_id` COLLATE utf8_bin NOT NULL,
	`date` date NOT NULL,
	`hours` integer NOT NULL,
	`minutes` integer NOT NULL,	
	PRIMARY KEY (`id`)
); ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS `water` CASCADE; 

CREATE TABLE `water` (
	`id` binary(16) NOT NULL, 
	`user_id` COLLATE utf8_bin NOT NULL,
	`name` varchar(50) NOT NULL,
	`default_serving` varchar(10) NOT NULL,
	`serving_size_amount` double NOT NULL,
	PRIMARY KEY (`id`)
); ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS `water_consumed` CASCADE; 

CREATE TABLE `water_consumed` (
	`id` binary(16) NOT NULL, 
	`user_id` COLLATE utf8_bin NOT NULL,
	`water_id` COLLATE utf8_bin NOT NULL,
	`date` date NOT NULL,
	`serving_size` varchar(10) NOT NULL,
	`serving_amount` double NOT NULL,
	PRIMARY KEY (`id`)
); ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS `weekly_report_data` CASCADE; 

CREATE TABLE `weekly_report_data` (
	`id` binary(16) NOT NULL, 
	`user_id` COLLATE utf8_bin NOT NULL,
	`date` date NOT NULL,
	`weekly_sleep` double NOT NULL,
	`weekly_water` double NOT NULL,
	`weekly_screen_time` double NOT NULL,
	PRIMARY KEY (`id`)
); ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;