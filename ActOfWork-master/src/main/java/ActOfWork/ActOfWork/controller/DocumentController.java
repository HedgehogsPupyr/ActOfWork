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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping(value = "/objectOfBuilder/{idObject}/documentationSections/{idSection}")
public class DocumentController {


    @Autowired
    private ActRepository actRepository;
    @Autowired
    private ObjectOfBuilderRepository objectOfBuilderRepository;
    @Autowired
    private DocumentationSectionsRepository documentationSectionsRepository;

    @GetMapping("/document/1")
    public String ActOfWork(@PathVariable long idObject, @PathVariable long idSection, Model model) {

        ObjectOfBuilder objectOfBuilder = objectOfBuilderRepository.findById(idObject).get();
        DocumentationSections documentationSections = documentationSectionsRepository.findById(idSection).get();
        List<Act> acts = actRepository.findAllByDocumentationSectionsId(idSection);
        model.addAttribute("docSect",documentationSections);
        model.addAttribute("objects",objectOfBuilder);
        model.addAttribute("acts", acts);

        return "document";
    }


}
