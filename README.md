# 🛒 MonsterShop Backend

Backend developed in **Java Spring Boot** for managing products and reviews.

## 📁 Repository structure

```
src/main/java/com/api/monster_shop/
├── controllers/
│   ├── ProductController.java
│   └── ReviewController.java
├── dtos/
│   ├── product/
│   │   ├── ProductMapper.java
│   │   ├── ProductRequest.java
│   │   └── ProductResponse.java
│   └── review/
│       ├── ReviewMapper.java
│       ├── ReviewRequest.java
│       └── ReviewResponse.java
├── models/
│   ├── Product.java
│   └── Review.java
├── repositories/
│   ├── ProductRepository.java
│   └── ReviewRepository.java
├── services/
│   ├── ProductService.java
│   └── ReviewService.java
└── MonsterShopApplication.java
```
This view focuses on the main application package. Other project files like `pom.xml`, `mvnw`, and configuration files in `src/main/resources` are located at the project root or standard Maven locations.



## ⚙️ Prerequisites

- Java 21
- Maven 3.5.0
- Recommended IDE: IntelliJ IDEA

## 🚀 Quick guide to run the backend

1. **Clone the repository**  
   🧬
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd monster_shop
   ```
Configure the database 🗄️ Edit the file src/main/resources/application.properties with your database information (H2, MySQL, etc).

2. **Build the projec**
🛠️


mvn clean install
3. **Run the application**
🚦


mvn spring-boot:run or from your IDE by running MonsterShopApplication.java.

4. **Access the API**
🌐
   By default it will be available at: http://localhost:8080/api


## 📬 Main endpoints
1. /api/products
2. /api/reviews

## 📝 Notes

You can test the endpoints using Postman or any REST client. Check the console logs for error messages or additional information.

## ✍️ Author
- [Ana Carina](https://github.com/acpp2510)
<hr></hr>Done! Your backend should be up and running 🚀