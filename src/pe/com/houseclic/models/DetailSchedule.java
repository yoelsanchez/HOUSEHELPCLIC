package pe.com.houseclic.models;

        import java.sql.ResultSet;
        import java.sql.SQLException;

public class DetailSchedule {
    private int id;
    private String startSchedule;
    private String endSchedule;

    public DetailSchedule(int id, String startSchedule, String endSchedule) {
        this.id = id;
        this.startSchedule = startSchedule;
        this.endSchedule = endSchedule;
    }

    public int getId() { return id; }

    public DetailSchedule setId(int id) {
        this.id = id;
        return this;
    }

    public String getStartSchedule() { return startSchedule; }

    public DetailSchedule setStartSchedule (String startSchedule) {
        this.startSchedule = startSchedule;
        return this;
    }

    public String getEndSchedule() { return endSchedule; }

    public DetailSchedule setEndSchedule (String endSchedule) {
        this.endSchedule = endSchedule;
        return this;
    }

    public static DetailSchedule from(ResultSet rs) {
        try {
            return (new DetailSchedule())
                    .setId(rs.getInt("CodeDetailSchedule"))
                    .setStartSchedule(rs.getString("StartSchedule"))
                    .setEndSchedue(rs.getString("EndSchedule"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}