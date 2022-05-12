# Read Me First
This project was build using Maven and SpringBoot:

* [Maven]
* [Spring Boot]
* [IntelliJ]

This project can be run directly with IntelliJ or it can be run through cmd with 
```
> mvn spring-boot:run
```
# Getting Started

### Web Service

This project enables 2 endpoints that are available at:

```
> (1) POST http://localhost:8080/topsecret
```
 and 
```
> POST | GET http://localhost:8080/topsecret_split/{satelliteName}
```

### DTO used

These endpoints accept JSON formatted payload as follows

For endpoint (1):
```
{
    "satellites": [
        {
            "name": "kenobi",
            "distance": 100.0,
            "message": ["este", "", "", "mensaje", ""]
        },
         {
            "name": "skywalker",
            "distance": 115.5,
            "message": ["", "es", "", "", "secreto"]
        },
         {
            "name": "sato",
            "distance": 142.7,
            "message": ["este", "", "un", "", ""]
        }
    ]
}
```

For endpoint (2)
```
         {
            "distance": 142.7,
            "message": ["este", "", "un", "", ""]
        }
```