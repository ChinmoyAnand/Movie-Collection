# Assignment for Tracking a Movie Collection.
The Project solves the problem of identifying Movie Collection. It also sorts the Movie based on Title,Genre,Rating etc.  
The user can also search a particular movie. Its a wild search based on any field.  
There is pagination, we can have 10 rows per page and increase the per page records to 25/50 also.  


### Technology Used
	* Java 8
	* Spring Boot 2
	* Thymeleaf
	* HTML, CSS, Jquery
	* Lombok
	* H2 Database
	* JUnit,Mockito
	
# How to run the project

Step 1: Git clone the repository into local machine.</br>
Step 2: Go to MovieApplication File and Right Click Run As Java Application</br>
Step 3: To Login: user/user(READ access) or admin/admin(ADMIN access)</br>
Note: Other configuration will be auto configured after we start the SpringBoot Application.

# SECURITY

The Portal is protected by Spring Security.  
To access the webpage you have to Login by user/user or admin/admin
There are 2 roles for authorization.
USER - Can access and add new movie. CAN NOT EDIT or DELETE. 
ADMIN - Can Add,edit,delete movie  


# UNIT TEST

The Unit test is definced for the Controller Layer with Mocking to Repository Layer.


## Improvements

Next Phase will have improved UI with Thumbnails and IMDB link for each movie. 
More properties will be added to MOVIE ex- actor,director,thumbnail etc
Backend will have service layer added for more Validation and Business Logic.
