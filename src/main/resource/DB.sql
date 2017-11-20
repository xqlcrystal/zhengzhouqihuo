CREATE DATABASE futuredata DEFAULT CHARACTER SET utf8

CREATE TABLE `futuredatatradeamt` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rankingvol` int(11) DEFAULT NULL,
  `rankingamount` int(11) DEFAULT NULL,
  `memberno` varchar(20) DEFAULT NULL,
  `membername` varchar(30) DEFAULT NULL,
  `vol` decimal(18,2) DEFAULT NULL,
  `amount` decimal(18,2) DEFAULT NULL,
  `curdate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8