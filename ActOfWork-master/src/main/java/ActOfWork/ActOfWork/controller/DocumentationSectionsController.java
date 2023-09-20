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

    @GetMapping("/documentationSectionsAdd")
    public String ActAdd (@PathVariable long idObject, Model model) {
        //передаём объект, id которого получили в запросе, в шаблон, чтоб корректно отработал сам шаблон
        ObjectOfBuilder objectOfBuilder = objectOfBuilderRepository.findById(idObject).get();
        model.addAttribute("objectOfBuilder", objectOfBuilder);
        return "documentationSections-add";
    }

    @PostMapping("/documentationSectionsAdd")
    public String addDocumentationSectionPost(@PathVariable long idObject, @RequestParam String nameOfSection, Model model){
        ObjectOfBuilder objectOfBuilder = objectOfBuilderRepository.findById(idObject).get();
        DocumentationSections docSection =  new DocumentationSections(nameOfSection);
        //запись объекта, который мы получили из адресной строки (через idObject) в таблицу к созданому разделу
        docSection.setObjectOfBuilder(objectOfBuilder);
        documentationSectionsRepository.save(docSection);
        return "redirect:/objectOfBuilder/{idObject}";
    }

    @GetMapping("/documentationSections/{idSection}/sectionEdit")
    public String SectionEdit(@PathVariable long idObject, @PathVariable long idSection, Model model) {
        if (!documentationSectionsRepository.existsById(idSection)) {
            return "redirect:/objectOfBuilder/{idObject}";
        }
        ObjectOfBuilder objectOfBuilder = objectOfBuilderRepository.findById(idObject).get();
        DocumentationSections documentationSections = documentationSectionsRepository.findById(idSection).get();
        model.addAttribute("objectOfBuilder", objectOfBuilder);
        model.addAttribute("documentationSections", documentationSections);
        return "documentationSections-edit";
    }

    @PostMapping("/documentationSections/{idSection}/sectionEdit")
    public String SectionEdit ( @PathVariable long idObject, @PathVariable long idSection, @RequestParam  String nameOfSection, Model model) {
        DocumentationSections documentationSections = documentationSectionsRepository.findById(idSection).orElseThrow();
        documentationSections.setNameOfSection(nameOfSection);
        documentationSectionsRepository.save(documentationSections);
        return "redirect:/objectOfBuilder/{idObject}";
    }

    @PostMapping("/documentationSections/{idSection}/remove")
    public String SectionRemove ( @PathVariable long idObject, @PathVariable long idSection, Model model) {
        DocumentationSections documentationSections = documentationSectionsRepository.findById(idSection).orElseThrow();
        documentationSectionsRepository.delete(documentationSections);
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


}
