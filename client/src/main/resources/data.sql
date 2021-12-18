DROP TABLE IF EXISTS game;
DROP TABLE IF EXISTS steamUser;
DROP TABLE IF EXISTS steam_user;
DROP TABLE IF EXISTS ownership;

CREATE TABLE game (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  price FLOAT NOT NULL,
  category VARCHAR(250) DEFAULT NULL
);

CREATE TABLE steam_user (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  user_name VARCHAR(250) NOT NULL,
  is_logged_in BOOLEAN
);

CREATE TABLE ownership (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    steam_user_id INT NOT NULL,
    game_id INT NOT NULL,
    foreign key (game_id) references game(id),
    foreign key (steam_user_id) references steam_user(id)
);

ALTER TABLE steam_user ALTER COLUMN is_logged_in SET DEFAULT FALSE;

INSERT INTO game (name, price, category) VALUES
  ('cod', 49.90, 'shooter'),
  ('fortnite', 5.99, 'battle royale'),
  ('overwatch', 12.99, 'shooter'),
  ('counter strike', 4.99, 'shooter'),
  ('rocket league', 12.99, 'sport'),
  ('new world', 29.99, 'MMORPG'),
  ('euro truck simulator', 9.99, 'simulator'),
  ('player unknown battlegrounds', 12.99, 'battle royale'),
  ('rust', 29.99, 'survival'),
  ('grand theft auto 5', 15.99, 'rpg'),
  ('among us', 5.99, 'party'),
  ('crab game', 0.00, 'party'),
  ('outlast', 7.99, 'horror'),
  ('league of legends', 1.99, 'moba');

INSERT INTO steam_user (user_name) VALUES
  ('pista99'),
  ('joska'),
  ('superGamer69'),
  ('cringeName123'),
  ('qpak');

INSERT INTO ownership (steam_user_id, game_id) VALUES
    (1,1), (1,5), (1,9),
    (2,5), (2,3), (2,14),
    (3,1), (3,2), (3,3), (3,4), (3,5), (3,6), (3,7), (3,8), (3,9), (3,10), (3,11), (3,12), (3,13), (3,14),
    (4,2), (4,7), (4,11), (4,13);