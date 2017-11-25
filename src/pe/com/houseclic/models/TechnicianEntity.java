package pe.com.houseclic.models;

        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.ArrayList;
        import java.util.List;

public class TechnicianEntity extends BaseEntity {


    public TechnicianEntity() {
        super();
        setTableName("Technician");
    }

    //***********************************************************************************************************

    public List<Technician> findAll(DistrictsEntity districtsEntity, DetailScheduleEntity detailScheduleEntity, ContractEntity contractEntity, TypeQuotationEntity typeQuotationEntity) {
        return findByCriteria("", districtsEntity, detailScheduleEntity, contractEntity, typeQuotationEntity);
    }

    private List<Technician> findByCriteria(String criteria, DistrictsEntity districtsEntity, DetailScheduleEntity detailScheduleEntity, ContractEntity contractEntity, TypeQuotationEntity typeQuotationEntity) {
        try {

            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            criteria.isEmpty() ?
                                    getBaseStatement() :
                                    getBaseStatement()
                                            .concat(" WHERE ")
                                            .concat(criteria));
            List<Technician> technician = new ArrayList<>();
            while (rs.next())
                technician.add(Technician.from(rs, districtsEntity, detailScheduleEntity, contractEntity, typeQuotationEntity));
            return technician;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean create(Technician technician) {
        return executeUpdate(String.format(
                "INSERT INTO %s(CodeTechnician, CodeDistrict, CodeDetailSchedule, CodeContract, CodeTypeQuotation, NameTech, LastNameTech, DniTech, AgeTech, CellPhoneTech, DescriptionTech, PhotoTech, PasswordTech) VALUES (%d, %d, %d, %d, %d, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                getTableName(), technician.getId(), technician.getDistrict(), technician.getDetailSchedule(), technician.getContract(), technician.getTypeQuotation(), technician.getName(), technician.getLastname(), technician.getDni(), technician.getAge(), technician.getCell(), technician.getDescription(), technician.getPhoto(), technician.getPass()));
    }

    public boolean create(int id, District district, DetailSchedule detailSchedule, Contract contract, TypeQuotation typeQuotation, String name, String lastname, String dni, String age, String cell, String description, String photo, String pass) {
        return create(new Technician(id, district, detailSchedule, contract, typeQuotation, name, lastname, dni, age, cell, description, photo, pass));
    }

    public boolean update(Technician technician) {
        return executeUpdate(String.format("UPDATE %s SET CodeDistrict = %d, CodeDetailSchedule = %d, CodeContract = %d, CodeTypeQuotation = %d, NameTech = '%s', LastNameTech = '%s', DniTech = '%s', AgeTech = '%s', CellPhoneTech = '%s', DescriptionTech = '%s', PhotoTech = '%s', PasswordTech = '%s' WHERE CodeTechnician = %d",
                getTableName(), technician.getId(), technician.getDistrict(), technician.getDetailSchedule(), technician.getContract(), technician.getTypeQuotation(), technician.getName(), technician.getLastname(), technician.getDni(), technician.getAge(), technician.getCell(), technician.getDescription(), technician.getPhoto(), technician.getPass()));
    }

    public boolean update(int id, District district, DetailSchedule detailSchedule, Contract contract, TypeQuotation typeQuotation, String name, String lastname, String dni, String age, String cell, String description, String photo, String pass) {
        return update(new Technician(id, district, detailSchedule, contract, typeQuotation, name, lastname, dni, age, cell, description, photo, pass));
    }

    public boolean delete(Technician technician) {
        return executeUpdate(String.format("DELETE FROM %s WHERE CodeTechnician = '%s'",
                getTableName(), technician.getId()));
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