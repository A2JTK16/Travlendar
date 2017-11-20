-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 20, 2017 at 02:19 PM
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
-- Database: `travlendar2anew`
--

-- --------------------------------------------------------

--
-- Table structure for table `markers`
--

CREATE TABLE `markers` (
  `id` int(11) NOT NULL,
  `name` varchar(60) NOT NULL,
  `address` varchar(80) NOT NULL,
  `lat` float(10,6) NOT NULL,
  `lng` float(10,6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `markers`
--

INSERT INTO `markers` (`id`, `name`, `address`, `lat`, `lng`) VALUES
(1, 'Polban', 'Polban', -6.871882, 107.574783),
(2, 'Bandara', 'Bandara Depati Amir', -2.157335, 106.141151),
(3, 'Bandara', 'Bandara Soekarno Hatta', -6.127512, 106.653687);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `markers`
--
ALTER TABLE `markers`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `markers`
--
ALTER TABLE `markers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
