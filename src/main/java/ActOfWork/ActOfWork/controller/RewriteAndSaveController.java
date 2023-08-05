package ActOfWork.ActOfWork.controller;


import ActOfWork.ActOfWork.Service.ReWriteTemplateService;
import ActOfWork.ActOfWork.models.Act;
import ActOfWork.ActOfWork.rep.ActRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Controller
public class RewriteAndSaveController {
    @Autowired
    private ActRepository actRepository;

    private static final String DEFAULT_FILE_NAME = "Result.xlsx";
    private ReWriteTemplateService changesTempl = new ReWriteTemplateService();


    @GetMapping(value = "/act/{id}/download2", produces = MediaType.APPLICATION_CBOR_VALUE)

    public ResponseEntity<byte[]> saveFile(@PathVariable long id) throws IOException {
        Optional<Act> act = actRepository.findById(id);
        ArrayList<Act> res = new ArrayList<>();
        act.ifPresent(res::add);
        byte[] result = changesTempl.rewRiteFile(res);
        HttpHeaders responseHeaders = new HttpHeaders();
        Act oneAct = actRepository.findById(id).get() ;
        int number_of_act = oneAct.getNumber_of_act();
        String job = "AOCP";
        responseHeaders.set(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=%s%s.xlsx",job,number_of_act));

        return new ResponseEntity<>(
                result,
                responseHeaders,
                HttpStatus.OK
        );

    }
}

