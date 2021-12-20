package id.oneindoensia.javabootcamp.day5.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Date;

@Controller
public class DemoMVCThymeleaf {
    @GetMapping("/sayhello")
    public String sayHello(Model theModel) {
        theModel.addAttribute("theDate", new Date());
        return "sayhello";
    }
}
