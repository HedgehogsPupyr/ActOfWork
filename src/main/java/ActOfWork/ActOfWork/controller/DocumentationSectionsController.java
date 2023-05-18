package ActOfWork.ActOfWork.controller;


import ActOfWork.ActOfWork.models.DocumentationSections;
import ActOfWork.ActOfWork.models.ObjectOfBuilder;
import ActOfWork.ActOfWork.rep.DocumentationSectionsRepository;
import ActOfWork.ActOfWork.rep.ObjectOfBuilderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DocumentationSectionsController {

    @Autowired
    private DocumentationSectionsRepository documentationSectionsRepository;

    @Autowired
    private ObjectOfBuilderRepository objectOfBuilderRepository;

//    @RequestMapping (value = "/objectOfBuilder/{idObject}")
    @GetMapping("/objectOfBuilder/{idObject}/documentationSections")
    public String documentationSections (@PathVariable(value = "idObject") Long idObject, Model model) {


        List <DocumentationSections> docSection = documentationSectionsRepository.findAll();
        model.addAttribute("docSection", docSection);
        return "documentationSections";
    }

    @GetMapping("/objectOfBuilder/{idObject}/documentationSections/add")
    public String ActAdd (@PathVariable (value = "idObject") Long idObject, Model model) {
        List <ObjectOfBuilder> objectsForAdd = objectOfBuilderRepository.findAll();
        model.addAttribute("objectsForAdd", objectsForAdd);
        return "documentationSections-add";
    }

    @PostMapping("/objectOfBuilder/{idObject}/documentationSections/add")
    public String addDocumentationSectionPost(@PathVariable(value = "idObject")  Long idObject, @RequestParam String nameOfSection, Model model){
        ObjectOfBuilder objectOfBuilder = objectOfBuilderRepository.findById(idObject).get();
        DocumentationSections docSection =  new DocumentationSections(nameOfSection);
        docSection.setObjectOfBuilder(objectOfBuilder);
        documentationSectionsRepository.save(docSection);
        return "redirect:/objectOfBuilder/{idObject}/documentationSections";
    }



}
