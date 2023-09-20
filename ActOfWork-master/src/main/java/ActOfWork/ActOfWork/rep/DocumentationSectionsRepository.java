package ActOfWork.ActOfWork.rep;

import ActOfWork.ActOfWork.models.DocumentationSections;
import ActOfWork.ActOfWork.models.ObjectOfBuilder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentationSectionsRepository extends CrudRepository <DocumentationSections, Long> {
    List<DocumentationSections> findAll();
    List<DocumentationSections> findAllByObjectOfBuilderId( Long id);

}
