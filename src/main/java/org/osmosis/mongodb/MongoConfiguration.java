package org.osmosis.mongodb;

/*
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;

import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import static java.util.Collections.singletonList;

@Configuration
@EnableMongoAuditing(auditorAwareRef = "springSecurityAuditorAware")
public class MongoConfiguration extends AbstractMongoConfiguration{

    //private final Logger log = (Logger) LoggerFactory.getLogger(MongoConfiguration.class);

    @Value("#{config['mongodb.url'] ?: '127.0.0.1'}")
    private String host;

    @Value("#{systemProperties['mongodb.port'] ?: 27017}")
    private Integer port;

    @Value("${spring.data.mongodb.username}")
    private String username;

    @Value("${spring.data.mongodb.database}")
    private String database;

    @Value("${spring.data.mongodb.password}")
    private String password;

    @Bean
    public ValidatingMongoEventListener validatingMongoEventListener() {
        return new ValidatingMongoEventListener(validator());
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }

    @Override
    protected String getDatabaseName() {
        return database;
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient(
                singletonList(
                    new ServerAddress(host, port)
                ),
                singletonList(
                        MongoCredential.createCredential(
                                username,
                                database,
                                password.toCharArray()
                        )
                )
        );
    }

}
*/