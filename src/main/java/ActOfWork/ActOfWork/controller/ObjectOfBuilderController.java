package ActOfWork.ActOfWork.controller;


import ActOfWork.ActOfWork.models.Act;
import ActOfWork.ActOfWork.models.ObjectOfBuilder;
import ActOfWork.ActOfWork.rep.ObjectOfBuilderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ObjectOfBuilderController {

    @Autowired
    private ObjectOfBuilderRepository objectOfBuilderRepository;


    @GetMapping("/objectOfBuilder")
    public String objectOfBuilder  (Model model){
     return "objectOfBuilder";
    }

    @GetMapping("/objectOfBuilder/{id}")
    public String objectOfBuilderDetails (@PathVariable(value = "id") long id, Model model) {
        if (!objectOfBuilderRepository.existsById(id)) {
            return "redirect:/home";
        }

        Optional<ObjectOfBuilder> objects = objectOfBuilderRepository.findById(id);
        ArrayList<ObjectOfBuilder> res = new ArrayList<>();
        objects.ifPresent(res::add);
        model.addAttribute("objects", res);
        return "objectOfBuilder-details";
    }

}
