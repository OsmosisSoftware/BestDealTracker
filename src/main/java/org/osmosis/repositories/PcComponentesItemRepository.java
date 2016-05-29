package org.osmosis.repositories;

import org.osmosis.entities.PcComponentesItem;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PcComponentesItemRepository extends MongoRepository<PcComponentesItem, String> {
}
