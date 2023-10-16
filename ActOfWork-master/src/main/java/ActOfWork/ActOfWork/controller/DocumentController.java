package ActOfWork.ActOfWork.controller;


import ActOfWork.ActOfWork.Service.Storage.StorageFileNotFoundException;
import ActOfWork.ActOfWork.Service.StorageService;
import ActOfWork.ActOfWork.models.*;
import ActOfWork.ActOfWork.rep.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping(value = "/objectOfBuilder/{idObject}/documentationSections/{idSection}")
public class DocumentController {


    @Autowired
    private ActRepository actRepository;
    @Autowired
    private ObjectOfBuilderRepository objectOfBuilderRepository;
    @Autowired
    private DocumentationSectionsRepository documentationSectionsRepository;

    @Autowired
    private FileDataBaseRepository fileDataBaseRepository;
    private final StorageService storageService;
    @Autowired
    public DocumentController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/document")
    public String Document(@PathVariable long idObject, @PathVariable long idSection, Model model) {

        ObjectOfBuilder objectOfBuilder = objectOfBuilderRepository.findById(idObject).get();
        DocumentationSections documentationSections = documentationSectionsRepository.findById(idSection).get();
        List<Act> acts = actRepository.findAllByDocumentationSectionsId(idSection);
        List <FileDataBase> fileDataBases = fileDataBaseRepository.findAllByDocumentationSectionsId(idSection);
        model.addAttribute("docSect",documentationSections);
        model.addAttribute("objects",objectOfBuilder);
        model.addAttribute("acts", acts);
        model.addAttribute("files",fileDataBases );
        model.addAttribute("file", storageService.loadAll().map(
                        path -> MvcUriComponentsBuilder.fromMethodName(DocumentController.class,
                                "serveFile", path.getFileName().toString()).build().toUri().toString())
                .collect(Collectors.toList()));

        return "document";
    }


    @GetMapping("/documentAdd")
    public String DocumentAdd(@PathVariable long idObject, @PathVariable long idSection, Model model) {

        ObjectOfBuilder objectOfBuilder = objectOfBuilderRepository.findById(idObject).get();
        DocumentationSections documentationSections = documentationSectionsRepository.findById(idSection).get();
        List<Act> acts = actRepository.findAllByDocumentationSectionsId(idSection);
        List <FileDataBase> fileDataBases = fileDataBaseRepository.findAll();

        model.addAttribute("docSect",documentationSections);
        model.addAttribute("objects",objectOfBuilder);
        model.addAttribute("acts", acts);
        model.addAttribute("files",fileDataBases );


        return "document-add";
    }

    @GetMapping("document/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename ) {

        Resource file = storageService.loadAsResource(filename);
        FileDataBase fileDataBase = new FileDataBase();
        fileDataBase.setNameFile(file.getFilename());
        ContentDisposition contentDisposition = ContentDisposition.builder("attachment")
                .filename(file.getFilename(), StandardCharsets.UTF_8)
                .build();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition.toString())
                .contentType(MediaType.APPLICATION_PDF)
                .body(file);
    }

    @PostMapping("/documentAdd")
    public String handleFileUpload(@PathVariable long idObject, @PathVariable long idSection, @RequestParam String materialName,
                                   @RequestParam String  pasportName,  @RequestParam String pasportDate, @RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes, Model model) {
       ObjectOfBuilder objectOfBuilder = objectOfBuilderRepository.findById(idObject).get();
       DocumentationSections documentationSections = documentationSectionsRepository.findById(idSection).get();
       FileDataBase fileDataBase = new FileDataBase();
       fileDataBase.setNameFile(file.getOriginalFilename());
       fileDataBase.setType(file.getContentType());
       fileDataBase.setDate(new Date());
       fileDataBase.setSize(file.getSize());
       fileDataBase.setMaterialName(materialName);
       fileDataBase.setPasportName(pasportName);
       fileDataBase.setPasportDate(pasportDate);
       fileDataBase.setDocumentationSections(documentationSections);
       fileDataBaseRepository.save(fileDataBase);
       storageService.store(file);
       model.addAttribute("docSect",documentationSections);
       model.addAttribute("objects",objectOfBuilder);
       redirectAttributes.addFlashAttribute("message",
               "You successfully uploaded " + file.getOriginalFilename() + "!");

       return "redirect:/objectOfBuilder/{idObject}/documentationSections/{idSection}/document";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }




}
