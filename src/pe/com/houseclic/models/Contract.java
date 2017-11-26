package pe.com.houseclic.models;

        import java.sql.ResultSet;
        import java.sql.SQLException;

public class Contract {
    private int id;
    private String dateContract;
    private String totalCostContract;
    private String stateContract;
    private String assistanceReason;
    private String ratingScore;
    private String ratingState;
    private String ratingCommentary;

    public Contract(int id, String dateContract, String totalCostContract, String stateContract, String assistanceReason, String ratingScore, String ratingState, String ratingCommentary) {
        this.setId(id);
        this.setDateContract(dateContract);
        this.setTotalCostContract(totalCostContract);
        this.setStateContract(stateContract);
        this.setAssistanceReason(assistanceReason);
        this.setRatingScore(ratingScore);
        this.setRatingState(ratingState);
        this.setRatingCommentary(ratingCommentary);
    }
//************* POR CAMPO SE HACE **********************************************************************************************

    public int getId() { return id; }

    public Contract setId(int id) { this.id = id; return this; }

//*******************************************************************************************************************************

    public String getDateContract() { return dateContract; }

    public Contract setDateContract (String dateContract) { this.dateContract = dateContract; return this; }

//*******************************************************************************************************************************

    public String getTotalCostContract() { return totalCostContract; }

    public Contract setTotalCostContract (String totalCostContract) { this.totalCostContract = totalCostContract; return this; }

//*******************************************************************************************************************************

    public String getStateContract() { return stateContract; }

    public Contract setStateContract (String stateContract) { this.stateContract = stateContract; return this; }

//*******************************************************************************************************************************

    public String getAssistanceReason() { return assistanceReason; }

    public Contract setAssistanceReason (String assistanceReason) { this.assistanceReason = assistanceReason; return this; }

//*******************************************************************************************************************************

    public String getRatingScore() { return ratingScore; }

    public Contract setRatingScore (String ratingScore) { this.ratingScore = ratingScore; return this; }

//*******************************************************************************************************************************

    public String getRatingState() { return ratingState; }

    public Contract setRatingState (String ratingState) { this.ratingState = ratingState; return this; }

//*******************************************************************************************************************************

    public String getRatingCommentary() { return ratingCommentary; }

    public Contract setRatingCommentary (String ratingCommentary) { this.ratingCommentary = ratingCommentary; return this; }

//*******************************************************************************************************************************

    public static Contract from(ResultSet resultSet) {
        Contract contract = new Contract();
        try {
            contract.setId(resultSet.getInt("CodeCotract"))
                    .setDateContract(resultSet.getString("NameTech"))
                    .setTotalCostContract(resultSet.getString("TotalCostContract"))
                    .setStateContract(resultSet.getString("StateContract"))
                    .setAssistanceReason(resultSet.getString("AssistanceReason"))
                    .setRatingScore(resultSet.getString("RatingScore"))
                    .setRatingState(resultSet.getString("RatingState"))
                    .setRatingCommentary(resultSet.getString("RatingCommentary"));

            return contract;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
