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

import java.util.List;
import java.util.Map;

@RequestMapping (value = "/objectOfBuilder/{idObject}")
@Controller
public class DocumentationSectionsController {

    @Autowired
    private DocumentationSectionsRepository documentationSectionsRepository;

    @Autowired
    private ObjectOfBuilderRepository objectOfBuilderRepository;

    @Autowired
    private ActRepository actRepository;


    @GetMapping("/documentationSections")
    public String documentationSections (@PathVariable(value = "idObject") long idObject, Model model) {


        List <DocumentationSections> docSection = documentationSectionsRepository.findAll();
        model.addAttribute("docSection", docSection);
        return "documentationSections";
    }

    @GetMapping("/documentationSectionsAdd")
    public String ActAdd (@PathVariable (value = "idObject") long idObject, Model model) {
        //передаём объект, id которого получили в запросе, в шаблон, чтоб корректно отработал сам шаблон
        ObjectOfBuilder objectOfBuilder = objectOfBuilderRepository.findById(idObject).get();
        model.addAttribute("objectOfBuilder", objectOfBuilder);
        return "documentationSections-add";
    }

    @PostMapping("/documentationSectionsAdd")
    public String addDocumentationSectionPost(@PathVariable long idObject, @RequestParam String nameOfSection, Model model){
        ObjectOfBuilder objectOfBuilder = objectOfBuilderRepository.findById(idObject).get();
        DocumentationSections docSection =  new DocumentationSections(nameOfSection);
        //запись id объекта, которое мы получили из адресной строки в таблицу к созданой секции
        docSection.setObjectOfBuilder(objectOfBuilder);
        documentationSectionsRepository.save(docSection);
//        model.addAttribute("objectOfBuilder", objectOfBuilder);
        return "redirect:/objectOfBuilder/{idObject}";
    }


    @GetMapping("/documentationSections/{idSection}")
    public String ViewDocumentationSections (@PathVariable long idObject, @PathVariable long idSection,
                                                          Model model){
        ObjectOfBuilder objectOfBuilder = objectOfBuilderRepository.findById(idObject).get();
        DocumentationSections documentationSections = documentationSectionsRepository.findById(idSection).get();
        List <DocumentationSections> tryToFindAllSection = documentationSectionsRepository.findAllByObjectOfBuilderId(idObject);
        List <Act> acts = actRepository.findAllByDocumentationSectionsId(idSection);
        List <Act> tryToFindAllActs = actRepository.findAllByDocumentationSectionsId(idSection);
        model.addAttribute("listDocSection", tryToFindAllSection);
        model.addAttribute("docSect",documentationSections);
        model.addAttribute("objects",objectOfBuilder);
        model.addAttribute("acts", acts);
        model.addAttribute("listAct", tryToFindAllActs);





        return "documentationSections";
    }




//    @PostMapping("/objectOfBuilder/{idObject}/documentationSections/remove")
//    public String ActPostRemove ( @PathVariable(value = "id") long id, Model model) {
//        Act act = actRepository.findById(id).orElseThrow();
//        actRepository.delete(act);
//        return "redirect:/objectOfBuilder-details";
//    }



}
