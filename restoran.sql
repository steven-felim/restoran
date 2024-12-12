-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 12, 2024 at 02:04 PM
-- Server version: 11.3.0-MariaDB
-- PHP Version: 8.0.30

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
-- Table structure for table `booktable`
--

CREATE TABLE `booktable` (
                             `book_id` int(11) NOT NULL,
                             `table_id` varchar(10) NOT NULL,
                             `user_id` int(11) DEFAULT NULL,
                             `guest_id` int(11) DEFAULT NULL,
                             `date` date NOT NULL,
                             `status` enum('AVAILABLE','BOOKED') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
                        `cart_id` int(11) NOT NULL,
                        `user_id` int(11) DEFAULT NULL,
                        `guest_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `cart_items`
--

CREATE TABLE `cart_items` (
                              `cart_id` int(11) NOT NULL,
                              `fnb_id` int(11) NOT NULL,
                              `quantity` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `fnb`
--

CREATE TABLE `fnb` (
                       `fnb_id` int(11) NOT NULL,
                       `name` varchar(255) NOT NULL,
                       `stock` int(11) DEFAULT 0,
                       `price` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;


-- --------------------------------------------------------

--
-- Table structure for table `guest`
--

CREATE TABLE `guest` (
                         `guest_id` int(11) NOT NULL,
                         `guest_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tables`
--

CREATE TABLE `tables` (
                          `table_id` varchar(10) NOT NULL,
                          `table_no` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
                               `transaction_id` int(11) NOT NULL,
                               `cart_id` int(11) NOT NULL,
                               `voucher_id` int(11) DEFAULT NULL,
                               `date` date DEFAULT NULL,
                               `status` enum('PENDING','SUCCESS') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
                        `user_id` int(11) NOT NULL,
                        `name` varchar(255) NOT NULL,
                        `email` varchar(255) NOT NULL,
                        `password` varchar(255) NOT NULL,
                        `cellphone` varchar(13) NOT NULL,
                        `role` enum('ADMIN','EMPLOYEE','MEMBER') NOT NULL,
                        `wallet_balance` double(7,2) DEFAULT 0.00,
                        `pin` char(6) DEFAULT NULL,
                        `point` int(11) DEFAULT 0,
                        `jobdesk` enum('CASHIER','CHEF','WAITER','DELIVERYMAN') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;


-- --------------------------------------------------------

--
-- Table structure for table `voucher`
--

CREATE TABLE `voucher` (
                           `voucher_id` int(11) NOT NULL,
                           `name` varchar(255) NOT NULL,
                           `discount` double(2,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `booktable`
--
ALTER TABLE `booktable`
    ADD PRIMARY KEY (`book_id`),
    ADD KEY `table_id` (`table_id`),
    ADD KEY `user_id` (`user_id`),
    ADD KEY `guest_id` (`guest_id`);

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
    ADD PRIMARY KEY (`cart_id`),
    ADD KEY `user_id` (`user_id`),
    ADD KEY `guest_id` (`guest_id`);

--
-- Indexes for table `cart_items`
--
ALTER TABLE `cart_items`
    ADD PRIMARY KEY (`cart_id`,`fnb_id`),
    ADD KEY `fnb_id` (`fnb_id`);

--
-- Indexes for table `fnb`
--
ALTER TABLE `fnb`
    ADD PRIMARY KEY (`fnb_id`);

--
-- Indexes for table `guest`
--
ALTER TABLE `guest`
    ADD PRIMARY KEY (`guest_id`);

--
-- Indexes for table `tables`
--
ALTER TABLE `tables`
    ADD PRIMARY KEY (`table_id`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
    ADD PRIMARY KEY (`transaction_id`),
    ADD KEY `cart_id` (`cart_id`),
    ADD KEY `voucher_id` (`voucher_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
    ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `voucher`
--
ALTER TABLE `voucher`
    ADD PRIMARY KEY (`voucher_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `booktable`
--
ALTER TABLE `booktable`
    MODIFY `book_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
    MODIFY `cart_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `fnb`
--
ALTER TABLE `fnb`
    MODIFY `fnb_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `guest`
--
ALTER TABLE `guest`
    MODIFY `guest_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
    MODIFY `transaction_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
    MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `voucher`
--
ALTER TABLE `voucher`
    MODIFY `voucher_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `booktable`
--
ALTER TABLE `booktable`
    ADD CONSTRAINT `booktable_ibfk_1` FOREIGN KEY (`table_id`) REFERENCES `tables` (`table_id`) ON DELETE CASCADE ON UPDATE CASCADE,
    ADD CONSTRAINT `booktable_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
    ADD CONSTRAINT `booktable_ibfk_3` FOREIGN KEY (`guest_id`) REFERENCES `guest` (`guest_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `cart`
--
ALTER TABLE `cart`
    ADD CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
    ADD CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`guest_id`) REFERENCES `guest` (`guest_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `cart_items`
--
ALTER TABLE `cart_items`
    ADD CONSTRAINT `cart_items_ibfk_1` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`cart_id`) ON DELETE CASCADE ON UPDATE CASCADE,
    ADD CONSTRAINT `cart_items_ibfk_2` FOREIGN KEY (`fnb_id`) REFERENCES `fnb` (`fnb_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `transaction`
--
ALTER TABLE `transaction`
    ADD CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`cart_id`) ON DELETE CASCADE ON UPDATE CASCADE,
    ADD CONSTRAINT `transaction_ibfk_2` FOREIGN KEY (`voucher_id`) REFERENCES `voucher` (`voucher_id`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
