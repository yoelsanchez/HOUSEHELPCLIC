package pe.com.houseclic.models;

        import java.sql.ResultSet;
        import java.sql.SQLException;

public class Especialty {
    private int id;
    private Job job;
    private Technician technician;
    private String name;
    private String description;

    public Especialty(int id, Job job, Technician technician, String name, String description) {
        this.setId(id);
        this.setJob(job);
        this.setTechnician(technician);
        this.setName(name);
        this.setDescription(description)
    }
//************* POR CAMPO SE HACE *******************************************************

    public int getId() { return id; }

    public Especialty setId(int id) { this.id = id; return this; }

//****************DE LA RELACION CON TABLA JOB********************************************

    public Job getJob() { return job; }

    public Especialty setJob(Job job) { this.job = job; return this; }

//*************** DE LA RELACION CON LA  TABLA TECHNICIAN*********************************************

    public Technician getTechnician() { return technician; }

    public Especialty setTechnician(Technician technician) { this.technician = technician; return this; }

//************************************************************

    public String getName() { return name; }

    public Especialty setName(String name) { this.name = name; return this; }

//************************************************************

    public String getDescription() { return description; }

    public Especialty setDescription(String description) { this.description = description; return this; }

//************************************************************

    public static Especialty from(ResultSet resultSet, JobsEntity jobsEntity) {
        Especialty especialty = new Especialty();
        try {
                    especialty.setId(resultSet.getInt("CodeSpecialty"))
                    .setJob(JobsEntity.findById(ResultSet.getInt("job_id")));
                    .setTechnician(TechnicianEntity.findById(ResultSet.getInt("technician_id")));
                    .setName(resultSet.getString("NameSpecialty"));
                    .setDescription(resultSet.getString("DescriptionSpecialty"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
