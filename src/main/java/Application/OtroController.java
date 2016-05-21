package Application;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OtroController {

  @RequestMapping("/otro")
  public String otro(
    @RequestParam(value="name", required=false, defaultValue="Otro value pol dios") String name,
    Model model
  ) {
    model.addAttribute("name", name);
    return "otro";
  }
}
