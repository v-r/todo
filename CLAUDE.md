# CLAUDE.md - AI Assistant Guide for Todo Application

## Project Overview

This is a **Java Spring MVC Todo Application** - a web-based task management system built with Spring Framework 3.2, JPA/Hibernate persistence, and JSP views. The application follows a classic layered architecture pattern.

## Tech Stack

| Layer | Technology |
|-------|------------|
| Build | Maven 3.x |
| Framework | Spring MVC 3.2.0 |
| Security | Spring Security 3.2.0.RC1 |
| Persistence | JPA 2.0 / Hibernate 4.1.9 |
| Database | MySQL 5.x |
| Validation | Hibernate Validator 4.2 |
| View | JSP with JSTL 1.2 |
| Frontend | Bootstrap CSS, jQuery 1.8.3 |
| Server | Servlet 2.5 (WAR deployment) |

## Project Structure

```
todo/
├── pom.xml                          # Maven configuration
├── src/main/
│   ├── java/com/lorem/Todo/
│   │   ├── controller/              # Spring MVC Controllers
│   │   │   └── HelloController.java # Main controller with item CRUD
│   │   ├── model/                   # JPA Entity classes
│   │   │   ├── Item.java           # Todo item entity (@Entity)
│   │   │   └── User.java           # User model (validation only)
│   │   ├── service/                 # Business logic layer
│   │   │   ├── ItemService.java    # Service interface
│   │   │   └── ItemServiceImpl.java # Service implementation
│   │   └── repository/              # Data access layer
│   │       ├── ItemRepository.java  # Repository interface
│   │       ├── ItemRepositoryImpl.java  # JPA implementation
│   │       └── StaticItemRepository.java # In-memory implementation
│   ├── resources/
│   │   ├── jpaContext.xml          # JPA/Hibernate configuration
│   │   └── META-INF/persistence.xml # JPA persistence unit
│   └── webapp/
│       ├── index.jsp               # Application entry point
│       ├── jquery-1.8.3.js         # jQuery library
│       ├── assets/
│       │   ├── css/                # Bootstrap CSS files
│       │   └── js/                 # Bootstrap JS files
│       └── WEB-INF/
│           ├── web.xml             # Servlet configuration
│           ├── config/
│           │   └── servlet-config.xml  # Spring MVC config
│           └── views/              # JSP templates
│               ├── hello.jsp
│               ├── login.jsp
│               └── items/
│                   ├── items.jsp   # Item list view
│                   └── item_form.jsp # Item form view
└── target/                          # Build output directory
```

## Architecture

### Layered Pattern

```
[HTTP Request] → Controller → Service → Repository → Database
                    ↓             ↓           ↓
                 @Controller  @Service   @Repository
                    ↓             ↓           ↓
              View (JSP)    Business    EntityManager
                            Logic       (JPA)
```

### Key Components

1. **Controllers** (`@Controller`)
   - Handle HTTP requests via `@RequestMapping`
   - URL pattern: `*.do` (e.g., `/items.do`, `/hello.do`)
   - Use `@Autowired` for dependency injection

2. **Services** (`@Service`)
   - Contain business logic
   - Handle transactions via `@Transactional`
   - Named beans (e.g., `@Service("itemService")`)

3. **Repositories** (`@Repository`)
   - Data access via JPA EntityManager (`@PersistenceContext`)
   - Two implementations: JPA-based and static/in-memory

4. **Models** (`@Entity`)
   - JPA entities with validation annotations
   - Use `@Id`, `@GeneratedValue` for primary keys

## Development Commands

### Build

```bash
# Compile and package
mvn clean package

# Skip tests during build
mvn clean package -DskipTests

# Run only tests
mvn test
```

### Dependencies

```bash
# Download dependencies
mvn dependency:resolve

# Update dependencies
mvn versions:display-dependency-updates
```

## Configuration Files

| File | Purpose |
|------|---------|
| `pom.xml` | Maven dependencies and build config |
| `web.xml` | Servlet container configuration |
| `servlet-config.xml` | Spring MVC beans and view resolver |
| `jpaContext.xml` | JPA/Hibernate and datasource config |
| `persistence.xml` | JPA persistence unit definition |

## Database Configuration

Currently configured for MySQL in `jpaContext.xml`:
- Database: `todo`
- Host: `localhost:3306`
- Dialect: `MySQL5InnoDBDialect`
- DDL Mode: `none` (manual schema management)

## URL Routing

All requests use the `.do` suffix pattern:

| URL | Method | Description |
|-----|--------|-------------|
| `/hello.do` | GET | Hello page with static items |
| `/hello/{id}.do` | GET | Hello with user ID (session handling) |
| `/items.do` | GET | List all todo items |
| `/items.do` | POST | Create new item |

## Code Conventions

### Naming

- **Packages**: lowercase with dots (`com.lorem.Todo.controller`)
- **Classes**: PascalCase (`ItemService`, `HelloController`)
- **Interfaces**: No prefix, implementations use `Impl` suffix
- **Beans**: camelCase names (`@Service("itemService")`)

### Annotations

- Use `@Autowired` for dependency injection
- Use `@Valid` with `BindingResult` for form validation
- Use `@Transactional` on service methods that modify data
- Use `@SessionAttributes` for session-scoped data

### Views

- JSPs located in `/WEB-INF/views/`
- Use JSTL `<c:forEach>` for iterations
- Use Spring `<spring:message>` for i18n
- Include Bootstrap CSS for styling

## Important Notes for AI Assistants

### When Adding New Features

1. **New Endpoints**: Add methods to existing controller or create new `@Controller` class
2. **New Entities**: Create in `model/` package with `@Entity` annotation
3. **New Services**: Create interface + implementation with `@Service`
4. **New Views**: Add JSP files in `WEB-INF/views/`

### Common Patterns

```java
// Controller method pattern
@RequestMapping(value="/path", method=RequestMethod.GET)
public String methodName(Model model) {
    model.addAttribute("key", value);
    return "viewName"; // maps to /WEB-INF/views/viewName.jsp
}

// Service method with transaction
@Transactional
public Entity save(Entity entity) {
    return repository.save(entity);
}
```

### Known Incomplete Implementations

- `ItemRepositoryImpl.findAll()` returns `null` - needs JPQL query implementation
- `ItemRepositoryImpl.findByPriority()` returns `null` - needs implementation
- User authentication is partially set up but not fully implemented
- Spring Security dependencies exist but are not configured

### Validation

- Item: `description` must be at least 3 characters (`@Size(min=3)`)
- Item: `priority` must not be null (`@NotNull`)
- Form validation uses `@Valid` + `BindingResult`

## Testing

Currently using JUnit 3.8.1. Test files should be placed in `src/test/java/`.

```bash
# Run tests
mvn test
```

## Deployment

The application builds as a WAR file (`Todo.war`) for deployment to a servlet container (Tomcat, Jetty, etc.):

```bash
mvn clean package
# Output: target/Todo.war
```
