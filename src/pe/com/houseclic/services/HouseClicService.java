package pe.com.houseclic.services;

import pe.com.houseclic.models.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class HouseClicService {
    Connection connection;
    HouseClicDataStore dataStore;
    public HouseClicService() {
        try {
            InitialContext context = new InitialContext();
            connection = ((DataSource) context.lookup("jdbc/MySQLDataSource"))
                    .getConnection();
            dataStore = new HouseClicDataStore(connection);
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DISTRITO - DISTRICT *********************************************************************************

    public District findDistrictById(int id) { return dataStore.findDistrictById(id); }

    public List<District> findAllDistricts() { return dataStore.findAllDistricts();}

    public District createDistrict(String name) { return dataStore.createDistrict(name);}

    public boolean eraseDistrict(District district) { return dataStore.eraseDistrict(district);}

    public boolean updateDistrict(District district) { return dataStore.updateDistrict(district);}

    // TRABAJO - JOB ***************************************************************************************

    public Job findJobById(int id) { return dataStore.findJobById(id); }

    public List<Job> findAllJobs() { return dataStore.findAllJobs();}

    public Job createJob(String name) { return dataStore.createJob(name);}

    public boolean eraseJob(Job job) { return dataStore.eraseJob(job);}

    public boolean updateJob(Job job) { return dataStore.updateJob(job);}


    //ESPECIALIDAD - ESPECIALTY******************************************************************************

    public Especialty findEspecialtyById(String  id){return dataStore.findEspecialtyById(id);}

    public List<Especialty> findAllEspecialties(){return dataStore.findAllEspecialties();}

    //TECNICO - TECHNICIAN **********************************************************************************

    public Technician findTechnicianById(String  id){return dataStore.findTechnicianById(id);}

    public List<Technician> findAllTechnicians(){return dataStore.findAllTechnicians();}

    //DETALLE HORARIO - DETAILSCHUDULE **********************************************************************************

    public DetailSchedule findDetailScheduleById(String  id){return dataStore.findDetailScheduleById(id);}

    public List<DetailSchedule> findAllDetailSchedules(){return dataStore.findAllDetailSchedules();}

    //HORARIO - SCHEDULE **********************************************************************************

    public Schedule findScheduleById(String  id){return dataStore.findScheduleById(id);}

    public List<Schedule> findAllSchedules(){return dataStore.findAllSchedules();}

    //DETALLE RESPUESTA - ANSWER **********************************************************************************

    public Answer findAnswerById(String  id){return dataStore.findAnswerById(id);}

    public List<Answer> findAllAnswers(){return dataStore.findAllAnswers();}

    //CONTRATO - CONTRACT **********************************************************************************

    public Contract findContractById(String  id){return dataStore.findContractById(id);}

    public List<Contract> findAllContract(){return dataStore.findAllContract();}

    //CLIENTE - CLIENT **********************************************************************************

    public Client findClientById(String  id){return dataStore.findClientById(id);}

    public List<Client> findAllClient(){return dataStore.findAllClient();}

    //COTIZACION - QUOTATION **********************************************************************************

    public Quotation findQuotationById(String  id){return dataStore.findQuotationById(id);}

    public List<Quotation> findAllQuotation(){return dataStore.findAllQuotation();}

    //TYPO DE COTIZACION - TYPEQUOTATION **********************************************************************************

    public TypeQuotation findTypeQuotationById(String  id){return dataStore.findTypeQuotationById(id);}

    public List<TypeQuotation> findAllTypeQuotation(){return dataStore.findAllTypeQuotation();}
}