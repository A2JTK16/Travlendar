-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 18, 2017 at 10:04 AM
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
-- Database: `travlendardb`
--

DELIMITER $$
--
-- Functions
--
CREATE DEFINER=`root`@`localhost` FUNCTION `isThereUser` (`usrname` VARCHAR(30), `pass` VARCHAR(40)) RETURNS TINYINT(1) BEGIN

   DECLARE result BOOLEAN;

   SELECT COUNT(*) INTO @temp FROM traveller WHERE (traveller_username = usrname AND traveller_password = pass);
   IF @temp = 1 THEN SET result = TRUE;
   ELSEIF @temp = 0 THEN SET result = FALSE;
   END IF;

   RETURN(result);
   END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `traveller_username` varchar(30) NOT NULL,
  `start_location_id` int(11) NOT NULL,
  `end_location_id` int(11) NOT NULL,
  `event_id` bigint(20) NOT NULL,
  `event_name` varchar(35) NOT NULL,
  `start_event` datetime NOT NULL,
  `end_event` datetime NOT NULL,
  `note` text
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`traveller_username`, `start_location_id`, `end_location_id`, `event_id`, `event_name`, `start_event`, `end_event`, `note`) VALUES
('maryam', 1, 2, 1, 'Absensi dan Mengambil Surat Tugas', '2017-12-22 07:00:00', '2017-12-22 08:00:00', 'Jangan telat'),
('maryam', 2, 3, 2, 'Keberangkatan Menuju Jakarta', '2017-12-22 08:20:00', '2017-12-22 10:20:00', 'Jangan lupa bawa berkas'),
('maryam', 3, 4, 3, 'Keberangkatan Menuju Tempat Rapat', '2017-12-22 11:20:00', '2017-12-22 11:50:00', 'Jangan telat'),
('maryam', 4, 5, 4, 'Rapat', '2017-12-22 13:00:11', '2017-12-22 16:00:11', 'Rapat Pleno'),
('maryam', 5, 4, 5, 'Mengunjungi Anak', '2017-12-22 17:00:11', '2017-12-22 20:00:11', 'Silaturahim');

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `location_id` int(11) NOT NULL,
  `latitude` float NOT NULL,
  `longitude` float NOT NULL,
  `location_name` varchar(100) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`location_id`, `latitude`, `longitude`, `location_name`) VALUES
(1, -2.75104, 107.658, 'Jl. Pemuda Dalam, Lesung Batang, Tj. Pandan, Kabupaten Belitung, Kepulauan Bangka Belitung 33412,'),
(2, -2.16044, 106.141, 'Jl. Dahlia, Dul, Pangkalan Baru, Kabupaten Bangka Tengah, Kepulauan Bangka Belitung 33684, Indonesia'),
(3, -6.12535, 106.66, '\r\nJl. P2, Pajang, Benda, Kota Tangerang, Banten 15126, Indonesia'),
(4, -6.18283, 106.829, '\r\nJl. Kebon Sirih No.18, Kb. Sirih, Gambir, Kota Jakarta Pusat, Daerah Khusus Ibukota Jakarta 10110,'),
(5, -6.20239, 106.653, '\r\nJl. Gajah Mada No.2, Cipete, Pinang, Kota Tangerang, Banten 15142, Indonesia');

-- --------------------------------------------------------

--
-- Table structure for table `travel`
--

CREATE TABLE `travel` (
  `traveller_username` varchar(30) NOT NULL,
  `start_location_id` int(11) NOT NULL,
  `end_location_id` int(11) NOT NULL,
  `event_id` bigint(20) NOT NULL,
  `depature_time` datetime NOT NULL,
  `transportation_mode` enum('walking','driving','bicycling','transit') NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `travel`
--

INSERT INTO `travel` (`traveller_username`, `start_location_id`, `end_location_id`, `event_id`, `depature_time`, `transportation_mode`) VALUES
('maryam', 1, 2, 1, '2017-09-22 06:00:00', 'driving'),
('maryam', 2, 3, 2, '2017-09-22 08:00:00', 'transit'),
('maryam', 3, 4, 3, '2017-09-22 11:00:00', 'transit'),
('maryam', 4, 5, 4, '2017-09-22 15:20:00', 'driving'),
('maryam', 5, 4, 5, '2017-09-22 19:00:00', 'driving');

-- --------------------------------------------------------

--
-- Table structure for table `traveller`
--

CREATE TABLE `traveller` (
  `traveller_username` varchar(30) NOT NULL,
  `traveller_email` varchar(40) NOT NULL,
  `traveller_password` varchar(25) NOT NULL,
  `traveller_fullname` varchar(50) DEFAULT NULL,
  `traveller_address` varchar(60) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `traveller`
--

INSERT INTO `traveller` (`traveller_username`, `traveller_email`, `traveller_password`, `traveller_fullname`, `traveller_address`) VALUES
('maryam', 'maryam@yahoo.co', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', 'Maryam', 'Belitung');

-- --------------------------------------------------------

--
-- Stand-in structure for view `viewevent`
-- (See below for the actual view)
--
CREATE TABLE `viewevent` (
`traveller_username` varchar(30)
,`event_id` bigint(20)
,`event_name` varchar(35)
,`start_event` datetime
,`end_event` datetime
,`note` text
,`start_location_name` varchar(100)
,`strt_loc_lat` float
,`strt_loc_long` float
,`end_location_name` varchar(100)
,`end_loc_lat` float
,`end_loc_long` float
,`transportation_mode` enum('walking','driving','bicycling','transit')
,`depature_time` datetime
);

-- --------------------------------------------------------

--
-- Structure for view `viewevent`
--
DROP TABLE IF EXISTS `viewevent`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `viewevent`  AS  select distinct `e`.`traveller_username` AS `traveller_username`,`e`.`event_id` AS `event_id`,`e`.`event_name` AS `event_name`,`e`.`start_event` AS `start_event`,`e`.`end_event` AS `end_event`,`e`.`note` AS `note`,`l1`.`location_name` AS `start_location_name`,`l1`.`latitude` AS `strt_loc_lat`,`l1`.`longitude` AS `strt_loc_long`,`l2`.`location_name` AS `end_location_name`,`l2`.`latitude` AS `end_loc_lat`,`l2`.`longitude` AS `end_loc_long`,`t`.`transportation_mode` AS `transportation_mode`,`t`.`depature_time` AS `depature_time` from ((((`traveller` `tl` join `event` `e`) join `location` `l1`) join `location` `l2`) join `travel` `t`) where ((`e`.`event_id` = `t`.`event_id`) and (`l1`.`location_id` = `e`.`start_location_id`) and (`l2`.`location_id` = `e`.`end_location_id`)) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`traveller_username`,`start_location_id`,`end_location_id`,`event_id`),
  ADD KEY `FK_LOCATED` (`start_location_id`),
  ADD KEY `FK_RELATIONSHIP_4` (`end_location_id`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`location_id`);

--
-- Indexes for table `travel`
--
ALTER TABLE `travel`
  ADD PRIMARY KEY (`traveller_username`,`start_location_id`,`end_location_id`,`event_id`);

--
-- Indexes for table `traveller`
--
ALTER TABLE `traveller`
  ADD PRIMARY KEY (`traveller_username`),
  ADD UNIQUE KEY `traveller_email` (`traveller_email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `event`
--
ALTER TABLE `event`
  MODIFY `event_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `location`
--
ALTER TABLE `location`
  MODIFY `location_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
