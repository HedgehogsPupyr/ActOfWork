package ActOfWork.ActOfWork.models;


import javax.persistence.*;


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

    public void setObjectOfBuilders(ObjectOfBuilder objectOfBuilders) {
        this.objectOfBuilders = objectOfBuilders;
    }

    public ObjectOfBuilder getObjectOfBuilders() {
        return objectOfBuilders;
    }

}
