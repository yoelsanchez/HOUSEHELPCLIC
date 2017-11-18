package pe.com.houseclic.struts;
import com.opensymphony.xwork2.ActionSupport;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;
//import sun.security.util.Password;

//import java.sql.ResultSet;
//import java.sql.SQLDataException;

public class ContractAction extends ActionSupport {

    private Character CodeContract;
    private Character CodeClient;
    private Character CodeTechnician;
    private Character CodeQuotation;
    private DateTime  DateContract;
    private Double TotalCostContract;
    private String StateContract;
    private String AssistanceReason;
    private Double RatingScore;
    private String RatingState;
    private String RatingCommentary;

    public Character getCodeContract() {
        return CodeContract;
    }

    public void setCodeContract(Character codeContract) {
        CodeContract = codeContract;
    }

    public Character getCodeClient() {
        return CodeClient;
    }

    public void setCodeClient(Character codeClient) {
        CodeClient = codeClient;
    }

    public Character getCodeTechnician() {
        return CodeTechnician;
    }

    public void setCodeTechnician(Character codeTechnician) {
        CodeTechnician = codeTechnician;
    }

    public Character getCodeQuotation() {
        return CodeQuotation;
    }

    public void setCodeQuotation(Character codeQuotation) {
        CodeQuotation = codeQuotation;
    }

    public DateTime getDateContract() {
        return DateContract;
    }

    public void setDateContract(DateTime dateContract) {
        DateContract = dateContract;
    }

    public Double getTotalCostContract() {
        return TotalCostContract;
    }

    public void setTotalCostContract(Double totalCostContract) {
        TotalCostContract = totalCostContract;
    }

    public String getStateContract() {
        return StateContract;
    }

    public void setStateContract(String stateContract) {
        StateContract = stateContract;
    }

    public String getAssistanceReason() {
        return AssistanceReason;
    }

    public void setAssistanceReason(String assistanceReason) {
        AssistanceReason = assistanceReason;
    }

    public Double getRatingScore() {
        return RatingScore;
    }

    public void setRatingScore(Double ratingScore) {
        RatingScore = ratingScore;
    }

    public String getRatingState() {
        return RatingState;
    }

    public void setRatingState(String ratingState) {
        RatingState = ratingState;
    }

    public String getRatingCommentary() {
        return RatingCommentary;
    }

    public void setRatingCommentary(String ratingCommentary) {
        RatingCommentary = ratingCommentary;
    }

    public String execute(){
        return "success";
    }
}
