title: Spring Cloud FTW
author:
  name: Javi Moreno
  twitter: ciberado
  url: www.javier-moreno.com
output: readme.html
theme: sjaakvandenberg/cleaver-dark



#Spring Cloud



##Motivación

* En un mundo cloudificado no hay ninguna razón para pensar que tu proyecto no va a petarlo nunca. Be ready.
* Speed is not more important than scalability
* No es tanto montar pequeños programas como conseguir que hablen fluídamente entre ellos



##Un webservice cualquiera

* https://sketchboard.me/RzqMrLEaynHv#/
* Dependencias básicas: actuator, config client, eureka discovery, devtools, lombok, web
* Las /metrics, los /health y los /trace van a hacer feliz
* Los /env y los /beans te van a ayudar a depurar cuando estés triste
  


##The fucking manual

* https://github.com/spring-cloud-samples


##Registro de servicios 

* Eureka ftw 
* Totalmente distribuído y escrito en Go
* spring-cloud-starter-eureka-server + @EnableEurekaServer es todo lo necesario para implementar un servidor
* Eureka implementa caché de descubrimiento tanto en cliente como en el servidor
* Un servicio se identifica mediante su spring.application.name (normalmente dclarado en bootstrap.yml)
* El servidor de Eureka contiene un dashboard: http://localhost:8761/
* También es posible recuperar la información en raw: http://localhost:8761/eureka/apps
* eureka.client.serviceUrl.defaultZone indica la url del servidor
* Un cambio en el git actualiza eureka inmediateamente pero no el cliente
* @RefreshScope permite la actualización de un bean basado en su configuración
* El refresco de la configuración se basa en jms/rabbitmq 
* Puede usarse para construír urls de HATEOAS
* mvn spring-boot:run para ejecutarlo sin tener que excluír referencias a jersey (java -jar dará error)
* A menos que se explicite en la configuración si el 85% de los servicios dejan de responder al heartbeat Eureka considera que es un fallo de red y no los elimina



##Registro en Eureka

* server.port=0 para indicar que se desea un puerto arbitrario
* @EnableDiscoveryClient
* Ojo: por defecto ejecutar varios clientes en la misma mÃ¡quina harÃ¡ que solo se registre uno de ellos (ver Making the Eureka Instance ID Unique) 



##Composición de webservices: Eureka + Ribbon

* Supone el layer de valor agregado
* spring-cloud-starter-eureka + @EnableDiscoveryClient activa la integración con Eureka 
* spring-cloud-starter-ribbon integra los servicios de loadbalancer en cliente
* Ribbon se integra automÃ¡ticamente con RestTemplate para buscar instancias basadas en nombre de servicio 


  
##Configuración dinámica y distribuída: servidor

* RTFM: http://cloud.spring.io/spring-cloud-config/spring-cloud-config.html
* Un buen pom vale mÃ¡s que mil imÃ¡genes: http://pastebin.com/HdrwsLF6
* spring-cloud-config-server
* Crea un grupo de ymls/properties en un repositorio git para guardar la configuración
* Crea un servidor con la anotación @SpringBootApplication y @EnableConfigServer
* Fija el git desde el que cargar los ficheros con spring.cloud.config.server.git.uri
* Usa el endpoint /env para conocer su entorno 
* Utiliza el endpoint /health para saber si están bien
* Usa /trace para conocer los últimos accesos
* curl localhost:8888/promociones/default para recuperar la rama default de la aplicación promociones 
* Puedes usar branches para varios escenarios (dev, stage, prod)
* Cambiar un valor en el git se refleja inmediatamente en /promociones/default 



##Configuración dinÃ¡mica y distribuída: cliente

* spring-cloud-config-client
* spring.cloud.config.uri indica dónde buscar la configuración 
* @RefreshScope para indicar que debe recargarse ante un cambio de configuración
* GET /env permite comprobar el valor de las variables en todo momento
* POST /refresh recrea los beans marcados con @RefreshScope
* POST /restart para reiniciar el contexto (desactivado por defecto)



##Zuul

* Enrutado para microservicios (load balancer, proxy inverso, whatever)
* Edge endpoint 
* Autentificación, log, routing dinÃ¡mico, etc
* Integrado con Eureka y Hystrix 
* @EnableZuulProxy (para enrutar) y @EnableZuulServer (para solo filtrar)
* Cuidado con subir ficheros grandes a través de él sin configurarlo correctamente



##Circuit breakers

* Hystrix ftw
* Si un servicio no estÃ¡ disponible salta a una implementación alternativa
* Evita bloquear en cascada mÃºltiples servicios 
* @EnableCircuitBreaker para activar en un punto de la cadena de servicios 
* @EnableHystrixDashBoard
* Permite reabrir parcialmente el servicio si detecta que se ha corregido
* Fail: problemas con el cóndigo asíncrono



##Edge services

* Zuul funciona como un punto de entrada en el sistema
* Permite centralizar la autorización
* Agrega webservices para reducir CORS
* ¡Es un proxy layer 7! Perfecto para apis bonitas



##Las rutas

* eureka: http://localhost:8761
* stock: http://localhost:55222/productos/1000/stock
* catalogo: http://localhost:8080/referencias/1000
* productos: http://localhost:55377/productos/1000
* zuul: http://localhost:8000/productos/1000








