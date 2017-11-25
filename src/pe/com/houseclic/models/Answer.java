package pe.com.houseclic.models;

        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.AbstractQueue;

public class Answer {
    private int id;
    private Technician technician;
    private Client client;
    private String dateAnswer;
    private String commentAnswer;
    private String priceAnswer;

    public Quotation(int id, Technician technician, Client client, String dateAnswer, String commentAnswer, String priceAnswer) {
        this.setId(id);
        this.setTechnician(technician);
        this.setClient(client);
        this.setDateAnswer(dateAnswer);
        this.setCommentAnswer(commentAnswer);
        this.setPriceAnswer(priceAnswer);
    }
//************* POR CAMPO SE HACE **********************************************************************************************

    public int getId() { return id; }

    public Answer setId(int id) { this.id = id; return this; }

//****************DE LA RELACION CON TABLA TECHNICIAN*****************************************************************************

    public Technician getTechnician() { return technician; }

    public Technician setTechnician(Technician technician) { this.technician = technician; return this; }

//****************DE LA RELACION CON TABLA CLIENT*****************************************************************************

    public Client getClient() { return client; }

    public Client setClient (Client client) { this.client = client; return this; }

//*******************************************************************************************************************************

    public String getDateAnswer() { return dateAnswer; }

    public Answer setDateAnswer (String dateAnswer) { this.dateAnswer = dateAnswer; return this; }

//*******************************************************************************************************************************

    public String getCommentAnswer() { return commentAnswer; }

    public Answer setCommentAnswer (String commentAnswer) { this.commentAnswer = commentAnswer; return this; }

//*******************************************************************************************************************************

    public String getPriceAnswer() { return priceAnswer; }

    public Answer setPriceAnswer (String priceAnswer) { this.priceAnswer = priceAnswer; return this; }

//*******************************************************************************************************************************

    public static Answer from(ResultSet resultSet, TechnicianEntity technicianEntity, ClientEntity clientEntity) {
        Answer answer = new Answer();
        try {
            answer.setId(resultSet.getInt("CodeAnswer"))
                    .setTechnician(TechnicianEntity.findById(ResultSet.getInt("CodeTechnician")))
                    .setClient(ClientEntity.finById(ResultSet.getInt("CodeClient")))
                    .setDateAnswer(resultSet.getString("DateAnswer"))
                    .setCommentAnswer(resultSet.getString("CommentAnswer"))
                    .setPriceAnswer(resultSet.getString("PriceAswer"));

            return answer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}