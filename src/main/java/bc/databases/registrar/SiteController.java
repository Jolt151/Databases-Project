package bc.databases.registrar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class SiteController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("insertUser")
    public void insertUser(){

    }

}
