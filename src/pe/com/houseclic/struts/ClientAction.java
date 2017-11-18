package pe.com.houseclic.struts;
import com.opensymphony.xwork2.ActionSupport;
//import sun.security.util.Password;

//import java.sql.ResultSet;
//import java.sql.SQLDataException;


public class ClientAction extends ActionSupport {
    private Character CodeClient;
    private Character  CodeDistrict;
    private String NameClient;
    private String LastNameClient;
    private Integer AgeClient;
    private Character CellPhoneClient;
    private String AddressClient;
    private String PasswordClient;


    public Character getCodeClient() {
        return CodeClient;
    }

    public void setCodeClient(Character codeClient) {
        CodeClient = codeClient;
    }

    public Character getCodeDistrict() {
        return CodeDistrict;
    }

    public void setCodeDistrict(Character codeDistrict) {
        CodeDistrict = codeDistrict;
    }

    public String getNameClient() {
        return NameClient;
    }

    public void setNameClient(String nameClient) {
        NameClient = nameClient;
    }

    public String getLastNameClient() {
        return LastNameClient;
    }

    public void setLastNameClient(String lastNameClient) {
        LastNameClient = lastNameClient;
    }

    public Integer getAgeClient() {
        return AgeClient;
    }

    public void setAgeClient(Integer ageClient) {
        AgeClient = ageClient;
    }

    public Character getCellPhoneClient() {
        return CellPhoneClient;
    }

    public void setCellPhoneClient(Character cellPhoneClient) {
        CellPhoneClient = cellPhoneClient;
    }

    public String getAddressClient() {
        return AddressClient;
    }

    public void setAddressClient(String addressClient) {
        AddressClient = addressClient;
    }

    public String getPasswordClient() {
        return PasswordClient;
    }

    public void setPasswordClient(String passwordClient) {
        PasswordClient = passwordClient;
    }

    public String execute(){
        return "success";
    }

}
