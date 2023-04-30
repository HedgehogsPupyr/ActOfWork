package ActOfWork.ActOfWork.controller;


import ActOfWork.ActOfWork.models.LastViewObject;
import ActOfWork.ActOfWork.models.ObjectOfBuilder;
import ActOfWork.ActOfWork.rep.LastViewObjectRepository;
import ActOfWork.ActOfWork.rep.ObjectOfBuilderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ObjectOfBuilderRepository objectOfBuilderRepository;

    @Autowired
    private LastViewObjectRepository lastViewObjectRepository;

    @GetMapping("/")
    public String home ( Model model) {
        Iterable <ObjectOfBuilder> objects = objectOfBuilderRepository.findAll();
        List<LastViewObject> lastViewObjects = lastViewObjectRepository.findAll();

        var asd= lastViewObjects.get(0);


        ObjectOfBuilder objectOfBuilders = asd.getObjectOfBuilders();
        model.addAttribute("history", List.of(objectOfBuilders));
        model.addAttribute("objects", objects);
        return "home";

    }

    @GetMapping("/objectAdd")
    public String objectAdd(Model model) {
        return "object-add";
    }

    @PostMapping("/objectAdd")
    public String objectPostAdd (@RequestParam String object, @RequestParam String customer, @RequestParam String builder,
                              @RequestParam String architect, Model model) {

        ObjectOfBuilder objects = new ObjectOfBuilder (object,customer, builder, architect);
        objectOfBuilderRepository.save(objects);

        return "redirect:/";
    }

}
