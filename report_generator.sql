-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 02, 2021 at 01:22 PM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

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

DROP TABLE IF EXISTS `address`;
CREATE TABLE IF NOT EXISTS `address` (
  `email` varchar(50) NOT NULL,
  `addr_line_1` varchar(200) NOT NULL,
  `addr_line_2` varchar(200) NOT NULL,
  `city` varchar(20) NOT NULL,
  `district` varchar(20) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`email`, `addr_line_1`, `addr_line_2`, `city`, `district`) VALUES
('ajithwasantha@gmail.com', 'No 98, Uduwila', 'Tangalla', 'polonmaruwa', 'hambantota'),
('asitha@gmail.com', 'No 100, Mavi road', 'Bulathsinhala', 'bulathsinhala', 'kurunegala'),
('dhanujasahas@gmail.com', 'No 465, Nallu road', 'Jaffna', 'jaffna', 'jaffna'),
('dinukagayan23@gmail.com', 'No 79, Allu road', 'Jaffna', 'araly', 'jaffna'),
('isurimalkishara@icloud.com', 'No. 210, Ex road', 'Mahiyanganaya', 'mahiyanganaya', 'badulla'),
('jayawardene.pasandevin@gmail.com', 'No 338, Kompe', 'Handapangoda', 'ingiriya', 'kaluthara'),
('krishanshamod@gmail.com', 'No 502, Ex road', 'kurunegala', 'kurunegala', 'kurunegala'),
('mahi2015@gmail.com', 'No 23, Madamulana', 'Weerakatiya', 'weerakatiya', 'hambantota'),
('malith03@gmail.com', 'No 12, Halpe', 'Welimada', 'welimada', 'Badulla'),
('mimira@gmail.com', 'No 780, Jhone road', 'Daluwa', 'kaluthara', 'kaluthara'),
('navodyagim234@gmail.com', 'No 85, Prison road', 'Bandarawela', 'kudaheella', 'badulla'),
('nimal12@gmail.com', 'No 36, Lake road', 'Kurunegala', 'alawwa', 'kurunegala'),
('nimanthagayan@outlook.com', 'No 403, Thissa Wewa Rd', 'Thissa', 'thissa', 'hambanthota'),
('pubuduwik98@gmail.com', 'No 35, Adalla', 'Hungama', 'hungama', 'hambantota'),
('sadisan@gmail.com', 'No 34, Main road', 'Dodangoda', 'dodangoda', 'kaluthara'),
('sadun20@gmail.com', 'No 470, Nallu road', 'Navaly', 'navaly', 'jaffna'),
('sureshkumarkaja@gmail.com', 'No 212, Ex Rd', 'Jaffna', 'jaffna', 'jaffna'),
('thushara@gmail.com', 'No 90, Erlalai', 'Moolai', 'moolai', 'jaffna'),
('umayanga12@gmail.com', 'No 12, Samagi mawatha', 'Beruwala', 'beruwala', 'kaluthara'),
('warunajithbandara@gmail.com', 'No 302, Ex rd', 'kuliyapitiya', 'kuliyapitiya', 'kurunegala');

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
CREATE TABLE IF NOT EXISTS `items` (
  `item_id` varchar(10) NOT NULL,
  `item_name` varchar(100) NOT NULL,
  `category` varchar(20) NOT NULL,
  `brand` varchar(20) NOT NULL,
  `item_price` int(7) NOT NULL,
  PRIMARY KEY (`item_id`)
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

DROP TABLE IF EXISTS `orderitems`;
CREATE TABLE IF NOT EXISTS `orderitems` (
  `order_id` varchar(10) NOT NULL,
  `item_id` varchar(10) NOT NULL,
  `no_of_items` int(4) NOT NULL,
  PRIMARY KEY (`order_id`,`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `orderitems`
--

INSERT INTO `orderitems` (`order_id`, `item_id`, `no_of_items`) VALUES
('1', '01', 1),
('10', '11', 5),
('10', '18', 2),
('11', '17', 1),
('12', '01', 2),
('12', '04', 1),
('12', '16', 1),
('13', '12', 1),
('14', '07', 1),
('14', '09', 2),
('15', '20', 1),
('16', '02', 1),
('16', '06', 2),
('17', '02', 2),
('17', '13', 2),
('18', '08', 2),
('19', '01', 3),
('19', '19', 2),
('2', '03', 4),
('20', '10', 3),
('20', '14', 1),
('3', '04', 1),
('3', '08', 2),
('4', '07', 2),
('5', '06', 1),
('6', '01', 1),
('6', '03', 3),
('7', '14', 2),
('8', '05', 6),
('8', '10', 3),
('8', '19', 4),
('9', '20', 2);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `order_id` varchar(10) NOT NULL,
  `email` varchar(100) NOT NULL,
  `price` int(7) NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`order_id`, `email`, `price`, `date`) VALUES
('1', 'isurimalkishara@icloud.com', 174990, '2021-09-01'),
('10', 'dinukagayan23@gmail.com', 7899, '2021-10-24'),
('11', 'navodyagim234@gmail.com', 8900, '2021-09-09'),
('12', 'dhanujasahas@gmail.com', 19820, '2021-10-18'),
('13', 'mimira@gmail.com', 15650, '2021-10-08'),
('14', 'pubuduwik98@gmail.com', 8499, '2021-09-30'),
('15', 'sadun20@gmail.com', 14900, '2021-09-22'),
('16', 'umayanga12@gmail.com', 5700, '2021-09-23'),
('17', 'thushara@gmail.com', 10599, '2021-10-15'),
('18', 'mahi2015@gmail.com', 12950, '2021-09-19'),
('19', 'asitha@gmail.com', 3550, '2021-10-27'),
('2', 'jayawardene.pasandevin@gmail.com', 52199, '2021-09-23'),
('20', 'sadisan@gmail.com', 6500, '2021-09-05'),
('3', 'krishanshamod@gmail.com', 74999, '2021-09-17'),
('4', 'nimanthagayan@outlook.com', 14380, '2021-10-13'),
('5', 'sureshkumarkaja@gmail.com', 275999, '2021-10-29'),
('6', 'warunajithbandara@gmail.com', 255000, '2021-10-16'),
('7', 'malith03@gmail.com', 12350, '2021-09-14'),
('8', 'nimal12@gmail.com', 14569, '2021-10-04'),
('9', 'ajithwasantha@gmail.com', 21750, '2021-09-18');

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
CREATE TABLE IF NOT EXISTS `stock` (
  `item_id` varchar(10) NOT NULL,
  `no_of_items` int(3) NOT NULL,
  PRIMARY KEY (`item_id`)
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
('10', 2),
('11', 13),
('12', 5),
('13', 15),
('14', 9),
('15', 8),
('16', 12),
('17', 4),
('18', 10),
('19', 4),
('20', 14);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `email` varchar(50) NOT NULL,
  `f_name` varchar(30) NOT NULL,
  `l_name` varchar(30) NOT NULL,
  `password` varchar(40) NOT NULL,
  `signup_date` date DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`email`, `f_name`, `l_name`, `password`, `signup_date`) VALUES
('ajithwasantha@gmail.com', 'Ajith', 'Wasantha', '89ajithff21', '2021-07-03'),
('asitha@gmail.com', 'Asitha', 'Nuwan', 'asi123', '2021-08-18'),
('dhanujasahas@gmail.com', 'Dhanuja', 'Sahas', 'sahas645', '2021-07-20'),
('dinukagayan23@gmail.com', 'Dinuka', 'Gayan', 'dinuka189', '2021-07-24'),
('isurimalkishara@icloud.com', 'Isuri', 'Malkishara', '1234', '2021-07-06'),
('jayawardene.pasandevin@gmail.com', 'Pasan', 'Jayawardene', '1234', '2021-08-19'),
('krishanshamod@gmail.com', 'Krishan', 'Shamod', '1234', '2021-07-21'),
('mahi2015@gmail.com', 'Mahinda', 'Kumara', 'mahi85', '2021-07-29'),
('malith03@gmail.com', 'Malith', 'Kumara', 'ywywynshaa654', '2021-08-18'),
('mimira@gmail.com', 'Mimira', 'Sadun', 'mimira90', '2021-08-26'),
('navodyagim234@gmail.com', 'Navodya', 'Gimhani', 'gimhani89', '2021-08-30'),
('nimal12@gmail.com', 'Nimal', 'Ranjith', 'eie12ee', '2021-07-17'),
('nimanthagayan@outlook.com', 'Nimantha', 'Gayan', '1234', '2021-08-24'),
('pubuduwik98@gmail.com', 'Pubudu', 'Sanjaya', 'pub78', '2021-08-22'),
('sadisan@gmail.com', 'Sadisa', 'Chamalsha', 'sadi456', '2021-07-01'),
('sadun20@gmail.com', 'Sandun', 'Jayasekara', 'sandun123', '2021-08-07'),
('sureshkumarkaja@gmail.com', 'Sureshkumar', 'Kajanthan', '1234', '2021-08-19'),
('thushara@gmail.com', 'Thushara', 'Amaraweera', 'thush345', '2021-07-09'),
('umayanga12@gmail.com', 'Umayanga', 'Vidunuwan', 'widu234', '2021-07-13'),
('warunajithbandara@gmail.com', 'Warunajith', 'Bandara', '1234', '2021-07-06');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
