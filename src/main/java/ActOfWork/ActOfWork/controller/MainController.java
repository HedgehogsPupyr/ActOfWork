package ActOfWork.ActOfWork.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home (Model model) {
        model.addAttribute("home_name", "Страница домашняя");
        return "home";
    }
}
