package pe.com.houseclic.models;

        import java.lang.reflect.Type;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.ArrayList;
        import java.util.List;

public class TypeQuotationEntity extends BaseEntity {


    public TypeQuotationEntity() {
        super();
        setTableName("TypeQuotations");
    }

    //***********************************************************************************************************

    public List<TypeQuotation> findAll(QuotationEntity) {
        return findByCriteria("", quotationEntity);
    }

    private List<TypeQuotation> findByCriteria(String criteria, QuotationEntity quotationEntity) {
        try {

            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            criteria.isEmpty() ?
                                    getBaseStatement() :
                                    getBaseStatement()
                                            .concat(" WHERE ")
                                            .concat(criteria));
            List<TypeQuotation> typeQuotations = new ArrayList<>();
            while (rs.next())
                typeQuotations.add(Technician.from(rs, QuotationEntity));
            return typeQuotations;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean create(TypeQuotation typeQuotation) {
        return executeUpdate(String.format(
                "INSERT INTO %s(CodeTypeQuotation, CodeQuotation, NameTypeQ, DescriptionTypeQ) VALUES (%d, %d, '%s', '%s')",
                getTableName(), typeQuotation.getId(), typeQuotation.getQuotation(), typeQuotation.getName(), typeQuotation.getDescription()));
    }

    public boolean create(int id, quotation, String name, String description) {
        return create(new TypeQuotation(id, quotation, name,description));
    }

    public boolean update(TypeQuotation typeQuotation) {
        return executeUpdate(String.format("UPDATE %s SET CodeQuotation = %d, NameTypeQ = '%s', DescriptionTypeQ = '%s' WHERE CodeTypeQuotation = %d",
                getTableName(), typeQuotation.getId(), typeQuotation.getQuotation(), typeQuotation.getName(), typeQuotation.getDescription()));
    }

    public boolean update(int id, Quotation quotation, String name, String description) {
        return update(new TypeQuotation(id, quotation, name, description));
    }

    public boolean delete(TypeQuotation typeQuotation) {
        return executeUpdate(String.format("DELETE FROM %s WHERE CodeTypeQuotation = '%s'",
                getTableName(), typeQuotation.getId()));
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