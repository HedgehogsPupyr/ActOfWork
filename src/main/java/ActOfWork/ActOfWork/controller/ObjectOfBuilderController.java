package ActOfWork.ActOfWork.controller;



import ActOfWork.ActOfWork.models.DocumentationSections;
import ActOfWork.ActOfWork.models.LastViewObject;
import ActOfWork.ActOfWork.models.ObjectOfBuilder;
import ActOfWork.ActOfWork.rep.DocumentationSectionsRepository;
import ActOfWork.ActOfWork.rep.LastViewObjectRepository;
import ActOfWork.ActOfWork.rep.ObjectOfBuilderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.ArrayList;
import java.util.List;


@Controller
public class ObjectOfBuilderController {

    @Autowired
    private ObjectOfBuilderRepository objectOfBuilderRepository;

    @Autowired
    LastViewObjectRepository lastViewObjectRepository;

    @Autowired
    DocumentationSectionsRepository documentationSectionsRepository;



    @GetMapping("/objectOfBuilder/{id}")
    public String objectOfBuilderDetails (@PathVariable(value = "id") long id, Model model) {
        if (!objectOfBuilderRepository.existsById(id)) {
            return "redirect:/home";
        }
        LastViewObject lastViewObject = new LastViewObject();
        ObjectOfBuilder object = objectOfBuilderRepository.findById(id).get();
        lastViewObject.setObjectOfBuilders(object);
        lastViewObjectRepository.deleteAll();
        lastViewObjectRepository.save(lastViewObject);
        List objects = new ArrayList();
        objects.add(object);
        List <DocumentationSections> docSection = documentationSectionsRepository.findAll();
        model.addAttribute("docSection", docSection);
        model.addAttribute("objects",objects);
        return "objectOfBuilder-details";
    }

}
