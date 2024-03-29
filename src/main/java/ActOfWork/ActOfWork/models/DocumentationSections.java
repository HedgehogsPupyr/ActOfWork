package ActOfWork.ActOfWork.models;


import javax.persistence.*;

@Entity
public class DocumentationSections {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (name="name_of_section")
    String nameOfSection;

    @ManyToOne
    ObjectOfBuilder objectOfBuilder;

    public DocumentationSections(String nameOfSection) {
        this.nameOfSection = nameOfSection;
    }

    public  DocumentationSections(){

    }

    public DocumentationSections(String nameOfSection, ObjectOfBuilder objectOfBuilder) {
        this.nameOfSection = nameOfSection;
        this.objectOfBuilder = objectOfBuilder;
    }

    public ObjectOfBuilder getObjectOfBuilder() {
        return objectOfBuilder;
    }

    public void setObjectOfBuilder(ObjectOfBuilder objectOfBuilder) {
        this.objectOfBuilder = objectOfBuilder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfSection() {
        return nameOfSection;
    }

    public void setNameOfSection(String nameOfSection) {
        this.nameOfSection = nameOfSection;
    }
}
