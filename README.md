# Conflict Tracker API

A RESTful API for tracking and managing information about global conflicts, built with Spring Boot 3 and Java 17.

## Features

- Complete CRUD operations for conflicts, factions, countries, and events
- RESTful API design following best practices
- Layered architecture (Controller-Service-Repository)
- Data Transfer Objects (DTOs) for request/response decoupling
- H2 in-memory database for development
- PostgreSQL compatibility for production
- Sample frontend interface for testing

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- (Optional) PostgreSQL for production

## Getting Started

### 1. Clone the repository

```bash
git clone <repository-url>
cd conflict-tracker-api