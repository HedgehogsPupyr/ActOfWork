package ActOfWork.ActOfWork.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ObjectOfBuilder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String object, customer, builder, architect;

    public ObjectOfBuilder() {
    }

    public ObjectOfBuilder(String object, String customer, String builder, String architect) {
        this.object = object;
        this.customer = customer;
        this.builder = builder;
        this.architect = architect;
    }

    @Override
    public String toString() {
        return "Object{" +
                "id=" + id +
                ", object='" + object + '\'' +
                ", customer='" + customer + '\'' +
                ", builder='" + builder + '\'' +
                ", architect='" + architect + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getBuilder() {
        return builder;
    }

    public void setBuilder(String builder) {
        this.builder = builder;
    }

    public String getArchitect() {
        return architect;
    }

    public void setArchitect(String architect) {
        this.architect = architect;
    }
}
