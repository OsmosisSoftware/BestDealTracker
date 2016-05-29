package org.osmosis.application;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@Configuration
@ComponentScan(basePackages = {"org.osmosis.rest", "org.osmosis.repositories", "org.osmosis.entities"})
@EnableMongoRepositories(basePackages = {"repository"})
@EnableAutoConfiguration
public class AppConfiguration {

}
