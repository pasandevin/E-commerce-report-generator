-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Sep 30, 2021 at 10:34 AM
-- Server version: 5.7.34
-- PHP Version: 7.4.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `report_generator`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `email` varchar(50) NOT NULL,
  `addr_line_1` varchar(200) NOT NULL,
  `addr_line_2` varchar(200) NOT NULL,
  `city` varchar(20) NOT NULL,
  `district` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`email`, `addr_line_1`, `addr_line_2`, `city`, `district`) VALUES
('isurimalkishara@icloud.com', 'No. 210, Ex road', 'Mahiyanganaya', 'mahiyanganaya', 'badulla'),
('jayawardene.pasandevin@gmail.com', 'No 338, Kompe', 'Handapangoda', 'ingiriya', 'kaluthara'),
('krishanshamod@gmail.com', 'No 502, Ex road', 'kurunegala', 'kurunegala', 'kurunegala'),
('nimanthagayan@outlook.com', 'No 403, Thissa Wewa Rd', 'Thissa', 'thissa', 'hambanthota'),
('sureshkumarkaja@gmail.com', 'No 212, Ex Rd', 'Jaffna', 'jaffna', 'jaffna'),
('warunajithbandara@gmail.com', 'No 302, Ex rd', 'kuliyapitiya', 'kuliyapitiya', 'kurunegala');

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

CREATE TABLE `items` (
  `item_id` varchar(10) NOT NULL,
  `item_name` varchar(100) NOT NULL,
  `category` varchar(20) NOT NULL,
  `brand` varchar(20) NOT NULL,
  `item_price` int(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `items`
--

INSERT INTO `items` (`item_id`, `item_name`, `category`, `brand`, `item_price`) VALUES
('01', 'Samsung Galaxy Note20 5G Gold', 'smartphone', 'samsung', 174990),
('02', 'Samsung Galaxy Z Fold Black', 'smartphone', 'samsung', 399990),
('03', 'Huawei Watch GT 2 Pro', 'smartwatch', 'huawei', 52199),
('04', 'Sony Mark 4 White', 'audio', 'sony', 74999),
('05', 'MacBook Air M1 8GB 256GB SpaceGray', 'laptop', 'apple', 255000),
('06', 'Apple ipad Pro 11 256GB SpaceGray', 'tablet', 'apple', 275999),
('07', 'Samsung Travel Adapter 45W', 'accessories', 'samsung', 7190),
('08', 'Samsung Galaxy Watch Active 2', 'smartwatch', 'samsung', 66290),
('09', 'iPhone 12 - Black 256GB', 'smartphone', 'apple', 212999),
('10', 'Apple AirPods Max 2020 Sky Blue', 'audio', 'apple', 129999),
('11', 'OnePlus Buds Pro Glossy White', 'audio', 'oneplus', 33969),
('12', 'OnePlus Bullets Wireless Z', 'audio', 'oneplus', 11990),
('13', 'OnePlus Warp Charge 50 Wireless Charger White', 'accessories', 'oneplus', 13999),
('14', 'OnePlus Warp Charge Type-C Cable 100 cm', 'accessories', 'oneplus', 4999),
('15', 'OnePlus Nord N200 5G', 'smartphone', 'oneplus', 43200),
('16', 'OnePlus 8', 'smartphone', 'oneplus', 128000),
('17', 'Apple Watch SE (2020) White', 'smartwatch', 'apple', 102541),
('18', 'Apple Watch 6 (2020)', 'smartwatch', 'apple', 121999),
('19', 'Apple Mac Book Pro M1 (2020) SPACE GREY', 'laptop', 'apple', 377582),
('20', 'Apple Pencil (2nd Generation)', 'accessories', 'apple', 31999);

-- --------------------------------------------------------

--
-- Table structure for table `orderitems`
--

CREATE TABLE `orderitems` (
  `order_id` varchar(10) NOT NULL,
  `item_id` varchar(10) NOT NULL,
  `no_of_items` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `orderitems`
--

INSERT INTO `orderitems` (`order_id`, `item_id`, `no_of_items`) VALUES
('1', '01', 1),
('2', '03', 4),
('3', '04', 1),
('3', '08', 2),
('4', '07', 2),
('5', '06', 1),
('6', '01', 1),
('6', '03', 3);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `order_id` varchar(10) NOT NULL,
  `email` varchar(100) NOT NULL,
  `price` int(7) NOT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`order_id`, `email`, `price`, `date`) VALUES
('1', 'isurimalkishara@icloud.com', 174990, '2021-09-01'),
('2', 'jayawardene.pasandevin@gmail.com', 52199, '2021-09-23'),
('3', 'krishanshamod@gmail.com', 74999, '2021-09-17'),
('4', 'nimanthagayan@outlook.com', 14380, '2021-10-13'),
('5', 'sureshkumarkaja@gmail.com', 275999, '2021-10-29'),
('6', 'warunajithbandara@gmail.com', 255000, '2021-10-16');

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `item_id` varchar(10) NOT NULL,
  `no_of_items` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`item_id`, `no_of_items`) VALUES
('01', 10),
('02', 5),
('03', 8),
('04', 4),
('05', 8),
('06', 6),
('07', 2),
('08', 20),
('09', 15),
('10', 2);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `email` varchar(50) NOT NULL,
  `f_name` varchar(30) NOT NULL,
  `l_name` varchar(30) NOT NULL,
  `password` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`email`, `f_name`, `l_name`, `password`) VALUES
('isurimalkishara@icloud.com', 'Isuri', 'Malkishara', '1234'),
('jayawardene.pasandevin@gmail.com', 'Pasan', 'Jayawardene', '1234'),
('krishanshamod@gmail.com', 'Krishan', 'Shamod', '1234'),
('nimanthagayan@outlook.com', 'Nimantha', 'Gayan', '1234'),
('sureshkumarkaja@gmail.com', 'Sureshkumar', 'Kajanthan', '1234'),
('warunajithbandara@gmail.com', 'Warunajith', 'Bandara', '1234');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`email`);

--
-- Indexes for table `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`item_id`);

--
-- Indexes for table `orderitems`
--
ALTER TABLE `orderitems`
  ADD PRIMARY KEY (`order_id`,`item_id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`item_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`email`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
