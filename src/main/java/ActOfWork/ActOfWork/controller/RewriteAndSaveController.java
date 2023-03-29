package ActOfWork.ActOfWork.controller;


import ActOfWork.ActOfWork.Service.ReWriteTemplateService;
import ActOfWork.ActOfWork.models.Act;
import ActOfWork.ActOfWork.rep.ActRepository;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Optional;



@Controller
public class RewriteAndSaveController {
    @Autowired
    private ActRepository actRepository;



    private static final String DIRECTORY = "/Users/igogor/Desktop/Java/PDF";
    private static final String DEFAULT_FILE_NAME = "Template.xlsx";
    private ReWriteTemplateService changesTempl = new ReWriteTemplateService();



    @GetMapping(value = "/act/{id}/download2", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)

    public @ResponseBody byte[] getFile( @RequestParam(defaultValue = DEFAULT_FILE_NAME) String fileName,
                                         @PathVariable(value = "id") long id, Model model) throws IOException {
        Optional<Act> act = actRepository.findById(id);
        ArrayList<Act> res = new ArrayList<>();
        act.ifPresent(res::add);
        changesTempl.rewRiteFile(res);

        InputStream in = getClass().getResourceAsStream("/Users/igogor/Desktop/Java/PDF/Template.xlsx");
        return IOUtils.toByteArray(in);
    }

    }



