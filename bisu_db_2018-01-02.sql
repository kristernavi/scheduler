# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.18)
# Database: bisu_db
# Generation Time: 2018-01-02 10:39:26 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table courses
# ------------------------------------------------------------

DROP TABLE IF EXISTS `courses`;

CREATE TABLE `courses` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `code` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `department_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `courses_code_unique` (`code`),
  KEY `courses_department_id_foreign` (`department_id`),
  CONSTRAINT `courses_department_id_foreign` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;

INSERT INTO `courses` (`id`, `description`, `code`, `department_id`)
VALUES
	(1,'Good description','TT101',1);

/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table departments
# ------------------------------------------------------------

DROP TABLE IF EXISTS `departments`;

CREATE TABLE `departments` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `code` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `head` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `departments_code_unique` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;

INSERT INTO `departments` (`id`, `description`, `code`, `head`)
VALUES
	(1,'A fantasic descriotion here','Testing 101','My heade department');

/*!40000 ALTER TABLE `departments` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table faculties
# ------------------------------------------------------------

DROP TABLE IF EXISTS `faculties`;

CREATE TABLE `faculties` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `prc_no` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `firstname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `lastname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `middlename` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rank` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `designation` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `eligibility` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `specialization` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `degree_earned` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `post_degree` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `min_load` smallint(5) unsigned NOT NULL DEFAULT '1',
  `max_load` smallint(5) unsigned NOT NULL DEFAULT '1',
  `department_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `faculties_prc_no_unique` (`prc_no`),
  KEY `faculties_department_id_foreign` (`department_id`),
  CONSTRAINT `faculties_department_id_foreign` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

LOCK TABLES `faculties` WRITE;
/*!40000 ALTER TABLE `faculties` DISABLE KEYS */;

INSERT INTO `faculties` (`id`, `prc_no`, `firstname`, `lastname`, `middlename`, `rank`, `designation`, `eligibility`, `specialization`, `degree_earned`, `post_degree`, `min_load`, `max_load`, `department_id`)
VALUES
	(1,'101020','Ivan','Garcia','Bungabong',NULL,NULL,NULL,NULL,NULL,NULL,1,1,1);

/*!40000 ALTER TABLE `faculties` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table migrations
# ------------------------------------------------------------

DROP TABLE IF EXISTS `migrations`;

CREATE TABLE `migrations` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `migration` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

LOCK TABLES `migrations` WRITE;
/*!40000 ALTER TABLE `migrations` DISABLE KEYS */;

INSERT INTO `migrations` (`id`, `migration`, `batch`)
VALUES
	(1,'2014_10_12_000000_create_users_table',1),
	(2,'2017_12_19_094912_create_departments_table',1),
	(3,'2017_12_19_095759_create_rooms_table',1),
	(4,'2017_12_19_095810_create_teachers_table',1),
	(5,'2017_12_23_015628_create_courses_table',1),
	(6,'2017_12_24_100001_create_subjects_table',1),
	(7,'2017_12_27_173936_create_school_years_table',1),
	(8,'2017_12_28_150108_create_teachers_loadings_table',1),
	(9,'2017_12_28_150355_create_teachers_loading_details_table',1),
	(10,'2018_01_02_090409_table_forieng_key_to_details',2);

/*!40000 ALTER TABLE `migrations` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table rooms
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rooms`;

