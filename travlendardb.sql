-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 23, 2018 at 08:13 PM
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

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `event_id` bigint(20) NOT NULL,
  `traveller_username` varchar(30) NOT NULL,
  `start_location_id` int(11) NOT NULL,
  `end_location_id` int(11) NOT NULL,
  `event_name` varchar(35) NOT NULL,
  `start_event` datetime NOT NULL,
  `end_event` datetime NOT NULL,
  `note` text
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`event_id`, `traveller_username`, `start_location_id`, `end_location_id`, `event_name`, `start_event`, `end_event`, `note`) VALUES
(1, 'maryam', 1, 2, 'Absensi dan Mengambil Surat Tugas', '2017-12-22 07:00:00', '2017-12-22 08:00:00', 'Jangan telat'),
(2, 'maryam', 2, 3, 'Keberangkatan Menuju Jakarta', '2017-12-22 08:20:00', '2017-12-22 10:20:00', 'Jangan lupa bawa berkas'),
(3, 'maryam', 3, 4, 'Keberangkatan Menuju Tempat Rapat', '2017-12-22 11:20:00', '2017-12-22 11:50:00', 'Jangan telat'),
(4, 'maryam', 4, 5, 'Rapat', '2017-12-22 13:00:11', '2017-12-22 16:00:11', 'Rapat Pleno'),
(5, 'maryam', 5, 4, 'Mengunjungi Anak', '2017-12-22 17:00:11', '2017-12-22 20:00:11', 'Silaturahim'),
(6, 'maryam', 6, 7, 'Kunjungan Politeknik Negeri Jakarta', '2018-04-23 04:00:00', '2018-04-23 08:00:00', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`traveller_username`,`event_id`,`start_location_id`,`end_location_id`) USING BTREE,
  ADD KEY `FK_LOCATED` (`start_location_id`),
  ADD KEY `FK_RELATIONSHIP_4` (`end_location_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `event`
--
ALTER TABLE `event`
  MODIFY `event_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
