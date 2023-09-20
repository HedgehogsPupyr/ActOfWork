package ActOfWork.ActOfWork.Service;

import org.apache.poi.util.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.security.Principal;

public class RenameService {

    public ResponseEntity <byte[]>  renameFileService() throws IOException {
        FileSystemResource fsr = new FileSystemResource("/Users/igogor/Desktop/Java/PDF/Template.xlsx");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename={id}.xlsx" ));

        return new ResponseEntity<>(
                IOUtils.toByteArray(fsr.getInputStream()),
                responseHeaders,
                HttpStatus.OK
        );

    }


}
