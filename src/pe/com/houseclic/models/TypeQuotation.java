package pe.com.houseclic.models;

        import java.sql.ResultSet;
        import java.sql.SQLException;

public class TypeQuotation {
    private int id;
    private Quotation quotation;
    private String name;
    private String description;

    public Especialty(int id, Quotation quotation, String name, String description) {
        this.setId(id);
        this.setQuotation(quotation);
        this.setName(name);
        this.setDescription(description);
    }
//************* POR CAMPO SE HACE **********************************************************************************************

    public int getId() { return id; }

    public TypeQuotation setId(int id) { this.id = id; return this; }

//****************DE LA RELACION CON QUOTATION*****************************************************************************

    public Quotation getQuotation() { return Quotation; }

    public Quotation setQuotation(Quotation quotation) { this.quotation = quotation; return this; }

//*******************************************************************************************************************************

    public String getName() { return name; }

    public TypeQuotation setName (String name) { this.name = name; return this; }

//*******************************************************************************************************************************

    public String getDescription() { return description; }

    public TypeQuotation setDescription (String description) { this.description = description; return this; }


//*******************************************************************************************************************************

    public static TypeQuotation from(ResultSet resultSet, QuotationEntity QuotationEntity) {
        TypeQuotation typeQuotation = new TypeQuotation();
        try {
            typeQuotation.setId(resultSet.getInt("CodeTypeQuotation"))
                    .setQuotation(Quotation.findById(ResultSet.getInt("CodeQuotation")));
                    .setName(resultSet.getString("NameTypeQ"));
                    .setDescription(resultSet.getString("DescriptionTypeQ"));

            return TypeQuotation;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}