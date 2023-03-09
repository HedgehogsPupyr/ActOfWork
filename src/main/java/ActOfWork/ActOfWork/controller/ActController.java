package ActOfWork.ActOfWork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ActController {
    @GetMapping("/act")
    public String ActOfWork(Model model) {
        model.addAttribute("Act", "Страница акта");
        return "actofwork";
    }

}
