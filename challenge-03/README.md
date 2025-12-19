# Challenge 03 - API de Biblioteca 📚

## 📋 Descripción

API y aplicación de consola desarrollada en Java con Spring Boot que permite gestionar una biblioteca digital. Permite buscar libros por título, listar libros y autores registrados, consultar autores vivos en un año específico y filtrar libros por idioma. Utiliza la API pública de Gutendex para obtener información de libros.

## ✨ Características

- 🔍 Buscar y agregar libros por título desde Gutendex
- 📚 Listar libros registrados en la base de datos
- 👨‍💼 Listar autores registrados
- 📅 Consultar autores vivos en un año específico
- 🌐 Filtrar libros por idioma
- 🗄️ Persistencia en base de datos PostgreSQL

## 🛠️ Tecnologías

- **Java 25**
- **Spring Boot 4**
- **Maven**
- **Spring Data JPA**
- **PostgreSQL**
- **Jackson** (JSON)

## 📦 Dependencias

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.20.1</version>
</dependency>
```

## 📁 Estructura del Proyecto

```
challenge-03/
├── src/
│   └── main/
│       ├── java/com/library/library_api/
│       │   ├── LibraryApiApplication.java
│       │   ├── main/Main.java
│       │   ├── models/AuthorEntity.java, BookEntity.java
│       │   ├── records/ApiResponse.java, Author.java, Book.java
│       │   ├── repositories/AuthorRepository.java, BookRepository.java
│       │   └── services/ApiRequest.java, BookService.java, Mapper.java
│       └── resources/application.properties
├── pom.xml
```

## ⚙️ Configuración

La conexión a la base de datos se configura en `src/main/resources/application.properties`:

```
spring.datasource.url=jdbc:postgresql://<host>/<database>
spring.datasource.username=<usuario>
spring.datasource.password=<contraseña>
```

## 🚀 Ejecución

1. Clona el repositorio y accede a la carpeta `challenge-03`.
2. Instala dependencias y compila el proyecto:
   ```
   ./mvnw clean install
   ```
3. Ejecuta la aplicación:
   ```
   ./mvnw spring-boot:run
   ```
4. Sigue las instrucciones en consola para interactuar con la biblioteca.

## 🖥️ Opciones de la Consola

- **1. Buscar y agregar libro por título**
- **2. Listar libros registrados**
- **3. Listar autores registrados**
- **4. Listar autores vivos en determinado año**
- **5. Buscar libros por idioma**
- **0. Salir**

## 🌐 API Externa

- [Gutendex Books API](https://gutendex.com/books)

## 📝 Notas

- El proyecto utiliza persistencia en PostgreSQL, asegúrate de tener la base de datos configurada.
- Puedes modificar la configuración de la base de datos en `application.properties`.

---

Proyecto realizado para el programa **ONE G9** (Oracle Next Education).
