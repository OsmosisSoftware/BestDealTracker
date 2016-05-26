// tag::runner[]
package Application;

import Entities.AmazonItem;
import Repositories.AmazonItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * No sé por qué pero no sirve
 * Tutorial: https://spring.io/guides/tutorials/bookmarks/
 */

@Configuration
@ComponentScan("Entities")
@EnableAutoConfiguration
public class Application {

  @Bean
  CommandLineRunner init(
    AmazonItemRepository amazonItemRepository
  ) {
      return (evt) -> {
        Arrays.asList(
          "item1,ittem2,item3,item4,item5".split(",")
        ).forEach(
          a -> {
            AmazonItem item = new AmazonItem(22.5, a, "www"+a+".com", "ABDCE");
            amazonItemRepository.save(item);
          }
        );
      };
  }
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
// end::runer[]

@Component
class AmazonItemCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        for(AmazonItem a : this.amazonItemRepository.findAll()){
            System.out.println(a.toString());
        }

    }
    @Autowired AmazonItemRepository amazonItemRepository;
}