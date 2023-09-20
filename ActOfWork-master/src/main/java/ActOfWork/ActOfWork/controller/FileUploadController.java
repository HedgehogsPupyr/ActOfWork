package ActOfWork.ActOfWork.controller;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ActOfWork.ActOfWork.Service.Storage.StorageFileNotFoundException;
import ActOfWork.ActOfWork.Service.StorageService;
import ActOfWork.ActOfWork.models.Act;
import ActOfWork.ActOfWork.models.DocumentationSections;
import ActOfWork.ActOfWork.models.ObjectOfBuilder;
import ActOfWork.ActOfWork.rep.ActRepository;
import ActOfWork.ActOfWork.rep.DocumentationSectionsRepository;
import ActOfWork.ActOfWork.rep.ObjectOfBuilderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping(value = "/objectOfBuilder/{idObject}/documentationSections/{idSection}")
public class FileUploadController {
    @Autowired
    private ActRepository actRepository;
    @Autowired
    private ObjectOfBuilderRepository objectOfBuilderRepository;
    @Autowired
    private DocumentationSectionsRepository documentationSectionsRepository;
    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/document")
    public String listUploadedFiles(@PathVariable long idObject, @PathVariable long idSection, Model model) throws IOException {


        ObjectOfBuilder objectOfBuilder = objectOfBuilderRepository.findById(idObject).get();
        DocumentationSections documentationSections = documentationSectionsRepository.findById(idSection).get();
        List<Act> acts = actRepository.findAllByDocumentationSectionsId(idSection);
        model.addAttribute("docSect",documentationSections);
        model.addAttribute("objects",objectOfBuilder);
        model.addAttribute("acts", acts);


        model.addAttribute("files", storageService.loadAll().map(
                        path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                                "serveFile", path.getFileName().toString()).build().toUri().toString())
                .collect(Collectors.toList()));

        return "document";
    }

    @GetMapping("document/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/document")
    public String handleFileUpload(@PathVariable long idObject, @PathVariable long idSection, @RequestParam("file")  MultipartFile file,
                                   RedirectAttributes redirectAttributes, Model model) {

        ObjectOfBuilder objectOfBuilder = objectOfBuilderRepository.findById(idObject).get();
        DocumentationSections documentationSections = documentationSectionsRepository.findById(idSection).get();
        List<Act> acts = actRepository.findAllByDocumentationSectionsId(idSection);
        model.addAttribute("docSect",documentationSections);
        model.addAttribute("objects",objectOfBuilder);
        model.addAttribute("acts", acts);

        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/objectOfBuilder/{idObject}/documentationSections/{idSection}/document";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}
