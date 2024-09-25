# Microservice Example Project

Welcome to the Microservice Example Project! This repository showcases my journey in learning and implementing microservices using various technologies. As I explore this architecture, I’m documenting my progress and sharing code examples along the way.

## Table of Contents

- [Project Overview](#project-overview)
- [Technologies Used](#technologies-used)
- [Setup Instructions](#setup-instructions)
- [Features](#features)
- [Ongoing Progress](#ongoing-progress)
- [Contributing](#contributing)
- [License](#license)

## Project Overview

This project demonstrates a basic microservice architecture, incorporating key components like:

- **Eureka Server** for service discovery
- **API Gateway** for routing requests
- **RESTful Services** for handling various business operations
- **Exception Handling** to manage errors gracefully
- **Docker** for containerization and easier deployment

## Technologies Used

- **Spring Boot**: For building microservices
- **Eureka**: Service discovery
- **Spring Cloud Gateway**: API Gateway
- **Docker**: Containerization
- **JUnit**: For testing
- **Postman**: For API testing

## Setup Instructions

To run this project locally, follow these steps:

1. **Clone the repository:**
  
      `git clone https://github.com/karan-sachdev/com.microservice.git`
      `cd com.microservice`

2. **Build the project:**

      Ensure you have Gradle installed, then run:
      `./gradlew build`

3. **Start the Eureka Server:**

      Navigate to the Eureka Server directory and run:
      `./gradlew bootRun`

4. **Start the API Gateway:**

      In a new terminal, navigate to the API Gateway directory and run:
      `./gradlew bootRun`

5. **Start the RESTful Services:**

      Repeat the previous step for each microservice you have implemented.

6. **Access the application:**

      Open your browser and go to `http://localhost:8080` (or your configured API Gateway port).

## Features

- **Service Discovery**: Register and discover services using Eureka.
- **API Gateway**: Centralized entry point for all requests.
- **Robust REST APIs**: Implemented multiple RESTful services.
- **Error Handling**: Global exception handling for better user experience.
- **Docker Support**: Containerized services for easier deployment.

## Ongoing Progress

This project is a work in progress as I continue to learn about microservices. I plan to implement additional features such as:

- Advanced security measures
- Load balancing
- CI/CD integration

Feel free to check back for updates!

## Contributing

I welcome contributions and suggestions! If you have ideas for improvements or want to share your own experiences, please feel free to open an issue or submit a pull request.

## License

This project is licensed under the MIT License. See the LICENSE file for more details.

---

Thank you for checking out my microservice example project! I hope you find it useful in your own learning journey. If you have any questions, feel free to reach out!

