-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 05, 2021 at 02:32 PM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inventory_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `inventoryorder`
--

CREATE TABLE `inventoryorder` (
  `inventoryOrder_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `supplier_id` int(11) NOT NULL,
  `ware_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `inventoryorder`
--
ALTER TABLE `inventoryorder`
  ADD PRIMARY KEY (`inventoryOrder_id`),
  ADD UNIQUE KEY `supplier_id` (`supplier_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `ware_id` (`ware_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `inventoryorder`
--
ALTER TABLE `inventoryorder`
  MODIFY `inventoryOrder_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `inventoryorder`
--
ALTER TABLE `inventoryorder`
  ADD CONSTRAINT `inventoryorder_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  ADD CONSTRAINT `inventoryorder_ibfk_2` FOREIGN KEY (`supplier_id`) REFERENCES `users` (`user_id`),
  ADD CONSTRAINT `inventoryorder_ibfk_3` FOREIGN KEY (`ware_id`) REFERENCES `warehouse` (`ware_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
