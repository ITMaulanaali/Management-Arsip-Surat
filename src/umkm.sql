-- phpMyAdmin SQL Dump
-- version 5.1.1deb5ubuntu1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 12, 2024 at 09:29 AM
-- Server version: 8.0.40-0ubuntu0.22.04.1
-- PHP Version: 8.1.2-1ubuntu2.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `umkm`
--

-- --------------------------------------------------------

--
-- Table structure for table `detail_izin_produk`
--

CREATE TABLE `detail_izin_produk` (
  `id_Izin_Produk` int NOT NULL,
  `id_Produk` int NOT NULL,
  `id_Master_Izin` int NOT NULL,
  `Tgl_Pengajuan_Izin_Produk` date NOT NULL,
  `Tgl_Berakhir_Izin_Produk` date DEFAULT NULL,
  `Status_Izin_Produk` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detail_izin_produk`
--

INSERT INTO `detail_izin_produk` (`id_Izin_Produk`, `id_Produk`, `id_Master_Izin`, `Tgl_Pengajuan_Izin_Produk`, `Tgl_Berakhir_Izin_Produk`, `Status_Izin_Produk`) VALUES
(1, 1, 2, '2024-01-15', '2029-01-15', 'Disetujui'),
(2, 2, 2, '2024-02-20', '2029-02-20', 'Disetujui'),
(3, 3, 2, '2024-03-10', '2029-03-10', 'Disetujui'),
(4, 4, 2, '2023-10-10', '2028-10-10', 'Disetujui'),
(5, 5, 2, '2023-12-12', '2029-12-12', 'Disetujui'),
(6, 6, 2, '2024-04-05', '2029-04-05', 'Tertunda'),
(7, 7, 2, '2024-05-15', '2029-05-15', 'Disetujui'),
(8, 8, 2, '2024-06-25', '2029-06-25', 'Disetujui'),
(9, 9, 2, '2024-07-30', '2029-07-30', 'Tertunda'),
(10, 10, 2, '2024-08-20', '2029-08-20', 'Disetujui'),
(11, 11, 2, '2024-09-10', '2029-09-10', 'Disetujui');

-- --------------------------------------------------------

--
-- Table structure for table `detail_izin_umkm`
--

CREATE TABLE `detail_izin_umkm` (
  `id_Izin_UMKM` int NOT NULL,
  `id_UMKM` int NOT NULL,
  `id_Master_Izin` int NOT NULL,
  `Tgl_Pengajuan_Izin_UMKM` date NOT NULL,
  `Tgl_Berakhir_Izin_UMKM` date DEFAULT NULL,
  `Status_Izin_UMKM` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detail_izin_umkm`
--

INSERT INTO `detail_izin_umkm` (`id_Izin_UMKM`, `id_UMKM`, `id_Master_Izin`, `Tgl_Pengajuan_Izin_UMKM`, `Tgl_Berakhir_Izin_UMKM`, `Status_Izin_UMKM`) VALUES
(1, 1, 1, '2024-10-05', '2029-10-05', 'Disetujui'),
(2, 2, 1, '2024-10-05', '2029-10-05', 'Tertunda'),
(3, 3, 1, '2024-10-05', '2029-10-05', 'Disetujui'),
(4, 4, 1, '2023-10-10', '2028-10-10', 'Disetujui'),
(5, 5, 1, '2023-12-12', '2029-12-12', 'Disetujui');

-- --------------------------------------------------------

--
-- Table structure for table `master_izin`
--

CREATE TABLE `master_izin` (
  `id_Master_Izin` int NOT NULL,
  `Jenis_Izin` varchar(50) NOT NULL,
  `Keterangan` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `master_izin`
--

INSERT INTO `master_izin` (`id_Master_Izin`, `Jenis_Izin`, `Keterangan`) VALUES
(1, 'Izin Usaha', 'Izin UMKM  adalah dokumen resmi yang diberikan oleh pemerintah kepada pelaku usaha untuk menjalankan kegiatan bisnis secara legal.'),
(2, 'Izin Edar Produk', 'Izin edar produk adalah dokumen resmi yang dikeluarkan oleh pemerintah atau lembaga berwenang yang memberikan izin kepada suatu produk untuk dipasarkan dan didistribusikan kepada konsumen.'),
(3, 'Halal', 'babi');

-- --------------------------------------------------------

--
-- Table structure for table `produk`
--

CREATE TABLE `produk` (
  `id_Produk` int NOT NULL,
  `Nama_Produk` varchar(100) NOT NULL,
  `Kategori_Produk` varchar(50) DEFAULT NULL,
  `Harga_Produk` decimal(10,2) NOT NULL,
  `id_UMKM` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `produk`
--

INSERT INTO `produk` (`id_Produk`, `Nama_Produk`, `Kategori_Produk`, `Harga_Produk`, `id_UMKM`) VALUES
(1, 'Original Tea', 'Minuman', '3000.00', 1),
(2, 'Choco Milktea', 'Minuman', '5000.00', 1),
(3, 'Lemon Tea', 'Minuman', '4000.00', 1),
(4, 'Sempol Biasa', 'Makanan', '1000.00', 2),
(5, 'Sempol Pedes', 'Makanan', '1000.00', 2),
(6, 'Cilok Goang Paedes', 'Makanan', '5000.00', 4),
(7, 'Cilok Goang Ori', 'Makanan', '5000.00', 4),
(8, 'Cilok Bumbu kacang', 'Makanan', '5000.00', 4),
(9, 'Molen', 'Makanan', '5000.00', 4),
(10, 'Sebring', 'Makanan', '5000.00', 4),
(11, 'Cireng isi', 'Makanan', '5000.00', 4);

-- --------------------------------------------------------

--
-- Table structure for table `umkm`
--

CREATE TABLE `umkm` (
  `id_UMKM` int NOT NULL,
  `Nama_UMKM` varchar(100) NOT NULL,
  `Owner` varchar(50) NOT NULL,
  `Alamat` text NOT NULL,
  `Notelp` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `umkm`
--

INSERT INTO `umkm` (`id_UMKM`, `Nama_UMKM`, `Owner`, `Alamat`, `Notelp`) VALUES
(1, 'Es Teh Nusantara', 'Faiz Royi', 'Jl. Gang Lebar Wonocolo, Surabaya', '0895332090704'),
(2, 'Sempol Enak', 'Agus', 'Perum. Makarya Binangon, Sidoarjo', '085784577687'),
(3, 'Kebab Kaboss', 'Kabib', 'Jl. Mangkurejo 59 Sedati, Sidoarjo', '0895337013170'),
(4, 'Cilok Goang', 'Ridwan', 'Jl. Raya Pagesangan 1, Sidoarjo', '087746230502'),
(5, 'Dinotice Food & Beverage', 'Akmal', 'Jl. Gang Lebar Wonocolo, Surabaya', '085785905832'),
(6, 'bhbhb', 'jbnjkbhb', 'ub', 'nnjn'),
(7, 'ANU', 'iya', 'dd', 'ddd'),
(8, 'hasan', 'gaming', '1wd', 'dad'),
(9, 'hasan', 'hasan', 'hasan', '08777'),
(10, 'hasan', 'hasan', 'hasan', 'hasan'),
(11, 'Hasan', 'dwd', 'wdw', 'dwd'),
(36, 'as', 'sa', 'sd', 'sd'),
(37, 'p', 'p', 'p', '000'),
(38, 'teh', 'lana', 'jl kebon agung', '08765544');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id_User` int NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Role` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id_User`, `Username`, `Password`, `Role`) VALUES
(1, 'jaya', '123', 'admin'),
(2, 'lana', '123', 'admin'),
(3, 'hasan', '123', 'admin'),
(4, 'dita', '123', 'admin'),
(5, 'nopal', '123', 'admin'),
(6, 'faiz', '1234', 'users'),
(7, 'agus', '1234', 'users'),
(8, 'kabib', '1234', 'users'),
(9, 'ridwan', '1234', 'users'),
(10, 'akmal', '1234', 'users'),
(122, 'jya', '123', 'Users'),
(124, 'jk', '12', 'Admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `detail_izin_produk`
--
ALTER TABLE `detail_izin_produk`
  ADD PRIMARY KEY (`id_Izin_Produk`),
  ADD KEY `id_Produk` (`id_Produk`),
  ADD KEY `id_Master_Izin` (`id_Master_Izin`);

--
-- Indexes for table `detail_izin_umkm`
--
ALTER TABLE `detail_izin_umkm`
  ADD PRIMARY KEY (`id_Izin_UMKM`),
  ADD KEY `id_UMKM` (`id_UMKM`),
  ADD KEY `id_Master_Izin` (`id_Master_Izin`);

--
-- Indexes for table `master_izin`
--
ALTER TABLE `master_izin`
  ADD PRIMARY KEY (`id_Master_Izin`);

--
-- Indexes for table `produk`
--
ALTER TABLE `produk`
  ADD PRIMARY KEY (`id_Produk`),
  ADD KEY `id_UMKM` (`id_UMKM`);

--
-- Indexes for table `umkm`
--
ALTER TABLE `umkm`
  ADD PRIMARY KEY (`id_UMKM`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_User`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `detail_izin_produk`
--
ALTER TABLE `detail_izin_produk`
  MODIFY `id_Izin_Produk` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `detail_izin_umkm`
--
ALTER TABLE `detail_izin_umkm`
  MODIFY `id_Izin_UMKM` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `master_izin`
--
ALTER TABLE `master_izin`
  MODIFY `id_Master_Izin` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `produk`
--
ALTER TABLE `produk`
  MODIFY `id_Produk` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `umkm`
--
ALTER TABLE `umkm`
  MODIFY `id_UMKM` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id_User` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=125;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `detail_izin_produk`
--
ALTER TABLE `detail_izin_produk`
  ADD CONSTRAINT `detail_izin_produk_ibfk_1` FOREIGN KEY (`id_Produk`) REFERENCES `produk` (`id_Produk`),
  ADD CONSTRAINT `detail_izin_produk_ibfk_2` FOREIGN KEY (`id_Master_Izin`) REFERENCES `master_izin` (`id_Master_Izin`);

--
-- Constraints for table `detail_izin_umkm`
--
ALTER TABLE `detail_izin_umkm`
  ADD CONSTRAINT `detail_izin_umkm_ibfk_1` FOREIGN KEY (`id_UMKM`) REFERENCES `umkm` (`id_UMKM`),
  ADD CONSTRAINT `detail_izin_umkm_ibfk_2` FOREIGN KEY (`id_Master_Izin`) REFERENCES `master_izin` (`id_Master_Izin`);

--
-- Constraints for table `produk`
--
ALTER TABLE `produk`
  ADD CONSTRAINT `produk_ibfk_1` FOREIGN KEY (`id_UMKM`) REFERENCES `umkm` (`id_UMKM`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
