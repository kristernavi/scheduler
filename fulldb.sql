-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: bisu_db
-- ------------------------------------------------------
-- Server version	5.7.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courses` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `code` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `department_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `courses_code_unique` (`code`),
  KEY `courses_department_id_foreign` (`department_id`),
  CONSTRAINT `courses_department_id_foreign` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1,'hello','Hi',1);
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departments`
--

DROP TABLE IF EXISTS `departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departments` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `code` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `head` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `departments_code_unique` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departments`
--

LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` VALUES (1,'Descption','Code1','Head'),(2,'its me','hello','the head');
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculties`
--

DROP TABLE IF EXISTS `faculties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  `regular_load` int(10) unsigned NOT NULL DEFAULT '0',
  `deloading` int(10) unsigned NOT NULL DEFAULT '0',
  `overload` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `faculties_prc_no_unique` (`prc_no`),
  KEY `faculties_department_id_foreign` (`department_id`),
  CONSTRAINT `faculties_department_id_foreign` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculties`
--

LOCK TABLES `faculties` WRITE;
/*!40000 ALTER TABLE `faculties` DISABLE KEYS */;
INSERT INTO `faculties` VALUES (1,'qwe','Ivan','Garcia','Krister','Class S','Designation','elig','special','earned','post',0,0,1,30,20,10);
/*!40000 ALTER TABLE `faculties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `load_courses`
--

DROP TABLE IF EXISTS `load_courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `load_courses` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `load_detail_id` int(10) unsigned NOT NULL,
  `course_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `load_courses_load_detail_id_foreign` (`load_detail_id`),
  KEY `load_courses_course_id_foreign` (`course_id`),
  CONSTRAINT `load_courses_course_id_foreign` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`) ON DELETE CASCADE,
  CONSTRAINT `load_courses_load_detail_id_foreign` FOREIGN KEY (`load_detail_id`) REFERENCES `teachers_loading_details` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `load_courses`
--

LOCK TABLES `load_courses` WRITE;
/*!40000 ALTER TABLE `load_courses` DISABLE KEYS */;
INSERT INTO `load_courses` VALUES (3,4,1),(4,5,1);
/*!40000 ALTER TABLE `load_courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `migrations`
--

DROP TABLE IF EXISTS `migrations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `migrations` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `migration` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `migrations`
--

LOCK TABLES `migrations` WRITE;
/*!40000 ALTER TABLE `migrations` DISABLE KEYS */;
INSERT INTO `migrations` VALUES (1,'2014_10_12_000000_create_users_table',1),(2,'2017_12_19_094912_create_departments_table',1),(3,'2017_12_19_095759_create_rooms_table',1),(4,'2017_12_19_095810_create_teachers_table',1),(5,'2017_12_23_015628_create_courses_table',1),(6,'2017_12_24_100001_create_subjects_table',1),(7,'2017_12_27_173936_create_school_years_table',1),(8,'2017_12_28_150108_create_teachers_loadings_table',1),(9,'2017_12_28_150355_create_teachers_loading_details_table',1),(10,'2018_01_02_090409_table_forieng_key_to_details',1),(11,'2018_01_06_013617_add_prerequites_table_subjects',1),(12,'2018_01_06_143610_create_subject_departments_table',1),(13,'2018_01_06_160023_create_subject_courses_table',1),(15,'2018_01_12_005930_add_colums_in_facutlies',2),(18,'2018_01_30_112614_create_load_courses_table',3);
/*!40000 ALTER TABLE `migrations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rooms`
--

DROP TABLE IF EXISTS `rooms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rooms` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `location` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `type` enum('lecture','laboratory','lec_lab') COLLATE utf8_unicode_ci NOT NULL,
  `capacity` int(10) unsigned NOT NULL,
  `number` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `rooms_number_unique` (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rooms`
--

LOCK TABLES `rooms` WRITE;
/*!40000 ALTER TABLE `rooms` DISABLE KEYS */;
INSERT INTO `rooms` VALUES (1,'helo','aw','lecture',30,222);
/*!40000 ALTER TABLE `rooms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `school_years`
--

DROP TABLE IF EXISTS `school_years`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `school_years` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `year_start` int(10) unsigned NOT NULL,
  `semester` smallint(5) unsigned NOT NULL,
  `actived` tinyint(1) NOT NULL DEFAULT '0',
  `year_end` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `school_years`
--

LOCK TABLES `school_years` WRITE;
/*!40000 ALTER TABLE `school_years` DISABLE KEYS */;
INSERT INTO `school_years` VALUES (1,2017,1,0,2018),(2,2018,1,0,2019),(3,2018,2,1,2019),(4,2015,1,0,2016);
/*!40000 ALTER TABLE `school_years` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_courses`
--

DROP TABLE IF EXISTS `subject_courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject_courses` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `subject_id` int(10) unsigned NOT NULL,
  `course_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `subject_courses_course_id_foreign` (`course_id`),
  KEY `subject_courses_subject_id_foreign` (`subject_id`),
  CONSTRAINT `subject_courses_course_id_foreign` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`),
  CONSTRAINT `subject_courses_subject_id_foreign` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_courses`
--

LOCK TABLES `subject_courses` WRITE;
/*!40000 ALTER TABLE `subject_courses` DISABLE KEYS */;
INSERT INTO `subject_courses` VALUES (6,2,1);
/*!40000 ALTER TABLE `subject_courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_departments`
--

DROP TABLE IF EXISTS `subject_departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject_departments` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `subject_id` int(10) unsigned NOT NULL,
  `department_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `subject_departments_department_id_foreign` (`department_id`),
  KEY `subject_departments_subject_id_foreign` (`subject_id`),
  CONSTRAINT `subject_departments_department_id_foreign` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`),
  CONSTRAINT `subject_departments_subject_id_foreign` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_departments`
--

LOCK TABLES `subject_departments` WRITE;
/*!40000 ALTER TABLE `subject_departments` DISABLE KEYS */;
/*!40000 ALTER TABLE `subject_departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  `pre_requisite` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `subjects_code_unique` (`code`),
  KEY `subjects_pre_requisite_id_foreign` (`pre_requisite_id`),
  KEY `subjects_course_id_foreign` (`course_id`),
  CONSTRAINT `subjects_course_id_foreign` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`),
  CONSTRAINT `subjects_pre_requisite_id_foreign` FOREIGN KEY (`pre_requisite_id`) REFERENCES `subjects` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` VALUES (2,'My Decription','44D',NULL,NULL,1,1,3,4,4,'general','aa');
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachers_loading_details`
--

DROP TABLE IF EXISTS `teachers_loading_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers_loading_details`
--

LOCK TABLES `teachers_loading_details` WRITE;
/*!40000 ALTER TABLE `teachers_loading_details` DISABLE KEYS */;
INSERT INTO `teachers_loading_details` VALUES (4,1,'07:30:00','09:30:00',1,1,1,0,0,20),(5,1,'10:30:00','11:30:00',1,0,0,1,1,20);
/*!40000 ALTER TABLE `teachers_loading_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachers_loadings`
--

DROP TABLE IF EXISTS `teachers_loadings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers_loadings`
--

LOCK TABLES `teachers_loadings` WRITE;
/*!40000 ALTER TABLE `teachers_loadings` DISABLE KEYS */;
INSERT INTO `teachers_loadings` VALUES (20,1,2,3);
/*!40000 ALTER TABLE `teachers_loadings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `users_email_unique` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-04 14:28:27
