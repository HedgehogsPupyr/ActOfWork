package ActOfWork.ActOfWork.controller;


import ActOfWork.ActOfWork.models.DocumentationSections;
import ActOfWork.ActOfWork.rep.DocumentationSectionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DocumentationSectionsController {

    @Autowired
    private DocumentationSectionsRepository documentationSectionsRepository;

//    @RequestMapping (value = "/objectOfBuilder/{id}")
    @ResponseBody
    @GetMapping("/documentationSections")
    public String documentationSections (Model model) {

        List <DocumentationSections> docSection = documentationSectionsRepository.findAll();
        model.addAttribute("docSection", docSection);
        return "documentationSections";
    }

    @GetMapping("/documentationSections/add")
    public String ActAdd(Model model) {
        return "documentationSections-add";
    }

    @PostMapping("/documentationSections/add")
    public String addDocumentationSectionPost(@RequestParam String nameOfSection, Model model){

        DocumentationSections docSection =  new DocumentationSections(nameOfSection);
        documentationSectionsRepository.save(docSection);
        return "redirect:/documentationSections";
    }



}
