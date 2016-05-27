package controller;

import entities.AmazonItem;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repositories.AmazonItemRepository;

import java.util.List;


@RestController
@ComponentScan(basePackages = {"controller","repositories","entities"})
@EnableMongoRepositories(basePackages = {"repositories"})
public class AmazonItemRestController {

    @Autowired
    private AmazonItemRepository repository;

    @RequestMapping("/amazonitems")
    public List<AmazonItem> getAmazonItems(){
        this.repository.deleteAll();
        this.repository.save(new AmazonItem(220.5, "Mochila", "http://www.amazon.com/algo", "ABCSDEQW"));
        this.repository.save(new AmazonItem(20.5, "chila", "http://www.amazon.com/algo2", "abc123abc4"));
        return this.repository.findAll();
    }

}
