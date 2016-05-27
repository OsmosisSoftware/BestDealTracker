package repositories;


import entities.AmazonItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public interface AmazonItemRepository extends MongoRepository<AmazonItem, String> {
    /*public List<AmazonItem> listAmazonItems(){
        ArrayList<AmazonItem> listAmazonItems = new ArrayList<>();
        listAmazonItems.add(new AmazonItem(220.5, "Mochila", "http://www.amazon.com/algo", "ABCSDEQW"));
        listAmazonItems.add(new AmazonItem(20.5, "chila", "http://www.amazon.com/algo2", "abc123abc4"));

        return listAmazonItems;
    }*/




}

