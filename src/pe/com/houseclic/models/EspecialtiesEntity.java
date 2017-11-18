package pe.com.houseclic.models;

        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.ArrayList;
        import java.util.List;

public class EspecialtiesEntity extends BaseEntity {


    public EspecialtiesEntity() {
        super();
        setTableName("Especialties");
    }

    //***********************************************************************************************************

    public List<Especialty> findAll(JobsEntity jobsEntity) {
        return findByCriteria("",  jobsEntity);
    }

    private List<Especialty> findByCriteria(String criteria, JobsEntity jobsEntity) {
        try {

            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            criteria.isEmpty() ?
                                    getBaseStatement() :
                                    getBaseStatement()
                                            .concat(" WHERE ")
                                            .concat(criteria));
            List<Especialty> especialties = new ArrayList<>();
            while (rs.next())
                especialties.add(Especialty.from(rs, jobsEntity));
            return especialties;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean create(Especialty especialty) {
        return executeUpdate(String.format(
                "INSERT INTO %s(CodeSpecialty, CodeJob, CodeTechnician, NameSpecialty, DescriptionSpecialty) VALUES ('%s', %d, %d, '%s', '%s')",
                getTableName(), especialty.getId(), especialty.getJob(), especialty.getTechnician(), especialty.getName(), especialty.getDescription()));
    }

    public boolean create(int id, Job job, Technician technician, String name, String description) {
        return create(new Especialty(id, job, technician, name, description));
    }

    public boolean update(Especialty especialty) {
        return executeUpdate(String.format("UPDATE %s SET CodeJob = %d, CodeTechnician = %d, NameSpecialty = '%s', DescriptionSpecialty = '%s'  WHERE CodeSpecialty = '%s'",
                getTableName(), especialty.getId(), especialty.getJob(), especialty.getTechnician(), especialty.getName(), especialty.getDescription()));
    }

    public boolean update(int id, Job job, Technician technician, String name, String description) {
        return update(new Especialty(id, job, technician, name, description));
    }

    public boolean delete(Especialty especialty) {
        return executeUpdate(String.format("DELETE FROM %s WHERE CodeSpecialty = '%s'",
                getTableName(), especialty.getId()));
    }

    private boolean executeUpdate(String sql) {
        try {
            int result = getConnection().createStatement().executeUpdate(sql);
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
