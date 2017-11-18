package pe.com.houseclic.struts;
import com.opensymphony.xwork2.ActionSupport;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;
//import sun.security.util.Password;

//import java.sql.ResultSet;
//import java.sql.SQLDataException;
public class AnswerAction extends ActionSupport {
    private Character CodeAnswer;
    private Character CodeTechnician;
    private Character CodeQuotation;
    private Character CodeClient;
    private DateTime  DateAnswer;
    private String CommentAnswer;
    private Double PriceAnswer;

    public Character getCodeAnswer() {
        return CodeAnswer;
    }

    public void setCodeAnswer(Character codeAnswer) {
        CodeAnswer = codeAnswer;
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

    public Character getCodeClient() {
        return CodeClient;
    }

    public void setCodeClient(Character codeClient) {
        CodeClient = codeClient;
    }

    public DateTime getDateAnswer() {
        return DateAnswer;
    }

    public void setDateAnswer(DateTime dateAnswer) {
        DateAnswer = dateAnswer;
    }

    public String getCommentAnswer() {
        return CommentAnswer;
    }

    public void setCommentAnswer(String commentAnswer) {
        CommentAnswer = commentAnswer;
    }

    public Double getPriceAnswer() {
        return PriceAnswer;
    }

    public void setPriceAnswer(Double priceAnswer) {
        PriceAnswer = priceAnswer;
    }

    public String execute(){
        return "success";
    }
}