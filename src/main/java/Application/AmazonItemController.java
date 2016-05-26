package Application;

import Entities.AmazonItem;
import java.util.Collection;

import Repositories.AmazonItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class AmazonItemController {

    @RequestMapping("/amazonitems")
    Collection<AmazonItem> amazonItems() {
        return this.amazonItemRepository.findAll();
    }
    @Autowired AmazonItemRepository amazonItemRepository;
}
