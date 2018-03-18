# Dawllapop
This is a practice for the subject of web application development simulating the wallapop appp.

#### Development team:

|Name                     |E-mail                       |GitHub Name        |
|:-----------------------:|:---------------------------:|:-----------------:|
|Juan Manuel Verano Garri |jm.verano@alumnos.urjc.es    |juanmaverano       |
|Daniel Anguita Viñas     |d.anguita@alumnos.urjc.es    |daniel097541       |
|Alvaro Porres Gonzalez   |a.deporres@alumnos.urjc.es   |varodpg            |
|David Rial Vega          |d.rial@alumnos.urjc.es       |davidrialvega      |
|Alberto Alvarez Gomez    |a.alvarezgom@alumnos.urjc.es |alberalgo          |

#### Trello: https://trello.com/b/hSJ9ryp5/practica-daw

#### Data base entity diagram:

![alt text](https://github.com/varodpg/daw-wallapop/blob/master/diagrams/Entity%20diagram.png "Entity Diagram")

#### Data base entities attributes:

User: id(PK), name (UQ), email,  password, img ?, location
Product: id(PK), id_user(FK), id_category(FK), tags, imgs?, description, specifications, state, price
Category: id(PK), name
Friend_request: id(PK), from(FK), to(FK), mesage, state
Product_request: id(PK), from(FK), to(FK), product(FK), mesage, state

#### Advanced funcionality:
For the advanced funcionality we have thought to include personal recomendations based on your personal info like what you have bought, products near you, etc

#### Charts:
We are going to show the user history of purchases and his sales. And for more advanced stadistics we are going to show more info like the places that are more purchases, the bests categories, etc.

#### Funcionality with advanced technology:
To facilitate the contact of the users we will introduce a chat so they can talk in real time with their friends and with the sellers. 

#### Screenshots
Screenshots of the pages

1. Inicio: Main page from the Dawllapop web. Include some sections like "Products Near you", "Latest products added","products of interest" and search bar.

![alt text](https://github.com/varodpg/daw-wallapop/blob/master/screenshots/index.png "Index1")

2. Categorias: Advanced web search for products ordered by categories.

![alt text](https://github.com/varodpg/daw-wallapop/blob/master/screenshots/categorias.png "Categories")

3. Perfil:  A simple view for an user profile. There are two profile pages: public and private. You can access to your products, my products for sale,my shopping, my sales,reviews, offers received and friend requests.
You can see the public information of an user from public profile.

![alt text](https://github.com/varodpg/daw-wallapop/blob/master/screenshots/perfil-misCompras.png "Private Profile- myshopping")
![alt text](https://github.com/varodpg/daw-wallapop/blob/master/screenshots/oferta.png "Private Profile-offers")
![alt text](https://github.com/varodpg/daw-wallapop/blob/master/screenshots/amistad.png "Private Profile-friend requests")
![alt text](https://github.com/varodpg/daw-wallapop/blob/master/screenshots/PerfilPublico.png "Public Profile")

4. Editar Perfil: Personal data edition page.

![alt text](https://github.com/varodpg/daw-wallapop/blob/master/screenshots/editarPerfil.png "Edit Profile")

5. Producto: The main information about a product and how to buy it.

![alt text](https://github.com/varodpg/daw-wallapop/blob/master/screenshots/producto.png "Product")

6. Editar Producto: A complete form to create or edit the information about a product for sale.

![alt text](https://github.com/varodpg/daw-wallapop/blob/master/screenshots/editar_producto.jpeg "Edit Product")

7. Registro: You must login on the "Iniciar sesion" button on the rigth corner where. If you have not an account, you can register on the web through the form. 

![alt text](https://github.com/varodpg/daw-wallapop/blob/master/screenshots/login.png "Login")
![alt text](https://github.com/varodpg/daw-wallapop/blob/master/screenshots/registro.png "Register form")

8. Chat: You can talk to your friends and sellers that you have added to your friends list
![alt text](https://github.com/varodpg/daw-wallapop/blob/master/screenshots/chat.png "Chat")

9. Admin: Site where the administrator can edit the products and users of the page
![alt text](https://github.com/varodpg/daw-wallapop/blob/master/screenshots/admin.png "Admin")

# FASE 3 - SPRING APPLICATION - 

### NAVIGATION DIAGRAM
![alt text](https://github.com/varodpg/daw-wallapop/blob/master/diagrams/Diagrama%20de%20navegaci%C3%B3n.png "Navigation diagram")

### DEVELOPMENT ENVIROMENT

To configure the development environment and to develop a Spring Boot application, we will need a program that provides us with the structure of the
packages to make the application as well as to manage the dependencies of Maven. To start we will download the program, we have used STS, which can be downloaded from the following link (https://spring.io/tools), once installed to create a project we will have to go to File -> New -> Sring Starter Project and we would have our project ready to start developing and working.

### DATABASE DIAGRAM

The following image show a diagram of the Entities database:
![alt text](https://github.com/varodpg/daw-wallapop/blob/master/screenshots/bddiagram.png "BDdiagram")

### CLASSES DIAGRAM

The following image show a diagram of the classes into the app: Controllers, services, repositories and HTML documents:
![alt text](https://github.com/varodpg/daw-wallapop/blob/master/screenshots/clasesdiagram.png "Classesdiagram")

### STARTING THE APPLICATION:

Windows:
We need to have XAMPP installed to run the MYSQL process or MysqlCommunityServer.
We need to have Workbench installed to manage the tables.

The first thing we will do will be to give you start in the xampp part to start the MYSQL process, then we start the workbench and give you run to connect the database.
Finally we will give the run spring boot application in our sts and we could already access our application.

MacOs:
We need to have XAMPP installed to run the MYSQL process or MysqlCommunityServer.
We need to have Workbench installed to manage the tables.

First of all, we need intall MysqlCommunityServer and MysqlWorkbench, an IDE to manage the database. We also may manage the databse through the console terminal.
After that, we create a database with the name "daw" into MysqlWorkbench.
Finally we include the followinf lines into the application.properties file to indicate how to connect to the datase:

spring.datasource.url=jdbc:mysql://localhost/daw
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driverClassName=com.mysql.jdbc.Driver
spring.jpa.hibernate.ddl-auto=create-drop


Note: MacOs maybe will not add to the $PATH the mysql Server process. We need to run server into settings page and include it to the path into ~/.bash_profile 

# FASE 4 - API REST AND DOCKER -

### API REST DOCUMENTATION

https://github.com/varodpg/daw-wallapop/blob/master/API.md

### CLASSES DIAGRAM

The following image show a diagram of the classes into the app: Controllers, services, repositories, apiRest and HTML documents:

![alt text](https://github.com/varodpg/daw-wallapop/blob/master/screenshots/clasesdiagramUpdated.png "Classesdiagram")

### FIRST STEPS TO PREPARE THE ENVIRONMENT TO DOCKERIZE THE APP 

First of all, we need to download Docker from https://www.docker.com/community-edition 
Docker will be a process on your computer. Use it through computer console.
The image of the java project will be allocated on DockerHub. You can create an account from https://hub.docker.com
Into DockerHub we need to create a repository to allocate the java app.

### INSTRUCTIONS TO DEVELOP

To Dockerize the java application we need to compile the app, build the image, publish the image into the DockerHub repository and launch the application through a Docker-compose into command line console.

To compile the project we need maven. In our case, we will use a maven container.  

To build the image we need a DockerFile file that contains the files and settings to build a image. In this case this file will contain the route for sdk java version 8, the java app and configurations like the web port to launch the app.

Docker-compose command instruction need a file called docker-compose.yml. We need to execute the command into the directory that contains the docker-compose.yml. This file contains the route to the image, the route to a mysql image and the rest of settings to prepare the app to be launched (for example, the configuration to connect java application to mysql database). 

### INSTRUCTIONS TO EXECUTE THE DOCKERIZED APP.

To make easy the process to launch the app dockerized, its included a shell script (execute_scripts.sh) into Docker Directory for linux and macOs machines that will launch some scripts to compile and build the app image (create_image.sh) and publish the image into DockerHub* (publish_image.sh).
*Its needed to have docker process launched and be logged into DockerHub.

### SOME EXTRA COMMAND LINE COMMANDS

docker images: shows images downloaded into the computer. <br>
docker ps: shows containers running. <br>
docker rmi --force: delete an image from the computer. <br>
docker build -t name_of_image . : build an image based on a DockerFile (dot indicate this) <br>
docker tag my_image $DOCKER_ID_USER/my_image : tag an image (needed to push an image into DockerHub) <br>
docker push $DOCKER_ID_USER/my_image: push the tagged image to DockerHub <br>
docker-compose up: launch a docker-compose. <br>
docker-compose down: stop a docker-compose. <br>
docker-compose rm: remove a docker-compose executed. Sometimes its needed to rebuild a docker-compose <br>
