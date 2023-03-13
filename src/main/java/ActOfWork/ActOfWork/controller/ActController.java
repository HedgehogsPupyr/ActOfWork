package ActOfWork.ActOfWork.controller;

import ActOfWork.ActOfWork.models.Act;
import ActOfWork.ActOfWork.rep.ActRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ActController {

    @Autowired
    private ActRepository actRepository;

    @GetMapping("/act")
    public String ActOfWork(Model model) {
        Iterable <Act> acts = actRepository.findAll();

        model.addAttribute("acts", acts);
        return "actofwork";
    }

}
