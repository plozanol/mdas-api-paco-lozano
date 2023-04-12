## Prerequisites
- Java SDK 17

## Stack used 
- Java 17
- SpringBoot 3
- Maven 3
- RabbitMQ

## Prerequisites
This project use RabbitMQ server to allow messaging between bounded contexts, then before running the project you need to have RabbitMQ up and configured as follows:
```
VHOST=pokeworld
USER=pokeuser
PASS=pikachu66
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.11-management
docker exec -it rabbitmq rabbitmqctl add_vhost ${VHOST}
docker exec -it rabbitmq rabbitmqctl add_user ${USER} ${PASS}
docker exec -it rabbitmq rabbitmqctl set_user_tags ${USER} administrator
docker exec -it rabbitmq rabbitmqctl set_permissions -p ${VHOST} ${USER} ".*" ".*" ".*"
```

## How to use
At the root of the project you have two maven wrapper executables, that will allow you to compile, execute and running tests
without the need of installing maven.

You have the linux executable(mvnw) and the windows executable(mvnw.cmd). Just check you have execute permission set on these files to be able to run it.
In the following sections you will see example commands made with the linux maven wrapper.

## Testing
```
./mvnw clean verify
```

## How to run
There are to ways to execute this project, via terminal commands or a http request.

### Commands via terminal
Follow this steps:
  - Open a terminal and change the directory to the root of this project.
  - Execute the following command: 
```
./mvn clean compile -Dexec.mainClass=pokedex.pokemonType.infrastructure.GetPokemonTypeWithConsole exec:java -Dexec.args="pikachu"
```

The pokemon type should appear on console.

### Running a http server
Spring Boot provides an internal tomcat server that we can use to easily run a http server.

Follow this steps:
- Open a terminal and change the directory to the root of the project.
- Execute the following command:
``` 
./mvn clean package spring-boot:run
```

- Open a web browser and type the following URL: http://localhost:8080/get-pokemon-types-by-name?pokemonName={{the name of the pokemon that you want to search}}.
For example: http://localhost:8080/get-pokemon-types-by-name?pokemonName=
  
The pokemon type should appear in the browser.

## Database
This application is just a proof of software design concepts, so isn't needed a real database. We have use a simple java Map to simulate InMemoryDatabase

## Endpoints
The tomcat server by default will start at 8080 port, so you could check all the request with http://localhost:8080 address
You can use any http client, but just for the convenience of testing header injection, we will use wget in the next examples.

### GET /get-pokemon-types-by-name?pokemonName={pokemonName}
```
wget --method=GET -q -O- "localhost:8080/get-pokemon-types-by-name?pokemonName=pikachu"
["electric"]
```
### POST /trainer/{ID}
Create a trainer in the given ID
```
wget --method=POST -O- "localhost:8080/trainer/99"
```

### PATCH /trainer/favourite-pokemon/{pokemonID}
Note: you need to inject an existing user_id custom header, to be able to add a FavoritePokemon from a Trainer
```
wget --method=PATCH -q -O - --header='user_id:99' "localhost:8080/trainer/favourite-pokemon/2"
```

### DELETE /trainer/favourite-pokemon/{pokemonID}
Note: you need to inject an existing user_id custom header, to be able to remove a FavoritePokemon from a Trainer
```
wget --method=DELETE -q -O - --header='user_id:99' "localhost:8080/trainer/favourite-pokemon/2"
```

### GET "localhost:8080/get-pokemon-details-by-id?pokemonId=2"{pokemonID}
```
wget --method=GET -q -O- "localhost:8080/get-pokemon-details-by-id?pokemonId=2"
```