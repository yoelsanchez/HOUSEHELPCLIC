package pe.com.houseclic.models;

        import com.oracle.wls.shaded.org.apache.xpath.operations.Quo;
        import javafx.util.converter.ShortStringConverter;

        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.ArrayList;
        import java.util.List;

public class QuotationEntity extends BaseEntity {


    public QuotationEntity() {
        super();
        setTableName("Quotation");
    }

    //***********************************************************************************************************

    public List<Quotation> findAll(AnswerEntity answerEntity) {
        return findByCriteria("", answerEntity);
    }

    private List<Quotation> findByCriteria(String criteria, AnswerEntity answerEntity) {
        try {

            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            criteria.isEmpty() ?
                                    getBaseStatement() :
                                    getBaseStatement()
                                            .concat(" WHERE ")
                                            .concat(criteria));
            List<Quotation> quotations = new ArrayList<>();
            while (rs.next())
                quotations.add(Quotation.from(rs, answerEntity));
            return quotations;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean create(Quotation quotation) {
        return executeUpdate(String.format(
                "INSERT INTO %s(CodeQuotation, CodeAnswer, TitleSubject, DetailSubject, PhotoSubject, VisitCost, AddressSubject) VALUES (%d, %d, '%s', '%s', '%s', '%s', '%s')",
                getTableName(), quotation.getId(), quotation.getAnswer(), quotation.getTitlesubject(), quotation.getDetailsubject(), quotation.getPhotosubject(), quotation.getVisitcost(), quotation.getAddresssubject()));
    }

    public boolean create(int id, Answer answer, String titlesubject, String ) {
        return create(new Technician(id, district, detailSchedule, contract, typeQuotation, name, lastname, dni, age, cell, description, photo, pass));
    }

    public boolean update(Technician technician) {
        return executeUpdate(String.format("UPDATE %s SET CodeDistrict = %d, CodeDetailSchedule = %d, CodeContract = %d, CodeTypeQuotation = %d, CodeTechnician = %d, NameTech = '%s', LastNameTech = '%s', DniTech = '%s', AgeTech = '%s', CellPhoneTech = '%s', DescriptionTech = '%s', PhotoTech = '%s', PasswordTech = '%s' WHERE CodeTechnician = %d",
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