# Travel Agency Management System

A comprehensive web application for managing travel packages, bookings, payments, and customer reviews. Built with Spring Boot and MySQL, this system provides both customer-facing features and administrative capabilities.

## Description

This travel agency web application enables users to:
- Search and browse touristic travel packages
- Book and manage travel reservations
- Process payments securely
- Write and read package reviews
- Manage personal profiles and booking history

Administrative features include:
- Create, update, and delete travel packages
- Manage system-wide package offerings
- Monitor bookings and customer activity

## Technologies Used

- **Spring Boot** - version 3.5.7
- **MySQL Database** - for data persistence
- **Java JDK** - version 17
- **Thymeleaf** - version 3.5.4 (templating engine)
- **IntelliJ IDEA** - recommended IDE

## Prerequisites

Before running this application, ensure you have:
- Java JDK 17 or higher installed
- MySQL Server installed and running
- IntelliJ IDEA or Eclipse IDE
- Git (for cloning the repository)

## Installation & Setup

### 1. Clone the Repository
```bash
git clone [repository-url]
cd travel-agency-management
```

### 2. Database Configuration
Create a MySQL database named `travel_agency_management`:
```sql
CREATE DATABASE travel_agency_management;
```

### 3. Configure Application Properties
Update the `application.properties` file with your database credentials:

```properties
spring.application.name=Travel-Agency-Management
spring.datasource.url=jdbc:mysql://localhost:3306/travel_agency_management
spring.datasource.username={your_root}
spring.datasource.password={your_password}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

### 4. Import Project
- Open IntelliJ IDEA or Eclipse
- Select **File → Open** and navigate to the project directory
- Wait for dependencies to download

### 5. Run the Application
Run the main application class:
```
TravelAgencyManagementApplication.java
```

The application will start on `http://localhost:8080` by default.

## API Endpoints

### Home & Authentication

#### AuthController
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/register` | Display registration page |
| POST | `/register` | Handle user registration |
| GET | `/login` | Display login page |

#### HomeController
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/` | Display home page |

#### DashboardController
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/dashboard` | Display user dashboard |

### User Features

#### UserController
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/profile/` | View user profile |
| POST | `/profile/update` | Update profile information |
| POST | `/profile/delete` | Delete user account |

#### BookingController
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/bookings/my` | View user's bookings |

#### PaymentController
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/payments/{packageId}` | Display payment page |
| POST | `/payments/confirm/{packageId}` | Confirm payment |

#### ReviewController
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/reviews/add/{packageId}` | Display review form |
| POST | `/reviews/add/{packageId}` | Submit package review |

### Admin Features

#### AdminPackageController
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/admin/packages` | List all packages |
| GET | `/admin/packages/create` | Display package creation form |
| POST | `/admin/packages/create` | Handle package creation |
| GET | `/admin/packages/edit/{id}` | Display package edit form |
| POST | `/admin/packages/update/{id}` | Handle package update |
| GET | `/admin/packages/delete/{id}` | Delete a package |

## User Roles

### Customer Role
- Browse and search travel packages
- Make bookings and payments
- Write reviews
- Manage personal profile
- View booking history

### Admin Role
- Full CRUD operations on travel packages
- Access to all system features
- Package management dashboard

## Project Structure

```
travel-agency-management/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/travelagency/
│   │   │       ├── controller/
│   │   │       ├── model/
│   │   │       ├── repository/
│   │   │       ├── service/
│   │   │       └── TravelAgencyManagementApplication.java
│   │   └── resources/
│   │       ├── templates/
│   │       ├── static/
│   │       └── application.properties
│   └── test/
└── pom.xml
```


## Support

For issues, questions, or contributions, please open an issue in the repository.

---

**Note**: Make sure to keep your database credentials secure and never commit them to version control. Consider using environment variables for sensitive configuration.
