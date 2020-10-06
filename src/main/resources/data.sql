DROP TABLE IF EXISTS MOVIE;

CREATE TABLE Movie (
	id INT AUTO_INCREMENT  PRIMARY KEY,
  	title VARCHAR(250) NOT NULL,
  	genre VARCHAR(250) NOT NULL,
  	year INT ,
  	rating INT
  );

INSERT INTO 
    Movie (title, genre, year, rating) 
VALUES
    ('Titanic', 'Drama', 2000, 5),
    ('John', 'Action', 1995, 3);