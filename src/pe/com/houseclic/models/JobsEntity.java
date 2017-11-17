package pe.com.houseclic.models;

        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.ArrayList;
        import java.util.List;

public class JobsEntity extends BaseEntity {

    public JobsEntity() {
        super();
        setTableName("job");
    }

    public List<Job> findAll() { return findByCriteria(""); }

    public Job findById(int id) {
        return findByCriteria(String.format(
                "CodeJob = %d", id)).get(0);
    }

    public Job findByName(String name) {
        return findByCriteria(String.format(
                "NameJob = '%s'", name)).get(0);
    }

    private List<Job> findByCriteria(String criteria) {
        try {

            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            criteria.isEmpty() ?
                                    getBaseStatement() :
                                    getBaseStatement()
                                            .concat(" WHERE ")
                                            .concat(criteria));
            List<Job> Jobs = new ArrayList<>();
            while (rs.next())
                Jobs.add(Job.from(rs));
            return Jobs;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean create(Job job) {
        return executeUpdate(String.format(
                "INSERT INTO %s(CodeJob, NameJob) VALUES (%d, '%s')",
                getTableName(), job.getId(), job.getName()));
    }

    public boolean create(int id, String name) {
        return create(new Job(id, name));
    }

    public boolean update(Job job) {
        return executeUpdate(String.format("UPDATE %s SET CodeJob = %d, NameJob = '%s' WHERE CodeJob = %d",
                getTableName(), job.getId(), job.getName(), job.getId()));
    }

    public boolean update(int id, String name) {
        return update(new Job(id, name));
    }

    public boolean erase(Job job) {
        return executeUpdate(String.format("DELETE FROM %s WHERE CodeJob = %d", getTableName(), job.getId()));
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
