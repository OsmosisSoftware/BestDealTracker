package Application;

import Entities.AmazonItem;
import Repositories.AmazonItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan("Entities Repositoriesk")
@EnableAutoConfiguration
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}

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