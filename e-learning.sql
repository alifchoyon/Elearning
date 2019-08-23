-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 31, 2017 at 06:38 PM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `e-learning`
--

-- --------------------------------------------------------

--
-- Table structure for table `answer`
--

CREATE TABLE `answer` (
  `questionid` int(11) DEFAULT NULL,
  `studentid` int(11) DEFAULT NULL,
  `studentAnswer` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `article`
--

CREATE TABLE `article` (
  `articleid` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` text NOT NULL,
  `facultyid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `article`
--

INSERT INTO `article` (`articleid`, `name`, `description`, `facultyid`) VALUES
(3, 'this is another tes', 'test on1', 1),
(4, 'Andreea D - Paradise (Official Video)', 'I can''t believe it, \r\nYou''re hypnotic\r\nDon''t wanna wait no more\r\nMove your body,\r\nWe don''t need no money\r\nJust play it really nice and slow\r\n\r\nIt''s Paradise, it''s Paradise\r\nI can take you to your Paradise\r\nRoll the dice, roll the dice,\r\nI''m your ticket to your Paradise\r\n\r\nHere we are, we are now\r\nWe are, we are now\r\nHere we are, we are now\r\nFeel my body\r\nTurn me, turn me on now\r\nYou turn me on now\r\nYe, Ye, Oh Baby you can turn me on now\r\n\r\n', 456),
(5, 'Hostage Taker Got Killed ', ' Philippines\r\nAn 11-year old girl was taken as hostage by a paranoid murderer. See how the stand-off between the sadistic kidnapper, vigilante, and authorities ended. They say, "if you live by knife you will die by the bullet.\r\n\r\n*Collected*', 1),
(6, 'Juan Manuel de Rosas', 'Juan Manuel de Rosas\r\nFrom Wikipedia, the free encyclopedia\r\nFor the station, see Juan Manuel de Rosas (Buenos Aires Underground).\r\nJuan Manuel de Rosas\r\nHalf-length painted portrait of a man with curly hair, long sideburns and blue eyes who wears a heavily embroidered military tunic with high collar, gold braid epaulettes and a red sash of office\r\nPosthumous portrait of Juan Manuel de Rosas wearing the full dress of a brigadier general\r\n17th Governor of Buenos Aires Province\r\nIn office\r\n7 March 1835 – 3 February 1852\r\nPreceded by	Manuel Vicente Maza\r\nSucceeded by	Vicente López y Planes\r\n13th Governor of Buenos Aires Province\r\nIn office\r\n6 December 1829 – 5 December 1832\r\nPreceded by	Juan José Viamonte\r\nSucceeded by	Juan Ramón Balcarce\r\nPersonal details\r\nBorn	Juan Manuel José Domingo Ortiz de Rosas\r\n30 March 1793\r\nBuenos Aires, Viceroyalty of the Río de la Plata\r\nDied	14 March 1877 (aged 83)\r\nSouthampton, United Kingdom\r\nResting place	La Recoleta Cemetery, Buenos Aires\r\nNationality	Argentine\r\nPolitical party	\r\nUnitarian Party (1820–26)\r\nFederalist Party (1826–52)\r\nSpouse(s)	Encarnación Ezcurra\r\nChildren	\r\nJuan Bautista Ortiz de Rosas\r\nManuela Robustiana Rosas\r\nReligion	Catholicism\r\nSignature	Cursive signature in ink\r\nJuan Manuel de Rosas (30 March 1793 – 14 March 1877), nicknamed "Restorer of the Laws",[A] was a politician and army officer who ruled Buenos Aires Province and briefly the Argentine Confederation. Although born into a wealthy family, Rosas independently amassed a personal fortune, acquiring large tracts of land in the process. Rosas enlisted his workers in a private militia, as was common for rural proprietors, and took part in the disputes that led to numerous civil wars in his country. Victorious in warfare, personally influential, and with vast landholdings and a loyal private army, Rosas became a caudillo, as provincial warlords in the region were known. He eventually reached the rank of brigadier general, the highest in the Argentine army, and became the undisputed leader of the Federalist Party.\r\n\r\nIn December 1829, Rosas became governor of the province of Buenos Aires and established a dictatorship backed by state terrorism. In 1831, he signed the Federal Pact, recognising provincial autonomy and creating the Argentine Confederation. When his term of office ended in 1832, Rosas departed to the frontier to wage war on the indigenous peoples. After his supporters launched a coup in Buenos Aires, Rosas was asked to return and once again took office as governor. Rosas reestablished his dictatorship and formed the repressive Mazorca, an armed parapolice that killed thousands of citizens. Elections became a farce, and the legislature and judiciary became docile instruments of his will. Rosas created a cult of personality and his regime became totalitarian in nature, with all aspects of society rigidly controlled.\r\n\r\nRosas faced many threats to his power during the late 1830s and early 1840s. He fought a war against the Peru–Bolivian Confederation, endured a blockade by France, faced a revolt in his own province and battled a major rebellion that lasted years and spread to several Argentine provinces. Rosas persevered and extended his influence in the provinces, exercising effective control over them through direct and indirect means. By 1848, he had extended his power beyond the borders of Buenos Aires and was ruler of all of Argentina. Rosas also attempted to annex the neighbouring nations of Uruguay and Paraguay. France and Great Britain jointly retaliated against Argentine expansionism, blockading Buenos Aires for most of the late 1840s, but were unable to halt Rosas, whose prestige was greatly enhanced by his string of successes.\r\n\r\nWhen the Empire of Brazil began aiding Uruguay in its struggle against Argentina, Rosas declared war in August 1851, starting the Platine War. This short conflict ended with the defeat of Rosas and his flight to Britain. His last years were spent in exile living as a tenant farmer until his death in 1877. Rosas garnered an enduring public perception among Argentines as a brutal tyrant. Since the 1930s, an authoritarian, anti-Semitic, and racist political movement in Argentina called Revisionism has tried to improve Rosas''s reputation and establish a new dictatorship in the model of his regime. In 1989, his remains were repatriated by the government in an attempt to promote national unity, seeking forgiveness for him and especially for the 1970s military dictatorship. Rosas remains a controversial figure in Argentina in the 21st century.', NULL),
(56, 'Juan fgdfg', 'dgdfgfdfbdfdf   tese\n\n\ntgfghfghfghfg', 666),
(57, 'love', 'Love  —n. 1 deep affection or fondness. 2 sexual passion. 3 sexual relations. 4 a beloved one; sweetheart (often as a form of address). B colloq. Form of address regardless of affection. 5 colloq. Person of whom one is fond. 6 affectionate greetings (give him my love). 7 (in games) no score; nil. —v. (-ving) 1 feel love or a deep fondness for. 2 delight in; admire; greatly cherish. 3 colloq. Like very much (loves books). 4 (foll. By verbal noun, or to + infin.) Be inclined, esp. As a habit; greatly enjoy (children love dressing up; loves to run).  fall in love (often foll. By with) suddenly begin to love. For love for pleasure not profit. For the love of for the sake of. In love (often foll. By with) enamoured (of). Make love (often foll. By to) 1 have sexual intercourse (with). 2 archaic pay amorous attention (to). Not for love or money colloq. Not in any circumstances. [old english]\n', 666),
(58, 'pop', '				Pop is an onomatopoeic word for a small explosion. It may also refer to:\n\n , Father\n\n , Soft drink\n\n , Pop music, a music genre\n\n , Pop (nickname)\n\n', 666),
(59, 'legend ', 'Legen (pronounced&#160;) is a settlement in the City Municipality of Slovenj Gradec in northern Slovenia. It lies in the valley of Barbara Creek (Slovene: Barbarski potok) and the surrounding Pohorje Hills east of Slovenj Gradec. The area was traditionally part of Styria. The entire municipality is now included in the Carinthia Statistical Region.\n\nTwo churches in the settlement are dedicated to Saint George and Saint Barbara and belong to the Parish of Šmartno pri Slovenj Gradcu. The former was built in the late 13th century on the site of an earlier Romanesque building and the latter dates to the early 16th century.\n\n', 666),
(60, 'Super Computer', 'A supercomputer is a computer with a high level of computing performance compared to a general-purpose computer. Performance of a supercomputer is measured in floating-point operations per second (FLOPS) instead of million instructions per second (MIPS). As of 2015, there are supercomputers which can perform up to quadrillions of FLOPS.\n\nThe supercomputers were introduced in the 1960s, made initially, and for decades primarily, by Seymour Cray at Control Data Corporation (CDC), Cray Research and subsequent companies bearing his name or monogram. While the supercomputers of the 1970s used only a few processors, in the 1990s, machines with thousands of processors began to appear and, by the end of the 20th century, massively parallel supercomputers with tens of thousands of off-the-shelf processors were the norm.\n\nAdding test\n\n', 666),
(61, 'linux mint', 'Linux Mint is a community-driven Linux distribution based on Debian and Ubuntu that strives to be a "modern, elegant and comfortable operating system which is both powerful and easy to use." Linux Mint provides full out-of-the-box multimedia support by including some proprietary software and comes bundled with a variety of free and open-source applications; however, with the release of v18 "Sarah" some previously included proprietary software such as multimedia codecs was no longer included by default. Its motto is "from freedom came elegance."\n\nThe project was conceived by Clement Lefebvre and is being actively developed by the Linux Mint Team and community.\n\n', 666),
(62, 'lol', 'LOL or lol, an acronym for laugh(ing) out loud or lots of laughs, is a popular element of Internet slang. It was first used almost exclusively on Usenet, but has since become widespread in other forms of computer-mediated communication and even face-to-face communication. It is one of many initialisms for expressing bodily reactions, in particular laughter, as text, including initialisms for more emphatic expressions of laughter such as LMAO ("laugh(ing) my ass off") and ROFL (or its older form ROTFL; "roll(ing) on the floor laughing"). Other unrelated expansions include the now mostly obsolete "lots of luck" or "lots of love" used in letter-writing.\n\nThe list of acronyms "grows by the month" and they are collected along with emoticons and smileys into folk dictionaries that are circulated informally amongst users of Usenet, IRC, and other forms of (textual) computer-mediated communication. These initialisms are controversial, and several authors recommend against their use, either in general or in specific contexts such as business communications.\n\n', 666);

-- --------------------------------------------------------

--
-- Table structure for table `article_links`
--

CREATE TABLE `article_links` (
  `articleid` int(11) DEFAULT NULL,
  `links` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `assignment`
--

CREATE TABLE `assignment` (
  `assignmentid` int(11) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `link` varchar(500) DEFAULT NULL,
  `starting_timeslotid` int(11) DEFAULT NULL,
  `ending_timeslotid` int(11) DEFAULT NULL,
  `studentid` int(11) DEFAULT NULL,
  `facultyid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `can_read`
--

CREATE TABLE `can_read` (
  `articleid` int(11) DEFAULT NULL,
  `studentid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `faculty`
--

CREATE TABLE `faculty` (
  `facultyid` int(11) NOT NULL,
  `firstName` varchar(20) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `dept_name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `faculty`
--

INSERT INTO `faculty` (`facultyid`, `firstName`, `lastName`, `dept_name`, `password`, `email`, `gender`) VALUES
(1, 'abul', 'kasem', 'cse', '2345', 'dfgdfg', 'male'),
(456, 'jTextField2', 'jTextField2', 'jTextField2', 'jTextField2', 'jTextField2', 'jTextField2'),
(666, 'opi', 'Ana', 'eee', '1234', 'opi', 'female');

-- --------------------------------------------------------

--
-- Table structure for table `is_related`
--

CREATE TABLE `is_related` (
  `questionid` int(11) DEFAULT NULL,
  `articleid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `questionandanswer`
--

CREATE TABLE `questionandanswer` (
  `questionid` int(11) NOT NULL,
  `question` varchar(200) NOT NULL,
  `answer` varchar(2) NOT NULL,
  `facultyid` int(11) DEFAULT NULL,
  `testid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `questionandanswer_options`
--

CREATE TABLE `questionandanswer_options` (
  `questionid` int(11) DEFAULT NULL,
  `options` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `studentid` int(11) NOT NULL,
  `firstName` varchar(20) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `dept_name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`studentid`, `firstName`, `lastName`, `dept_name`, `password`, `email`, `gender`) VALUES
(77, 'alu', 'potol', 'goru', 'naikka', 'nomail', 'durro'),
(456, 'jTextField2', 'jTextField2', 'jTextField2', 'jTextField2', 'jTextField2', 'jTextField2'),
(123123, '1fdf', 'dfdfa', 'dfasdf', 'asdfasdf', 'adfasdfasd', 'asdfasdfasd'),
(11142002, 'Alif', 'Choyon', 'cse', '1234', 'alifchoyn@gmail.com', 'male');

-- --------------------------------------------------------

--
-- Table structure for table `student_phonenumber`
--

CREATE TABLE `student_phonenumber` (
  `studentid` int(11) DEFAULT NULL,
  `phoneNumber` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `test`
--

CREATE TABLE `test` (
  `testid` int(11) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `course_id` varchar(11) DEFAULT NULL,
  `starting_timeslotid` varchar(4) DEFAULT NULL,
  `ending_timeslotid` varchar(4) DEFAULT NULL,
  `facultyid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `time_slot`
--

CREATE TABLE `time_slot` (
  `timeslotid` int(11) NOT NULL,
  `hour` varchar(2) DEFAULT NULL,
  `minute` varchar(2) DEFAULT NULL,
  `year` varchar(4) DEFAULT NULL,
  `month` varchar(2) DEFAULT NULL,
  `day` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `answer`
--
ALTER TABLE `answer`
  ADD KEY `questionid` (`questionid`),
  ADD KEY `studentid` (`studentid`);

--
-- Indexes for table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`articleid`),
  ADD KEY `facultyid` (`facultyid`);
ALTER TABLE `article` ADD FULLTEXT KEY `description` (`description`);

--
-- Indexes for table `article_links`
--
ALTER TABLE `article_links`
  ADD KEY `articleid` (`articleid`);

--
-- Indexes for table `assignment`
--
ALTER TABLE `assignment`
  ADD PRIMARY KEY (`assignmentid`),
  ADD KEY `facultyid` (`facultyid`),
  ADD KEY `studentid` (`studentid`);

--
-- Indexes for table `can_read`
--
ALTER TABLE `can_read`
  ADD KEY `articleid` (`articleid`),
  ADD KEY `studentid` (`studentid`);

--
-- Indexes for table `faculty`
--
ALTER TABLE `faculty`
  ADD PRIMARY KEY (`facultyid`);

--
-- Indexes for table `is_related`
--
ALTER TABLE `is_related`
  ADD KEY `questionid` (`questionid`),
  ADD KEY `articleid` (`articleid`);

--
-- Indexes for table `questionandanswer`
--
ALTER TABLE `questionandanswer`
  ADD PRIMARY KEY (`questionid`),
  ADD KEY `facultyid` (`facultyid`),
  ADD KEY `testid` (`testid`);

--
-- Indexes for table `questionandanswer_options`
--
ALTER TABLE `questionandanswer_options`
  ADD KEY `questionid` (`questionid`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`studentid`);

--
-- Indexes for table `student_phonenumber`
--
ALTER TABLE `student_phonenumber`
  ADD KEY `studentid` (`studentid`);

--
-- Indexes for table `test`
--
ALTER TABLE `test`
  ADD PRIMARY KEY (`testid`),
  ADD KEY `facultyid` (`facultyid`);

--
-- Indexes for table `time_slot`
--
ALTER TABLE `time_slot`
  ADD PRIMARY KEY (`timeslotid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `article`
--
ALTER TABLE `article`
  MODIFY `articleid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;
--
-- AUTO_INCREMENT for table `assignment`
--
ALTER TABLE `assignment`
  MODIFY `assignmentid` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `faculty`
--
ALTER TABLE `faculty`
  MODIFY `facultyid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=667;
--
-- AUTO_INCREMENT for table `questionandanswer`
--
ALTER TABLE `questionandanswer`
  MODIFY `questionid` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `studentid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11142003;
--
-- AUTO_INCREMENT for table `test`
--
ALTER TABLE `test`
  MODIFY `testid` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `time_slot`
--
ALTER TABLE `time_slot`
  MODIFY `timeslotid` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `answer`
--
ALTER TABLE `answer`
  ADD CONSTRAINT `answer_ibfk_1` FOREIGN KEY (`questionid`) REFERENCES `questionandanswer` (`questionid`) ON DELETE SET NULL,
  ADD CONSTRAINT `answer_ibfk_2` FOREIGN KEY (`studentid`) REFERENCES `student` (`studentid`) ON DELETE CASCADE;

--
-- Constraints for table `article`
--
ALTER TABLE `article`
  ADD CONSTRAINT `article_ibfk_1` FOREIGN KEY (`facultyid`) REFERENCES `faculty` (`facultyid`) ON DELETE CASCADE;

--
-- Constraints for table `article_links`
--
ALTER TABLE `article_links`
  ADD CONSTRAINT `article_links_ibfk_1` FOREIGN KEY (`articleid`) REFERENCES `article` (`articleid`) ON DELETE SET NULL;

--
-- Constraints for table `assignment`
--
ALTER TABLE `assignment`
  ADD CONSTRAINT `assignment_ibfk_1` FOREIGN KEY (`facultyid`) REFERENCES `faculty` (`facultyid`) ON DELETE CASCADE,
  ADD CONSTRAINT `assignment_ibfk_2` FOREIGN KEY (`studentid`) REFERENCES `student` (`studentid`) ON DELETE CASCADE;

--
-- Constraints for table `can_read`
--
ALTER TABLE `can_read`
  ADD CONSTRAINT `can_read_ibfk_1` FOREIGN KEY (`articleid`) REFERENCES `article` (`articleid`) ON DELETE SET NULL,
  ADD CONSTRAINT `can_read_ibfk_2` FOREIGN KEY (`studentid`) REFERENCES `student` (`studentid`) ON DELETE SET NULL;

--
-- Constraints for table `is_related`
--
ALTER TABLE `is_related`
  ADD CONSTRAINT `is_related_ibfk_1` FOREIGN KEY (`questionid`) REFERENCES `questionandanswer` (`questionid`) ON DELETE SET NULL,
  ADD CONSTRAINT `is_related_ibfk_2` FOREIGN KEY (`articleid`) REFERENCES `article` (`articleid`) ON DELETE CASCADE;

--
-- Constraints for table `questionandanswer`
--
ALTER TABLE `questionandanswer`
  ADD CONSTRAINT `questionandanswer_ibfk_1` FOREIGN KEY (`facultyid`) REFERENCES `faculty` (`facultyid`) ON DELETE SET NULL,
  ADD CONSTRAINT `questionandanswer_ibfk_2` FOREIGN KEY (`testid`) REFERENCES `test` (`testid`) ON DELETE CASCADE;

--
-- Constraints for table `questionandanswer_options`
--
ALTER TABLE `questionandanswer_options`
  ADD CONSTRAINT `questionandanswer_options_ibfk_1` FOREIGN KEY (`questionid`) REFERENCES `questionandanswer` (`questionid`) ON DELETE SET NULL;

--
-- Constraints for table `student_phonenumber`
--
ALTER TABLE `student_phonenumber`
  ADD CONSTRAINT `student_phonenumber_ibfk_1` FOREIGN KEY (`studentid`) REFERENCES `student` (`studentid`) ON DELETE SET NULL;

--
-- Constraints for table `test`
--
ALTER TABLE `test`
  ADD CONSTRAINT `test_ibfk_1` FOREIGN KEY (`facultyid`) REFERENCES `faculty` (`facultyid`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
