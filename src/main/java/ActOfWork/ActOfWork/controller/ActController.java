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
    public String ActPostAdd ( @RequestParam String object, @RequestParam String customer,@RequestParam String builder,
                               @RequestParam String architect, @RequestParam int number_of_act, @RequestParam String date,
                               @RequestParam String technical_supervision, @RequestParam String builder_face,
                               @RequestParam String builder_supervision, @RequestParam String architect_face,
                               @RequestParam String builder_stroy, @RequestParam String another_face, @RequestParam String builder_short,
                               @RequestParam String job, @RequestParam String project, @RequestParam String material,
                               @RequestParam String docks, @RequestParam String date_start, @RequestParam String date_end,
                               @RequestParam String docks_project,@RequestParam String next_work,
                               @RequestParam String technical_supervision_name, @RequestParam String builder_face_name,
                               @RequestParam String builder_supervision_name,@RequestParam String architect_face_name,
                               @RequestParam String builder_stroy_name,@RequestParam  String another_face_name1,
                               @RequestParam String another_face_name2, Model model) {

        Act act = new Act (object,customer, builder, architect, number_of_act, date, technical_supervision, builder_face,
                builder_supervision, architect_face, builder_stroy, another_face, builder_short, job, project, material,
                docks, date_start, date_end, docks_project, next_work, technical_supervision_name, builder_face_name,
                builder_supervision_name, architect_face_name,  builder_stroy_name, another_face_name1, another_face_name2);
        actRepository.save(act);

        return "redirect:/act";
    }


    @GetMapping("/act/{id}")
    public String ActDetails(@PathVariable(value = "id") long id, Model model) {
        if (!actRepository.existsById(id)) {
            return "redirect:/act";
        }
        Optional<Act> act = actRepository.findById(id);
        ArrayList<Act> res = new ArrayList<>();
        act.ifPresent(res::add);
        model.addAttribute("act", res);
        return "act-details";
    }

    @GetMapping("/act/{id}/edit")
    public String ActEdit(@PathVariable(value = "id") long id, Model model) {
        if (!actRepository.existsById(id)) {
            return "redirect:/act";
        }
        Optional<Act> act = actRepository.findById(id);
        ArrayList<Act> res = new ArrayList<>();
        act.ifPresent(res :: add);
        model.addAttribute("act", res);
        return "act-edit";
    }

    @PostMapping("/act/{id}/edit")
    public String ActPostUpdate ( @PathVariable(value = "id") long id, @RequestParam  String name, @RequestParam String job, Model model) {
        Act act = actRepository.findById(id).orElseThrow();
        act.setAnother_face(name);
        act.setJob(job);
        actRepository.save(act);
        return "redirect:/act";
    }

    @PostMapping("/act/{id}/remove")
    public String ActPostRemove ( @PathVariable(value = "id") long id, Model model) {
        Act act = actRepository.findById(id).orElseThrow();
        actRepository.delete(act);
        return "redirect:/act";
    }


}
