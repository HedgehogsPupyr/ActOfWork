package ActOfWork.ActOfWork.controller;


import ActOfWork.ActOfWork.models.Act;
import ActOfWork.ActOfWork.rep.ActRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Optional;



@Controller
public class ReriteAndSaveController {
    @Autowired
    private ActRepository actRepository;



    private static final String DIRECTORY = "/Users/igogor/Desktop/Java/PDF";
    private static final String DEFAULT_FILE_NAME = "AOSR.xlsx";

    @Autowired
    private ServletContext servletContext;


    @GetMapping("/act/{id}/download2")
    public void downloadFile2(HttpServletResponse response,
                              @RequestParam(defaultValue = DEFAULT_FILE_NAME) String fileName,
                              @PathVariable(value = "id") long id, Model model ) throws IOException {

        Optional<Act> act = actRepository.findById(id);
        ArrayList<Act> res = new ArrayList<>();
        act.ifPresent(res::add);

        ReWriteTemplateController changesTempl = new ReWriteTemplateController();
        changesTempl.rewRiteFile(res);

        File file = new File(DIRECTORY + "/" + fileName);

        // Content-Disposition
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName());

        // Content-Length
        response.setContentLength((int) file.length());

        BufferedInputStream inStream = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream outStream = new BufferedOutputStream(response.getOutputStream());

        byte[] buffer = new byte[1024];
        int bytesRead = 0;
        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
        outStream.flush();
        inStream.close();
    }


}
