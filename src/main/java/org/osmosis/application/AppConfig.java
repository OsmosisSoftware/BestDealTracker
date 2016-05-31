package org.osmosis.application;


import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.UnknownHostException;


@Configuration
@ComponentScan(basePackages = {
        "org.osmosis.rest",
        "org.osmosis.repositories",
        "org.osmosis.entities",
})
@EnableMongoRepositories(basePackages = {"repository"})
@EnableAutoConfiguration
public class AppConfig {

    public @Bean Mongo mongo() throws Exception {
        return new MongoClient("localhost", 27017);
    }

    public @Bean MongoClientFactoryBean mongoClient() {
        MongoClientFactoryBean mongo = new MongoClientFactoryBean();
        mongo.setHost("localhost");
        return mongo;
    }

    public @Bean MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "bdtdb");
    }

}
