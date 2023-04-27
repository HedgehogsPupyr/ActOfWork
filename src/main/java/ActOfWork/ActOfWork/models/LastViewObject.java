package ActOfWork.ActOfWork.models;


import javax.persistence.*;
import java.util.Date;

@Entity
public class LastViewObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private Date inActViews;

    private Date lastViews;

    public LastViewObject () {

    }

    public LastViewObject(Long id, Date inActViews, Date lastViews) {
        this.id = id;
        this.inActViews = inActViews;
        this.lastViews = lastViews;
    }

    @Override
    public String toString() {
        return "LastViewObject{" +
                "id=" + id +
                ", inActViews=" + inActViews +
                ", lastViews=" + lastViews +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getInActViews() {
        return inActViews;
    }

    public void setInActViews(Date inActViews) {
        this.inActViews = inActViews;
    }

    public Date getLastViews() {
        return lastViews;
    }

    public void setLastViews(Date lastViews) {
        this.lastViews = lastViews;
    }
}
