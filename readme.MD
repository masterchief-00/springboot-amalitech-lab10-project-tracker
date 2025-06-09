# LAB: Project Tracker API

## Overview
A web-based project tracking application built with Spring Boot. This application is designed to help teams organize, track, and manage their projects efficiently. It provides features for creating projects, assigning tasks, tracking progress, and managing team members.

## Features

- Create developer
- Project creation and management
- Task assignment and tracking
- RESTful API endpoints
- Swagger documentation

## Architecture Diagram
![diagram.png](src%2Fmain%2Fresources%2Fdiagram.png)

## Entity Relationship Diagram
![project_tracker_erd.png](src%2Fmain%2Fresources%2Fproject_tracker_erd.png)

## 💻 Requirements
- Java 21
- Maven
- (Optional) Docker

## Getting Started

### Prerequisites

- Java 17 or newer
- Maven or Gradle
- (Optional) MySQL/PostgreSQL for production database

## Setup

1. Clone the repository:
   ```sh
   git clone https://github.com/masterchief-00/springboot-amalitech-lab10-project-tracker.git
   cd springboot-amalitech-lab09-task-manager
   ```

2. Build the project:
   ```sh
   ./mvnw clean install   
   ```

3. Run the application:
   ```sh
   ./mvnw spring-boot:run
   ```
The app will start on - [http://localhost:8080](http://localhost:8080).

### Or, do it with docker
1. Build the project:
   ```sh
   docker build -t springboot-projecttracker-dockerized . 
   ```  
2. Run the image:
    ```
   docker run -p 8080:8080 springboot-projecttracker-dockerized
   ```

## Swagger Documentation
All endpoints are well described on the Swagger UI documentation on - [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html).
