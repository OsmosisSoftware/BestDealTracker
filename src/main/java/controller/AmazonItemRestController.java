package controller;

import entities.AmazonItem;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AmazonItemRestController {

    //private AmazonItemRepository amazonItemRepository;

    @RequestMapping("/amazonitems")
    AmazonItem amazonItems() {
        return new AmazonItem(220.5, "Mochila", "http://www.amazon.com/algo", "ABCSDEQW");
    }


}
