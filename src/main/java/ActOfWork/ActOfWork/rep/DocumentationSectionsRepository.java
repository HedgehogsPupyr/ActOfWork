package ActOfWork.ActOfWork.rep;

import ActOfWork.ActOfWork.models.DocumentationSections;
import ActOfWork.ActOfWork.models.ObjectOfBuilder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DocumentationSectionsRepository extends CrudRepository <DocumentationSections, Long> {
    List<DocumentationSections> findAll();
}
