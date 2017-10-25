-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 25, 2017 at 12:00 PM
-- Server version: 5.7.19
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mobkart`
--

-- --------------------------------------------------------

--
-- Table structure for table `mobilephone`
--

DROP TABLE IF EXISTS `mobilephone`;
CREATE TABLE IF NOT EXISTS `mobilephone` (
  `modelNo` varchar(20) NOT NULL,
  `noInStock` int(11) NOT NULL,
  `brand` varchar(20) NOT NULL,
  `frontCamera` varchar(10) DEFAULT NULL,
  `rearCamera` varchar(10) DEFAULT NULL,
  `price` int(11) NOT NULL,
  `quantitySold` int(11) NOT NULL,
  `memoryRam` varchar(10) NOT NULL,
  `mainMemory` varchar(10) NOT NULL,
  `osName` varchar(20) NOT NULL,
  `processorId` varchar(10) NOT NULL,
  `batteryId` varchar(10) NOT NULL,
  `mobileName` varchar(50) NOT NULL,
  PRIMARY KEY (`modelNo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `phoneno`
--

DROP TABLE IF EXISTS `phoneno`;
CREATE TABLE IF NOT EXISTS `phoneno` (
  `username` varchar(10) NOT NULL,
  `phoneNo` varchar(10) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `phoneno`
--

INSERT INTO `phoneno` (`username`, `phoneNo`) VALUES
('aishanya11', '9716107555'),
('apargarg05', '8527719767');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `username` varchar(10) NOT NULL,
  `password` varchar(30) DEFAULT NULL,
  `firstName` varchar(10) NOT NULL,
  `middleName` varchar(10) DEFAULT NULL,
  `lastNmae` varchar(10) NOT NULL,
  `emailId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`, `firstName`, `middleName`, `lastNmae`, `emailId`) VALUES
('aishanya11', 'hello', 'Aishanya', '', 'Singh', 'aishanya1999@gmail.com'),
('apargarg05', 'apargarg05', 'apar', '', 'garg', 'apargarg05@gmail.com');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
