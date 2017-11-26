package pe.com.houseclic.models;

        import java.sql.ResultSet;
        import java.sql.SQLException;

public class Schedule {
    private int id;
    private DetailSchedule detailSchedule;
    private String frecuencySchedule;
    private String daysSchedule;

    public Schedule(int id, DetailSchedule detailSchedule, String frecuencySchedule, String daysSchedule) {
        this.setId(id);
        this.setDetailSchedule(detailSchedule);
        this.setFrecuencySchedule(frecuencySchedule);
        this.setDaysSchedule(daysSchedule);
    }
//************* POR CAMPO SE HACE **********************************************************************************************

    public int getId() {
        return id;
    }

    public Schedule setId(int id) {
        this.id = id;
        return this;
    }

//****************DE LA RELACION CON TABLA DETALSCHEDULE*****************************************************************************

    public DetailSchedule getDetailSchedule() {
        return detailSchedule;
    }

    public Schedule setDetailSchedule(DetailSchedule detailSchedule) {
        this.detailSchedule = detailSchedule;
        return this;
    }

//*******************************************************************************************************************************

    public String getFrecuencySchedule() {
        return frecuencySchedule;
    }

    public Schedule setFrecuencySchedule(String frecuencySchedule) {
        this.frecuencySchedule = frecuencySchedule;
        return this;
    }

//*******************************************************************************************************************************

    public String getDaysSchedule() {
        return daysSchedule;
    }

    public Schedule setDaysSchedule(String daysSchedule) {
        this.daysSchedule = daysSchedule;
        return this;
    }

//*******************************************************************************************************************************

    public static Schedule from(ResultSet resultSet, DetailScheduleEntity detailScheduleEntity) {
        Schedule schedule = new Schedule();
        try {
            schedule.setId(resultSet.getInt("CodeTechnician"))
                    .setDetailSchedule(DetailSchedule.findById(ResultSet.getInt("CodeDetailSchedule")))
                    .setFrecuencySchedule(resultSet.getString("FrecuencySchedule"))
                    .setDaysSchedule(resultSet.getString("DaysSchedule"));

            return schedule;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}