package pe.com.houseclic.struts;
import com.opensymphony.xwork2.ActionSupport;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;
//import sun.security.util.Password;

//import java.sql.ResultSet;
//import java.sql.SQLDataException;
public class QuotationAction extends ActionSupport {
    private Character CodeQuotation;
    private Character CodeClient;
    private Character CodeTypeQuotation;
    private Character CodeJob;
    private String TitleSubject;
    private String DetailSubject;
    private Double VisitCost;
    private String AddressSubject;
    private Character StartSubject;
    private Character EndSubject;
    private DateTime DateSubject;
    private String  StateQuotation;
    private Integer CountAnswerQuotation;

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

    public Character getCodeTypeQuotation() {
        return CodeTypeQuotation;
    }

    public void setCodeTypeQuotation(Character codeTypeQuotation) {
        CodeTypeQuotation = codeTypeQuotation;
    }

    public Character getCodeJob() {
        return CodeJob;
    }

    public void setCodeJob(Character codeJob) {
        CodeJob = codeJob;
    }

    public String getTitleSubject() {
        return TitleSubject;
    }

    public void setTitleSubject(String titleSubject) {
        TitleSubject = titleSubject;
    }

    public String getDetailSubject() {
        return DetailSubject;
    }

    public void setDetailSubject(String detailSubject) {
        DetailSubject = detailSubject;
    }

    public Double getVisitCost() {
        return VisitCost;
    }

    public void setVisitCost(Double visitCost) {
        VisitCost = visitCost;
    }

    public String getAddressSubject() {
        return AddressSubject;
    }

    public void setAddressSubject(String addressSubject) {
        AddressSubject = addressSubject;
    }

    public Character getStartSubject() {
        return StartSubject;
    }

    public void setStartSubject(Character startSubject) {
        StartSubject = startSubject;
    }

    public Character getEndSubject() {
        return EndSubject;
    }

    public void setEndSubject(Character endSubject) {
        EndSubject = endSubject;
    }

    public DateTime getDateSubject() {
        return DateSubject;
    }

    public void setDateSubject(DateTime dateSubject) {
        DateSubject = dateSubject;
    }

    public String getStateQuotation() {
        return StateQuotation;
    }

    public void setStateQuotation(String stateQuotation) {
        StateQuotation = stateQuotation;
    }

    public Integer getCountAnswerQuotation() {
        return CountAnswerQuotation;
    }

    public void setCountAnswerQuotation(Integer countAnswerQuotation) {
        CountAnswerQuotation = countAnswerQuotation;
    }
    public String execute(){
        return "success";
    }
}