# **Customer Management System**

## Description
A Spring Boot REST API for managing customer data with basic CRUD operations, connected to a MySQL database.

## Features
- Add a customer
- Get all customers
- Update customer details
- Delete a customer

## Technologies Used
- Spring Boot
- Java 17
- Spring Data JPA
- MySQL
- Lombok

## Example Usage

### Add a Customer
Send a `POST` request to `/customers` with the following JSON:
```json
{
  "customername": "John Doe",
  "customeraddress": "123 Main St",
  "mobile": 9876543210
}
```
###  Get All Customers
Send a GET request to /customers.

###  Get Customer by ID
Send a GET request to /customers/{id}.

###  Update a Customer
Send a PUT request to /customers with the updated details:
```json
{
  "customerid": 1,
  "customername": "Jane Doe",
  "customeraddress": "456 Oak St",
  "mobile": 1234567890
}
```
###  Delete a Customer
Send a DELETE request to /customers/{id}.

###  Prerequisites
-  Java 17 or higher
-  Maven
-  MySQL Server
