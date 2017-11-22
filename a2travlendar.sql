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
  `USERNAME` varchar(25) NOT NULL,
  `PASSWORD` varchar(25) DEFAULT NULL,
  `FULLNAME` varchar(30) DEFAULT NULL,
  `EMAIL` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `EVENT_ID` bigint(20) NOT NULL,
  `LOCATION_ID` int(11) NOT NULL,
  `TRAVELLER_ID` bigint(20) NOT NULL,
  `EVENT_NAME` varchar(35) NOT NULL,
  `START_EVENT` datetime NOT NULL,
  `END_EVENT` datetime NOT NULL,
  `NOTE` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`EVENT_ID`, `LOCATION_ID`, `TRAVELLER_ID`, `EVENT_NAME`, `START_EVENT`, `END_EVENT`, `NOTE`) VALUES
(1, 1, 1, 'Belanja', '2009-09-22 08:08:11', '2009-09-22 12:08:11', NULL),
(2, 1, 1, 'Liburan', '2009-09-22 08:08:11', '2009-09-22 12:08:11', NULL),
(3, 1, 1, 'Makan', '2009-09-22 08:08:11', '2009-09-22 12:08:11', NULL),
(4, 1, 1, 'Sarapan', '2009-09-22 08:08:11', '2009-09-22 00:08:11', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `LOCATION_ID` int(11) NOT NULL,
  `LATITUDE` float DEFAULT NULL,
  `LONGITUDE` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`LOCATION_ID`, `LATITUDE`, `LONGITUDE`) VALUES
(1, 22, 22);

-- --------------------------------------------------------

--
-- Table structure for table `travel`
--

CREATE TABLE `travel` (
  `EVENT_ID` bigint(20) NOT NULL,
  `DEPATURE_TIME` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `traveller`
--

CREATE TABLE `traveller` (
  `TRAVELLER_ID` bigint(20) NOT NULL,
  `TRAVELLER_NAME` varchar(30) DEFAULT NULL,
  `TRAVELLER_EMAIL` varchar(40) DEFAULT NULL,
  `TRAVELLER_PASSWORD` varchar(25) DEFAULT NULL,
  `TRAVELLER_FULLNAME` varchar(50) DEFAULT NULL,
  `TRAVELLER_ADDRESS` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `traveller`
--

INSERT INTO `traveller` (`TRAVELLER_ID`, `TRAVELLER_NAME`, `TRAVELLER_EMAIL`, `TRAVELLER_PASSWORD`, `TRAVELLER_FULLNAME`, `TRAVELLER_ADDRESS`) VALUES
(1, 'Ibu Maryam', 'aa@aa.vo', 'Maryam', 'Maryam', 'Belitung');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`USERNAME`);

--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`EVENT_ID`),
  ADD KEY `FK_CREATE` (`TRAVELLER_ID`),
  ADD KEY `FK_LOCATED` (`LOCATION_ID`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`LOCATION_ID`);

--
-- Indexes for table `travel`
--
ALTER TABLE `travel`
  ADD PRIMARY KEY (`EVENT_ID`);

--
-- Indexes for table `traveller`
--
ALTER TABLE `traveller`
  ADD PRIMARY KEY (`TRAVELLER_ID`);

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
