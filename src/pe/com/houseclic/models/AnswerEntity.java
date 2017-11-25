package pe.com.houseclic.models;

        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.ArrayList;
        import java.util.List;

public class AnswerEntity extends BaseEntity {


    public AnswerEntity() {
        super();
        setTableName("Answer");
    }

    //***********************************************************************************************************

    public List<Answer> findAll(TechnicianEntity technicianEntity, ClientEntity clientEntity) {
        return findByCriteria("", technicianEntity, clientEntity);
    }

    private List<Answer> findByCriteria(String criteria, TechnicianEntity technicianEntity, ClientEntity clientEntity) {
        try {

            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            criteria.isEmpty() ?
                                    getBaseStatement() :
                                    getBaseStatement()
                                            .concat(" WHERE ")
                                            .concat(criteria));
            List<Answer> answers = new ArrayList<>();
            while (rs.next())
                answers.add(Answer.from(rs, technicianEntity, clientEntity));
            return answers;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean create(Answer answer) {
        return executeUpdate(String.format(
                "INSERT INTO %s(CodeAnswer, CodeTechnician, CodeClient, DateAnswer, CommentAnswer, PriceAnswer) VALUES (%d, %d, %d, '%s', '%s', '%s')",
                getTableName(), answer.getId(), answer.getTechnician(), answer.getClient(), answer.getDateAnswer(), answer.getCommentAnswer(), answer.getPriceAnswer()));
    }

    public boolean create(int id, Technician technician, Client client, String dateAnswer, String commentAnswer, String priceAnswer) {
        return create(new Answer(id, technician, client, dateAnswer, commentAnswer, priceAnswer));
    }

    public boolean update(Answer answer) {
        return executeUpdate(String.format("UPDATE %s SET CodeTechnician = %d, CodeClient = %d, DateAnswer = '%s', CommentAnswer = '%s', PriceAnswer = '%s' WHERE CodeAnswer = %d",
                getTableName(), answer.getId(), answer.getTechnician(), answer.getClient(), answer.getDateAnswer(), answer.getCommentAnswer(), answer.getPriceAnswer()));
    }

    public boolean update(int id, Technician technician, Client client, String dateAnswer, String commentAnswer, String priceAnswer) {
        return update(new Answer(id, technician, client, dateAnswer, commentAnswer, priceAnswer));
    }

    public boolean delete(Answer answer) {
        return executeUpdate(String.format("DELETE FROM %s WHERE CodeAnswer = '%s'",
                getTableName(), answer.getId()));
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