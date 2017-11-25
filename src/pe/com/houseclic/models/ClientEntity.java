package pe.com.houseclic.models;

        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.ArrayList;
        import java.util.List;

public class ClientEntity extends BaseEntity {


    public ClientEntity() {
        super();
        setTableName("Client");
    }

    //***********************************************************************************************************

    public List<Client> findAll(DistrictsEntity districtsEntity, ContractEntity contractEntity, TypeQuotationEntity typeQuotationEntity) {
        return findByCriteria("", districtsEntity, contractEntity, typeQuotationEntity);
    }

    private List<Client> findByCriteria(String criteria, DistrictsEntity districtsEntity, ContractEntity contractEntity, TypeQuotationEntity typeQuotationEntity) {
        try {

            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            criteria.isEmpty() ?
                                    getBaseStatement() :
                                    getBaseStatement()
                                            .concat(" WHERE ")
                                            .concat(criteria));
            List<Client> clients = new ArrayList<>();
            while (rs.next())
                clients.add(Client.from(rs, districtsEntity, contractEntity, typeQuotationEntity));
            return clients;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean create(Client client) {
        return executeUpdate(String.format(
                "INSERT INTO %s(CodeClient, CodeDistrict, CodeContract, CodeTypeQuotation, NameClient, LastNameClient, AgeClient, CellPhoneClient, AddressClient, PasswordClient, PhotoClient) VALUES (%d, %d, %d, %d, '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                getTableName(), client.getId(), client.getDistrict(), client.getContract(), client.getTypeQuotation(), client.getNameClient(), client.getLastnameclient(), client.getAgeClient(), client.getCellPhoneClient(), client.getAddressClient(), client.getPasswordClient(), client.getPhotoClient()));
    }

    public boolean create(int id, District district, Contract contract, TypeQuotation typeQuotation, String nameclient, String lastnameclient, String ageclient, String cellPhoneClient, String addressClient, String passwordClient, String photoClient) {
        return create(new Client(id, district, contract, typeQuotation, nameclient, lastnameclient, ageclient, cellPhoneClient, addressClient, passwordClient, photoClient));
    }

    public boolean update(Client client) {
        return executeUpdate(String.format("UPDATE %s SET CodeDistrict = %d, CodeContract = %d, CodeTypeQuotation = %d, NameClient = '%s', LastNameClient = '%s', AgeClient = '%s', CellPhoneClient = '%s', AddressClient = '%s', PasswordClient = '%s', PhotoClient = '%s' WHERE CodeClient = %d",
                getTableName(), client.getId(), client.getDistrict(), client.getContract(), client.getTypeQuotation(), client.getNameClient(), client.getLastnameclient(), client.getAgeClient(), client.getCellPhoneClient(), client.getAddressClient(), client.getPasswordClient(), client.getPhotoClient()));
    }

    public boolean update(int id, District district, Contract contract, TypeQuotation typeQuotation, String nameclient, String lastnameclient, String ageclient, String cellPhoneClient, String addressClient, String passwordClient, String photoClient) {
        return update(new Client(id, district, contract, typeQuotation, nameclient, lastnameclient, ageclient, cellPhoneClient, addressClient, passwordClient, photoClient));
    }

    public boolean delete(Client client) {
        return executeUpdate(String.format("DELETE FROM %s WHERE CodeClient = '%s'",
                getTableName(), client.getId()));
    }

    private boolean executeUpdate(String sql) {
        try {
            int result = getConnection().createStatement().executeUpdate(sql);
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}