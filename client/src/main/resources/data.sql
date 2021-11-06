DROP TABLE IF EXISTS game;

CREATE TABLE game (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  price FLOAT NOT NULL,
  category VARCHAR(250) DEFAULT NULL
);

INSERT INTO game (name, price, category) VALUES
  ('cod', 49.90, 'shooter');