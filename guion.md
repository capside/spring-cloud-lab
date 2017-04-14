title: Spring Cloud FTW
author:
  name: Javi Moreno
  twitter: ciberado
  url: www.javier-moreno.com
output: readme.html
theme: sjaakvandenberg/cleaver-dark



#Spring Cloud

--

##Motivaci�n

* En un mundo cloudificado no hay ninguna raz�n para pensar que tu proyecto no va a petarlo nunca. Be ready.
* Speed is not more important than scalability
* No es tanto montar peque�os programas como conseguir que hablen flu�damente entre ellos

--

##Un webservice cualquiera

* https://sketchboard.me/RzqMrLEaynHv#/
* Dependencias b�sicas: actuator, config client, eureka discovery, devtools, lombok, web
* Las /metrics, los /health y los /trace van a hacer feliz
* Los /env y los /beans te van a ayudar a depurar cuando est�s triste
  
--

##The fucking manual

* https://github.com/spring-cloud-samples
* http://martinfowler.com/bliki/

--

##Registro de servicios 

* Eureka ftw 
* Totalmente distribu�do y escrito en Go
* spring-cloud-starter-eureka-server + @EnableEurekaServer es todo lo necesario para implementar un servidor
* Eureka implementa cach� de descubrimiento tanto en cliente como en el servidor
* Un servicio se identifica mediante su spring.application.name (normalmente dclarado en bootstrap.yml)
* El servidor de Eureka contiene un dashboard: http://localhost:8761/
* Tambi�n es posible recuperar la informaci�n en raw: http://localhost:8761/eureka/apps
* eureka.client.serviceUrl.defaultZone indica la url del servidor
* Un cambio en el git actualiza eureka inmediateamente pero no el cliente
* @RefreshScope permite la actualizaci�n de un bean basado en su configuraci�n
* El refresco de la configuraci�n se basa en jms/rabbitmq 
* Puede usarse para constru�r urls de HATEOAS
* mvn spring-boot:run para ejecutarlo sin tener que exclu�r referencias a jersey (java -jar dar� error)
* A menos que se explicite en la configuraci�n si el 85% de los servicios dejan de responder al heartbeat Eureka considera que es un fallo de red y no los elimina

--

##Registro en Eureka

* server.port=0 para indicar que se desea un puerto arbitrario
* @EnableDiscoveryClient
* Ojo: por defecto ejecutar varios clientes en la misma máquina hará que solo se registre uno de ellos (ver Making the Eureka Instance ID Unique) 

--

##Composici�n de webservices: Eureka + Ribbon

* Supone el layer de valor agregado
* spring-cloud-starter-eureka + @EnableDiscoveryClient activa la integraci�n con Eureka 
* spring-cloud-starter-ribbon integra los servicios de loadbalancer en cliente
* Ribbon se integra automáticamente con RestTemplate para buscar instancias basadas en nombre de servicio 

--
  
##Configuraci�n dinámica y distribu�da: servidor

* RTFM: http://cloud.spring.io/spring-cloud-config/spring-cloud-config.html
* Un buen pom vale más que mil imágenes: http://pastebin.com/HdrwsLF6
* spring-cloud-config-server
* Crea un grupo de ymls/properties en un repositorio git para guardar la configuraci�n
* Crea un servidor con la anotaci�n @SpringBootApplication y @EnableConfigServer
* Fija el git desde el que cargar los ficheros con spring.cloud.config.server.git.uri
* Usa el endpoint /env para conocer su entorno 
* Utiliza el endpoint /health para saber si está bien
* Usa /trace para conocer los últimos accesos
* curl localhost:8888/promociones/default para recuperar la rama default de la aplicaci�n promociones 
* Puedes usar branches para varios escenarios (dev, stage, prod)
* Cambiar un valor en el git se refleja inmediatamente en /promociones/default 

--

##Configuraci�n dinámica y distribu�da: cliente

* spring-cloud-config-client
* spring.cloud.config.uri indica d�nde buscar la configuraci�n 
* @RefreshScope para indicar que debe recargarse ante un cambio de configuraci�n
* GET /env permite comprobar el valor de las variables en todo momento
* POST /refresh recrea los beans marcados con @RefreshScope
* POST /restart para reiniciar el contexto (desactivado por defecto)

--

##Zuul

* Enrutado para microservicios (load balancer, proxy inverso, whatever)
* Edge endpoint 
* Autentificaci�n, log, routing dinámico, etc
* Integrado con Eureka y Hystrix 
* @EnableZuulProxy (para enrutar) y @EnableZuulServer (para solo filtrar)
* Cuidado con subir ficheros grandes a trav�s de �l sin configurarlo correctamente

--

##Circuit breakers

* Hystrix ftw
* Si un servicio no está disponible salta a una implementaci�n alternativa
* Evita bloquear en cascada múltiples servicios 
* @EnableCircuitBreaker para activar en un punto de la cadena de servicios 
* @EnableHystrixDashBoard
* Permite reabrir parcialmente el servicio si detecta que se ha corregido
* Fail: problemas con el c�ndigo as�ncrono

--

##Edge services

* Zuul funciona como un punto de entrada en el sistema
* Permite centralizar la autorizaci�n
* Agrega webservices para reducir CORS
* �Es un proxy layer 7! Perfecto para apis bonitas

--

##M�s madera

* Ribbon
* OAuth2
* Connector para AWS

##Las rutas

* stock: http://localhost:55222/productos/1000/stock
* catalogo: http://localhost:8080/referencias/1000
* productos: http://localhost:55377/productos/1000
* zuul: http://localhost:8000/productos/1000

##Los artefactos

http://ciberado.blob.core.windows.net/artifacts/configserver-0.0.1-SNAPSHOT.jar
http://ciberado.blob.core.windows.net/artifacts/eurekaRegistry-0.0.1-SNAPSHOT.jar
http://ciberado.blob.core.windows.net/artifacts/catalogoservice-0.0.1-SNAPSHOT.jar
http://ciberado.blob.core.windows.net/artifacts/catalogoservice-0.0.1-SNAPSHOT.jar
http://ciberado.blob.core.windows.net/artifacts/productoservice-0.0.1-SNAPSHOT.jar
http://ciberado.blob.core.windows.net/artifacts/zuulserver-0.0.1-SNAPSHOT.jar
 






