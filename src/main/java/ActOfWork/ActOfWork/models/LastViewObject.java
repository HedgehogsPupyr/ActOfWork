package ActOfWork.ActOfWork.models;


import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class LastViewObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    @JoinColumn (name = "building_id")
    private Set<ObjectOfBuilder> buildingId;

    public LastViewObject(Long id, Set<ObjectOfBuilder> buildingId) {
        this.id = id;
        this.buildingId = buildingId;
    }

    public LastViewObject(Set<ObjectOfBuilder> buildingId) {
        this.buildingId = buildingId;
    }

    public LastViewObject() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<ObjectOfBuilder> getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Set<ObjectOfBuilder> buildingId) {
        this.buildingId = buildingId;
    }
}
