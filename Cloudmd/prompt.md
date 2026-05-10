# AI Development Prompt

## Project Name
Article Management System

## Backend Framework
Spring Boot

## Database
MySQL


# Requirements
Create a Spring Boot REST API application.


# Features

1. User Registration
2. User Login
3. JWT Authentication
4. Create Article
5. Update Article
6. Delete Article
7. Get Single Article
8. Get All Articles


# Coding Standards

- Use layered architecture
- Use DTO pattern
- Use constructor injection
- Use Lombok
- Use REST APIs
- Use validation annotations
- Use exception handling


# Package Structure

- controller
- service
- repository
- entity
- dto
- config
- security


# API Response Format

```json
{
  "success": true,
  "message": "Operation successful",
  "data": {}
}
```


# Security

Use JWT authentication with Spring Security.


# Database Tables

## users

- id
- username
- email
- password
- role

## articles

- id
- title
- content
- author
- created_at