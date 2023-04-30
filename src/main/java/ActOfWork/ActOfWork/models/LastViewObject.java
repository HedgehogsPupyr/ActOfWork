package ActOfWork.ActOfWork.models;


import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
public class LastViewObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn (name = "building_id")
    private ObjectOfBuilder objectOfBuilders;

    public LastViewObject() {
    }

    public LastViewObject(ObjectOfBuilder objectOfBuilders) {
        this.objectOfBuilders = objectOfBuilders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ObjectOfBuilder getObjectOfBuilders() {
        return objectOfBuilders;
    }

}
