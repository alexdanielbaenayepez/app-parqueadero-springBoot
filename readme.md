# Backend Parqueadero

Esta aplicacion trata del backend del parqueadero, tiene funciones **CRUD**  como agregar, editar, eliminar, listar los objetos en base de datos.
Construida con Spring Boot. El backend es un microservicio.

Para la cuenta de cobro segun las horas, fue necesario usar la api
DataTime y operadores aritmeticos.
Al agregar un vehiculo y luego retirarlo se generan de 
forma automatica fechas de entrada y salida segun hora local
y al retirar el vehiculo se compute el valor a cobrar segun las
fechas generadas 