package pe.com.houseclic.models;

        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.ArrayList;
        import java.util.List;

public class ContractEntity extends BaseEntity {


    public ContractEntity() {
        super();
        setTableName("Contract");
    }

    //***********************************************************************************************************

    public List<Contract> findAll() { return findByCriteria(""); }

    private List<Contract> findByCriteria(String criteria) {
        try {

            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            criteria.isEmpty() ?
                                    getBaseStatement() :
                                    getBaseStatement()
                                            .concat(" WHERE ")
                                            .concat(criteria));
            List<Contract> contracts = new ArrayList<>();
            while (rs.next())
                contracts.add(Contract.from(rs));
            return contracts;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean create(Contract contract) {
        return executeUpdate(String.format(
                "INSERT INTO %s(CodeContract, DateContract, TotalCostContract, StateContract, AssistanceReason, RatingScore, RatingState, RatingCommentary) VALUES (%d, '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                getTableName(), contract.getId(), contract.getDateContract(), contract.getTotalCostContract(), contract.getStateContract(), contract.getAssistanceReason(), contract.getRatingScore(), contract.getRatingState(), contract.getRatingCommentary()));
    }

    public boolean create(int id, String dateContract, String totalCostContract, String stateContract, String assistanceReason, String ratingScore, String ratingState, String ratingCommentary) {
        return create(new Contract(id, dateContract, totalCostContract, stateContract, assistanceReason, ratingScore, ratingState, ratingCommentary));
    }

    public boolean update(Contract contract) {
        return executeUpdate(String.format("UPDATE %s SET DateContract = '%s', TotalCostContract = '%s', StateContract = '%s', AssistanceReason = '%s', RatingScore = '%s', RatingState = '%s', RatingCommentary = '%s' WHERE CodeContract = %d",
                getTableName(), contract.getId(), contract.getDateContract(), contract.getTotalCostContract(), contract.getStateContract(), contract.getAssistanceReason(), contract.getRatingScore(), contract.getRatingState(), contract.getRatingCommentary()));
    }

    public boolean update(int id, String dateContract, String totalCostContract, String stateContract, String assistanceReason, String ratingScore, String ratingState, String ratingCommentary) {
        return update(new Contract(id, dateContract, totalCostContract, stateContract, assistanceReason, ratingScore, ratingState, ratingCommentary));
    }

    public boolean delete(Contract contract) {
        return executeUpdate(String.format("DELETE FROM %s WHERE CodeContract = '%s'",
                getTableName(), contract.getId()));
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