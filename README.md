# JiluDB

JiluDB is a lightweight document-oriented NoSQL database built from scratch in Java.

The project was created to understand how database systems work internally, including data storage, CRUD operations, querying, serialization, parsing, and file-based persistence.

## Features

- Document-oriented data model
- Database → Collection → Document architecture
- CRUD operations
- Insert, Find, Update, and Delete APIs
- HashMap-based in-memory storage
- File-based persistence
- Custom serialization
- Custom parser for loading stored data
- Separate API layer

## Architecture

JiluDB follows a simple three-level document-oriented structure:

Database
└── Collection
    └── Document
        └── HashMap<String, Object>

### Database

Stores multiple collections using:

HashMap<String, Collection>

### Collection

Stores multiple documents using:

HashMap<String, Document>

### Document

Stores fields and values using:

HashMap<String, Object>

Example:

users
├── user1
│   ├── name: Jayesh
│   ├── age: 23
│   └── active: true
│
└── user2
    ├── name: Dharmendra
    └── age: 24

## CRUD API

JiluDB provides a separate API class for database operations.

### Insert

api.insert("users", "user1", "name", "Jayesh");
api.insert("users", "user1", "age", 21);

If the collection or document does not exist, it is created automatically.

### Find

api.find("users", "name", "Jayesh");

Returns matching documents based on the provided key and value.

Example result:

{user1={name=Jayesh, age=21}}

### Update

api.update("users", "name", "Jayesh", "age", 23);

This finds documents where name is "Jayesh" and updates their age to 23.

### Delete

api.delete("users", "name", "Jayesh");

This deletes documents where name is "Jayesh".

## Persistence

JiluDB supports file-based persistence using:

DataBase/database.txt

### Save

database.save();

The save operation writes the current in-memory database to the database file.

### Load

database.load();

The load operation reads the stored data from the database file and reconstructs the database in memory.

Persistence flow:

Memory → save() → database.txt
database.txt → load() → Memory

This allows data to persist after the application is closed and started again.

## Example

public class Main {
    public static void main(String[] args) throws Exception {

        Database database = new Database();
        API api = new API(database);

        // Insert
        api.insert("users", "user1", "name", "Jayesh");
        api.insert("users", "user1", "age", 21);

        api.insert("users", "user2", "name", "Dharmendra");
        api.insert("users", "user2", "age", 24);

        // Update
        api.update("users", "name", "Jayesh", "age", 23);

        // Find
        System.out.println(
            api.find("users", "name", "Jayesh")
        );

        // Delete
        api.delete("users", "name", "Jayesh");

        // Save
        database.save();
    }
}

## Project Structure

JiluDB/
├── src/
│   ├── Main.java
│   ├── API.java
│   ├── Database.java
│   ├── Collection.java
│   └── Document.java
│   
├── DataBase/
│   └── database.txt
│
├── .gitignore
└── README.md

### File Responsibilities

Main.java
Application entry point and testing.

API.java
Provides CRUD operations.

Database.java
Manages database storage and persistence.

Collection.java
Manages documents inside a collection.

Document.java
Manages fields and values inside a document.

## How It Works

A typical database operation flows through the following layers:

API
 ↓
Database
 ↓
Collection
 ↓
Document
 ↓
HashMap<String, Object>

For example:

api.insert("users", "user1", "age", 21);

The data is stored internally as:

users
 ↓
Collection
 ↓
user1
 ↓
Document
 ↓
"age" → 21

## Technologies

- Java
- Java Collections Framework
- Java NIO
- File I/O
- Object-Oriented Programming

## Concepts Explored

- HashMap-based data storage
- Object-oriented design
- CRUD operations
- Document-oriented data modeling
- Querying
- Serialization
- Parsing
- File-based persistence
- API design
- Separation of responsibilities
- Java Collections
- Java File I/O

## Project Goals

The goal of JiluDB is to understand the fundamental concepts behind database systems by building a small database engine from scratch rather than relying on an existing database library.

The project focuses on understanding how storage, CRUD operations, querying, parsing, serialization, and persistence work internally.

## Current Status

JiluDB currently supports:

- Create / Insert
- Read / Find
- Update
- Delete
- File-based Save
- File-based Load
- Basic key-value querying
- Custom serialization
- Custom parsing
- Separate API layer

JiluDB is a lightweight, learning-focused NoSQL database implementation built from scratch in Java.

## Author

Jayesh Choudhary

Built with Java to explore how database systems work internally.