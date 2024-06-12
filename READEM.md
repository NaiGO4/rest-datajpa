## Aplicación SpringBoot

Proyecto SpringBoot con dependencia y starters: 

* H2
* Spring Data JAP
* Spring Wed
* Spring Boot Dev tools
* OpenApi

Aplicacion API Rest con acceso a base de datos  H2 para persistir la informacion.

El acceso se puede realizar desde Postman o Navegador.

## Entidad Book

1. Book
2. BookRepository
3. BookController

# Documentación de API con OpenAPI en Spring Boot

Esta aplicación utiliza OpenAPI para documentar y visualizar la API RESTful. OpenAPI es una especificación para 
describir APIs que permite a los desarrolladores y consumidores de APIs entender y probar los servicios de manera 
eficiente.

# Configuración de OpenAPI
Hemos configurado OpenAPI utilizando la biblioteca springdoc-openapi, que facilita la integración de OpenAPI 3 
con aplicaciones Spring Boot.

# Pasos para Integrar OpenAPI en la Aplicación
1. Agregar Dependencias
   Primero, necesitamos agregar las dependencias necesarias en el archivo pom.xml.

```
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.6.9</version>
</dependency>
```


