package ActOfWork.ActOfWork.rep;

import ActOfWork.ActOfWork.models.LastViewObject;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LastViewObjectRepository extends CrudRepository <LastViewObject, Long> {

    List<LastViewObject> findAll();
}


