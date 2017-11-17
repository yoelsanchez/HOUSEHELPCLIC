package pe.com.houseclic.models;

        import java.sql.ResultSet;
        import java.sql.SQLException;

public class District {
    private int id;
    private String name;

    public District(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public District() {
    }

    public int getId() { return id; }

    public District setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() { return name; }

    public District setName(String name) {
        this.name = name;
        return this;
    }

    public static District from(ResultSet rs) {
        try {
            return (new District())
                    .setId(rs.getInt("CodeDistrict"))
                    .setName(rs.getString("NameDistrict"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
