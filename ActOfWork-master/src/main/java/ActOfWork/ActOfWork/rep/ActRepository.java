package ActOfWork.ActOfWork.rep;

import ActOfWork.ActOfWork.models.Act;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActRepository extends CrudRepository <Act, Long> {
    List<Act> findAll();
    List<Act> findAllByDocumentationSectionsId (Long id);



}
