# Sudoku

This project is composed of two repositories.

This repository is front part, developed using Angular 9. 
The back part was developed using spring boot cf git repository. 
There is no database in this project. Dosuku API was used to create new games.

The player creates a new game, can verify his grid during his game, and get his grid's solution.


&nbsp;
______________________________________
&nbsp;



### Tech Dev


* [JAVA] - version 8 
* [Spring Boot] - focus on application-level business logic
* [Maven] - Manage project 



### Installation

ChemEventz requires Java 8 to run.

Create new folder

```sh
$ git clone https://github.com/nawelb/sudoku_back.git
$ cd sudoku_back
```
Import the project in your favorite IDE :


```sh
$ mvn clean install package
```

Finally, run the project.

### URLs

POST

- /verification : compares completed grid with its solution

/GET
- /newgame : get new grid with solution
- /solution : get solution of current grid





[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)

  [Maven]: <https://maven.apache.org/>
  [Java]:<https://www.java.com/fr/download/>
  [Git]: <https://github.com/nawelb>
  [Spring Boot]: <https://spring.io/projects/spring-boot>