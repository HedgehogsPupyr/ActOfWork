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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private ObjectOfBuilderRepository objectOfBuilderRepository;

    @Autowired
    private LastViewObjectRepository lastViewObjectRepository;

    @GetMapping("/")
    public String home ( Model model) {
        List <ObjectOfBuilder> objects = objectOfBuilderRepository.findAll();
        List<LastViewObject> lastViewObjects = lastViewObjectRepository.findAll();

        if (lastViewObjects.size()>0){
            LastViewObject lastViewObject= lastViewObjects.get(0);

            ObjectOfBuilder lastSawObjectOfBuilders = lastViewObject.getObjectOfBuilders();
            objects.remove(lastSawObjectOfBuilders);

            model.addAttribute("history", lastSawObjectOfBuilders);
            model.addAttribute("objects", objects);
            return "home";
        }
        else{
            model.addAttribute("objects", objects);
            return "home1";
        }

    }

    @GetMapping("/objectAdd")
    public String objectAdd (Model model) {

        return "object-add";
    }

    @PostMapping("/objectAdd")
    public String objectPostAdd (@RequestParam String object, @RequestParam String customer, @RequestParam String builder,
                              @RequestParam String architect, Model model) {

        ObjectOfBuilder objects = new ObjectOfBuilder (object,customer, builder, architect);
        objectOfBuilderRepository.save(objects);
        return "redirect:/";
    }

    @GetMapping("/objectOfBuilder/{idObject}/objectEdit")
    public String ObjectOfBuilderEdit(@PathVariable long idObject, Model model) {
        if (!objectOfBuilderRepository.existsById(idObject)) {
            return "redirect:/";
        }

        ObjectOfBuilder objectOfBuilder = objectOfBuilderRepository.findById(idObject).get();
        model.addAttribute("objectOfBuilder", objectOfBuilder);
        return "object-edit";
    }

    @PostMapping("/objectOfBuilder/{idObject}/objectEdit")
    public String ObjectOdBuildingEdit ( @PathVariable long idObject, @RequestParam  String object, @RequestParam String customer, @RequestParam String builder, @RequestParam String architect, Model model) {
        ObjectOfBuilder objectOfBuilder = objectOfBuilderRepository.findById(idObject).orElseThrow();
        objectOfBuilder.setObject(object);
        objectOfBuilder.setCustomer(customer);
        objectOfBuilder.setBuilder(builder);
        objectOfBuilder.setArchitect(architect);
        objectOfBuilderRepository.save(objectOfBuilder);
        return "redirect:/";
    }

    @PostMapping("/objectOfBuilder/{idObject}/remove")
    public String ObjectOfBuilderRemove ( @PathVariable long idObject, Model model) {
        ObjectOfBuilder objectOfBuilder = objectOfBuilderRepository.findById(idObject).orElseThrow();
        objectOfBuilderRepository.delete(objectOfBuilder);
        return "redirect:/";
    }





}
