package pe.com.houseclic.struts;
import com.opensymphony.xwork2.ActionSupport;

public class TechnicianAction extends ActionSupport {
    private Character CodeTechnician;
    private Character CodeSpecialty;
    private Character CodeDistrict;

    private String NameTech;
    private String LastNameTech;
    private Character DniTech;
    private Integer AgeTech;
    private Character CellPhoneTech;
    private String DescriptionTech;
    private String PasswordTech;


    public Character getCodeTechnician() {
        return CodeTechnician;
    }

    public void setCodeTechnician(Character codeTechnician) {
        CodeTechnician = codeTechnician;
    }

    public Character getCodeSpecialty() {
        return CodeSpecialty;
    }

    public void setCodeSpecialty(Character codeSpecialty) {
        CodeSpecialty = codeSpecialty;
    }

    public Character getCodeDistrict() {
        return CodeDistrict;
    }

    public void setCodeDistrict(Character codeDistrict) {
        CodeDistrict = codeDistrict;
    }

    public String getNameTech() {
        return NameTech;
    }

    public void setNameTech(String nameTech) {
        NameTech = nameTech;
    }

    public String getLastNameTech() {
        return LastNameTech;
    }

    public void setLastNameTech(String lastNameTech) {
        LastNameTech = lastNameTech;
    }

    public Character getDniTech() {
        return DniTech;
    }

    public void setDniTech(Character dniTech) {
        DniTech = dniTech;
    }

    public Integer getAgeTech() {
        return AgeTech;
    }

    public void setAgeTech(Integer ageTech) {
        AgeTech = ageTech;
    }

    public Character getCellPhoneTech() {
        return CellPhoneTech;
    }

    public void setCellPhoneTech(Character cellPhoneTech) {
        CellPhoneTech = cellPhoneTech;
    }

    public String getDescriptionTech() {
        return DescriptionTech;
    }

    public void setDescriptionTech(String descriptionTech) {
        DescriptionTech = descriptionTech;
    }

    public String getPasswordTech() {
        return PasswordTech;
    }

    public void setPasswordTech(String passwordTech) {
        PasswordTech = passwordTech;
    }
    public String execute(){
        return "successTechnician";
    }
}
