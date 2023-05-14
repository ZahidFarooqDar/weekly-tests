# INSTAGRAM Project
![Version](https://img.shields.io/static/v1?label=java-version&message=%3E=11&color=blue) ![documentation](https://img.shields.io/static/v1?label=documentation&message=yes&color=green) ![maintanined?](https://img.shields.io/static/v1?label=MySQL?&message=yes&color=green) ![License](https://img.shields.io/static/v1?label=Linsenced&message=ZAHID&color=orange)

README file for INSTAGRAM PROJECT
## 🏠  [Homepage](https://github.com/ZahidFarooqDar/weekly-tests/tree/main/instagram)
## Prerequisities
* java >=11.0
* Spring Boot
* MySQL database

## Author

* 🙍‍♂️ Zahid Farooq Dar
  * LinkedIn: [@Zahid Farooq](https://www.linkedin.com/in/zahid-farooq-dar/)
  * Github: [@ZahidFarooqDar](https://github.com/ZahidFarooqDar)

## DATA FLOW
* Application is based on MVC architecture where we have
---
### MODEL
* It contains model of USER where we have entities of USER class
* It also contain model of POST and entities of post as well
* It is also inbuilded with mappings as well like @OneToOne, @ManyToOne
---
### CONTROLLER
* This package contains different API end points 

### SERVICE
* It contains the business logic for the API's
* Additionally here we have authorization as well for user who can update the user details
---
### REPOSITORY 
* It is the repository layer where we extend JPA repository which extend JPA Repository and some other methods as well

### DAO
* It contains some class for the sake of authorization

### DATA BASE DESIGN
* HERE we are using MySQL database to store our data 
---

## PROJECT SUMMARY
* The application is designed to perform sign in and sign up functions for a particular user with authorization as well, here also we are using encrypted password as well and the authorize with token to update user details.
---
## 📝 License

 Copyright @ 2019 [@ZahidFarooqDar](https://github.com/ZahidFarooqDar)


# 

This README was generated with ❤️ by [@ZahidFarooqDar](https://github.com/ZahidFarooqDar)
