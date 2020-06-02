-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 28, 2018 at 10:10 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `f1`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `userId` varchar(12) NOT NULL,
  `customerName` varchar(30) NOT NULL,
  `phoneNumber` varchar(13) NOT NULL,
  `address` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`userId`, `customerName`, `phoneNumber`, `address`) VALUES
('c001', 'Customer1', '+921234567890', 'Lahore'),
('c002', 'Customer2', '+921234567891', 'Islamabad'),
('c003', 'Customer3', '+921234567892', 'Peshawar'),
('c004', 'Customer4', '+921234567893', 'Karachi'),
('c005', 'Customer5', '+921234567894', 'Quetta'),
('c006', 'Customer6', '+921234567895', 'Muzaffarabad'),
('c007', 'Customer7', '+921234567896', 'Sahiwal'),
('c008', 'Customer8', '+921234567897', 'Sheikhwala'),
('c009', 'Customer9', '+921234567898', 'Chiniot'),
('c010', 'Customer10', '+921234567899', 'Gilgit');
-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `userId` varchar(12) NOT NULL,
  `employeeName` varchar(50) NOT NULL,
  `phoneNumber` varchar(13) NOT NULL,
  `role` varchar(8) NOT NULL,
  `salary` double(8,2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`userId`, `employeeName`, `phoneNumber`, `role`, `salary`) VALUES
('m001', 'Manager1', '+921234567890', 'Manager', 60000.00),
('m002', 'Manager2', '+921234567891', 'Manager', 60000.00),
('e001', 'Employee1', '+921234567893', 'General', 25000.00),
('e002', 'Employee2', '+921234567894', 'General', 25000.00),
('e003', 'Employee3', '+921234567895', 'General', 25000.00);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `userId` varchar(12) NOT NULL,
  `password` varchar(12) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`userId`, `password`, `status`) VALUES
('m001', 'm001', 0),
('m002', 'm002', 0),
('e001', 'e001', 0),
('e002', 'e002', 0),
('e003', 'e003', 0),
('c001', 'c001', 1),
('c002', 'c002', 1),
('c003', 'c003', 1),
('c004', 'c004', 1),
('c005', 'c005', 1),
('c006', 'c006', 1),
('c007', 'c007', 1),
('c008', 'c008', 1),
('c009', 'c009', 1),
('c010', 'c010', 1);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `productId` int(5) UNSIGNED ZEROFILL NOT NULL,
  `productName` varchar(50) NOT NULL,
  `price` double(8,2) NOT NULL,
  `quantity` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`productId`, `productName`, `price`, `quantity`) VALUES
(00001, 'Juice Apple 1L', 250.00, 100),
(00002, 'Juice Mango 1L', 250.00, 100),
(00003, 'Juice Orange 1L', 250.00, 100),
(00004, 'Juice Peach 1L', 250.00, 100),
(00005, 'Soda Cola 1.5L', 100.00, 200),
(00006, 'Soda Fanta 1.5L', 100.00, 200),
(00007, 'Soda Diet 1.5L', 100.00, 200),
(00008, 'Chocolate Sneakers', 80.00, 400),
(00009, 'Chocolate KitKat', 120.00, 400),
(00010, 'Chocolate Mars', 80.00, 400),
(00011, 'Chocolate Galaxy', 90.00, 400),
(00012, 'Bread Plain', 100.00, 150),
(00013, 'Bread Bran', 130.00, 150),
(00014, 'Muffins', 60.00, 150),
(00015, 'Battery AAA', 20.00, 300),
(00016, 'Soap Dove',130.00, 100),
(00017, 'Detergent', 200.00, 80),
(00018, 'Biscuits Sweet', 25.00, 150),
(00019, 'Biscuits salty', 25.00, 150),
(00020, 'Acer Predetor', 204000.00, 10),
(00021, 'Candles', 20.00, 100);


-- --------------------------------------------------------

--
-- Table structure for table `purchaseinfo`
--

CREATE TABLE `purchaseinfo` (
  `purchaseId` int(5) UNSIGNED ZEROFILL NOT NULL,
  `userId` varchar(12) NOT NULL,
  `productId` varchar(12) NOT NULL,
  `cost` double(12,2) UNSIGNED NOT NULL,
  `amount` int(8) UNSIGNED NOT NULL,
  `date` varchar(18) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchaseinfo`
--

INSERT INTO `purchaseinfo` (`purchaseId`, `userId`, `productId`, `cost`, `amount`, `date`) VALUES
(00001, 'c001', '00003', 250.00, 1, '2020-06-01'),
(00002, 'c002', '00005', 200.00, 2, '2020-06-01'),
(00006, 'c003', '00001', 750.00, 3, '2020-06-01'),
(00003, 'c004', '00002', 250.00, 1, '2020-06-01'),
(00007, 'c005', '00006', 100.00, 1, '2020-06-01'),
(00009, 'c006', '00007', 200.00, 2, '2020-06-01'),
(00011, 'c007', '00008', 240.00, 3, '2020-06-01'),
(00013, 'c008', '00003', 1000.00, 4, '2020-06-01'),
(00012, 'c009', '00010', 80.00, 1, '2020-06-01'),
(00004, 'c010', '00011', 90.00, 1, '2020-06-01'),
(00010, 'c001', '00007', 100.00, 1, '2020-06-02'),
(00021, 'c002', '00017', 400.00, 2, '2020-06-02'),
(00018, 'c003', '00014', 120.00, 2, '2020-06-02'),
(00022, 'c004', '00011', 360.00, 4, '2020-06-02'),
(00017, 'c005', '00010', 240.00, 3, '2020-06-02'),
(00005, 'c006', '00009', 120.00, 1, '2020-06-02'),
(00014, 'c008', '00002', 500.00, 1, '2020-06-02'),
(00020, 'c008', '00008', 80.00, 1, '2020-06-02'),
(00025, 'c010', '00016', 160.00, 2, '2020-06-02');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`userId`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`userId`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD UNIQUE KEY `userId` (`userId`),
  ADD UNIQUE KEY `userId_2` (`userId`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`productId`);

--
-- Indexes for table `purchaseinfo`
--
ALTER TABLE `purchaseinfo`
  ADD PRIMARY KEY (`purchaseId`),
  ADD KEY `userId` (`userId`),
  ADD KEY `userId_2` (`userId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `productId` int(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `purchaseinfo`
--
ALTER TABLE `purchaseinfo`
  MODIFY `purchaseId` int(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `purchaseinfo`
--
ALTER TABLE `purchaseinfo`
  ADD CONSTRAINT `FK_PUR_CUS` FOREIGN KEY (`userId`) REFERENCES `purchaseinfo` (`userId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
