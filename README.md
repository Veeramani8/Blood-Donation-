Blood Donation Management System
Description
The Blood Donation Management System is a Spring Boot web application designed to streamline the process of blood donor and receiver management. It enables users to register as donors, search for donors by blood type and location, and manage donor and receiver details through an admin interface.

Features
Donor Management:
Add, edit, delete, and list donors.
Donors can specify their name, email, phone, blood type, and location during registration.
Receiver Management:
Add, edit, delete, and list receivers.
Receivers can search for donors based on blood type and location.
Admin Panel:
Admin login to view and manage donor and receiver lists.
CRUD operations for both donors and receivers.
Dynamic Search:
Receivers can dynamically search for donors.
Thymeleaf Templates:
Interactive front-end using Thymeleaf for forms and pages.
Technology Stack
Backend: Spring Boot, Java
Frontend: Thymeleaf, HTML, CSS
Database: MySQL
Tools: Maven, Hibernate, Eclipse/IntelliJ
How to Run
Clone the repository:
bash
Copy code
git clone https://github.com/yourusername/blood-donation-management.git
Contributing
Contributions are welcome! Please fork the repository, create a feature branch, and submit a pull request.

License
This project is licensed under the MIT License. See the LICENSE file for details.
Navigate to the project directory and configure application.properties with your MySQL database credentials.
Run the application:
bash
Copy code
mvn spring-boot:run
Access the application at http://localhost:8080.
