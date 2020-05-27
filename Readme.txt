Title : This is an Application where a user can add a movie of their choice including its category and rating they want to provide.
-----------------------------------------------------------------------------------
Spring boot version : 2.1.5.RELEASE
hibernate/Jpa version : 2.1.5.RELEASE
-----------------------------------------------------------------------------------
Swagger-ui : http://localhost:8080/swagger-ui.html
-----------------------------------------------------------------------------------
API end points:
Get All Movies:  http://localhost:8080/movies
Get All Categories:  http://localhost:8080/categories
Get Movie By Id:  http://localhost:8080/movies/{id}
Delete Movie By Id:  http://localhost:8080/movies/{id}
Add New Movie :  http://localhost:8080/movies/addMovie
Update Movie :  http://localhost:8080/movies/updateMovie


-----------------------------------------------------------------------------------
Database queries to be executed before starting project:
CREATE DATABASE `movies_db` /*!40100 COLLATE 'utf8_general_ci' */;

Internal Entities will be created automatically when project starts.

Queries to insert Data at initial DB setup after project runs:

INSERT INTO `movies_db`.`category` (`id`, `name`) VALUES (1, 'Netflix');
INSERT INTO `movies_db`.`category` (`id`, `name`) VALUES (2, 'Prime');
INSERT INTO `movies_db`.`category` (`id`, `name`) VALUES (3, 'Hotstar');

INSERT INTO `movies_db`.`movie` (`title`, `cat_id`, `rating`) VALUES ('Movie Name', 3, 4.2);
INSERT INTO `movies_db`.`movie` (`title`, `cat_id`, `rating`) VALUES ('Movie Name 2', 1, 1.8);

