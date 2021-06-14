package epam.demo.bookservice;

import java.util.Collections;
import com.sun.xml.bind.v2.schemagen.xmlschema.Documentation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class BookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

	//Docket object to remove extra information from Spring like error controller etc.
	@Bean
	public Docket swaggerConfiguration2(){
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("Phase2")
				.select()
				.paths(PathSelectors.any())
				//.paths(PathSelectors.ant("/bookService/*"))
				.apis(RequestHandlerSelectors.basePackage("epam.demo"))
				.build()
				.apiInfo(apiMoreinformation());
	}

	//For adding metadata : we will add .apiInfo() before build of Docket object
	private ApiInfo apiMoreinformation() {
		return new ApiInfo("Book Service API",
				"Sample API for EPAM Training ",
				"1.0",
				"Free to Use",
				new springfox.documentation.service.Contact
						("Sumit","https://gmail.com","xyz@gmail.com"),
		"Api License",
		"https://google.com", Collections.emptyList());

	}

}
