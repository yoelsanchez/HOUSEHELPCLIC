package pe.com.houseclic.models;

        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.ArrayList;
        import java.util.List;

public class DetailScheduleEntity extends BaseEntity {

    public DetailScheduleEntity() {
        super();
        setTableName("DetailSchedule");
    }

    public List<DetailSchedule> findAll() { return findByCriteria(""); }

    public DetailSchedule findById(int id) {
        return findByCriteria(String.format(
                "CodeDetailSchedule = %d", id)).get(0);
    }

    public DetailSchedule findByStartSchedule(String startSchedule) {
        return findByCriteria(String.format(
                "StartSchedule = '%s'", startSchedule)).get(0);
    }

    public DetailSchedule findByEndSchedule(String endSchedule) {
        return findByCriteria(String.format(
                "EndSchedule = '%s'", endSchedule)).get(0);
    }

    private List<DetailSchedule> findByCriteria(String criteria) {
        try {

            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            criteria.isEmpty() ?
                                    getBaseStatement() :
                                    getBaseStatement()
                                            .concat(" WHERE ")
                                            .concat(criteria));
            List<DetailSchedule> DetailSchedules = new ArrayList<>();
            while (rs.next())
                DetailSchedules.add(DetailSchedule.from(rs));
            return DetailSchedules;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean create(DetailSchedule detailSchedule) {
        return executeUpdate(String.format(
                "INSERT INTO %s(CodeDetailSchedule, StartSchedule, EndSchedule) VALUES (%d, '%s', '%s')",
                getTableName(), detailSchedule.getId(), detailSchedule.getStartSchedule(), detailSchedule.getEndSchedule()));
    }

    public boolean create(int id, String starSchedule, String endSchedule) {
        return create(new DetailSchedule(id, starSchedule, endSchedule));
    }

    public boolean update(DetailSchedule detailSchedule) {
        return executeUpdate(String.format("UPDATE %s SET StartSchedule = '%s', EndSchedule = '%s' WHERE CodeDetailSchedule = %d",
                getTableName(), detailSchedule.getId(), detailSchedule.getStartSchedule(), detailSchedule.getEndSchedule()));
    }

    public boolean update(int id, String starSchedule, String endSchedule) {
        return update(new DetailSchedule(id, starSchedule, endSchedule));
    }

    public boolean erase(DetailSchedule detailSchedule) {
        return executeUpdate(String.format("DELETE FROM %s WHERE CodeDetailSchedule = %d", getTableName(), detailSchedule.getId()));
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