package repositories;

import entities.PcComponentesItem;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PcComponentesItemRepository extends MongoRepository<PcComponentesItem, String> {
}
