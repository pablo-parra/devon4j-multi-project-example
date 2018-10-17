# spring-boot-multi-module
Spring Boot project based on several spring boot modules (sub-projects) each one pointing to different DBs and configured with different Flyway instances

# Details
* library (multi-module parent project)
  * Books project (spring boot sub module of parent project and multi-module project) Acts like main module --> points to a PostgreSQL DB
  * Authors project (spring boot sub module of parent project and multi-module-project) Acts like a library module --> points to a MySQL DB

Each submodule, _Books_ and _Authors_, have also different [H2](http://www.h2database.com/html/main.html) instances (for tests) and [Flyway](https://flywaydb.org/) (for db migrations)

# DBs with docker

## Books db (PostgreSQL)

### Creation of the db container with Docker (first time)
C:\...\_db\docker-postgreSQL-books> docker build -t books_db_img:0.0.1 .

C:\...> docker run -d --name books_db -p 5432:5432 books_db_img:0.0.1

### Start the db container (rest of the times)

C:\...> docker start books_db

## Authors db (MySQL)

### Creation of the db container with Docker (first time)
C:\...\_db\docker-MySQL-authors> docker build -t authors_db_img:0.0.1 .

C:\...> docker run -d --name authors_db -p 3306:3306 authors_db_img:0.0.1

### Start the db container (rest of the times)

C:\...> docker start authors_db

