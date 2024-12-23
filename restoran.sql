-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 23 Des 2024 pada 09.37
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `restoran`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `booktable`
--

CREATE TABLE `booktable` (
  `book_id` int(11) NOT NULL,
  `table_id` varchar(10) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `guest_id` int(11) DEFAULT NULL,
  `date` date NOT NULL,
  `status` enum('BOOKED','PENDING') NOT NULL,
  `counts_reschedule` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `cart`
--

CREATE TABLE `cart` (
  `cart_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `guest_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `cart_items`
--

CREATE TABLE `cart_items` (
  `cart_id` int(11) NOT NULL,
  `fnb_id` int(11) NOT NULL,
  `quantity` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `delivery`
--

CREATE TABLE `delivery` (
  `delivery_id` int(11) NOT NULL,
  `delivery_status` enum('PENDING','CONFIRMED','DELIVERED','RECEIVED') DEFAULT 'PENDING',
  `address` varchar(255) NOT NULL,
  `transaction_id` int(11) DEFAULT NULL,
  `deliveryman_id` int(11) DEFAULT -1
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `discount`
--

CREATE TABLE `discount` (
  `discount_id` int(11) NOT NULL,
  `role` enum('GUEST','MEMBER') DEFAULT NULL,
  `discount_percent` decimal(5,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `discount`
--

INSERT INTO `discount` (`discount_id`, `role`, `discount_percent`) VALUES
(1, 'GUEST', 0.00),
(2, 'MEMBER', 10.00);

-- --------------------------------------------------------

--
-- Struktur dari tabel `fnb`
--

CREATE TABLE `fnb` (
  `fnb_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `stock` int(11) DEFAULT 0,
  `price` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `fnb`
--

INSERT INTO `fnb` (`fnb_id`, `name`, `stock`, `price`) VALUES
(1, 'Nasi Goreng', 60, 25000),
(2, 'Nasi Goreng Kampung', 50, 27000),
(3, 'Mie Goreng', 70, 22000),
(4, 'Mie Aceh', 30, 35000),
(5, 'Sate Ayam', 50, 35000),
(6, 'Rendang', 30, 60000),
(7, 'Ayam Penyet', 40, 27000),
(8, 'Gado-Gado', 55, 20000),
(9, 'Soto Ayam', 45, 28000),
(10, 'Nasi Liwet', 50, 27000),
(11, 'Nasi Campur', 60, 25000),
(12, 'Kwetiau Siram', 30, 30000),
(13, 'Pecel Lele', 50, 25000),
(14, 'Tahu Tempe', 80, 12000),
(15, 'Lontong Sayur', 60, 18000),
(16, 'Ayam Goreng Kremes', 40, 28000),
(17, 'Kare Ayam', 30, 32000),
(18, 'Sop Buntut', 20, 65000),
(19, 'Tahu Gejrot', 70, 15000),
(20, 'Tahu Sumedang', 60, 10000),
(21, 'Es Kelapa Muda', 80, 25000),
(22, 'Es Campur', 90, 12000),
(23, 'Es Teh Manis', 150, 10000),
(24, 'Jus Alpukat', 80, 18000),
(25, 'Jus Jeruk', 120, 13000),
(26, 'Kopi Tubruk', 100, 12000),
(27, 'Es Kelapa Muda', 80, 17000),
(28, 'Teh Tarik', 90, 15000),
(29, 'Jus Semangka', 100, 12000),
(30, 'Air Mineral', 200, 5000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `guest`
--

CREATE TABLE `guest` (
  `guest_id` int(11) NOT NULL,
  `guest_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tables`
--

CREATE TABLE `tables` (
  `table_id` varchar(10) NOT NULL,
  `table_no` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `tables`
--

INSERT INTO `tables` (`table_id`, `table_no`) VALUES
('Indoor01', 1),
('Indoor02', 2),
('Indoor03', 3),
('Indoor04', 4),
('Indoor05', 5),
('Indoor06', 6),
('Indoor07', 7),
('Indoor08', 8),
('Indoor09', 9),
('Indoor10', 10),
('Outdoor01', 1),
('Outdoor02', 2),
('Outdoor03', 3),
('Outdoor04', 4),
('Outdoor05', 5),
('Outdoor06', 6),
('Outdoor07', 7),
('Outdoor08', 8),
('Outdoor09', 9),
('Outdoor10', 10),
('VIP1', 1),
('VIP2', 2),
('VIP3', 3),
('VIP4', 4),
('VIP5', 5);

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaction`
--

CREATE TABLE `transaction` (
  `transaction_id` int(11) NOT NULL,
  `cart_id` int(11) NOT NULL,
  `voucher_id` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `status` enum('PENDING','SUCCESS') NOT NULL,
  `discount_id` int(11) DEFAULT NULL,
  `discount_percent` decimal(5,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `cellphone` varchar(13) NOT NULL,
  `role` enum('ADMIN','EMPLOYEE','MEMBER') NOT NULL,
  `wallet_balance` double(10,2) DEFAULT 0.00,
  `pin` char(6) DEFAULT NULL,
  `point` int(11) DEFAULT 0,
  `jobdesk` enum('CASHIER','CHEF','WAITER','DELIVERYMAN') DEFAULT NULL,
  `deliveryman_status` enum('AVAILABLE','DELIVER') DEFAULT 'AVAILABLE'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`user_id`, `name`, `email`, `password`, `cellphone`, `role`, `wallet_balance`, `pin`, `point`, `jobdesk`, `deliveryman_status`) VALUES
(1, 'Admin', 'admin@hbresto.id', '123456xyz', '', 'ADMIN', 0.00, NULL, 0, NULL, 'AVAILABLE'),
(2, 'John Doe', 'johndoe@hbresto.id', '123456xyz', '', 'EMPLOYEE', 0.00, NULL, 0, 'CASHIER', 'AVAILABLE'),
(3, 'Jemima', 'jemima@hbresto.id', '123456xyz', '', 'EMPLOYEE', 0.00, NULL, 0, 'CHEF', 'AVAILABLE'),
(4, 'Nathan', 'nathan@hbresto.id', '123456xyz', '', 'EMPLOYEE', 0.00, NULL, 0, 'DELIVERYMAN', 'AVAILABLE'),
(5, 'Tiara', 'tiara@hbresto.id', '123456xyz', '', 'EMPLOYEE', 0.00, NULL, 0, 'WAITER', 'AVAILABLE'),
(6, 'Felim', 'felim@yahoo.com', 'hehe', '1123002', 'MEMBER', 0.00, '123002', 0, NULL, 'AVAILABLE'),
(7, 'Jochal', 'jochal@ithb.com', 'josef', '1123021', 'MEMBER', 9999999.00, '123021', 0, NULL, 'AVAILABLE'),
(8, 'Jesha', 'jesha@gmail.oom', 'alkeba', '1123044', 'MEMBER', 0.00, '123044', 0, NULL, 'AVAILABLE');

-- --------------------------------------------------------

--
-- Struktur dari tabel `voucher`
--

CREATE TABLE `voucher` (
  `voucher_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `discount` double(2,2) DEFAULT NULL,
  `nominal` int(6) DEFAULT 0,
  `point` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `booktable`
--
ALTER TABLE `booktable`
  ADD PRIMARY KEY (`book_id`),
  ADD KEY `table_id` (`table_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `guest_id` (`guest_id`);

--
-- Indeks untuk tabel `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`cart_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `guest_id` (`guest_id`);

--
-- Indeks untuk tabel `cart_items`
--
ALTER TABLE `cart_items`
  ADD PRIMARY KEY (`cart_id`,`fnb_id`),
  ADD KEY `fnb_id` (`fnb_id`);

--
-- Indeks untuk tabel `delivery`
--
ALTER TABLE `delivery`
  ADD PRIMARY KEY (`delivery_id`),
  ADD KEY `deliveryman_id` (`deliveryman_id`);

--
-- Indeks untuk tabel `discount`
--
ALTER TABLE `discount`
  ADD PRIMARY KEY (`discount_id`);

--
-- Indeks untuk tabel `fnb`
--
ALTER TABLE `fnb`
  ADD PRIMARY KEY (`fnb_id`);

--
-- Indeks untuk tabel `guest`
--
ALTER TABLE `guest`
  ADD PRIMARY KEY (`guest_id`);

--
-- Indeks untuk tabel `tables`
--
ALTER TABLE `tables`
  ADD PRIMARY KEY (`table_id`);

--
-- Indeks untuk tabel `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`transaction_id`),
  ADD KEY `cart_id` (`cart_id`),
  ADD KEY `voucher_id` (`voucher_id`),
  ADD KEY `discount_id` (`discount_id`) USING BTREE;

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indeks untuk tabel `voucher`
--
ALTER TABLE `voucher`
  ADD PRIMARY KEY (`voucher_id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `booktable`
--
ALTER TABLE `booktable`
  MODIFY `book_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `cart`
--
ALTER TABLE `cart`
  MODIFY `cart_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `delivery`
--
ALTER TABLE `delivery`
  MODIFY `delivery_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `discount`
--
ALTER TABLE `discount`
  MODIFY `discount_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `fnb`
--
ALTER TABLE `fnb`
  MODIFY `fnb_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT untuk tabel `guest`
--
ALTER TABLE `guest`
  MODIFY `guest_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `transaction`
--
ALTER TABLE `transaction`
  MODIFY `transaction_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT untuk tabel `voucher`
--
ALTER TABLE `voucher`
  MODIFY `voucher_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `booktable`
--
ALTER TABLE `booktable`
  ADD CONSTRAINT `booktable_ibfk_1` FOREIGN KEY (`table_id`) REFERENCES `tables` (`table_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `booktable_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `booktable_ibfk_3` FOREIGN KEY (`guest_id`) REFERENCES `guest` (`guest_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`guest_id`) REFERENCES `guest` (`guest_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `cart_items`
--
ALTER TABLE `cart_items`
  ADD CONSTRAINT `cart_items_ibfk_1` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`cart_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cart_items_ibfk_2` FOREIGN KEY (`fnb_id`) REFERENCES `fnb` (`fnb_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `delivery`
--
ALTER TABLE `delivery`
  ADD CONSTRAINT `delivery_ibfk_1` FOREIGN KEY (`deliveryman_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
