CREATE DATABASE IF NOT EXISTS documentdb;
USE documentdb;

CREATE TABLE IF NOT EXISTS documents (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  author VARCHAR(255) NOT NULL,
  date DATE NOT NULL,
  content TEXT NOT NULL
);
