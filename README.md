GreenHub 🌿

GreenHub is a web application designed to connect gardening enthusiasts. It serves as a platform for sharing knowledge, discovering local shops, and engaging with blog posts about gardening. With a secure user authentication system and administrative controls, GreenHub fosters a safe, interactive environment for both users and admins.

Features
User Interactions: Users can comment on blog posts, interact with others, and follow gardening trends.
Shop Recommendations: Display curated shops where users can explore gardening supplies and products.
Role-Based Access: Secured with Spring Security, GreenHub protects against CSRF attacks, and administrators have special privileges.
Admin Control Panel: Admins can manage content by deleting comments, managing users, and adding or editing shops and products.
Tech Stack
Frontend: Angular
Backend: Spring Boot
Database: MySQL
Security: Spring Security with CSRF protection


Prerequisites
Java 17+
Node.js & npm
MySQL Server
Backend Setup (Spring Boot)

Clone the repository:
git clone https://github.com/oliverjvc/GreenHub.git
cd GreenHub

Set up the MySQL database:
Create a database named knjigacveca.
Update the database connection settings in src/main/resources/application.properties.

Run the backend:
./mvnw spring-boot:run
Frontend Setup (Angular)
Navigate to the Angular project directory:
cd src/main/webapp

Install dependencies:
npm install

Start the Angular development server:
ng serve
