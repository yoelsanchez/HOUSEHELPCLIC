package pe.com.houseclic.models;

        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.ArrayList;
        import java.util.List;

public class EspecialtiesEntity extends BaseEntity {


    public EspecialtiesEntity() {
        setTableName("Especialties");
    }

//********************************************************************

    public Especialty findById(String id, JobsEntity jobsEntity, TechnicianEntity technicianEntity) {
        return findByCriteria(String.format(
                "CodeSpecialty = '%s'", id), jobsEntity, technicianEntity).get(0);
    }

    public Especialty findByName(String name, JobsEntity jobsEntity, TechnicianEntity technicianEntity) {
        return findByCriteria(String.format(
                "NameSpecialty = '%s'", name), jobsEntity, technicianEntity).get(0);
    }

    public Especialty findByName(String description, JobsEntity jobsEntity, TechnicianEntity technicianEntity) {
        return findByCriteria(String.format(
                "DescriptionSpecialty = '%s'", description), jobsEntity, technicianEntity).get(0);
    }

//*************************************************************************

    public List<Especialty> findAll(EspecialtiesEntity especialtiesEntity) {
        return findByCriteria("", especialtiesEntity);
    }

    private List<Country> findByCriteria(String criteria, RegionsEntity regionsEntity) {
        try {

            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            criteria.isEmpty() ?
                                    getBaseStatement() :
                                    getBaseStatement()
                                            .concat(" WHERE ")
                                            .concat(criteria));
            List<Country> countries = new ArrayList<>();
            while (rs.next())
                countries.add(Country.from(rs, regionsEntity));
            return countries;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean create(Country country) {
        return executeUpdate(String.format(
                "INSERT INTO %s(country_id, country_name, region_id) VALUES ('%s', '%s', %d)",
                getTableName(), country.getId(), country.getName(), country.getRegion().getId()));
    }

    public boolean create(String id, String name, Region region) {
        return create(new Country(id, name, region));
    }

    public boolean update(Country country) {
        return executeUpdate(String.format("UPDATE %s SET country_name = '%s', region_id = %d WHERE country_id = '%s'",
                getTableName(), country.getName(), country.getRegion().getId(), country.getId()));
    }

    public boolean update(String id, String name, Region region) {
        return update(new Country(id, name, region));
    }

    public boolean delete(Country country) {
        return executeUpdate(String.format("DELETE FROM %s WHERE region_id = '%s'",
                getTableName(), country.getId()));
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
