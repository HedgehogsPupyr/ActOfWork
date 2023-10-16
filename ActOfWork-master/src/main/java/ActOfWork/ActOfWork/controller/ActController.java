package ActOfWork.ActOfWork.controller;

import ActOfWork.ActOfWork.models.Act;
import ActOfWork.ActOfWork.models.DocumentationSections;
import ActOfWork.ActOfWork.models.ObjectOfBuilder;
import ActOfWork.ActOfWork.rep.ActRepository;
import ActOfWork.ActOfWork.rep.DocumentationSectionsRepository;
import ActOfWork.ActOfWork.rep.ObjectOfBuilderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequestMapping(value = "/objectOfBuilder/{idObject}/documentationSections/{idSection}")
@Controller
public class ActController {

    @Autowired
    private ActRepository actRepository;

    @Autowired
    private ObjectOfBuilderRepository objectOfBuilderRepository;


    @Autowired
    private DocumentationSectionsRepository documentationSectionsRepository;

    @GetMapping("/act")
    public String ActOfWork(@PathVariable long idObject, @PathVariable long idSection, Model model) {

        ObjectOfBuilder objectOfBuilder = objectOfBuilderRepository.findById(idObject).get();
        DocumentationSections documentationSections = documentationSectionsRepository.findById(idSection).get();
        List <Act> acts = actRepository.findAllByDocumentationSectionsId(idSection);
        model.addAttribute("docSect",documentationSections);
        model.addAttribute("objects",objectOfBuilder);
        model.addAttribute("acts", acts);

        return "actofwork";
    }

    @GetMapping("/actAdd")
    public String ActAdd(@PathVariable long idObject, @PathVariable long idSection, Model model) {
        ObjectOfBuilder objectOfBuilder = objectOfBuilderRepository.findById(idObject).get();
        DocumentationSections documentationSections = documentationSectionsRepository.findById(idSection).get();
        model.addAttribute("docSect",documentationSections);
        model.addAttribute("objects",objectOfBuilder);


        return "act-add";
    }

    @PostMapping("/actAdd")
    public String ActPostAdd (@PathVariable long idObject, @PathVariable long idSection, @RequestParam String object, @RequestParam String customer, @RequestParam String builder,
                              @RequestParam String architect, @RequestParam int number_of_act, @RequestParam String date,
                              @RequestParam String technical_supervision, @RequestParam String builder_face,
                              @RequestParam String builder_supervision, @RequestParam String architect_face,
                              @RequestParam String builder_stroy, @RequestParam String another_face, @RequestParam String builder_short,
                              @RequestParam String job, @RequestParam String project, @RequestParam String material,
                              @RequestParam String docks, @RequestParam String date_start, @RequestParam String date_end,
                              @RequestParam String docks_project, @RequestParam String next_work,
                              @RequestParam String technical_supervision_name, @RequestParam String builder_face_name,
                              @RequestParam String builder_supervision_name, @RequestParam String architect_face_name,
                              @RequestParam String builder_stroy_name, @RequestParam  String another_face_name1,
                              @RequestParam String another_face_name2, @RequestParam("file") MultipartFile file, Model model) {

        DocumentationSections documentationSections = documentationSectionsRepository.findById(idSection).get();

            Act act = new Act(object, customer, builder, architect, number_of_act, date, technical_supervision, builder_face,
                    builder_supervision, architect_face, builder_stroy, another_face, builder_short, job, project, file.getOriginalFilename(),
                    file.getName(), date_start, date_end, docks_project, next_work, technical_supervision_name, builder_face_name,
                    builder_supervision_name, architect_face_name, builder_stroy_name, another_face_name1, another_face_name2);
            act.setDocumentationSections(documentationSections);


        return "redirect:/objectOfBuilder/{idObject}/documentationSections/{idSection}";
    }


    @GetMapping("/act/{idAct}")
    public String ActDetails(@PathVariable long idObject, @PathVariable long idSection, @PathVariable long idAct, Model model) {
        if (!actRepository.existsById(idAct)) {
            return "redirect:/act";
        }
        ObjectOfBuilder objectOfBuilder = objectOfBuilderRepository.findById(idObject).get();
        DocumentationSections documentationSections = documentationSectionsRepository.findById(idSection).get();
        List <Act> tryToFindAllActs = actRepository.findAllByDocumentationSectionsId(idSection);
        List <Act> acts = actRepository.findAllByDocumentationSectionsId(idSection);
        model.addAttribute("listActSection", tryToFindAllActs);
        model.addAttribute("docSect",documentationSections);
        model.addAttribute("objects",objectOfBuilder);
        model.addAttribute("acts", acts);
        Optional<Act> act = actRepository.findById(idAct);
        ArrayList<Act> res = new ArrayList<>();
        act.ifPresent(res::add);
        model.addAttribute("act", res);
        return "act-details";
    }

    @GetMapping("/act/{idAct}/edit")
    public String ActEdit(@PathVariable long idObject, @PathVariable long idSection, @PathVariable long idAct, Model model) {
        if (!actRepository.existsById(idAct)) {
            return "redirect:/objectOfBuilder/{idObject}/documentationSections/{idSection}";
        }

        Optional<Act> act = actRepository.findById(idAct);
        ArrayList<Act> res = new ArrayList<>();
        act.ifPresent(res :: add);
        model.addAttribute("act", res);
        return "act-edit";
    }

    @PostMapping("/act/{idAct}/edit")
    public String ActPostUpdate ( @PathVariable long idObject, @PathVariable long idSection, @PathVariable long idAct, @RequestParam  String name, @RequestParam String job, Model model) {
        Act act = actRepository.findById(idAct).orElseThrow();
        act.setAnother_face(name);
        act.setJob(job);
        actRepository.save(act);
        return "redirect:/objectOfBuilder/{idObject}/documentationSections/{idSection}";
    }

    @PostMapping("/act/{idAct}/remove")
    public String ActPostRemove ( @PathVariable long idObject, @PathVariable long idSection, @PathVariable long idAct, Model model) {
        Act act = actRepository.findById(idAct).orElseThrow();
        actRepository.delete(act);
        return "redirect:/objectOfBuilder/{idObject}/documentationSections/{idSection}";
    }


}