CREATE TABLE `rooms` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `location` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `type` enum('lecture','laboratory','lec_lab') COLLATE utf8_unicode_ci NOT NULL,
  `capacity` int(10) unsigned NOT NULL,
  `number` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `rooms_number_unique` (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

LOCK TABLES `rooms` WRITE;
/*!40000 ALTER TABLE `rooms` DISABLE KEYS */;

INSERT INTO `rooms` (`id`, `description`, `location`, `type`, `capacity`, `number`)
VALUES
	(1,'Description','Location','lecture',30,222);

/*!40000 ALTER TABLE `rooms` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table school_years
# ------------------------------------------------------------

DROP TABLE IF EXISTS `school_years`;

CREATE TABLE `school_years` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `year` int(10) unsigned NOT NULL,
  `semester` smallint(5) unsigned NOT NULL,
  `actived` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

LOCK TABLES `school_years` WRITE;
/*!40000 ALTER TABLE `school_years` DISABLE KEYS */;

INSERT INTO `school_years` (`id`, `year`, `semester`, `actived`)
VALUES
	(1,2018,2,1);

/*!40000 ALTER TABLE `school_years` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table subjects
# ------------------------------------------------------------

DROP TABLE IF EXISTS `subjects`;

CREATE TABLE `subjects` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `code` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `course_id` int(10) unsigned DEFAULT NULL,
  `pre_requisite_id` int(10) unsigned DEFAULT NULL,
  `year_level` smallint(5) unsigned NOT NULL,
  `semester` smallint(5) unsigned NOT NULL,
  `units` smallint(5) unsigned NOT NULL,
  `lec_hours` int(10) unsigned DEFAULT NULL,
  `lab_hours` int(10) unsigned DEFAULT NULL,
  `type` enum('major','general','elective') COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `subjects_code_unique` (`code`),
  KEY `subjects_pre_requisite_id_foreign` (`pre_requisite_id`),
  KEY `subjects_course_id_foreign` (`course_id`),
  CONSTRAINT `subjects_course_id_foreign` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`),
  CONSTRAINT `subjects_pre_requisite_id_foreign` FOREIGN KEY (`pre_requisite_id`) REFERENCES `subjects` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;

INSERT INTO `subjects` (`id`, `description`, `code`, `course_id`, `pre_requisite_id`, `year_level`, `semester`, `units`, `lec_hours`, `lab_hours`, `type`)
VALUES
	(1,'My beautifull description here','T101',1,NULL,1,1,0,3,3,'general');

/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table teachers_loading_details
# ------------------------------------------------------------

DROP TABLE IF EXISTS `teachers_loading_details`;

CREATE TABLE `teachers_loading_details` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `room_id` int(10) unsigned NOT NULL,
  `hour_start` time DEFAULT NULL,
  `hour_end` time DEFAULT NULL,
  `M` tinyint(1) NOT NULL DEFAULT '0',
  `T` tinyint(1) NOT NULL DEFAULT '0',
  `W` tinyint(1) NOT NULL DEFAULT '0',
  `Th` tinyint(1) NOT NULL DEFAULT '0',
  `F` tinyint(1) NOT NULL DEFAULT '0',
  `loading_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `teachers_loading_details_loading_id_foreign` (`loading_id`),
  KEY `teachers_loading_details_room_id_foreign` (`room_id`),
  CONSTRAINT `teachers_loading_details_loading_id_foreign` FOREIGN KEY (`loading_id`) REFERENCES `teachers_loadings` (`id`),
  CONSTRAINT `teachers_loading_details_room_id_foreign` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

LOCK TABLES `teachers_loading_details` WRITE;
/*!40000 ALTER TABLE `teachers_loading_details` DISABLE KEYS */;

INSERT INTO `teachers_loading_details` (`id`, `room_id`, `hour_start`, `hour_end`, `M`, `T`, `W`, `Th`, `F`, `loading_id`)
VALUES
	(1,1,'18:09:45','18:09:45',1,0,0,0,0,4),
	(2,1,'18:09:45','18:09:45',0,1,0,0,0,4),
	(3,1,'18:09:45','18:09:45',0,0,0,0,1,4);

/*!40000 ALTER TABLE `teachers_loading_details` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table teachers_loadings
# ------------------------------------------------------------

DROP TABLE IF EXISTS `teachers_loadings`;

CREATE TABLE `teachers_loadings` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `teacher_id` int(10) unsigned NOT NULL,
  `subject_id` int(10) unsigned NOT NULL,
  `school_year_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `teachers_loadings_teacher_id_foreign` (`teacher_id`),
  KEY `teachers_loadings_subject_id_foreign` (`subject_id`),
  KEY `teachers_loadings_school_year_id_foreign` (`school_year_id`),
  CONSTRAINT `teachers_loadings_school_year_id_foreign` FOREIGN KEY (`school_year_id`) REFERENCES `school_years` (`id`),
  CONSTRAINT `teachers_loadings_subject_id_foreign` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`),
  CONSTRAINT `teachers_loadings_teacher_id_foreign` FOREIGN KEY (`teacher_id`) REFERENCES `faculties` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

LOCK TABLES `teachers_loadings` WRITE;
/*!40000 ALTER TABLE `teachers_loadings` DISABLE KEYS */;

INSERT INTO `teachers_loadings` (`id`, `teacher_id`, `subject_id`, `school_year_id`)
VALUES
	(2,1,1,1),
	(3,1,1,1),
	(4,1,1,1);

/*!40000 ALTER TABLE `teachers_loadings` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table users
# ------------------------------------------------------------

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `users_email_unique` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
