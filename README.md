# Collage Management System
# Introduction:
We will make a java desktop application. This application will facilitate the user to book the room in different time of the year. We will make a desktop application which will help the user to book the rooms of college for the customers during evening, weekends and in holidays. In this desktop application we will have to main users, one is manger and other one is clerk. Manager and clerk both are playing different roles. The role of manager is to add the rooms, remove the rooms and manger can view the booking of rooms, booking time of rooms and booked rooms. The role of clerk is to book the rooms, view the availability of room etc. The application can be used from different places at same time using client server technique.
# Database:
The database of project is by name “room_reservation”. In “room_reservation” database the tables are “bookings” which is storing the data related booking of room and booking start and end date. The table “rooms” contains the information of room related for example “roomId”,”roomavailbility” etc. The table “roomcategories” Contains the information related to category of room.it contains the information whether room is ‘lectureroom’,’tutorialroom’ or ‘computeroom’. 
# Java Program:
In java program all classes are important to run this project possible but some classes listed below.
•	Java Fx is used to build the interface.
•	DAO class is created for establishing connection with database with different methods in this class which helping to fetch data from database and provide UI to display interface to end user.
•	Different model classes used in this project which helps to get data from DB to Java.
•	UI based classes named as controller classes used to display data to end user.
# Data structure:
In this project we used the data structure linked list. Linked list is used to save the number of seats and to reserve the number of seats with respect to the availability of seats and available rooms in specific time frame. We also used linked list to display the data.
Software testing:
Black box testing:
Black box testing is software testing method in which internal structure of software is unknown to the tester. This type of testing is considered as high-level testing or acceptance testing in which system is finally tested. For black box testing tester does not require any programming knowledge or any implementation knowledge.
Testing for this software:
# Equivalence testing:

Boundary testing is the process of testing between extreme ends or boundaries between partitions of the input values.
These extreme ends like Start- End, Lower- Upper, Maximum-Minimum, Just Inside-Just Outside values are called boundary values and the testing is called "boundary testing".The basic idea in boundary value testing is to select input variable values at their:
*	Minimum
*	Just above the minimum
*	A nominal value
*	Just below the maximum
*	Maximum
We used equivalence boundary testing to test the class booking and rooms data. We used different test the booking of rooms and booking of the day.

