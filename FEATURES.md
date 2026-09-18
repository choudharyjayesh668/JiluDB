# JiluDB — Features & Development Roadmap

> A lightweight document-oriented database built from scratch in Java.

---

## 1. Database Architecture

### Goal
Build the fundamental Database → Collection → Document hierarchy.

### Features
- [ ] Database manages multiple collections
- [ ] Collection manages multiple documents
- [ ] Document manages key-value fields
- [ ] Use HashMap for in-memory storage
- [ ] Define clear responsibility for each class

### Structure
Database
└── Collection
    └── Document
        └── Key → Value

### Acceptance Criteria
- [ ] Multiple collections can exist
- [ ] Multiple documents can exist inside each collection
- [ ] Multiple fields can exist inside each document


---

## 2. Document System

### Goal
Create the basic document data structure.

### Features
- [ ] Create Document
- [ ] Add field
- [ ] Get field
- [ ] Store different value types
- [ ] Retrieve complete document data
- [ ] Handle null values

### Supported Values
- [ ] String
- [ ] Integer
- [ ] Long
- [ ] Double
- [ ] Boolean
- [ ] null

### Acceptance Criteria
- [ ] A document can contain multiple fields
- [ ] Different field types can coexist


---

## 3. Collection System

### Goal
Manage documents inside collections.

### Features
- [ ] Create Collection
- [ ] Add document
- [ ] Get document
- [ ] Get all documents
- [ ] Document IDs
- [ ] Multiple documents per collection

### Acceptance Criteria
- [ ] Documents can be inserted
- [ ] Documents can be retrieved by ID
- [ ] Collection can expose its documents when required


---

## 4. Database System

### Goal
Manage collections inside the database.

### Features
- [ ] Create database
- [ ] Add collection
- [ ] Get collection
- [ ] Get all collections
- [ ] Multiple collections

### Acceptance Criteria
- [ ] Collections can be added
- [ ] Collections can be retrieved
- [ ] Multiple collections can coexist


---

## 5. File Creation & Storage

### Goal
Create the physical storage used by JiluDB.

### Features
- [ ] Define database storage location
- [ ] Automatically create storage file
- [ ] Detect existing database file
- [ ] Handle missing directories/files
- [ ] Define storage format

### Storage
DataBase/database.txt

### Acceptance Criteria
- [ ] First run creates required storage
- [ ] Existing database is detected
- [ ] JiluDB does not overwrite existing data accidentally


---

## 6. Database Serialization / Save

### Goal
Convert the in-memory database into persistent data.

### Features
- [ ] Serialize Database
- [ ] Serialize Collections
- [ ] Serialize Documents
- [ ] Serialize fields
- [ ] Serialize different value types
- [ ] Handle null
- [ ] Escape special characters
- [ ] Handle quotes inside strings
- [ ] Prevent invalid commas
- [ ] Write serialized data to disk

### Acceptance Criteria
- [ ] Saved file represents complete database state
- [ ] Strings remain valid
- [ ] Numbers remain numbers
- [ ] Boolean values remain booleans
- [ ] null remains null


---

## 7. Database Loading

### Goal
Reconstruct the complete database from the storage file.

### Features
- [ ] Read database file
- [ ] Parse stored data
- [ ] Detect collections
- [ ] Detect documents
- [ ] Detect fields
- [ ] Detect value types
- [ ] Handle strings
- [ ] Handle escaped characters
- [ ] Handle null
- [ ] Reconstruct Java objects
- [ ] Rebuild HashMaps

### Acceptance Criteria
- [ ] Save database
- [ ] Close program
- [ ] Start program again
- [ ] Load database
- [ ] Previous data is available

### Important Test

Create:

User → 1 → name = Jayesh

Restart JiluDB.

Expected:

User → 1 → name = Jayesh


---

## 8. CRUD Operations

### Goal
Provide complete database operations.

### Database Level
- [ ] Create collection
- [ ] Read collection
- [ ] Update collection
- [ ] Delete collection

### Collection Level
- [ ] Insert document
- [ ] Read document
- [ ] Update document
- [ ] Delete document

### Document Level
- [ ] Add field
- [ ] Read field
- [ ] Update field
- [ ] Delete field


