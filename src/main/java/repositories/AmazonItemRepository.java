package repositories;


import entities.AmazonItem;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * Tuto: http://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#new-features.1-9-0
 */
public interface AmazonItemRepository extends MongoRepository<AmazonItem, String> {

}

