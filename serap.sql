-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 09, 2022 at 09:51 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `serap`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `atasan_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `is_active`, `name`, `role`, `atasan_id`) VALUES
(1, b'1', 'SUPERADMIN', 'ADMIN', 1),
(2, b'1', 'agungf', 'USER', 1);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(10);

-- --------------------------------------------------------

--
-- Table structure for table `penyerapan_dana_desa`
--

CREATE TABLE `penyerapan_dana_desa` (
  `id` bigint(20) NOT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `kd_desa` varchar(255) DEFAULT NULL,
  `kd_uraian_output` varchar(255) DEFAULT NULL,
  `keterangan` varchar(255) DEFAULT NULL,
  `persentase` varchar(255) DEFAULT NULL,
  `realisasi` varchar(255) DEFAULT NULL,
  `satuan_output` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `tahun` varchar(255) DEFAULT NULL,
  `volume` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `penyerapan_dana_desa`
--

INSERT INTO `penyerapan_dana_desa` (`id`, `created_date`, `kd_desa`, `kd_uraian_output`, `keterangan`, `persentase`, `realisasi`, `satuan_output`, `status`, `tahun`, `volume`) VALUES
(4, '44691,92809', '1802052008', '410503', 'Bibit sayuran, tanaman obat', '80', '10000000', 'PAKET', '0', '2022', '1'),
(5, '44691,9192824074', '1802052008', '130201', 'Update SDGS desa, Musyawarah, IDM', '45', '1000000', 'PAKET', '0', '2022', '3'),
(6, '44691,92986', '1802052008', '530001', 'Bulan Ke 2', '100', '30300000', 'KK', '0', '2022', '101'),
(7, '44691,92949', '1802052008', '530001', 'Bulan Ke 1', '100', '30300000', 'KK', '0', '2022', '101'),
(8, '44691,92704', '1802052008', '230501', '4 unit ', '50', '11940750', 'METER (M)', '0', '2022', '12'),
(9, '44691,92337', '1802052008', '420302', 'Pelebaran badan jalan', '100', '20940000', 'PAKET', '0', '2022', '1'),
(10, '44691,93036', '1802052008', '530001', 'Bulan Ke 3', '100', '30300000', 'KK', '0', '2022', '101'),
(11, '44691,92221', '1802052008', '220408', 'operasioanal, ruang isolasi, operasional tim tugas, rumah desa sehat', '20', '5250000', 'PAKET', '0', '2022', '4'),
(12, '44691,93105', '1802052008', '62201', 'Penyertaan Modal', '100', '13000000', 'Rupiah', '0', '2022', '13000000'),
(13, '44691,92006', '1802052008', '220204', 'Operasional Poskedes', '30', '7950000', 'PAKET', '0', '2022', '1'),
(14, '44691,9244', '1802052008', '123456', 'Peliharaan saluran , penambahan tanggul', '30', '45808000', 'Test6', '0', '2022', '6'),
(15, '44691,91706', '1802052008', '110401', '', '35', '14165000', 'PAKET', '0', '2022', '1'),
(16, '44691,92096', '1802052008', '220301', 'Senam Lansia', '30', '600000', 'ORANG', '0', '2022', '1'),
(17, '44691,91799', '1802052008', '110701', 'Intenssif RT', '35', '46500000', 'PAKET', '0', '2022', '12');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `rolename` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `rolename`) VALUES
(1, 'Admin'),
(2, 'User');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `last_login` datetime DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `created_at`, `last_login`, `password`, `updated_at`, `username`, `employee_id`, `role_id`) VALUES
(1, '2022-11-07 16:04:04', NULL, '$2a$10$YSoEL32BKtDXW4Qis4BxbeLo.A0wEhCqxnXayUqyVRrhPBE6GUBSW', '2022-11-07 16:04:04', 'tes', NULL, NULL),
(2, '2022-11-07 16:07:13', NULL, '$2a$10$gTjoYcTqOcLfKwgVpjBQfeUuZ50icDMamzJXLPn7bDrQ8bSLgQKdi', '2022-11-07 16:07:13', 'admin', NULL, 1),
(3, '2022-11-08 10:28:22', NULL, '$2a$10$bMbT6JtU2BCgPlQL7GlqreEQa7s81aeGcRywIrpTRZBDobEK.yE8i', '2022-11-08 10:28:22', 'adit', NULL, 1),
(4, '2022-11-08 14:29:27', NULL, '$2a$10$n92yHHAvStsXTrCA6rqXi.7DyjAAF4UiYQXUARM50630p1ZcF3ZJC', '2022-11-08 14:29:27', 'satu', NULL, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKt1d5v0t8yyobp5vj0h4pfmemn` (`atasan_id`);

--
-- Indexes for table `penyerapan_dana_desa`
--
ALTER TABLE `penyerapan_dana_desa`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK211dk0pe7l3aibwce8yy61ota` (`employee_id`),
  ADD KEY `FKn82ha3ccdebhokx3a8fgdqeyy` (`role_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `FKt1d5v0t8yyobp5vj0h4pfmemn` FOREIGN KEY (`atasan_id`) REFERENCES `employee` (`id`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK211dk0pe7l3aibwce8yy61ota` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `FKn82ha3ccdebhokx3a8fgdqeyy` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
