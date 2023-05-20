package ActOfWork.ActOfWork.controller;


import ActOfWork.ActOfWork.models.Act;
import ActOfWork.ActOfWork.models.DocumentationSections;
import ActOfWork.ActOfWork.models.ObjectOfBuilder;
import ActOfWork.ActOfWork.rep.DocumentationSectionsRepository;
import ActOfWork.ActOfWork.rep.ObjectOfBuilderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping (value = "/objectOfBuilder/{idObject}")
@Controller
public class DocumentationSectionsController {

    @Autowired
    private DocumentationSectionsRepository documentationSectionsRepository;

    @Autowired
    private ObjectOfBuilderRepository objectOfBuilderRepository;


    @GetMapping("/documentationSections")
    public String documentationSections (@PathVariable(value = "idObject") Long idObject, Model model) {


        List <DocumentationSections> docSection = documentationSectionsRepository.findAll();
        model.addAttribute("docSection", docSection);
        return "documentationSections";
    }

    @GetMapping("/documentationSectionsAdd")
    public String ActAdd (@PathVariable (value = "idObject") Long idObject, Model model) {
        ObjectOfBuilder objectOfBuilder = objectOfBuilderRepository.findById(idObject).get();
        model.addAttribute("objectOfBuilder", objectOfBuilder);
        return "documentationSections-add";
    }

    @PostMapping("/documentationSectionsAdd")
    public String addDocumentationSectionPost(@PathVariable(value = "idObject")  Long idObject, @RequestParam String nameOfSection, Model model){
        ObjectOfBuilder objectOfBuilder = objectOfBuilderRepository.findById(idObject).get();
        DocumentationSections docSection =  new DocumentationSections(nameOfSection);
        docSection.setObjectOfBuilder(objectOfBuilder);
        documentationSectionsRepository.save(docSection);
//        model.addAttribute("objectOfBuilder", objectOfBuilder);
        return "redirect:/objectOfBuilder/{idObject}";
    }

//    @PostMapping("/objectOfBuilder/{idObject}/documentationSections/remove")
//    public String ActPostRemove ( @PathVariable(value = "id") long id, Model model) {
//        Act act = actRepository.findById(id).orElseThrow();
//        actRepository.delete(act);
//        return "redirect:/objectOfBuilder-details";
//    }



}
