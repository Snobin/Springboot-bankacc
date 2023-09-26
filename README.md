# BankTransactionController

The `BankTransactionController` is a Spring Boot RESTful controller responsible for handling HTTP requests related to bank transactions.

## Table of Contents

- [Overview](#overview)
- [Endpoints](#endpoints)
- [Usage](#usage)
- [Contributing](#contributing)


## Overview

The `BankTransactionController` provides endpoints to perform various operations related to bank transactions. These operations include creating, retrieving, verifying, and deleting bank transactions.

## Endpoints

### Create Bank Transaction

- **Endpoint**: `POST /transactions/create`
- **Description**: Create a new bank transaction.
- **Request Body**: JSON object with bank transaction details.
- **Response**: Returns a list of all bank transactions after creating the new one.

### Get All Bank Transactions

- **Endpoint**: `GET /transactions/get`
- **Description**: Retrieve a list of all bank transactions.
- **Response**: Returns a list of bank transactions.

### Verify Bank Transaction

- **Endpoint**: `POST /transactions/verify/{transactionReference}/{bankCode}`
- **Description**: Verify a bank transaction by its reference and bank code.
- **Path Variables**: `transactionReference` and `bankCode`.
- **Response**: Returns a response indicating the verification status.

### Get Bank Transaction by Id

- **Endpoint**: `GET /transactions/getById/{transactionReference}/{bankCode}`
- **Description**: Retrieve a specific bank transaction by its reference and bank code.
- **Path Variables**: `transactionReference` and `bankCode`.
- **Response**: Returns the details of the specified bank transaction.

### Delete Bank Transaction by Id

- **Endpoint**: `DELETE /transactions/deleteByid/{transactionReference}/{bankCode}`
- **Description**: Delete a bank transaction by its reference and bank code.
- **Path Variables**: `transactionReference` and `bankCode`.
- **Response**: Returns a response indicating the deletion status.

## Usage

To use the `BankTransactionController`, you can make HTTP requests to the provided endpoints. Ensure that you have the required input data and follow the API documentation for each endpoint.

## Contributing

Contributions to this project are welcome! If you would like to contribute, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature: `git checkout -b feature-name`
3. Make your changes and commit them: `git commit -m "Add feature"`
4. Push to the branch: `git push origin feature-name`
5. Submit a pull request.

