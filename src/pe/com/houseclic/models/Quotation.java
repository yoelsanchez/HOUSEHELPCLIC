package pe.com.houseclic.models;

        import java.sql.ResultSet;
        import java.sql.SQLException;

public class Quotation {
    private int id;
    private Answer answer;
    private String titlesubject;
    private String detailsubject;
    private String photosubject;
    private String visitcost;
    private String addresssubject;
    private String startsubject;
    private String endsubject;
    private String datesubject;
    private String statequotation;
    private String countanswerquotation;

    public Quotation(int id, Answer answer, String titlesubject, String detailsubject, String photosubject, String visitcost, String addresssubject, String startsubject, String endsubject, String datesubject, String statequotation, String countanswerquotation) {
        this.setId(id);
        this.setAnswer(answer);
        this.setTitleSubject(titlesubject);
        this.setDetailSubject(detailsubject);
        this.setPhotoSubject(photosubject);
        this.setVisitCost(visitcost);
        this.setAddressSubject(addresssubject);
        this.setStartSubject(startsubject);
        this.setEndSubject(endsubject);
        this.setDateSubject(datesubject);
        this.setStateQuotation(statequotation);
        this.setCountAnswerQuotation(countanswerquotation);
    }
//************* POR CAMPO SE HACE **********************************************************************************************

    public int getId() { return id; }

    public Quotation setId(int id) { this.id = id; return this; }

//****************DE LA RELACION CON TABLA ANSWER*****************************************************************************

    public Answer getAnswer() { return answer; }

    public Answer setAnswer(Answer answer) { this.answer = answer; return this; }

//*******************************************************************************************************************************

    public String getTitlesubject() { return titlesubject; }

    public Quotation setTitleSubject (String titlesubject) { this.titlesubject = titlesubject; return this; }

//*******************************************************************************************************************************

    public String getDetailsubject() { return detailsubject; }

    public Quotation setDetailSubject (String detailsubject) { this.detailsubject = detailsubject; return this; }

//*******************************************************************************************************************************

    public String getPhotosubject() { return photosubject; }

    public Quotation setPhotoSubject (String photosubject) { this.photosubject = photosubject; return this; }

//*******************************************************************************************************************************

    public String getVisitcost() { return visitcost; }

    public Quotation setVisitCost (String visitcost) { this.visitcost = visitcost; return this; }

//*******************************************************************************************************************************

    public String getAddresssubject() { return addresssubject; }

    public Quotation setAddressSubject (String addresssubject) { this.addresssubject = addresssubject; return this; }

//*******************************************************************************************************************************

    public String getStartsubject() { return startsubject; }

    public Quotation setStartSubject (String startsubject) { this.startsubject = startsubject; return this; }

//*******************************************************************************************************************************

    public String getEndsubject() { return endsubject; }

    public Quotation setEndSubject (String endsubject) { this.endsubject = endsubject; return this; }

//*******************************************************************************************************************************

    public String getDatesubject() { return datesubject; }

    public Quotation setDateSubject (String datesubject) { this.datesubject = datesubject; return this; }

//*******************************************************************************************************************************

    public String getStatequotation() { return statequotation; }

    public Quotation setStateQuotation (String statequotation) { this.statequotation = statequotation; return this; }

//*******************************************************************************************************************************

    public String getCountanswerquotation() { return countanswerquotation; }

    public Quotation setCountAnswerQuotation (String countanswerquotation) { this.countanswerquotation = countanswerquotation; return this; }

//*******************************************************************************************************************************

    public static Quotation from(ResultSet resultSet, AnswerEntity answerEntity) {
        Quotation quotation = new Quotation();
        try {
            quotation.setId(resultSet.getInt("CodeQuotation"))
                    .setAnswer(AnswerEntity.findById(ResultSet.getInt("CodeAnswer")));
                    .setTitleSubject(resultSet.getString("TitleSubject"));
                    .setDetailSubject(resultSet.getString("DetailSubject"))
                    .setPhotoSubject(resultSet.getString("PhotoSubject"));
                    .setVisitCost(resultSet.getString("VisitCost"));
                    .setAddressSubject(resultSet.getString("AddressSubject"));
                    .setStartSubject(resultSet.getString("StartSubject"));
                    .setEndSubject(resultSet.getString("EndSubject"));
                    .setDateSubject(resultSet.getString("DateSubject"));
                    .setStateQuotation(resultSet.getString("StateQuotation"));
                    .setCountAnswerQuotation(resultSet.getString("CountAnswerQuotation"))

            return quotation;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}