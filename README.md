# xml-projekat

Za pregled UML dijagrama treba instalirati StarUML.

## Uputstvo za pokretanje:
### Backend
**sluzbenik**

pokrenuti iz IntelliJ ili Eclipse IDE

**portal.za.imunizaciju**

pokrenuti iz IntelliJ ili Eclipse IDE

### ExistDB

    docker pull existdb/existdb:latest

**za sluzbenika**

    docker run -it -d -p 8080:8080 -p 8443:8443 --name exist-sluzbenik existdb/existdb:latest

Bazi se može pristupiti na http://localhost:8080

**za portal**

    docker run -it -d -p 8081:8080 -p 8444:8443 --name exist-portal existdb/existdb:latest

Bazi se može pristupiti na http://localhost:8081

### Jena Fuseki

**za sluzbenika**

    docker run --name fuseki-sluzbenik -p 3030:3030 ADMIN_PASSWORD=password stain/jena-fuseki

Nakon pokretanja treba otići na http://localhost:3030/, ulogovati se kao `admin` (`password`) i kreirati novi dataset **eUpravaDataset**

**za portal**

    docker run --name fuseki-portal -p 3031:3030 -e ADMIN_PASSWORD=password stain/jena-fuseki

Nakon pokretanja treba otići na http://localhost:3031/, ulogovati se kao `admin` (`password`) i kreirati novi dataset **eUpravaDataset**

### Frontend

**sluzbenik-app**

    npm install
    ng serve

link http://localhost:4201

**portal-za-imunizaciju-app**

    npm install
    ng serve

link http://localhost:4200


link do frontend repozitorijuma: https://github.com/JolaKl/xml-front