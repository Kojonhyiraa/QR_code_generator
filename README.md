# QR Code Generator with Spring Boot

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.1-brightgreen)  
![Java](https://img.shields.io/badge/Java-23-blue)  
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15.3-blue)  
![Maven](https://img.shields.io/badge/Maven-3.9.5-orange)  
![ZXing](https://img.shields.io/badge/ZXing-3.5.1-yellow)  

This is a **QR Code Generator** project built using **Spring Boot 3.4.1**, **Maven**, and **PostgreSQL**. It uses the **ZXing library** to generate QR codes for user information stored in the database. The QR code contains details such as the user's ID, first name, last name, email, and mobile number.

---

## Features ✨
- Generate QR codes for user information stored in a PostgreSQL database.
- REST API endpoints to fetch user data and generate QR codes.
- Tested with **Postman** for API validation.
- Easy-to-configure database settings in `application.properties`.

---

## Technologies Used 🛠️
- **Spring Boot 3.4.1**
- **Maven** (Build Tool)
- **PostgreSQL** (Database)
- **ZXing Library** (QR Code Generation)
- **Java 23**
- **Postman** (API Testing)

---

## Prerequisites 📋
Before running the project, ensure you have the following installed:
1. **Java 23 JDK**
2. **Maven**
3. **PostgreSQL**
4. **Postman** (for testing endpoints)
5. **IDE** (e.g., IntelliJ IDEA, Eclipse, or VS Code)

---

## Setup and Configuration ⚙️

### 1. Clone the Repository
Clone this repository to your local machine:
```bash
git clone https://github.com/your-username/qrcode-generator.git
cd qrcode-generator
```

### 2. Database Configuration
Update the `application.properties` file with your PostgreSQL database credentials:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/qrcode_db
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Build the Project
Run the following Maven command to build the project:
```bash
mvn clean install
```

### 4. Run the Application
Start the Spring Boot application:
```bash
mvn spring-boot:run
```

The application will start at `http://localhost:8080`.

---

## API Endpoints 🌐

### 1. Get All Users
- **Endpoint**: `GET http://localhost:8080/v1/all`
- **Description**: Fetches all users from the database and generates QR codes for each user.
- **Response**: List of users in JSON format.

### 2. Get User by ID
- **Endpoint**: `GET http://localhost:8080/v1/{id}`
- **Description**: Fetches a specific user by their ID and generates a QR code for the user.
- **Response**: User details in JSON format.

### 3. Add a New User
- **Endpoint**: `POST http://localhost:8080/v1/add`
- **Description**: Adds a new user to the database.
- **Request Body**:
  ```json
  {
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "mobileNumber": "1234567890"
  }
  ```
- **Response**: Saved user details in JSON format.

---

## User Model 📄
The `User` model contains the following fields:
- `id` (Auto-generated)
- `firstName`
- `lastName`
- `email`
- `mobileNumber`

---

## Generating QR Codes 📲
QR codes are generated automatically when you hit the following endpoints:
- `GET http://localhost:8080/v1/all` (Generates QR codes for all users)
- `GET http://localhost:8080/v1/{id}` (Generates a QR code for a specific user)

The QR codes are saved in the `src/main/resources/static` directory with filenames in the format:
```
<firstName><id>-QRCode.png
```

---

## Testing with Postman 🚀
1. Import the Postman collection provided in the `postman` folder.
2. Use the following endpoints to test the API:
   - Fetch all users: `GET http://localhost:8080/v1/all`
   - Fetch a user by ID: `GET http://localhost:8080/v1/1`
   - Add a new user: `POST http://localhost:8080/v1/add`

---

## How to Start a Spring Boot Project 🛠️
1. **Install Spring Boot CLI** (if not already installed):
   ```bash
   brew install springboot
   ```
2. **Create a New Spring Boot Project**:
   - Use [Spring Initializr](https://start.spring.io/) to generate a project.
   - Select the following dependencies:
     - Spring Web
     - Spring Data JPA
     - PostgreSQL Driver
   - Download the project and import it into your IDE.
3. **Configure the Database**:
   - Update the `application.properties` file with your database credentials.
4. **Run the Application**:
   - Use the command `mvn spring-boot:run` to start the application.

---

## Project Structure 📂
```
src/
├── main/
│   ├── java/
│   │   └── kttech/
│   │       └── QrCodeGenerator/
│   │           ├── controller/
│   │           │   └── UserController.java
│   │           ├── models/
│   │           │   └── User.java
│   │           ├── repository/
│   │           │   └── UserRepository.java
│   │           ├── service/
│   │           │   └── UserService.java
│   │           ├── utils/
│   │           │   └── QRCodeGenerator.java
│   │           └── QrCodeGeneratorApplication.java
│   └── resources/
│       ├── static/ (QR codes are saved here)
│       └── application.properties
└── test/
    └── java/
        └── kttech/
            └── QrCodeGenerator/
                └── QrCodeGeneratorApplicationTests.java
```

---

## Contributing 🤝
Feel free to contribute to this project by opening issues or submitting pull requests.

---

## License 📜
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Acknowledgements 🙏
- [ZXing Library](https://github.com/zxing/zxing) for QR code generation.
- [Spring Boot](https://spring.io/projects/spring-boot) for the backend framework.
- [PostgreSQL](https://www.postgresql.org/) for the database.
- Built by [Kojo Nhyira](https://github.com/kojonhyiraa/)

---

Enjoy generating QR codes! 🚀
