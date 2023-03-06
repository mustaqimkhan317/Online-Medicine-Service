-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 31, 2018 at 12:41 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `treatment`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `id` decimal(3,0) NOT NULL,
  `password` varchar(30) DEFAULT NULL,
  `test` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`id`, `password`, `test`) VALUES
('0', '', 0),
('101', '12345', 0),
('102', '12545', 0),
('116', '33333', 0),
('125', '12345', 0),
('201', '78945', 0),
('301', '22222', 0);

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `doctor_id` decimal(3,0) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `age` decimal(3,0) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `degree` varchar(30) DEFAULT NULL,
  `specialization` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`doctor_id`, `name`, `sex`, `age`, `address`, `degree`, `specialization`) VALUES
('201', 'TMA', 'M', '20', 'Dhaka', 'FCPS', 'Cardio'),
('202', 'TMA', 'M', '20', 'Dhaka', 'FCPS', 'Cancer'),
('203', 'TMA', 'M', '20', 'Dhaka', 'FCPS', 'Medicine'),
('204', 'TMA', 'M', '20', 'Dhaka', 'FCPS', 'Cardio'),
('205', 'TMA', 'M', '20', 'Dhaka', 'FCPS', 'Gyno'),
('206', 'TMA', 'M', '20', 'Dhaka', 'FCPS', 'general'),
('207', 'TMA', 'M', '20', 'Dhaka', 'FCPS', 'heart');

-- --------------------------------------------------------

--
-- Table structure for table `history`
--

