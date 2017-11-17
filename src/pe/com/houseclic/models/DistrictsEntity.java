package pe.com.houseclic.models;

        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.ArrayList;
        import java.util.List;

public class DistrictsEntity extends BaseEntity {

    public DistrictsEntity() {
        super();
        setTableName("districts");
    }

    public List<District> findAll() { return findByCriteria(""); }

    public District findById(int id) {
        return findByCriteria(String.format(
                "CodeDistrict = %d", id)).get(0);
    }

    public District findByName(String name) {
        return findByCriteria(String.format(
                "NameDistrict = '%s'", name)).get(0);
    }

    private List<District> findByCriteria(String criteria) {
        try {

            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            criteria.isEmpty() ?
                                    getBaseStatement() :
                                    getBaseStatement()
                                            .concat(" WHERE ")
                                            .concat(criteria));
            List<District> districts = new ArrayList<>();
            while (rs.next())
                districts.add(District.from(rs));
            return districts;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public District create(District district) {
        return executeUpdate(String.format(
                "INSERT INTO %s(CodeDistrict, NameDistrict) VALUES (%d, '%s')",
                getTableName(), district.getId(), district.getName())) ?
                district : null;
    }
    private int getMaxId(){
    String sql = "SELECT MAX(CodDisctrict) as max_id FROM district";
    try {
        ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
        return  resultSet.next() ? resultSet.getInt("max_id") : 0;
    }catch (SQLException e) {
        e.printStackTrace();
    }
    return 0;

}
    public District create(String name){
        return  create(getMaxId()+1,name);
    }

    public District create(int id, String name) {
        return create(new District(id, name));
    }

    public boolean update(District district) {
        return executeUpdate(String.format("UPDATE %s SET CodeDistrict = %d, NameDistrict = '%s' WHERE CodeDistrict = %d",
                getTableName(), district.getId(), district.getName(), district.getId()));
    }

    public boolean update(int id, String name) {
        return update(new District(id, name));
    }

    public boolean erase(District district) {
        return executeUpdate(String.format("DELETE FROM %s WHERE CodeDistrict = %d", getTableName(), district.getId()));
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