---

## 9. Automatic Document IDs

### Goal
Generate document IDs automatically when required.

### Features
- [ ] Define ID format
- [ ] Generate unique IDs
- [ ] Prevent collisions
- [ ] Retrieve document using generated ID
- [ ] Decide whether manual IDs are also supported

### Acceptance Criteria
- [ ] Two inserted documents never receive the same ID


---

## 10. Query System

### Goal
Allow users to search documents based on their data.

### Basic Queries
- [ ] Field equals value
- [ ] Field not equal to value
- [ ] Field exists
- [ ] Field does not exist

### Future Queries
- [ ] Greater than
- [ ] Less than
- [ ] Greater than or equal
- [ ] Less than or equal

### Example

Find users where:

age = 21

Expected:

Matching documents are returned.


---

## 11. Filtering

### Goal
Filter documents using conditions.

### Features
- [ ] Filter by String
- [ ] Filter by Integer
- [ ] Filter by Double
- [ ] Filter by Boolean
- [ ] Compare values
- [ ] Return matching documents
- [ ] Handle missing fields

### Future
- [ ] AND conditions
- [ ] OR conditions
- [ ] Multiple conditions
- [ ] Nested conditions


---

## 12. Update Operations

### Goal
Modify existing database data.

### Features
- [ ] Update document field
- [ ] Add new field during update
- [ ] Replace existing value
- [ ] Update multiple fields
- [ ] Persist updated data

### Acceptance Criteria
After updating:

Old value → New value

and the new value survives restart.


---

## 13. Delete Operations

### Goal
Remove database data safely.

### Features
- [ ] Delete field
- [ ] Delete document
- [ ] Delete collection
- [ ] Handle non-existing data
- [ ] Persist deletion

### Acceptance Criteria
Deleted data must not return after reload.


---

## 14. Data Type System

### Goal
Correctly preserve data types between memory and disk.

### Types
- [ ] String
- [ ] Integer
- [ ] Long
- [ ] Double
- [ ] Boolean
- [ ] null

### Important

Differentiate:

"100"

from:

100

The first is a String.

The second is a number.


---

## 15. Parser / Serialization Engine

### Goal
Build a reliable system for converting JiluDB data between Java objects and stored representation.

### Serializer
- [ ] Java object → stored format
- [ ] Escape special characters
- [ ] Handle nested structures

### Parser
- [ ] Stored format → Java objects
- [ ] Handle strings
- [ ] Handle escaped quotes
- [ ] Handle escaped backslashes
- [ ] Handle numbers
- [ ] Handle booleans
- [ ] Handle null
- [ ] Handle nested objects

### Acceptance Criteria
Everything produced by the serializer can be successfully parsed back.


---

## 16. Error Handling

### Goal
Make JiluDB fail safely and clearly.

### Errors
- [ ] Collection does not exist
- [ ] Document does not exist
- [ ] Field does not exist
- [ ] Duplicate ID
- [ ] Invalid data
- [ ] Invalid query
- [ ] Invalid storage file
- [ ] File access failure

### Features
- [ ] Meaningful error messages
- [ ] Custom exceptions where appropriate
- [ ] Avoid unexpected crashes


---

## 17. Database Initialization & Reload

### Goal
Make JiluDB automatically restore its previous state.

### Startup Flow

Program starts
↓
Database initialized
↓
Storage checked
↓
Existing data detected
↓
Load database
↓
Database ready

### Features
- [ ] Automatic load
- [ ] Empty database handling
- [ ] Existing database handling
- [ ] Corrupted database handling


---

## 18. Testing

### Goal
Verify that JiluDB works correctly.

### Basic Tests
- [ ] Create database
- [ ] Create collection
- [ ] Create document
- [ ] Insert document
- [ ] Read document
- [ ] Update document
- [ ] Delete document
- [ ] Save database
- [ ] Load database

### Edge Cases
- [ ] Empty database
- [ ] Empty collection
- [ ] Empty document
- [ ] null values
- [ ] Empty strings
- [ ] Quotes in strings
- [ ] Special characters
- [ ] Duplicate IDs
- [ ] Missing documents
- [ ] Missing fields
- [ ] Large number of documents

