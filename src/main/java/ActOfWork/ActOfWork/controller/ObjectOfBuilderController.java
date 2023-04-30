package ActOfWork.ActOfWork.controller;


import ActOfWork.ActOfWork.models.Act;
import ActOfWork.ActOfWork.models.LastViewObject;
import ActOfWork.ActOfWork.models.ObjectOfBuilder;
import ActOfWork.ActOfWork.rep.LastViewObjectRepository;
import ActOfWork.ActOfWork.rep.ObjectOfBuilderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

@Controller
public class ObjectOfBuilderController {

    @Autowired
    private ObjectOfBuilderRepository objectOfBuilderRepository;

    @Autowired
    LastViewObjectRepository lastViewObjectRepository;


    @GetMapping("/objectOfBuilder")
    public String objectOfBuilder  (Model model){
     return "objectOfBuilder";
    }

//    @PostMapping("/objectOfBuilder/{id}")
//    public String LastViewObjectAdd (@RequestParam Long id, @RequestParam LinkStyle<ObjectOfBuilder> builderId, Model model) {
//
//        LastViewObject lvo = new LastViewObject(id, builderId);
//        lastViewObjectRepository.save(lvo);
//        return "redirect:/objectOfBuilder/{id}";
//    }



    @GetMapping("/objectOfBuilder/{id}")
    public String objectOfBuilderDetails (@PathVariable(value = "id") long id, Model model) {
        if (!objectOfBuilderRepository.existsById(id)) {
            return "redirect:/home";
        }

        LastViewObject lastViewObject = new LastViewObject();
        ObjectOfBuilder obj = new ObjectOfBuilder();



//        Optional<ObjectOfBuilder> objects = objectOfBuilderRepository.findById(id);
//        lastViewObject.setObjectOfBuilders(objects);
//        ArrayList<ObjectOfBuilder> res = new ArrayList<>();
//        objects.ifPresent(res::add);
//        model.addAttribute("objects", res);
        return "objectOfBuilder-details";
    }

}
