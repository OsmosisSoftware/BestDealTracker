package org.osmosis.rest;


import org.osmosis.entities.User;
import org.osmosis.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Collection;

@RestController
@ComponentScan(basePackages = {
        "org.osmosis.rest",
        "org.osmosis.repositories",
        "org.osmosis.entities"
})
@EnableMongoRepositories(basePackages = {"org.osmosis.repositories"})
@RequestMapping("/rest/users")
public class UserRestController {

    @Autowired
    UserRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<User> list(){
        return this.repository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{user}")
    public User get(@PathVariable("user") String user){
        return this.repository.findOne(user);
    }

}
