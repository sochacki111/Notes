# Notes - RESTful API webservice for managing notes
#1. Requirements
- Java 1.8
- Maven
- MySQL
- MySQL Workbench
#2. Database setup
1. Open MySQL Workbench and create user: username=root, password=toor
2. Create new MySQL Connection: username=root password=toor
3. Open SQL Script: Point "db/note.sql" file and execute
#3. Build and run setup
1. Add JAVA_HOME as system variable
2. Open your terminal inside project folder and run following command: ```$ mvn spring-boot:run```
# Example usages:
- Get all notes:
```
$ curl http://localhost:8080/notes
```
- Get single note:
```
$ curl http://localhost:8080/notes/{id}
```
- Create note:
```
$ curl -H "Content-Type: application/json" -X POST -d 
'{"title":"note title","content":"note content"}' http://localhost:8080/notes/
```
- Update note:
```
$ curl -H "Content-Type: application/json" -X PUT -d 
'{"title":"new note title","content":"new note content"}' http://localhost:8080/notes/{id}
```
- Delete note:
```
$ curl -X DELETE http://localhost:8080/notes/{id}
```
- Get version history of single note (If version=0 it means that note has been deleted):
```
$ curl http://localhost:8080/audit/notes/{id}
```