### Persistence Test
- [ ] Create data
- [ ] Save
- [ ] Restart
- [ ] Load
- [ ] Verify data


---

## 19. Project Structure & Architecture

### Goal
Keep JiluDB maintainable as the project grows.

### Current

src/
├── Main.java
├── Database.java
├── Collection.java
└── Document.java

### Future

src/
├── Main.java
├── database/
├── parser/
├── query/
├── exceptions/
└── storage/

### Features
- [ ] Separate responsibilities
- [ ] Avoid unnecessary complexity
- [ ] Keep classes focused
- [ ] Refactor when required
- [ ] Document design decisions


---

## 20. JiluDB API

### Goal
Create a clean interface for developers using JiluDB.

### Features
- [ ] Initialize database
- [ ] Create collection
- [ ] Insert document
- [ ] Get document
- [ ] Update document
- [ ] Delete document
- [ ] Query documents
- [ ] Save database
- [ ] Load database

### Design Goals
- [ ] Simple API
- [ ] Predictable behavior
- [ ] Meaningful method names
- [ ] Clear return values
- [ ] Good error handling


---

## 21. Performance & Optimization

### Goal
Understand and improve JiluDB performance.

### Areas
- [ ] Measure insertion performance
- [ ] Measure lookup performance
- [ ] Measure query performance
- [ ] Measure save performance
- [ ] Measure load performance
- [ ] Analyze memory usage

### Future
- [ ] Indexes
- [ ] Faster queries
- [ ] Efficient serialization
- [ ] Reduce unnecessary disk writes
- [ ] Large dataset testing


---

## 22. Concurrency & Thread Safety

### Goal
Make JiluDB safe when multiple operations happen concurrently.

### Areas
- [ ] Understand race conditions
- [ ] Protect shared data
- [ ] Thread-safe collection operations
- [ ] Thread-safe database operations
- [ ] File write protection
- [ ] File locking
- [ ] Concurrent reads
- [ ] Concurrent writes

### Future
- [ ] Multi-threaded tests
- [ ] Read/write synchronization
- [ ] Concurrent data access


---

# 🚀 Recommended Implementation Order

## Phase 1 — Foundation
- [x] Database Architecture
- [x] Document System
- [x] Collection System
- [x] Database System
- [x] File Creation

## Phase 2 — Persistence
- [x] Serialization / Save
- [ ] Loading
- [ ] Automatic Reload

## Phase 3 — Database Operations
- [ ] CRUD
- [ ] Automatic IDs
- [ ] Update
- [ ] Delete

## Phase 4 — Query Engine
- [ ] Query System
- [ ] Filtering
- [ ] Comparisons
- [ ] Multiple Conditions

## Phase 5 — Reliability
- [ ] Data Type System
- [ ] Parser improvements
- [ ] Error Handling
- [ ] Testing

## Phase 6 — Architecture
- [ ] Refactoring
- [ ] API design
- [ ] Documentation

## Phase 7 — Advanced Database Concepts
- [ ] Performance
- [ ] Indexing
- [ ] Concurrency
- [ ] Thread Safety

---

# 🏁 Final Goal

JiluDB should eventually be able to:

1. Create a database
2. Create collections
3. Insert documents
4. Generate document IDs
5. Store different data types
6. Save data to disk
7. Load data from disk
8. Read documents
9. Update documents
10. Delete documents
11. Query documents
12. Filter results
13. Handle errors
14. Survive application restarts
15. Handle larger datasets
16. Provide a clean Java API
17. Support tests
18. Eventually support indexing
19. Eventually support concurrent operations

---

# Development Rule

JiluDB is being built from scratch to understand how databases work internally.

Before implementing a feature:

1. Understand the problem.
2. Design the logic yourself.
3. Try the implementation.
4. Test it.
5. Read Java documentation when needed.
6. Use external documentation/research when stuck.
7. Refactor after understanding why the code works.

Do not implement advanced features before understanding the previous layer.

---

# Current Status

**Project:** JiluDB

**Language:** Java

**Architecture:** Document-oriented database

**Storage:** Local file

**In-memory structure:** HashMap

**Current milestone:** Persistence / Loading

**Next major milestone:** Save → Restart → Load → Recover exact database state