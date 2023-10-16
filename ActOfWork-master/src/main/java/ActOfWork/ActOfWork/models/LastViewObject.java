package ActOfWork.ActOfWork.models;


import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;


@Entity
public class LastViewObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private ObjectOfBuilder objectOfBuilders;

    public LastViewObject() {
    }

    public LastViewObject(ObjectOfBuilder objectOfBuilders) {
        this.objectOfBuilders = objectOfBuilders;
    }

    public void setObjectOfBuilders(ObjectOfBuilder objectOfBuilders) {
        this.objectOfBuilders = objectOfBuilders;
    }

    public ObjectOfBuilder getObjectOfBuilders() {
        return objectOfBuilders;
    }

}
