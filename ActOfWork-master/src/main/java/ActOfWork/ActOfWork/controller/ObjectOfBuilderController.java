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



    @GetMapping("/objectOfBuilder/{idObject}")
    public String objectOfBuilderDetails (@PathVariable(value = "idObject") long idObject, Model model) {
        if (!objectOfBuilderRepository.existsById(idObject)) {
            return "redirect:/home";
        }
        LastViewObject lastViewObject = new LastViewObject();
        ObjectOfBuilder object = objectOfBuilderRepository.findById(idObject).get();// тут и далее
        lastViewObject.setObjectOfBuilders(object);  // логика добавления
        lastViewObjectRepository.deleteAll();   // последнего просматриваемого объекта
        lastViewObjectRepository.save(lastViewObject); // с высоводом на экран
        List <ObjectOfBuilder> objects = new ArrayList<>();
        objects.add(object);
        //поиск всех разделов у которых id объекта совпадает и запись в переменную
        List <DocumentationSections> tryToFindAllSection = documentationSectionsRepository.findAllByObjectOfBuilderId(idObject);
        model.addAttribute("listDocSection", tryToFindAllSection);
        model.addAttribute("objects",object);
        return "objectOfBuilder-details";
    }




}
