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
(1, 1, 1, 'Absensi dan Mengambil Surat Tugas', '2017-09-22 07:00:00', '2017-09-22 08:00:00', 'DRIVING', '2017-12-11 00:00:00', 'Jangan telat'),
(2, 2, 1, 'Keberangkatan Menuju Jakarta', '2017-09-22 08:20:00', '2017-09-22 10:20:00', 'TRANSIT', '2017-12-11 00:00:00', 'Jangan lupa bawa berkas'),
(3, 3, 1, 'Keberangkatan Menuju Tempat Rapat', '2017-09-22 11:20:00', '2017-09-22 11:50:00', 'DRIVING', '2017-12-11 00:00:00', 'Jangan telat'),
(4, 4, 1, 'Rapat', '2017-09-22 13:00:11', '2017-09-22 16:00:11', 'DRIVING', '2017-12-11 00:00:00', 'Rapat Pleno'),
(5, 5, 1, 'Mengunjungi Anak', '2017-09-22 17:00:11', '2017-09-22 20:00:11', 'TRANSIT', '2017-12-11 00:00:00', 'Silaturahim'),
(6, 6, 1, 'Kembali Pulang ke Bangka', '2017-09-23 04:00:11', '2017-09-22 06:00:11', 'TRANSIT', '2017-12-11 00:00:00', 'Jangan lupa bawa oleh-oleh');

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
(6, -2.16044, 106.141);

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
(1, 'maryam', 'aa@aa.vo', 'Ibu Maryam', 'Maryam', 'Belitung');

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
  MODIFY `EVENT_ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `location`
--
ALTER TABLE `location`
  MODIFY `LOCATION_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
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


Create or replace view viewevent as
SELECT
E.event_id, E.event_name, E.start_event ,
E.end_event , E.transportation,
E.departure_time, E.note,
L.latitude , L.longitude 
FROM
      event E, location L
   WHERE
      L.location_id = E.Location_id ;

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
