package pe.com.houseclic.models;

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

    public boolean create(int id, Answer answer, String titlesubject, String detailsubject, String photosubject, String visitcost, String addresssubject, String startsubject, String endsubject, String datesubject, String statequotation, String countanswerquotation) {
        return create(new Quotation(id, answer, titlesubject, detailsubject, photosubject, visitcost, addresssubject, startsubject, endsubject, datesubject, statequotation, countanswerquotation));
    }

    public boolean update(Quotation quotation) {
        return executeUpdate(String.format("UPDATE %s SET CodeAnswer = %d, TitleSubject = '%s', DetailSubject = '%s', PhotoSubject = '%s', VisitCost = '%s', AddressSubject = '%s', StartSubject = '%s', EndSubject = '%s', DateSubject = '%s', StateSubject = '%s', CountAnswerQuotation WHERE CodeQuotation = %d",
                getTableName(), quotation.getId(), quotation.getAnswer(), quotation.getTitlesubject(), quotation.getDetailsubject(), quotation.getPhotosubject(), quotation.getVisitcost(), quotation.getAddresssubject(), quotation.getStartsubject(), quotation.getEndsubject(), quotation.getDatesubject(), quotation.getStartsubject(), quotation.getCountanswerquotation()));
    }

    public boolean update(int id, Answer answer, String titlesubject, String detailsubject, String photosubject, String visitcost, String addresssubject, String startsubject, String endsubject, String datesubject, String statequotation, String countanswerquotation) {
        return update(new Quotation(id, answer, titlesubject, detailsubject, photosubject, visitcost, addresssubject, startsubject, endsubject, datesubject, statequotation, countanswerquotation));
    }

    public boolean delete(Quotation quotation) {
        return executeUpdate(String.format("DELETE FROM %s WHERE CodeQuotation = '%s'",
                getTableName(), quotation.getId()));
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