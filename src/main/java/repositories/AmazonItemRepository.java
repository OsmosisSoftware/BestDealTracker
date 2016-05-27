package repositories;


import entities.AmazonItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AmazonItemRepository extends MongoRepository<AmazonItem, String> {

}

