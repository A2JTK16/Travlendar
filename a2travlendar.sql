-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 22, 2017 at 11:54 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `a2travlendar`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `USERNAME` varchar(25) NOT NULL PRIMARY KEY,
  `PASSWORD` varchar(25) DEFAULT NULL,
  `FULLNAME` varchar(30) DEFAULT NULL,
  `EMAIL` varchar(40) DEFAULT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `EVENT_ID` bigint(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `LOCATION_ID` int(11) NOT NULL,
  `TRAVELLER_ID` bigint(20) NOT NULL,
  `EVENT_NAME` varchar(35) NOT NULL,
  `START_EVENT` datetime NOT NULL,
  `END_EVENT` datetime NOT NULL,
  `NOTE` text
);

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`LOCATION_ID`, `TRAVELLER_ID`, `EVENT_NAME`, `START_EVENT`, `END_EVENT`, `NOTE`) VALUES
(1, 1, 'Belanja', '2009-09-22 08:08:11', '2009-09-22 12:08:11', NULL),
(1, 1, 'Liburan', '2009-09-22 08:08:11', '2009-09-22 12:08:11', NULL),
(1, 1, 'Makan', '2009-09-22 08:08:11', '2009-09-22 12:08:11', NULL),
(1, 1, 'Sarapan', '2009-09-22 08:08:11', '2009-09-22 00:08:11', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `LOCATION_ID` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `LATITUDE` float DEFAULT NULL,
  `LONGITUDE` float DEFAULT NULL
);

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`LATITUDE`, `LONGITUDE`) VALUES
(22, 22);

-- --------------------------------------------------------

--
-- Table structure for table `travel`
--

CREATE TABLE `travel` (
  `EVENT_ID` bigint(20) PRIMARY KEY NOT NULL,
  `DEPATURE_TIME` datetime DEFAULT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table `traveller`
--

CREATE TABLE `traveller` (
  `TRAVELLER_ID` bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `TRAVELLER_NAME` varchar(30) DEFAULT NULL,
  `TRAVELLER_EMAIL` varchar(40) DEFAULT NULL,
  `TRAVELLER_PASSWORD` varchar(25) DEFAULT NULL,
  `TRAVELLER_FULLNAME` varchar(50) DEFAULT NULL,
  `TRAVELLER_ADDRESS` varchar(60) DEFAULT NULL
);

--
-- Dumping data for table `traveller`
--

INSERT INTO `traveller` (`TRAVELLER_NAME`, `TRAVELLER_EMAIL`, `TRAVELLER_PASSWORD`, `TRAVELLER_FULLNAME`, `TRAVELLER_ADDRESS`) VALUES
('Ibu Maryam', 'aa@aa.vo', 'Maryam', 'Maryam', 'Belitung');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD KEY `FK_CREATE` (`TRAVELLER_ID`),
  ADD KEY `FK_LOCATED` (`LOCATION_ID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `event`
--
ALTER TABLE `event`
  ADD CONSTRAINT `FK_CREATE` FOREIGN KEY (`TRAVELLER_ID`) REFERENCES `traveller` (`TRAVELLER_ID`),
  ADD CONSTRAINT `FK_LOCATED` FOREIGN KEY (`LOCATION_ID`) REFERENCES `location` (`LOCATION_ID`);

--
-- Constraints for table `travel`
--
ALTER TABLE `travel`
  ADD CONSTRAINT `FK_MEMILIKI_PE_AG` FOREIGN KEY (`EVENT_ID`) REFERENCES `event` (`EVENT_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
