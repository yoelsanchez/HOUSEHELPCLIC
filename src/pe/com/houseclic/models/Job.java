package pe.com.houseclic.models;

        import java.sql.ResultSet;
        import java.sql.SQLException;

public class Job {
    private int id;
    private String name;

    public Job(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }

    public Job setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() { return name; }

    public Job setName(String name) {
        this.name = name;
        return this;
    }

    public static Job from(ResultSet rs) {
        try {
            return (new Job())
            .setId(rs.getInt("CodeJob"))
            .setName(rs.getString("NameJob"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
