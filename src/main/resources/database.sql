CREATE DATABASE portfolio;

INSERT INTO skills (technology, image_url, percent, ord) VALUES ("Javascript", "https://javascribp.com/img.jpg", 80, 1), ("Angular", "https://angular.com/img.jpg", 50, 2), ("Java", "https://java.com/img.jpg", 50, 2);

ALTER TABLE skills modify COLUMN id INT AUTOINCREMENT;

