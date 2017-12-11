-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 11 Des 2017 pada 11.51
-- Versi Server: 10.1.25-MariaDB
-- PHP Version: 7.1.7

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
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `USERNAME` varchar(25) NOT NULL,
  `PASSWORD` varchar(25) DEFAULT NULL,
  `FULLNAME` varchar(30) DEFAULT NULL,
  `EMAIL` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `event`
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
-- Dumping data untuk tabel `event`
--

INSERT INTO `event` (`EVENT_ID`, `LOCATION_ID`, `TRAVELLER_ID`, `EVENT_NAME`, `START_EVENT`, `END_EVENT`, `TRANSPORTATION`, `DEPARTURE_TIME`, `NOTE`) VALUES
(1, 1, 1, 'Absensi dan Mengambil Surat Tugas', '2009-09-22 07:00:00', '2009-09-22 08:00:00', '', '2017-12-11 00:00:00', 'Jangan telat'),
(2, 2, 1, 'Keberangkatan Menuju Jakarta', '2009-09-22 08:20:00', '2009-09-22 10:20:00', '', '2017-12-11 00:00:00', 'Jangan lupa bawa berkas'),
(3, 3, 1, 'Keberangkatan Menuju Tempat Rapat', '2009-09-22 11:20:00', '2009-09-22 11:50:00', '', '2017-12-11 00:00:00', 'Jangan telat'),
(4, 4, 1, 'Rapat', '2009-09-22 13:00:11', '2009-09-22 16:00:11', '', '2017-12-11 00:00:00', 'Rapat Pleno'),
(5, 5, 1, 'Mengunjungi Anak', '2009-09-22 17:00:11', '2009-09-22 20:00:11', '', '2017-12-11 00:00:00', 'Silaturahim'),
(6, 6, 1, 'Kembali Pulang ke Bangka', '2009-09-22 04:00:11', '2009-09-22 06:00:11', '', '2017-12-11 00:00:00', 'Jangan lupa bawa oleh-oleh'),
(14, 18, 1, 'Rapat', '2017-11-28 10:00:00', '2017-11-28 14:00:00', 'TRANSIT', '2017-11-28 09:00:00', 'Jangan Telat'),
(15, 19, 1, 'Mengaji', '2017-11-28 14:00:00', '2017-11-28 15:00:00', 'TRANSIT', '2017-11-28 13:40:00', ''),
(16, 22, 1, '', '2017-11-28 11:00:00', '2017-11-28 11:30:00', 'TRANSIT', '2017-11-28 10:00:00', ''),
(17, 26, 1, '', '2017-11-28 11:00:00', '2017-11-28 11:30:00', 'TRANSIT', '2017-11-28 10:00:00', '');

-- --------------------------------------------------------

--
-- Struktur dari tabel `location`
--

CREATE TABLE `location` (
  `LOCATION_ID` int(11) NOT NULL,
  `LATITUDE` float DEFAULT NULL,
  `LONGITUDE` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `location`
--

INSERT INTO `location` (`LOCATION_ID`, `LATITUDE`, `LONGITUDE`) VALUES
(1, -2.75104, 107.658),
(2, -2.16044, 106.141),
(3, -6.12535, 106.66),
(4, -6.18283, 106.829),
(5, -6.20239, 106.653),
(6, -2.16044, 106.141),
(7, -6.8682, 107.601),
(8, -6.87131, 107.606),
(9, -6.92024, 107.628),
(10, -6.86884, 107.588),
(11, -6.91645, 107.614),
(12, -6.91651, 107.613),
(13, -6.91558, 107.613),
(14, -6.91645, 107.614),
(15, -6.91713, 107.613),
(16, -6.91933, 107.611),
(17, -6.91658, 107.611),
(18, -6.9179, 107.609),
(19, -6.86238, 107.558),
(20, -6.86279, 107.559),
(21, -6.86356, 107.561),
(22, -6.86113, 107.562),
(23, -6.86128, 107.575),
(24, -6.86079, 107.573),
(25, -6.8623, 107.561),
(26, -6.86358, 107.561);

-- --------------------------------------------------------

--
-- Struktur dari tabel `travel`
--

CREATE TABLE `travel` (
  `EVENT_ID` bigint(20) NOT NULL,
  `DEPATURE_TIME` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `traveller`
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
-- Dumping data untuk tabel `traveller`
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
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `event`
--
ALTER TABLE `event`
  MODIFY `EVENT_ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT for table `location`
--
ALTER TABLE `location`
  MODIFY `LOCATION_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT for table `traveller`
--
ALTER TABLE `traveller`
  MODIFY `TRAVELLER_ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `event`
--
ALTER TABLE `event`
  ADD CONSTRAINT `FK_CREATE` FOREIGN KEY (`TRAVELLER_ID`) REFERENCES `traveller` (`TRAVELLER_ID`),
  ADD CONSTRAINT `FK_LOCATED` FOREIGN KEY (`LOCATION_ID`) REFERENCES `location` (`LOCATION_ID`);

--
-- Ketidakleluasaan untuk tabel `travel`
--
ALTER TABLE `travel`
  ADD CONSTRAINT `FK_MEMILIKI_PE_AG` FOREIGN KEY (`EVENT_ID`) REFERENCES `event` (`EVENT_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
