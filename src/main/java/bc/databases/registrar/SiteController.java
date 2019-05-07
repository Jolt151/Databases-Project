package bc.databases.registrar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SiteController {
    @GetMapping({"/", "/index.html", "/home", "/home.html"})
    public String index(){
        return "home";
    }

    @GetMapping("viewTable")
    public String viewTable(){
        return "viewTable";
    }

}
