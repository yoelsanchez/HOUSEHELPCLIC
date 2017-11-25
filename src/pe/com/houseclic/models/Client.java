package pe.com.houseclic.models;

        import java.sql.ResultSet;
        import java.sql.SQLException;

public class Client {
    private int id;
    private District district;
    private Contract contract;
    private TypeQuotation typeQuotation;
    private String nameclient;
    private String lastnameclient;
    private String ageClient;
    private String cellPhoneClient;
    private String addressClient;
    private String passwordClient;
    private String photoClient;

    public Client(int id, District district, Contract contract, TypeQuotation typeQuotation, String nameclient, String lastnameclient, String ageClient, String cellPhoneClient, String addressClient, String passwordClient, String photoClient) {
        this.setId(id);
        this.setDistrict(district);
        this.setContract(contract);
        this.setTypeQuotation(typeQuotation);
        this.setNameClient(nameclient);
        this.setLastNameClient(lastnameclient);
        this.setAgeClient(ageClient);
        this.setCellPhoneClient(cellPhoneClient);
        this.setAddressClient(addressClient);
        this.setPasswordClient(passwordClient);
        this.setPhotoClient(photoClient);
    }
//************* POR CAMPO SE HACE **********************************************************************************************

    public int getId() { return id; }

    public Client setId(int id) { this.id = id; return this; }

//****************DE LA RELACION CON TABLA DISTRICT*****************************************************************************

    public Client getDistrict() { return district; }

    public Client setDistrict(District district) { this.district = district; return this; }

//*************** DE LA RELACION CON LA  TABLA CONTRACT**************************************************************************

    public Contract getContract() { return contract; }

    public Contract setContract(Contract contract) { this.contract = contract; return this; }

//**************** DE LA TABLA DE TYPEQUOTATION*********************************************************************************

    public TypeQuotation getTypeQuotation() { return typeQuotation; }

    public TypeQuotation setTypeQuotation(TypeQuotation typeQuotation) { this.typeQuotation = typeQuotation; return this; }

//*******************************************************************************************************************************

    public String getNameClient() { return nameclient; }

    public Client setNameClient (String nameclient) { this.nameclient = nameclient; return this; }

//*******************************************************************************************************************************

    public String getLastnameclient() { return lastnameclient; }

    public Client setLastNameClient (String lastnameclient) { this.lastnameclient = lastnameclient; return this; }

//*******************************************************************************************************************************

    public String getAgeClient() { return ageClient; }

    public Client setAgeClient (String ageClient) { this.ageClient = ageClient; return this; }

//*******************************************************************************************************************************

    public String getCellPhoneClient() { return cellPhoneClient; }

    public Client setCellPhoneClient (String cellPhoneClient) { this.cellPhoneClient = cellPhoneClient; return this; }

//*******************************************************************************************************************************

    public String getAddressClient() { return addressClient; }

    public Client setAddressClient(String addressClient) { this.addressClient = addressClient; return this; }

//*******************************************************************************************************************************

    public String getPasswordClient() { return passwordClient; }

    public Client setPasswordClient (String passwordClient) { this.passwordClient = passwordClient; return this; }

//*******************************************************************************************************************************

    public String getPhotoClient() { return photoClient; }

    public Client setPhotoClient (String photoClient) { this.photoClient = photoClient; return this; }

//*******************************************************************************************************************************

    public static Client from(ResultSet resultSet, DistrictsEntity districtsEntity, ContractEntity contractEntity, TypeQuotationEntity typeQuotationEntity) {
        Client client = new Client();
        try {
            client.setId(resultSet.getInt("CodeDistrict"))
                    .setDistrict(DistrictsEntity.findById(ResultSet.getInt("CodeDistrict")));
                    .setContract(Contract.findById(ResultSet.getInt("CodeContract")))
                    .setTypeQuotation(TypeQuotation.findById(ResultSet.getInt("CodeTypeQuotation")));
                    .setNameClient(resultSet.getString("NameClient"));
                    .setLastNameClient(resultSet.getString("LastNameClient"));
                    .setAgeClient(resultSet.getString("AgeClient"));
                    .setCellPhoneClient(resultSet.getString("CellPhoneClient"));
                    .setAddressClient(resultSet.getString("AddressClient"));
                    .setPasswordClient(resultSet.getString("PasswordClient"));
                    .setPhotoClient(resultSet.getString("PhotoClient"));

            return Client;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}