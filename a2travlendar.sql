-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 15, 2017 at 11:03 AM
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

DELIMITER $$
--
-- Functions
--
CREATE DEFINER=`root`@`localhost` FUNCTION `isThereUser` (`usrname` VARCHAR(30), `pass` VARCHAR(20)) RETURNS TINYINT(1) BEGIN

   DECLARE result BOOLEAN;

   SELECT COUNT(*) INTO @temp FROM traveller WHERE (traveller_name = usrname AND traveller_password = pass);
   IF @temp = 1 THEN SET result = TRUE;
   ELSEIF @temp = 0 THEN SET result = FALSE;
   END IF;

   RETURN(result);
   END$$

DELIMITER ;

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
  `TRANSPORTATION` varchar(20) NOT NULL,
  `DEPARTURE_TIME` datetime NOT NULL,
  `NOTE` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`EVENT_ID`, `LOCATION_ID`, `TRAVELLER_ID`, `EVENT_NAME`, `START_EVENT`, `END_EVENT`, `TRANSPORTATION`, `DEPARTURE_TIME`, `NOTE`) VALUES
(5, 5, 1, 'Mengunjungi Anak', '2017-09-22 17:00:11', '2017-09-22 20:00:11', 'TRANSIT', '2017-12-11 00:00:00', 'Silaturahim'),
(6, 4, 1, 'Kembali Pulang ke Bangka', '2017-09-23 04:00:11', '2017-09-22 06:00:11', 'TRANSIT', '2017-12-11 00:00:00', 'Jangan lupa bawa oleh-oleh'),
(7, 14, 4, 'mmmmmmmmmmmmmmm', '2017-11-28 00:00:00', '2017-11-28 21:00:00', 'DRIVING', '2017-11-28 22:00:00', '');

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `LOCATION_ID` int(11) NOT NULL,
  `LATITUDE` float(10,6) DEFAULT NULL,
  `LONGITUDE` float(10,6) DEFAULT NULL,
  `ADDRESS` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`LOCATION_ID`, `LATITUDE`, `LONGITUDE`, `ADDRESS`) VALUES
(1, -2.751040, 107.657997, 'Jl. Pemuda Dalam, Lesung Batang, Tj. Pandan, Kabupaten Belitung, Kepulauan Bangk'),
(2, -2.160440, 106.140999, 'Jl. Dahlia, Dul, Pangkalan Baru, Kabupaten Bangka Tengah, Kepulauan Bangka Belit'),
(3, -6.125350, 106.660004, 'Jl. P2, Pajang, Benda, Kota Tangerang, Banten 15126, Indonesia'),
(4, -6.182830, 106.829002, 'Jl. Kebon Sirih No.18, Kb. Sirih, Gambir, Kota Jakarta Pusat, Daerah Khusus Ibuk'),
(5, -6.202390, 106.653000, 'Jl. Gajah Mada No.2, Cipete, Pinang, Kota Tangerang, Banten 15142, Indonesia'),
(7, -6.206087, 106.852791, 'Jl. Minangkabau No.2, Ps. Manggis, Setia Budi, Kota Jakarta'),
(8, -6.209791, 106.849808, 'Jl. Minangkabau No.2, Ps. Manggis, Setia Budi, Kota Jakarta'),
(9, -6.913810, 107.601723, 'Jl. Kebon Sirih No.15, Babakan Ciamis, Sumur Bandung, Kota '),
(10, -6.913549, 107.602715, 'Jl. Kb. Sirih III, Babakan Ciamis, Sumur Bandung, Kota Band'),
(11, -6.916586, 107.605888, 'Jl. Kebon Sirih No.8, Babakan Ciamis, Sumur Bandung, Kota B'),
(12, -6.915346, 107.601250, 'Jl. Kb. Jukut No.3c, Babakan Ciamis, Sumur Bandung, Kota Ba'),
(13, -6.912186, 107.604729, 'Jl. Kb. Jukut No.7, Babakan Ciamis, Sumur Bandung, Kota Ban'),
(14, -6.917167, 107.605370, 'Jl. Stasiun Barat No.1, Kb. Jeruk, Andir, Kota Bandung, Jaw');

-- --------------------------------------------------------

--
-- Table structure for table `traveller`
--

CREATE TABLE `traveller` (
  `TRAVELLER_ID` bigint(20) NOT NULL,
  `TRAVELLER_NAME` varchar(20) DEFAULT NULL,
  `TRAVELLER_EMAIL` varchar(40) DEFAULT NULL,
  `TRAVELLER_PASSWORD` varchar(25) DEFAULT NULL,
  `TRAVELLER_FULLNAME` varchar(30) DEFAULT NULL,
  `TRAVELLER_ADDRESS` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `traveller`
--

INSERT INTO `traveller` (`TRAVELLER_ID`, `TRAVELLER_NAME`, `TRAVELLER_EMAIL`, `TRAVELLER_PASSWORD`, `TRAVELLER_FULLNAME`, `TRAVELLER_ADDRESS`) VALUES
(1, 'maryam', 'aa@aa.vo', '123', 'Maryam M', 'Belitung, Indonesia'),
(2, 'mufid', 'mm', '123', 'Mufid Jamaluddin', ''),
(3, 'mufidmm', 'mm', 'mm', 'Mufid Jamaluddin', ''),
(4, 'mmm', 'mmm', 'mmm', 'Mufid Jamaluddin', '');

-- --------------------------------------------------------

--
-- Stand-in structure for view `viewevent`
-- (See below for the actual view)
--
CREATE TABLE `viewevent` (
`traveller_id` bigint(20)
,`event_id` bigint(20)
,`event_name` varchar(35)
,`start_event` datetime
,`end_event` datetime
,`transportation` varchar(20)
,`departure_time` datetime
,`note` text
,`latitude` float(10,6)
,`longitude` float(10,6)
,`address` varchar(80)
);

-- --------------------------------------------------------

--
-- Structure for view `viewevent`
--
DROP TABLE IF EXISTS `viewevent`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `viewevent`  AS  select `e`.`TRAVELLER_ID` AS `traveller_id`,`e`.`EVENT_ID` AS `event_id`,`e`.`EVENT_NAME` AS `event_name`,`e`.`START_EVENT` AS `start_event`,`e`.`END_EVENT` AS `end_event`,`e`.`TRANSPORTATION` AS `transportation`,`e`.`DEPARTURE_TIME` AS `departure_time`,`e`.`NOTE` AS `note`,`l`.`LATITUDE` AS `latitude`,`l`.`LONGITUDE` AS `longitude`,`l`.`ADDRESS` AS `address` from (`event` `e` join `location` `l`) where (`l`.`LOCATION_ID` = `e`.`LOCATION_ID`) ;

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
-- Indexes for table `traveller`
--
ALTER TABLE `traveller`
  ADD PRIMARY KEY (`TRAVELLER_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `event`
--
ALTER TABLE `event`
  MODIFY `EVENT_ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `location`
--
ALTER TABLE `location`
  MODIFY `LOCATION_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `traveller`
--
ALTER TABLE `traveller`
  MODIFY `TRAVELLER_ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `event`
--
ALTER TABLE `event`
  ADD CONSTRAINT `FK_CREATE` FOREIGN KEY (`TRAVELLER_ID`) REFERENCES `traveller` (`TRAVELLER_ID`),
  ADD CONSTRAINT `FK_LOCATED` FOREIGN KEY (`LOCATION_ID`) REFERENCES `location` (`LOCATION_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
