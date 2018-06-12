package fworks.algorithms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger Configuration class.
 * 
 * @author flaviolcastro
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  private static final String ADMIN = "Admin";
  private static final String APP_PACKAGE = "fworks";

  /**
   * Enable the Swagger-UI.
   *
   * @return a Swagger docket
   */
  @Bean
  public Docket applicationApi() {
    return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors.basePackage(APP_PACKAGE)).paths(PathSelectors.any()).build()
        .apiInfo(apiInfo("")).pathMapping("/").groupName(APP_PACKAGE);
  }

  @Value("${management.context-path:admin}")
  String adminPath;
  @Value("${app.version:SNAPSHOT}")
  String version;

  /**
   * Swagger admin.
   * 
   * @return a Swagger docket
   */
  @Bean
  public Docket adminApi() {
    return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.ant(adminPath + "/*")).build()
        .apiInfo(apiInfo(String.format(" -%s", ADMIN))).pathMapping("/")
        .groupName(APP_PACKAGE + " " + ADMIN);
  }

  /**
   * Define the API info for the Swagger API.
   *
   * @return a new ApiInfo
   */
  private ApiInfo apiInfo(String description) {
    return new ApiInfoBuilder()
        .title("Fworks Algorithm App").description(String
            .format("A spring boot app for the old algorithm and data structure. %s", description))
        .license("private and proprietary").version(version).build();
  }
}
