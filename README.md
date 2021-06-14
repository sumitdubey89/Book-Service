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




configure swagger adding details as annotations to API
Docket object to remove extra information from Spring like error controller etc.
For adding metadata : we will add .apiInfo() before build of Docket object

@ApiOperation to provide specific infoamrtion for the mapping/method dioes on swagger
@ApiParam
@ApiModel for class description
@ApimodelProperty

springfox for mre annotations