package pe.com.houseclic.models;

        import java.sql.ResultSet;
        import java.sql.SQLException;

public class Technician {
    private int id;
    private District district;
    private DetailSchedule detailSchedule;
    private Contract contract;
    private TypeQuotation typeQuotation;
    private String name;
    private String lastname;
    private String dni;
    private String age;
    private String cell;
    private String description;
    private String photo;
    private String pass;

    public Especialty(int id, District district, DetailSchedule detailSchedule, Contract contract, TypeQuotation typeQuotation, String name, String lastname, String dni, String age, String cell, String description, String photo, String pass) {
        this.setId(id);
        this.setDistrict(district);
        this.setDetailSchedule(detailSchedule);
        this.setContract(contract);
        this.setTypeQuotation(typeQuotation);
        this.setName(name);
        this.setLastname(lastname);
        this.setDni(dni);
        this.setAge(age);
        this.setCell(cell);
        this.setDescription(description);
        this.setPhoto(photo);
        this.setPass(pass);
    }
//************* POR CAMPO SE HACE **********************************************************************************************

    public int getId() { return id; }

    public Technician setId(int id) { this.id = id; return this; }

//****************DE LA RELACION CON TABLA DISTRICT*****************************************************************************

    public District getDistrict() { return district; }

    public District setDistrict(District district) { this.district = district; return this; }

//*************** DE LA RELACION CON LA  TABLA DETAILSCHEDULE*******************************************************************

    public DetailSchedule getDetailSchedule() { return detailSchedule; }

    public DetailSchedule setDetailSchedule(DetailSchedule detailSchedule) { this.detailSchedule = detailSchedule; return this; }


//*************** DE LA RELACION CON LA  TABLA CONTRACT**************************************************************************

    public Contract getContract() { return contract; }

    public Contract setContract(Contract contract) { this.contract = contract; return this; }

//**************** DE LA TABLA DE TYPEQUOTATION*********************************************************************************

    public TypeQuotation getTypeQuotation() { return typeQuotation; }

    public TypeQuotation setTypeQuotation(TypeQuotation typeQuotation) { this.typeQuotation = typeQuotation; return this; }

//*******************************************************************************************************************************

    public String getName() { return name; }

    public Technician setName (String name) { this.name = name; return this; }

//*******************************************************************************************************************************

    public String getLastname() { return lastname; }

    public Technician setLastname (String lastname) { this.lastname = lastname; return this; }

//*******************************************************************************************************************************

public String getDni() { return dni; }

    public Technician setDni (String dni) { this.dni = dni; return this; }

//*******************************************************************************************************************************

    public String getAge() { return age; }

    public Technician setAge (String age) { this.age = age; return this; }

//*******************************************************************************************************************************

    public String getCell() { return cell; }

    public Technician setCell (String cell) { this.cell = cell; return this; }

//*******************************************************************************************************************************

    public String getDescription() { return description; }

    public Technician setDescription (String description) { this.description = description; return this; }

//*******************************************************************************************************************************

    public String getPhoto() { return photo; }

    public Technician setPhoto (String photo) { this.photo = photo; return this; }

//*******************************************************************************************************************************

    public String getPass() { return pass; }

    public Technician setPass (String photo) { this.pass = pass; return this; }

//*******************************************************************************************************************************

    public static Technician from(ResultSet resultSet, DistrictsEntity districtsEntity, DetailScheduleEntity detailScheduleEntity, ContractEntity contractEntity, TypeQuotationEntity typeQuotationEntity) {
        Technician technician = new Technician();
        try {
            technician.setId(resultSet.getInt("CodeTechnician"))
                    .setDistrict(DistrictsEntity.findById(ResultSet.getInt("District_CodeDistrict")));
                    .setDetailSchedule(DetailSchedule.findById(ResultSet.getInt("CodeDetailSchedule")));
                    .setContract(Contract.findById(ResultSet.getInt("CodeContract")))
                    .setTypeQuotation(TypeQuotation.findById(ResultSet.getInt("CodeTypeQuotation")));
                    .setName(resultSet.getString("NameTech"));
                    .setLastname(resultSet.getString("LastNameTech"));
                    .setDni(resultSet.getString("DniTech"));
                    .setAge(resultSet.getString("LastAge"));
                    .setCell(resultSet.getString("CellPhoneTech"));
                    .setDescription(resultSet.getString("DescriptionSpecialty"));
                    .setPhoto(resultSet.getString("PhotoTech"));
                    .setPass(resultSet.getString("PasswordTech"));

                    return technician;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}