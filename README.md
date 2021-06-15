# Book-Service

for config server
spring.cloud.config.uri=http://localhost:8888



Swagger

Swagger2 spring  dependency-springfox-swagger2

enable swagger in code - @EnableSwagger2
after restart
http://localhost:8080/v2/api-docs

for HTML documentation Springfox-swagger ui for version 3.0.0
http://localhost:8080/swagger-ui/index.html
for 2.9.2
http://localhost:8080/swagger-ui.html

.paths(PathSelectors.any())
during
return new Docket(DocumentationType.SWAGGER_2)
.groupName("Phase2")
.select()
.paths(PathSelectors.any())
//.paths(PathSelectors.ant("/bookService/*"))
.apis(RequestHandlerSelectors.basePackage("epam.demo"))
.build()
.apiInfo(apiMoreinformation());

so that all paths for controller are shown otherwise only one level of methods
are displayed


configure swagger adding details as annotations to API
Docket object to remove extra information from Spring like error controller etc.
For adding metadata : we will add .apiInfo() before build of Docket object

@ApiOperation to provide specific infoamrtion for the mapping/method dioes on swagger
@ApiParam
@ApiModel for class description
@ApimodelProperty

springfox for more annotations

things did not work with second line in property file
so it was removed and .import was used
spring.config.import=optional:configserver:http://localhost:8888
#spring.cloud.config.uri=http://localhost:8888

application-<profile>.yml or properties

change profile by adding in application.properties
spring.profiles.active=test

then application-test.yml or properties will be used

with any Bean we can use
@Profile("production") or @Profile("dev") to use values for properties from that application-profile.properties 

to fetch the refreshed values from config server:-
1.pom.xml must have spring-boot-starter-actuator dependency
2.mark beans as @RefeshScope 

writing @EnableEurekaClient along with @springBootApplication is not required.
Just add the below dependency and you are good to go
<dependency>
<groupId>org.springframework.cloud</groupId>
<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>