CREATE TABLE `history` (
  `tid` int(11) NOT NULL,
  `patient_id` decimal(3,0) DEFAULT NULL,
  `product_id` decimal(3,0) DEFAULT NULL,
  `amount` decimal(3,0) DEFAULT NULL,
  `money` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `history`
--

INSERT INTO `history` (`tid`, `patient_id`, `product_id`, `amount`, `money`) VALUES
(1, '101', '1', '0', '0'),
(2, '101', '1', '0', '0'),
(3, '101', '5', '0', '0'),
(4, '101', '5', '50', '300'),
(5, '101', '7', '100', '3500'),
(6, '101', '10', '100', '500'),
(7, '101', '1', '2', '10'),
(8, '101', '2', '20', '100'),
(9, '101', '11', '10', '50'),
(10, '101', '10', '5', '25'),
(11, '101', '9', '5', '250'),
(12, '102', '2', '50', '250'),
(13, '102', '2', '10', '50'),
(14, '101', '5', '20', '120'),
(15, '101', '7', '2', '70');

-- --------------------------------------------------------

--
-- Table structure for table `management`
--

CREATE TABLE `management` (
  `officer_id` decimal(3,0) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `age` decimal(3,0) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `designation` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `management`
--

INSERT INTO `management` (`officer_id`, `name`, `sex`, `age`, `address`, `designation`) VALUES
('301', 'Faisal', 'M', '20', 'Chittagong', 'CEO'),
('302', 'Farhan', 'M', '20', 'Dhaka', 'CEO'),
('303', 'Souvik', 'M', '20', 'Dhaka', 'CEO'),
('304', 'Adiba', 'F', '20', 'Chittagong', 'CEO'),
('305', 'Mehzabin', 'F', '20', 'Chittagong', 'CEO'),
('306', 'Faisal', 'M', '20', 'Chittagong', 'CEO');

-- --------------------------------------------------------

--
-- Table structure for table `manages`
--

CREATE TABLE `manages` (
  `officer_id` decimal(3,0) NOT NULL,
  `product_id` decimal(3,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `manages`
--

INSERT INTO `manages` (`officer_id`, `product_id`) VALUES
('301', '1'),
('302', '2'),
('303', '1');

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `patient_id` decimal(3,0) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `age` decimal(3,0) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `ad_date` date DEFAULT NULL,
  `disease` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`patient_id`, `name`, `sex`, `age`, `address`, `ad_date`, `disease`) VALUES
('0', '', '', '0', '', '2017-12-05', ''),
('101', 'Souvik', 'M', '20', 'DHAKA', '2011-03-25', 'FEVER'),
('102', 'Faisal', 'M', '20', 'kHULNA', '2011-03-25', 'JONDIS'),
('103', 'Rahim', 'M', '20', 'CMILLA', '2011-03-25', 'CANCER'),
('104', 'Karim', 'M', '20', 'JESSORE', '2011-03-25', 'HYPERTENSION'),
('105', 'Mehzabin', 'F', '20', 'CHIAGONG', '2011-03-25', 'DIABETES '),
('106', 'Tasnim', 'F', '20', 'RANGPUR', '2011-03-25', 'DIARRHOEA'),
('107', 'Anika', 'F', '20', 'DINAJPUR', '2011-03-25', 'AIDS'),
('108', 'Farhan', 'M', '20', 'BOGURA', '2011-03-25', 'NEURAL DISEASE'),
('109', 'A Man Has No Namme', 'M', '20', 'PABNA', '2011-03-25', 'ALZHEIMER '),
('116', 'SOUmik', 'm', '22', 'jhj', '2017-12-05', '21212'),
('120', 'f', 'f', '1', 'd', '0001-01-01', 'asd'),
('125', 'SrijonB', 'C', '100', 'sdsf', '2017-12-05', 'AIDS');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `product_id` decimal(3,0) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `category` varchar(30) DEFAULT NULL,
  `stock` decimal(5,0) DEFAULT NULL,
  `price` decimal(3,0) DEFAULT NULL,
  `sold` decimal(3,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`product_id`, `name`, `category`, `stock`, `price`, `sold`) VALUES
('1', 'Ace', 'Paracetamol', '986', '5', '312'),
('2', 'Napa', 'Paracetamol', '420', '5', '80'),
('3', 'Parapirol', 'Paracetamol', '500', '5', '0'),
('4', 'Loratin', 'Alatrol', '500', '5', '0'),
('5', 'Flexi', 'Painkiller', '330', '6', '170'),
('6', 'Zimax', 'Antibiotic', '500', '35', '0'),
('7', 'Trevox', 'Antibiotic', '398', '35', '102'),
('8', 'Cef3', 'Antibiotic', '500', '35', '0'),
('9', 'Thyrin', 'Hormone', '495', '50', '5'),
('10', 'Losectil', 'Omeprazol', '395', '5', '105'),
('11', 'Pantonix', 'Omeprazol', '390', '5', '10'),
('12', 'bopam', 'sleeping', '600', '20', '0'),
('13', 'sk', 'e', '1', '1', '1'),
('14', 'a', 'a', '1', '1', '11');

-- --------------------------------------------------------

--
-- Table structure for table `purchases`
--

CREATE TABLE `purchases` (
  `patient_id` decimal(3,0) NOT NULL,
  `product_id` decimal(3,0) NOT NULL,
  `quantity` decimal(3,0) DEFAULT NULL,
  `price` decimal(4,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchases`
--

INSERT INTO `purchases` (`patient_id`, `product_id`, `quantity`, `price`) VALUES
('101', '1', '0', '0'),
('102', '2', '0', '0'),
('103', '1', '0', '0');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `name` varchar(30) NOT NULL,
  `country` varchar(30) NOT NULL,
  `factory` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`name`, `country`, `factory`) VALUES
('Beximco', 'Bangladesh', 'factory'),
('MediCare', 'USA', 'factory'),
('Square', 'Bangladesh', 'factory');

-- --------------------------------------------------------

--
-- Table structure for table `supplies`
--

CREATE TABLE `supplies` (
  `name` varchar(30) NOT NULL,
  `country` varchar(30) NOT NULL,
  `product_id` decimal(3,0) NOT NULL,
  `amount` decimal(3,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplies`
--

INSERT INTO `supplies` (`name`, `country`, `product_id`, `amount`) VALUES
('Square', 'Bangladesh', '2', '500');

-- --------------------------------------------------------

--
-- Table structure for table `treatment`
--

CREATE TABLE `treatment` (
  `doctor_id` decimal(3,0) NOT NULL,
  `patient_id` decimal(3,0) NOT NULL,
  `product_id` decimal(3,0) NOT NULL,
  `dose` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `treatment`
--

INSERT INTO `treatment` (`doctor_id`, `patient_id`, `product_id`, `dose`) VALUES
('201', '101', '1', '1-1-1'),
('201', '101', '2', '1-1-1'),
('201', '101', '3', '1-1-1'),
('201', '101', '4', '1-1-1'),
('201', '101', '5', '1-1-1'),
('201', '101', '7', '1-1-1'),
('201', '101', '9', '1-1-1'),
('201', '101', '10', '1-1-1'),
('201', '101', '11', '1-1-1'),
('201', '102', '5', '1-1-1'),
('201', '103', '9', '1-1-1'),
('201', '104', '9', '1-1-1'),
('201', '106', '12', ''),
('201', '107', '12', '1-0-1'),
('201', '108', '1', ''),
('201', '108', '2', '1-0-0'),
('201', '108', '3', '1-1-1'),
('201', '108', '6', '1-0-1'),
('201', '109', '1', '1-0-1'),
('202', '102', '2', '1-1-1'),
('203', '103', '3', '1-1-1'),
('205', '105', '4', '1-1-1'),
('206', '106', '5', '1-1-1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`doctor_id`);

--
-- Indexes for table `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`tid`),
  ADD KEY `product_id` (`product_id`),
  ADD KEY `patient_id` (`patient_id`);

--
-- Indexes for table `management`
--
ALTER TABLE `management`
  ADD PRIMARY KEY (`officer_id`);

--
-- Indexes for table `manages`
--
ALTER TABLE `manages`
  ADD PRIMARY KEY (`officer_id`,`product_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`patient_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`product_id`);

--
-- Indexes for table `purchases`
--
ALTER TABLE `purchases`
  ADD PRIMARY KEY (`patient_id`,`product_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`name`,`country`);

--
-- Indexes for table `supplies`
--
ALTER TABLE `supplies`
  ADD PRIMARY KEY (`name`,`country`,`product_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `treatment`
--
ALTER TABLE `treatment`
  ADD PRIMARY KEY (`doctor_id`,`patient_id`,`product_id`),
  ADD KEY `patient_id` (`patient_id`),
  ADD KEY `product_id` (`product_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `history`
--
ALTER TABLE `history`
  MODIFY `tid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `history`
--
ALTER TABLE `history`
  ADD CONSTRAINT `history_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`),
  ADD CONSTRAINT `history_ibfk_2` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`);

--
-- Constraints for table `manages`
--
ALTER TABLE `manages`
  ADD CONSTRAINT `manages_ibfk_1` FOREIGN KEY (`officer_id`) REFERENCES `management` (`officer_id`),
  ADD CONSTRAINT `manages_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`);

--
-- Constraints for table `purchases`
--
ALTER TABLE `purchases`
  ADD CONSTRAINT `purchases_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`),
  ADD CONSTRAINT `purchases_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`);

--
-- Constraints for table `supplies`
--
ALTER TABLE `supplies`
  ADD CONSTRAINT `supplies_ibfk_1` FOREIGN KEY (`name`,`country`) REFERENCES `supplier` (`name`, `country`),
  ADD CONSTRAINT `supplies_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`);

--
-- Constraints for table `treatment`
--
ALTER TABLE `treatment`
  ADD CONSTRAINT `treatment_ibfk_1` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_id`),
  ADD CONSTRAINT `treatment_ibfk_2` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`),
  ADD CONSTRAINT `treatment_ibfk_3` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
