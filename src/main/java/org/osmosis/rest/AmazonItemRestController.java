package org.osmosis.rest;

import org.osmosis.entities.AmazonItem;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.osmosis.repositories.AmazonItemRepository;

import java.util.List;


@RestController
@ComponentScan(basePackages = {"org.osmosis.rest", "org.osmosis.repositories", "org.osmosis.entities"})
@EnableMongoRepositories(basePackages = {"org.osmosis.repositories"})
@RequestMapping("/amazonitems")
public class AmazonItemRestController {

    @Autowired
    private AmazonItemRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public List<AmazonItem> list(){
        this.repository.save(new AmazonItem(220.5, "Mochila", "http://www.amazon.com/algo", "ABCSDEQW"));
        this.repository.save(new AmazonItem(20.5, "chila", "http://www.amazon.com/algo2", "abc123abc4"));
        return this.repository.findAll();
    }

    @RequestMapping("/{amazonId}")
    public AmazonItem getByamazonId(
        @PathVariable String amazonId
    ){
        return this.repository.findByAmazonItemId(amazonId);
    }

}
