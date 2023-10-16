package ActOfWork.ActOfWork.models;
import javax.persistence.*;

@Entity
public class Act {
    public Act(String object, String customer, String builder, String architect) {
    }

    @Override
    public String toString() {
        return "Act{" +
                "id=" + id +
                ", object='" + object + '\'' +
                ", customer='" + customer + '\'' +
                ", builder='" + builder + '\'' +
                ", architect='" + architect + '\'' +
                ", number_of_act=" + number_of_act +
                ", date='" + date + '\'' +
                ", technical_supervision='" + technical_supervision + '\'' +
                ", builder_face='" + builder_face + '\'' +
                ", builder_supervision='" + builder_supervision + '\'' +
                ", architect_face='" + architect_face + '\'' +
                ", builder_stroy='" + builder_stroy + '\'' +
                ", another_face='" + another_face + '\'' +
                ", builder_short='" + builder_short + '\'' +
                ", job='" + job + '\'' +
                ", project='" + project + '\'' +
                ", material='" + material + '\'' +
                ", docks='" + docks + '\'' +
                ", date_start='" + date_start + '\'' +
                ", date_end='" + date_end + '\'' +
                ", docks_project='" + docks_project + '\'' +
                ", next_work='" + next_work + '\'' +
                ", technical_supervision_name='" + technical_supervision_name + '\'' +
                ", builder_face_name='" + builder_face_name + '\'' +
                ", builder_supervision_name='" + builder_supervision_name + '\'' +
                ", architect_face_name='" + architect_face_name + '\'' +
                ", builder_stroy_name='" + builder_stroy_name + '\'' +
                ", another_face_name1='" + another_face_name1 + '\'' +
                ", another_face_name2='" + another_face_name2 + '\'' +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne
    private DocumentationSections documentationSections;
    @ManyToOne
    private FileDataBase fileDataBase;

    public DocumentationSections getDocumentationSections() {
        return documentationSections;
    }

    public void setDocumentationSections(DocumentationSections documentationSections) {
        this.documentationSections = documentationSections;
    }

    private String object, customer, builder, architect;
    private  int number_of_act;
    private String date;
    private String technical_supervision, builder_face, builder_supervision, architect_face, builder_stroy, another_face;
    private String builder_short, job, project, material, docks;
    private String date_start, date_end, docks_project, next_work;
    private String technical_supervision_name, builder_face_name, builder_supervision_name, architect_face_name, builder_stroy_name, another_face_name1,another_face_name2;

    public Long getId() {
        return id;
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

    public int getNumber_of_act() {
        return number_of_act;
    }

    public void setNumber_of_act(int number_of_act) {
        this.number_of_act = number_of_act;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTechnical_supervision() {
        return technical_supervision;
    }

    public void setTechnical_supervision(String technical_supervision) {
        this.technical_supervision = technical_supervision;
    }

    public String getBuilder_face() {
        return builder_face;
    }

    public void setBuilder_face(String builder_face) {
        this.builder_face = builder_face;
    }

    public String getBuilder_supervision() {
        return builder_supervision;
    }

    public void setBuilder_supervision(String builder_supervision) {
        this.builder_supervision = builder_supervision;
    }

    public String getArchitect_face() {
        return architect_face;
    }

    public void setArchitect_face(String architect_face) {
        this.architect_face = architect_face;
    }

    public String getBuilder_stroy() {
        return builder_stroy;
    }

    public void setBuilder_stroy(String builder_stroy) {
        this.builder_stroy = builder_stroy;
    }

    public String getAnother_face() {
        return another_face;
    }

    public void setAnother_face(String another_face) {
        this.another_face = another_face;
    }

    public String getBuilder_short() {
        return builder_short;
    }

    public void setBuilder_short(String builder_short) {
        this.builder_short = builder_short;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDocks() {
        return docks;
    }

    public void setDocks(String docks) {
        this.docks = docks;
    }

    public String getDate_start() {
        return date_start;
    }

    public void setDate_start(String date_start) {
        this.date_start = date_start;
    }

    public String getDate_end() {
        return date_end;
    }

    public void setDate_end(String date_end) {
        this.date_end = date_end;
    }

    public String getDocks_project() {
        return docks_project;
    }

    public void setDocks_project(String docks_project) {
        this.docks_project = docks_project;
    }

    public String getNext_work() {
        return next_work;
    }

    public void setNext_work(String next_work) {
        this.next_work = next_work;
    }

    public String getTechnical_supervision_name() {
        return technical_supervision_name;
    }

    public void setTechnical_supervision_name(String technical_supervision_name) {
        this.technical_supervision_name = technical_supervision_name;
    }

    public String getBuilder_face_name() {
        return builder_face_name;
    }

    public void setBuilder_face_name(String builder_face_name) {
        this.builder_face_name = builder_face_name;
    }

    public String getBuilder_supervision_name() {
        return builder_supervision_name;
    }

    public void setBuilder_supervision_name(String builder_supervision_name) {
        this.builder_supervision_name = builder_supervision_name;
    }

    public FileDataBase getFileDataBase() {
        return fileDataBase;
    }

    public void setFileDataBase(FileDataBase fileDataBase) {
        this.fileDataBase = fileDataBase;
    }

    public String getArchitect_face_name() {
        return architect_face_name;
    }

    public void setArchitect_face_name(String architect_face_name) {
        this.architect_face_name = architect_face_name;
    }

    public String getBuilder_stroy_name() {
        return builder_stroy_name;
    }

    public void setBuilder_stroy_name(String builder_stroy_name) {
        this.builder_stroy_name = builder_stroy_name;
    }

    public String getAnother_face_name1() {
        return another_face_name1;
    }

    public void setAnother_face_name1(String another_face_name1) {
        this.another_face_name1 = another_face_name1;
    }

    public String getAnother_face_name2() {
        return another_face_name2;
    }

    public void setAnother_face_name2(String another_face_name2) {
        this.another_face_name2 = another_face_name2;
    }


    public Act(String object, String customer, String builder, String architect, int number_of_act, String date, String technical_supervision, String builder_face, String builder_supervision, String architect_face, String builder_stroy, String another_face, String builder_short, String job, String project, String material, String docks, String date_start, String date_end, String docks_project, String next_work, String technical_supervision_name, String builder_face_name, String builder_supervision_name, String architect_face_name, String builder_stroy_name, String another_face_name1, String another_face_name2) {
        this.object = object;
        this.customer = customer;
        this.builder = builder;
        this.architect = architect;
        this.number_of_act = number_of_act;
        this.date = date;
        this.technical_supervision = technical_supervision;
        this.builder_face = builder_face;
        this.builder_supervision = builder_supervision;
        this.architect_face = architect_face;
        this.builder_stroy = builder_stroy;
        this.another_face = another_face;
        this.builder_short = builder_short;
        this.job = job;
        this.project = project;
        this.material = material;
        this.docks = docks;
        this.date_start = date_start;
        this.date_end = date_end;
        this.docks_project = docks_project;
        this.next_work = next_work;
        this.technical_supervision_name = technical_supervision_name;
        this.builder_face_name = builder_face_name;
        this.builder_supervision_name = builder_supervision_name;
        this.architect_face_name = architect_face_name;
        this.builder_stroy_name = builder_stroy_name;
        this.another_face_name1 = another_face_name1;
        this.another_face_name2 = another_face_name2;
    }

    public Act() {
    }

    public Act(DocumentationSections documentationSections, FileDataBase fileDataBase, String object, String customer, String builder, String architect, int number_of_act, String date, String technical_supervision, String builder_face, String builder_supervision, String architect_face, String builder_stroy, String another_face, String builder_short, String job, String project, String material, String docks, String date_start, String date_end, String docks_project, String next_work, String technical_supervision_name, String builder_face_name, String builder_supervision_name, String architect_face_name, String builder_stroy_name, String another_face_name1, String another_face_name2) {
        this.documentationSections = documentationSections;
        this.fileDataBase = fileDataBase;
        this.object = object;
        this.customer = customer;
        this.builder = builder;
        this.architect = architect;
        this.number_of_act = number_of_act;
        this.date = date;
        this.technical_supervision = technical_supervision;
        this.builder_face = builder_face;
        this.builder_supervision = builder_supervision;
        this.architect_face = architect_face;
        this.builder_stroy = builder_stroy;
        this.another_face = another_face;
        this.builder_short = builder_short;
        this.job = job;
        this.project = project;
        this.material = material;
        this.docks = docks;
        this.date_start = date_start;
        this.date_end = date_end;
        this.docks_project = docks_project;
        this.next_work = next_work;
        this.technical_supervision_name = technical_supervision_name;
        this.builder_face_name = builder_face_name;
        this.builder_supervision_name = builder_supervision_name;
        this.architect_face_name = architect_face_name;
        this.builder_stroy_name = builder_stroy_name;
        this.another_face_name1 = another_face_name1;
        this.another_face_name2 = another_face_name2;
    }

    public Act(DocumentationSections documentationSections,
               String object, String customer, String builder, String architect,
               int number_of_act, String date, String technical_supervision, String builder_face,
               String builder_supervision, String architect_face, String builder_stroy,
               String another_face, String builder_short, String job, String project, String material,
               String docks, String date_start, String date_end, String docks_project, String next_work,
               String technical_supervision_name, String builder_face_name, String builder_supervision_name,
               String architect_face_name, String builder_stroy_name, String another_face_name1, String another_face_name2) {

        this.documentationSections = documentationSections;
        this.object = object;
        this.customer = customer;
        this.builder = builder;
        this.architect = architect;
        this.number_of_act = number_of_act;
        this.date = date;
        this.technical_supervision = technical_supervision;
        this.builder_face = builder_face;
        this.builder_supervision = builder_supervision;
        this.architect_face = architect_face;
        this.builder_stroy = builder_stroy;
        this.another_face = another_face;
        this.builder_short = builder_short;
        this.job = job;
        this.project = project;
        this.material = material;
        this.docks = docks;
        this.date_start = date_start;
        this.date_end = date_end;
        this.docks_project = docks_project;
        this.next_work = next_work;
        this.technical_supervision_name = technical_supervision_name;
        this.builder_face_name = builder_face_name;
        this.builder_supervision_name = builder_supervision_name;
        this.architect_face_name = architect_face_name;
        this.builder_stroy_name = builder_stroy_name;
        this.another_face_name1 = another_face_name1;
        this.another_face_name2 = another_face_name2;
    }
}


