#Java Spring Web Application for Educational Institution Management

PRECONDITION: If the user wants to execute the program, it is necessary to configure the database first. For this, I exported an SQL file
with all the tables and data originally created from my PostgreSQL software. That file is located inside "psql_database_backup" folder inside the project directory.
Load it inside any SQL database software, and then complete the "application.properties" file with your database credentials.

This Java Spring web application is designed to streamline the management of various elements within an educational institution. The main features include:
- Students; each student has an Address and a Contact.
- Courses
- Assignments

The program allows administrators to:
- Visualize the list of students, courses and assignments.
- Add, update and delete student records.
- Create and manage course information, including course name and price.
- Assign and manage assignments for each course to any registered student, specifying a student, a course, and a shift.

Users can only use the application to:
- Visualize the list of students, courses and assignments.

For more information about the features, architecture of the program, javadoc, etc. please refer to the full documentation.


-JDK 21-
