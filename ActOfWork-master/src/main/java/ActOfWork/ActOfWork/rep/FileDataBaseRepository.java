package ActOfWork.ActOfWork.rep;

import ActOfWork.ActOfWork.models.FileDataBase;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FileDataBaseRepository  extends CrudRepository<FileDataBase, Long> {

    List<FileDataBase> findAll();
    List<FileDataBase> findAllByDocumentationSectionsId (Long id);


}
