#ReadMe Solución desafío uno

En la esta Solución se implementó el nivel 3 el cual es generar un servicio rest que invoca el servicio GDD y presenta un Json 
con las fechas restantes a la generacion realizada por el servicio GDD.

Este proyecto está generado con Spring Boot y Maven

#Instalación del proyecto (instalación por jar independiente e ejecución por Maven, ambas en puerto 8081)

Instalación por Jar independiente
- Se debe realizar el siguiente comando en la carpeta del proyecto:

        mvn install

- luego de ejecutado el comando se creará una carpeta llamada target el cual contendra un jar llamado "Desafio_Uno-0.0.1-SNAPSHOT.jar", 
con este jar se puede ejecutar el siguiente comando para ejecutarlo de manera independiente:

        java -jar target/Desafio_Uno-0.0.1-SNAPSHOT.jar

- Con esto se ejecuta la aplicacion 

Ejecución por Maven

- Para la ejecucion directa se debe ejecutar el siguiente comando:

        mvn spring-boot:run 

- Con esto la aplicación se ejecutara de manera automatica y lista para ser usada. 

La llamada del servicio se debe hacer a la siguiente URL:
    
       http://localhost:8081/obtenerPeriodos

Una vez se llame al servicio, este generará las fechas restantes de la generación realizada por GDD.
