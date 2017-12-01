-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 01, 2017 at 04:40 AM
-- Server version: 10.1.25-MariaDB
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
-- Database: `movies`
--
CREATE DATABASE IF NOT EXISTS `movies` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `movies`;

-- --------------------------------------------------------

--
-- Table structure for table `films`
--

CREATE TABLE `films` (
  `id` int(11) NOT NULL,
  `title` text NOT NULL,
  `description` text NOT NULL,
  `genre` text NOT NULL,
  `duration` int(3) NOT NULL,
  `year` year(4) NOT NULL,
  `stars` text NOT NULL,
  `rating` decimal(2,1) NOT NULL,
  `url` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `films`
--

INSERT INTO `films` (`id`, `title`, `description`, `genre`, `duration`, `year`, `stars`, `rating`, `url`) VALUES
(1, 'The Shawshank Redemption', 'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.', 'Crime, Drama', 142, 1994, 'Tim Robbins, Morgan Freeman, Bob Gunton', '9.3', 'shawshank.jpg'),
(2, 'The Dark Knight', 'When the menace known as the Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham, the Dark Knight must accept one of the greatest psychological and physical tests of his ability to fight injustice.\r\n', 'Action, Thriller\r\n', 152, 2008, 'Christian Bale, Heath Ledger, Aaron Eckhart\r\n', '9.0', 'thedarkknight.jpg'),
(3, 'Pulp Fiction\r\n', 'The lives of two mob hit men, a boxer, a gangster\'s wife, and a pair of diner bandits intertwine in four tales of violence and redemption.', 'Crime, Drama\r\n', 154, 1994, 'John Travolta, Uma Thurman, Samuel L. Jackson\r\n', '8.9', 'pulpfiction.jpg'),
(4, 'The Lord of the Rings: The Return of the King\r\n', 'Gandalf and Aragorn lead the World of Men against Sauron\'s army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.\r\n', 'Adventure, Drama, Fantasy\r\n', 201, 2003, 'Elijah Wood, Viggo Mortensen, Ian McKellen\r\n', '8.9', 'returnoftheking.jpg'),
(5, 'Fight Club\r\n', 'An insomniac office worker, looking for a way to change his life, crosses paths with a devil-may-care soap maker, forming an underground fight club that evolves into something much, much more.\r\n', 'Drama\r\n', 139, 1999, 'Brad Pitt, Edward Norton, Meat Loaf \r\n', '8.8', 'fightclub.jpg'),
(6, 'The Lord of the Rings: The Fellowship of the Ring\r\n', 'A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle Earth from the Dark Lord Sauron..\r\n', 'Adventure, Drama, Fantasy\r\n', 178, 2001, 'Elijah Wood, Ian McKellen, Orlando Bloom\r\n', '8.8', 'fellowship.jpg'),
(7, 'Forrest Gump\r\n', 'JFK, LBJ, Vietnam, Watergate, and other history unfold through the perspective of an Alabama man with an IQ of 75.\r\n', 'Comedy, Drama, Romance\r\n', 142, 1994, 'Tom Hanks, Robin Wright, Gary Sinise\r\n', '8.8', 'forrestgump.jpg'),
(8, 'Star Wars: Episode V - The Empire Strikes Back\r\n', 'After the rebels are overpowered by the Empire on their newly established base, Luke Skywalker begins Jedi training with Master Yoda. His friends accept shelter from a questionable ally as Darth Vader hunts them in a plan to capture Luke.\r\n', 'Action, Adventure, Fantasy\r\n', 124, 1980, 'Mark Hamill, Harrison Ford, Carrie Fisher\r\n', '8.8', 'empirestrikesback.jpg'),
(9, 'Inception\r\n', 'A thief, who steals corporate secrets through use of dream-sharing technology, is given the inverse task of planting an idea into the mind of a CEO.\r\n', 'Action, Adventure,   Sci-Fi\r\n', 148, 2010, 'Leonardo DiCaprio, Joseph Gordon-Levitt, Ellen Page\r\n', '8.8', 'inception.jpg'),
(10, 'The Lord of the Rings: The Two Towers\r\n', 'While Frodo and Sam edge closer to Mordor with the help of the shifty Gollum, the divided fellowship makes a stand against Sauron\'s new ally, Saruman, and his hordes of Isengard.\r\n', 'Adventure, Drama, Fantasy\r\n', 179, 2002, 'Elijah Wood, Viggo Mortensen, Ian McKellen\r\n', '8.7', 'twotowers.jpg'),
(11, 'One Flew Over the Cuckoo\'s Nest\r\n', 'A criminal pleads insanity after getting into trouble again and once in the mental institution rebels against the oppressive nurse and rallies up the scared patients.\r\n', 'Drama\r\n', 133, 1975, 'Jack Nicholson, Louise Fletcher, Michael Berryman\r\n', '8.7', 'cuckoosnest.jpg'),
(12, 'The Matrix\r\n', 'A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.\r\n', 'Action, Sci-Fi\r\n', 136, 1999, 'Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss\r\n', '8.7', 'thematrix.jpg'),
(13, 'Star Wars: Episode IV - A New Hope\r\n', 'Luke Skywalker joins forces with a Jedi Knight, a cocky pilot, a Wookiee, and two droids to save the galaxy from the Empire\'s world-destroying battle-station, while also attempting to rescue Princess Leia from the evil Darth Vader.\r\n', 'Action, Adventure, Fantasy\r\n', 121, 1977, 'Mark Hamill, Harrison Ford, Carrie Fisher\r\n', '8.7', 'anewhope.jpg'),
(14, 'Saving Private Ryan\r\n', 'Following the Normandy Landings, a group of U.S. soldiers go behind enemy lines to retrieve a paratrooper whose brothers have been killed in action.\r\n', 'Drama, War\r\n', 169, 1998, 'Tom Hanks, Matt Damon, Tom Sizemore\r\n', '8.6', 'savingprivateryan.jpg'),
(15, 'Spirited Away\r\n', 'During her family\'s move to the suburbs, a sullen 10-year-old girl wanders into a world ruled by gods, witches, and spirits, and where humans are changed into beasts.\r\n', 'Animation, Adventure, Fantasy\r\n', 125, 2001, 'Daveigh Chase, Suzanne Pleshette, Miyu Irino\r\n', '8.6', 'spiritedaway.jpg'),
(16, 'Interstellar\r\n', 'A team of explorers travel through a wormhole in space in an attempt to ensure humanity\'s survival.\r\n', 'Adventure, Drama, Sci-Fi\r\n', 169, 2014, 'Matthew McConaughey, Anne Hathaway, Jessica Chastain\r\n', '8.6', 'interstellar.jpg'),
(17, 'Back to the Future\r\n', 'Marty McFly, a 17-year-old high school student, is accidentally sent 30 years into the past in a time-traveling DeLorean invented by his close friend, the maverick scientist Doc Brown.\r\n', 'Adventure, Comedy, Sci-Fi\r\n', 116, 1985, 'Michael J. Fox, Christopher Lloyd, Lea Thompson\r\n', '8.5', 'backtothefuture.jpg'),
(18, 'The Dark Knight Rises\r\n', 'Eight years after the Joker\'s reign of anarchy, the Dark Knight, with the help of the enigmatic Catwoman, is forced from his exile to save Gotham City, now on the edge of total annihilation, from the brutal guerrilla terrorist Bane.\r\n', 'Action, Thriller\r\n', 164, 2012, 'Christian Bale, Tom Hardy, Anne Hathaway\r\n', '8.4', 'darkknightrises.jpg'),
(19, 'Star Wars: Episode VI - Return of the Jedi\r\n', 'After a daring mission to rescue Han Solo from Jabba the Hutt, the rebels dispatch to Endor to destroy a more powerful Death Star. Meanwhile, Luke struggles to help Vader back from the dark side without falling into the Emperor\'s trap.\r\n', 'Action, Adventure, Fantasy\r\n', 131, 1983, 'Mark Hamill, Harrison Ford, Carrie Fisher\r\n', '8.3', 'returnofthejedi.jpg'),
(20, 'Your Name\r\n', 'Two strangers find themselves linked in a bizarre way. When a connection forms, will distance be the only thing to keep them apart?\r\n', 'Animation, Drama, Fantasy\r\n', 106, 2016, 'Ryûnosuke Kamiki, Mone Kamishiraishi, Ryô Narita\r\n', '8.3', 'yourname.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `films`
--
ALTER TABLE `films`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `films`
--
ALTER TABLE `films`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
