package pe.com.houseclic.models;

        import java.sql.ResultSet;
        import java.sql.SQLException;

public class Schedule {
    private int id;
    private String name;

    public Schedule(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Schedule() {
    }

    public int getId() { return id; }

    public Schedule setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() { return name; }

    public Schedule setName(String name) {
        this.name = name;
        return this;
    }

    public static Schedule from(ResultSet rs) {
        try {
            return (new Schedule())
                    .setId(rs.getInt("CodeJob"))
                    .setName(rs.getString("NameJob"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
