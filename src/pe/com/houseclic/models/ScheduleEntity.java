package pe.com.houseclic.models;

        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.ArrayList;
        import java.util.List;

public class ScheduleEntity extends BaseEntity {


    public ScheduleEntity() {
        super();
        setTableName("Schedule");
    }

    //***********************************************************************************************************

    public List<Schedule> findAll(DetailScheduleEntity detailScheduleEntity) {
        return findByCriteria("", detailScheduleEntity);
    }

    private List<Schedule> findByCriteria(String criteria, DetailScheduleEntity detailScheduleEntity) {
        try {

            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            criteria.isEmpty() ?
                                    getBaseStatement() :
                                    getBaseStatement()
                                            .concat(" WHERE ")
                                            .concat(criteria));
            List<Schedule> schedule = new ArrayList<>();
            while (rs.next())
                schedule.add(Schedule.from(rs, detailScheduleEntity));
            return schedule;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean create(Schedule schedule) {
        return executeUpdate(String.format(
                "INSERT INTO %s(CodeSchedule, CodeDetailSchedule, FrequencySchedule, DaysSchedule) VALUES (%d, %d, '%s', '%s')",
                getTableName(), schedule.getId(), schedule.getDetailSchedule(), schedule.getFrecuencySchedule(), schedule.getDaysSchedule()));
    }

    public boolean create(int id, DetailSchedule detailSchedule, String frecuencySchedule, String daysSchedule) {
        return create(new Schedule(id, detailSchedule, frecuencySchedule, daysSchedule));
    }

    public boolean update(Schedule schedule) {
        return executeUpdate(String.format("UPDATE %s SET CodeDetailSchedule = %d, FrecuencySchedule = '%s', DaysSchedule = '%s' WHERE CodeSchedule = %d",
                getTableName(), schedule.getId(), schedule.getDetailSchedule(), schedule.getFrecuencySchedule(), schedule.getDaysSchedule()));
    }

    public boolean update(int id, DetailSchedule detailSchedule, String frecuencySchedule, String daysSchedule) {
        return update(new Schedule(id, detailSchedule, frecuencySchedule, daysSchedule));
    }

    public boolean delete(Schedule schedule) {
        return executeUpdate(String.format("DELETE FROM %s WHERE CodeSchedule = '%s'",
                getTableName(), schedule.getId()));
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