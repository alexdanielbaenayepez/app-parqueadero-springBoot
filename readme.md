la cuenta de cobro segun las horas esta lista, ahora falta que
al agregar un vehiculo se genere de forma automatica una
fecha y al retirar el vehiculo se genere de forma automatica 
una fecha de salida y se compute el valor a cobrar segun las
fechas generadas

https://spring.io/projects/spring-boot

return Period.between(fechaEntrada, LocalDate.now()).getHours() * 1750 
este es para dias o meses  diration es para horas



**- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -** 
1 consultar la base de datos para traer de buelta la fecha de entrada       |
                                                                            |              
2 generar la hora actual para hallar los dias y guardar esa hora actual     |
con un put en ese mismo registro en la base de datos                        |
                                                                            |
3 mostrar el calculo final en el get por id                                 |