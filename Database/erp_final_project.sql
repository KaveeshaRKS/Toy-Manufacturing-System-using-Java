-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 29, 2022 at 03:34 PM
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
-- Database: `erp_final_project`
--

-- --------------------------------------------------------

--
-- Table structure for table `bom`
--

DROP TABLE IF EXISTS `bom`;
CREATE TABLE IF NOT EXISTS `bom` (
  `order_id` int(11) NOT NULL,
  `m_id` int(11) NOT NULL,
  `required_quantity` int(11) NOT NULL,
  `total_price` int(11) NOT NULL,
  PRIMARY KEY (`order_id`,`m_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bom`
--

INSERT INTO `bom` (`order_id`, `m_id`, `required_quantity`, `total_price`) VALUES
(1, 1, 60, 36000);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `c_id` int(11) NOT NULL,
  `name` varchar(254) NOT NULL,
  `address` varchar(254) NOT NULL,
  `tel` varchar(254) NOT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`c_id`, `name`, `address`, `tel`) VALUES
(1, 'Sadini', 'Gampaha', '2345'),
(2, 'Sanduni', 'Kaluthara', '5678'),
(3, 'Himasha', 'Matale', '3456'),
(4, 'Pubuduni', 'Gampaha', '1234'),
(5, 'Kasun', 'Kandy', '4578'),
(6, 'Kamal', 'Galle', '4578'),
(7, 'Amaya', 'Malabe', '6789'),
(9, 'Lahiru', 'Matara', '5678'),
(14, 'dfg', 'rty', '3456'),
(13, 'qwe', 'asd', '456');

-- --------------------------------------------------------

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
CREATE TABLE IF NOT EXISTS `material` (
  `m_id` int(11) NOT NULL,
  `material_description` varchar(254) NOT NULL,
  `unit` varchar(254) NOT NULL,
  `available_quantity` int(11) NOT NULL,
  `unit_price` int(11) NOT NULL,
  PRIMARY KEY (`m_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `material`
--

INSERT INTO `material` (`m_id`, `material_description`, `unit`, `available_quantity`, `unit_price`) VALUES
(1, 'Cotton', 'kg', 80, 600),
(2, 'Fiber', 'm', 5, 700),
(3, 'Rubber', 'kg', 20, 400),
(4, 'Plastic', 'kg', 240, 2000),
(5, 'abc', 'l', 100, 400),
(6, 'Ion', 'kg', 250, 1000),
(7, 'xyz', 'm', 70, 500),
(8, 'Cloths', 'kg', 215, 100),
(9, 'pqr', 'l', 50, 25),
(14, 'tgf', 'l', 50, 400),
(11, 'qwe', 'l', 50, 85);

-- --------------------------------------------------------

--
-- Table structure for table `mrp`
--

DROP TABLE IF EXISTS `mrp`;
CREATE TABLE IF NOT EXISTS `mrp` (
  `order_id` int(11) NOT NULL,
  `m_id` int(11) NOT NULL,
  `required_quantity` int(11) NOT NULL,
  PRIMARY KEY (`order_id`,`m_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mrp`
--

INSERT INTO `mrp` (`order_id`, `m_id`, `required_quantity`) VALUES
(1, 1, 60);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `order_id` int(11) NOT NULL,
  `c_id` int(11) NOT NULL,
  `p_id` int(11) NOT NULL,
  `required_quantity` int(11) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`order_id`,`c_id`,`p_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`order_id`, `c_id`, `p_id`, `required_quantity`, `date`) VALUES
(1, 1, 1, 500, '2022-06-16'),
(1, 1, 2, 550, '2022-06-16'),
(2, 2, 1, 600, '2022-05-11'),
(2, 2, 2, 650, '2022-05-11'),
(3, 3, 1, 700, '2022-06-24'),
(3, 3, 3, 725, '2022-06-24'),
(4, 4, 1, 450, '2022-04-12'),
(4, 4, 4, 475, '2022-04-12'),
(5, 5, 1, 800, '2022-03-14'),
(5, 5, 5, 1000, '2022-03-14'),
(6, 6, 2, 525, '2022-04-17'),
(7, 7, 8, 460, '2022-03-17'),
(8, 8, 6, 350, '2022-05-25');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `p_id` int(11) NOT NULL,
  `description` varchar(254) NOT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`p_id`, `description`) VALUES
(1, 'Doll'),
(2, 'Teady Bear'),
(3, 'Cars'),
(4, 'Plane'),
(5, 'Buldozer'),
(6, 'Flying Machine'),
(7, 'Train'),
(8, 'Lorry'),
(9, 'Gaming Pad');

-- --------------------------------------------------------

--
-- Table structure for table `product_planning`
--

DROP TABLE IF EXISTS `product_planning`;
CREATE TABLE IF NOT EXISTS `product_planning` (
  `p_id` int(11) NOT NULL,
  `m_id` int(11) NOT NULL,
  `required_quantity` int(11) NOT NULL,
  PRIMARY KEY (`p_id`,`m_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product_planning`
--

INSERT INTO `product_planning` (`p_id`, `m_id`, `required_quantity`) VALUES
(1, 1, 30),
(1, 2, 65),
(2, 1, 30),
(2, 3, 70),
(3, 3, 50),
(4, 4, 120),
(5, 5, 40),
(8, 11, 40),
(1, 8, 35);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(254) NOT NULL,
  `password` varchar(254) NOT NULL,
  `department` varchar(254) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
