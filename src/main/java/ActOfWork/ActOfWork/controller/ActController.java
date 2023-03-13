package ActOfWork.ActOfWork.controller;

import ActOfWork.ActOfWork.models.Act;
import ActOfWork.ActOfWork.rep.ActRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

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

    @GetMapping("/act/add")
    public String ActAdd(Model model) {
        return "act-add";
    }

    @PostMapping("/act/add")
    public String ActPostAdd ( @RequestParam  String name, @RequestParam String job, Model model) {
        Act act = new Act (name, job);
        actRepository.save(act);

        return "redirect:/act";
    }


    @GetMapping("/act/{id}")
    public String ActDetails(@PathVariable(value = "id") long id, Model model) {
        if (actRepository.existsById(id)) {
            return "redirect:/act";
        }
        Optional<Act> act = actRepository.findById(id);
        ArrayList<Act> res = new ArrayList<>();
        act.ifPresent(res :: add);
        model.addAttribute("act", res);
        return "act-details";
    }


}
