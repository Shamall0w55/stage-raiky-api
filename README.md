# Blog API – Spring Boot (DDD & Hexagonal Architecture)

## 📘 Project Description

**Blog API** is a RESTful API built with **Spring Boot** for managing blog posts and their **comments**. The project demonstrates the use of **Domain-Driven Design (DDD)** and **Hexagonal Architecture** to create a maintainable and well-structured backend.

Designed for **educational purposes**, this project is suitable for demonstrations and academic presentations (Stage L3).

---

## 🛠️ Technologies

* **Java 17**
* **Spring Boot**
* **Spring Data JPA**
* **PostgreSQL**
* **Maven**
* **Postman** (API testing)
* **Git & GitHub**

---

## 📂 Project Structure

The project follows a clear separation of concerns inspired by DDD:

```
blog/
├── domain
│   ├── entities
│   │   ├── valueobjects
│   │   └── aggregates
│   ├── repositories
│   └── services
│
├── application
│   └── usecases
│
└── infrastructure
    ├── persistence (JPA)
    └── controllers (REST)
```

* **Domain**: Contains business logic and rules
* **Application**: Manages use cases and orchestrates domain operations
* **Infrastructure**: Handles database access and REST API exposure

---

## ⚙️ Installation

### Prerequisites

* Java 17 or higher
* Maven
* PostgreSQL

### Steps

1. Clone the repository:

```bash
git clone git@github.com:Shamall0w55/stage-raiky-api.git
```

2. Configure the PostgreSQL database in `application.yml` or `application.properties`.

3. Run the application:

```bash
mvn spring-boot:run
```

Access the API at:

```
http://localhost:8080
```

---

## 🚀 Usage

### Main Endpoints

| Method | Endpoint      | Description             |
| ------ | ------------- | ----------------------- |
| GET    | `/posts`      | Retrieve all posts      |
| GET    | `/posts/{id}` | Retrieve a post by ID   |
| POST   | `/posts`      | Create a new post       |
| PUT    | `/posts/{id}` | Update an existing post |
| DELETE | `/posts/{id}` | Delete a post           |

* All IDs are **UUIDs**
* Requests and responses use **JSON** format

Example (POST):

```json
{
  "postTitle": "My first post",
  "postContent": "This is a sample post content."
}
```

---

## 📏 Business Rules

* `postTitle` must not be empty and cannot exceed **100 characters**
* `postContent` must not be empty and cannot exceed **500 characters**
* `commentText` must not be empty and cannot exceed **500 characters**
* A post can have a maximum of **100 comments**

All rules are enforced at the **domain level**.

---

## 🧪 Testing

* API endpoints are tested using **Postman**
* Requests are saved and organized into collections
* IDs are managed with **Postman environment variables**
* Clean test data is preloaded for demonstrations

---

## 🤝 Contributing

This project is primarily for **educational purposes**. Contributions, suggestions, and improvements are welcome via issues or pull requests.

---

## 👤 Author

**Ryan Andriamanga**
Software Engineering & Database Student (L3)

---

## 📄 License

This project is released for **educational use only**.
