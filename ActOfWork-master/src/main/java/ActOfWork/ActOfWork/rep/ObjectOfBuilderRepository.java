package ActOfWork.ActOfWork.rep;

import ActOfWork.ActOfWork.models.LastViewObject;
import ActOfWork.ActOfWork.models.ObjectOfBuilder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ObjectOfBuilderRepository extends CrudRepository <ObjectOfBuilder, Long> {
    List<ObjectOfBuilder> findAll();

}
