package controller;

import entities.AmazonItem;
import entities.PcComponentesItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import repositories.PcComponentesItemRepository;

import java.util.Collection;

@RestController
@ComponentScan(basePackages = {"controller","repositories","entities"})
@EnableMongoRepositories(basePackages = {"repositories"})
@RequestMapping("/pccomponentesitems")
public class PcComponentesRestController {

    @Autowired
    PcComponentesItemRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    Collection<PcComponentesItem> list() {
        this.repository.save(new PcComponentesItem(220.5, "Mochila", "http://www.pccomponentes.com/algo", "ABCSDEQW"));
        this.repository.save(new PcComponentesItem(20.5, "chila", "http://www.pccomponentes.com/algo2", "abc123abc4"));
        return this.repository.findAll();
    }


}
