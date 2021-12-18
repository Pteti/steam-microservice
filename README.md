# steam

## client
Spring-boot application running on port 8080

## payments
Spring boot application running on Docker or port 9888


## examples
Before running the example requests please read the individual Readme files in the microservices
The database is filled with example values. First start both applications and the you can check some examples for a complete test (order matters). You can run these at Postman

### List users (GET)
localhost:8080/steam/users

### List games (GET)
localhost:8080/steam/games

### Make purchase with not logged in users (POST)
localhost:8080/steam/qpak/buy/5

### Make purchase with not existing users (POST)
localhost:8080/steam/qpak2/buy/5

### Log In user (POST)
localhost:8080/steam/users/login/qpak

### Make purchase with not existing game (POST)
localhost:8080/steam/qpak/buy/100

### Make purchase (POST)
localhost:8080/steam/qpak/buy/5

