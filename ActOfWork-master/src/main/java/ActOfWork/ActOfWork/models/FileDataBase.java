package ActOfWork.ActOfWork.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class FileDataBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nameFile;
    private String type;
    private Date date;
    private long size;
    private String materialName;
    private String pasportName;
    private String pasportDate;

    @ManyToOne
    private Act act;

    @ManyToOne
    private DocumentationSections documentationSections;

    public FileDataBase() {
    }

    public FileDataBase(String nameFile, String type, Date date, long size, String materialName, String pasportName, String pasportDate) {
        this.nameFile = nameFile;
        this.type = type;
        this.date = date;
        this.size = size;
        this.materialName = materialName;
        this.pasportName = pasportName;
        this.pasportDate = pasportDate;
    }



    public FileDataBase(String nameFile, String type, Date date, long size) {
        this.nameFile = nameFile;
        this.type = type;
        this.date = date;
        this.size = size;
    }

    public FileDataBase(String nameFile, String type, Date date, long size, String materialName, String pasportName, String pasportDate, Act act) {
        this.nameFile = nameFile;
        this.type = type;
        this.date = date;
        this.size = size;
        this.materialName = materialName;
        this.pasportName = pasportName;
        this.pasportDate = pasportDate;
        this.act = act;
    }

    public FileDataBase(String nameFile, String type, Date date, long size, String materialName, String pasportName, String pasportDate, Act act, DocumentationSections documentationSections) {
        this.nameFile = nameFile;
        this.type = type;
        this.date = date;
        this.size = size;
        this.materialName = materialName;
        this.pasportName = pasportName;
        this.pasportDate = pasportDate;
        this.act = act;
        this.documentationSections = documentationSections;
    }

    public FileDataBase(String nameFile, String type, Date date, long size, String materialName, String pasportName, String pasportDate, DocumentationSections documentationSections) {
        this.nameFile = nameFile;
        this.type = type;
        this.date = date;
        this.size = size;
        this.materialName = materialName;
        this.pasportName = pasportName;
        this.pasportDate = pasportDate;
        this.documentationSections = documentationSections;
    }

    public FileDataBase(long size, String materialName, String pasportName, String pasportDate) {
        this.size = size;
        this.materialName = materialName;
        this.pasportName = pasportName;
        this.pasportDate = pasportDate;
    }

    public FileDataBase(String materialName, String pasportName, String pasportDate) {
        this.materialName = materialName;
        this.pasportName = pasportName;
        this.pasportDate = pasportDate;
    }



    public long getId() {
        return id;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Act getAct() {
        return act;
    }

    public void setAct(Act act) {
        this.act = act;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public DocumentationSections getDocumentationSections() {
        return documentationSections;
    }

    public void setDocumentationSections(DocumentationSections documentationSections) {
        this.documentationSections = documentationSections;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getPasportName() {
        return pasportName;
    }

    public void setPasportName(String pasportName) {
        this.pasportName = pasportName;
    }

    public String getPasportDate() {
        return pasportDate;
    }

    public void setPasportDate(String pasportDate) {
        this.pasportDate = pasportDate;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }
}
