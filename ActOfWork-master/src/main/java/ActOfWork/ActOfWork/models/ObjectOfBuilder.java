package ActOfWork.ActOfWork.models;


import javax.persistence.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

@Entity
public class ObjectOfBuilder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String object, customer, builder, architect;



    public ObjectOfBuilder(String object, String customer, String builder, String architect) {
        this.object = object;
        this.customer = customer;
        this.builder = builder;
        this.architect = architect;
    }


    public ObjectOfBuilder() {
    }

    public ObjectOfBuilder(Long id, String object, String customer, String builder, String architect, LastViewObject lastViewObject) {
        this.id = id;
        this.object = object;
        this.customer = customer;
        this.builder = builder;
        this.architect = architect;

    }

    @Override
    public String toString() {
        return "ObjectOfBuilder{" +
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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectOfBuilder that = (ObjectOfBuilder) o;
        return Objects.equals(id, that.id) && Objects.equals(object, that.object) && Objects.equals(customer, that.customer) && Objects.equals(builder, that.builder) && Objects.equals(architect, that.architect);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, object, customer, builder, architect);
    }
}
