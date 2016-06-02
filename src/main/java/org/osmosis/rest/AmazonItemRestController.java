package org.osmosis.rest;

import org.apache.log4j.Logger;
import org.osmosis.entities.AmazonItem;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.osmosis.repositories.AmazonItemRepository;

import javax.websocket.server.PathParam;
import java.util.Collection;
import java.util.List;


@RestController
@ComponentScan(basePackages = {
        "org.osmosis.rest",
        "org.osmosis.repositories",
        "org.osmosis.entities"
})
@EnableMongoRepositories(basePackages = {"org.osmosis.repositories"})
@RequestMapping("/amazonitems")
public class AmazonItemRestController {

    @Autowired
    private AmazonItemRepository repository;

    private static Logger logger = Logger.getLogger(AmazonItemRestController.class);

    @RequestMapping(method = RequestMethod.GET)
    public Collection<AmazonItem> list(
            @PathParam("from") String from,
            @PathParam("to") String to
            ){
        if( from == null || to == null) {
            logger.info("From or To are NULL");
            return this.repository.findAll();
        } else {
            try {
                logger.info("Nor From or To are NULL");
                double desde = Double.parseDouble(from);
                double hasta = Double.parseDouble(to);
                return this.repository.findByPrecioBetween(desde, hasta);
            } catch (Exception e){
                logger.error("ERROR IN list method\n"+e.getMessage());
            }
            return this.repository.findAll();
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{amazonId}")
    public AmazonItem getByamazonId(
        @PathVariable String amazonId
    ) {
        return this.repository.findByAmazonItemId(amazonId);
    }

}
