package ActOfWork.ActOfWork.controller;


import ActOfWork.ActOfWork.models.ObjectOfBuilder;
import ActOfWork.ActOfWork.rep.ObjectOfBuilderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private ObjectOfBuilderRepository objectOfBuilderRepository;

    @GetMapping("/")
    public String home (Model model) {
        Iterable <ObjectOfBuilder> objects = objectOfBuilderRepository.findAll();
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
