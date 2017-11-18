package pe.com.houseclic.models;

import java.sql.Connection;
import java.util.List;

public class HouseClicDataStore {
    private Connection connection;
    private DistrictsEntity districtsEntity;
    private JobsEntity jobsEntity;
    private EspecialtiesEntity especialtiesEntity;
    private TechnicianEntity technicianEntity;
    private DetailScheduleEntity detailScheduleEntity;
    private ScheduleEntity scheduleEntity;
    private AnswerEntity answerEntity;
    private ContractEntity contractEntity;
    private ClientEntity clientEntity;
    private QuotationEntity quotationEntity;
    private TypeQuotationEntity typeQuotationEntity;

//***********************************************************************************************

    public HouseClicDataStore (Connection connection) {
        this.setConnection(connection);
    }

    public Connection getConnection() { return connection; }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

//***********************************************************************************************

    private DistrictsEntity getDistrictsEntity() {
        if(districtsEntity == null) {
            districtsEntity = new DistrictsEntity();
            districtsEntity.setConnection(getConnection());
        }
        return districtsEntity;
    }

    private JobsEntity getJobsEntity() {
        if(jobsEntity == null) {
            jobsEntity = new JobsEntity();
            jobsEntity.setConnection(getConnection());
        }
        return jobsEntity;
    }

    private EspecialtiesEntity getEspecialtiesEntity() {
        if(especialtiesEntity == null) {
            especialtiesEntity = new EspecialtiesEntity();
            especialtiesEntity.setConnection(connection);
        }
        return especialtiesEntity;
    }

    private TechnicianEntity getTechnicianEntity() {
        if(technicianEntity == null) {
            technicianEntity = new TechnicianEntity();
            technicianEntity.setConnection(connection);
        }
        return technicianEntity;
    }

    private DetailScheduleEntity getDetailScheduleEntity() {
        if(detailScheduleEntity == null) {
            detailScheduleEntity = new DetailScheduleEntity();
            detailScheduleEntity.setConnection(connection);
        }
        return detailScheduleEntity;
    }

    private ScheduleEntity getScheduleEntity() {
        if(scheduleEntity == null) {
            scheduleEntity = new ScheduleEntity();
            scheduleEntity.setConnection(connection);
        }
        return scheduleEntity;
    }

    private AnswerEntity getAnswerEntity() {
        if(answerEntity == null) {
            answerEntity = new AnswerEntity();
            answerEntity.setConnection(connection);
        }
        return answerEntity;
    }

    private ContractEntity getContractEntity() {
        if(contractEntity == null) {
            contractEntity = new ContractEntity();
            contractEntity.setConnection(connection);
        }
        return answerEntity;
    }

    private ClientEntity getClientEntity() {
        if(clientEntity == null) {
            clientEntity = new ClientEntity();
            clientEntity.setConnection(connection);
        }
        return clientEntity;
    }

    private QuotationEntity getQuotationEntity() {
        if(quotationEntity == null) {
            quotationEntity = new QuotationEntity();
            quotationEntity.setConnection(connection);
        }
        return quotationEntity;
    }

    private TypeQuotationEntity getTypeQuotationEntity() {
        if(typeQuotationEntity == null) {
            typeQuotationEntity = new TypeQuotationEntity();
            typeQuotationEntity.setConnection(connection);
        }
        return typeQuotationEntity;
    }
//****************************************************************************************

    // DISTRITO - DISTRICT

    public District findDistrictById(int id) {
        return getConnection() == null ?
                null :
                getDistrictsEntity().findById(id);
    }

    public List<District> findAllDistricts (){
        return getConnection() == null ? null : getDistrictsEntity().findAll();
    }

    public District createDistrict (String name){
        return getConnection() == null ?
                null :
                getDistrictsEntity().create(name);
    }

    public boolean eraseDistrict (District district) {
        return getConnection() == null ?
                false :
                getDistrictsEntity().erase(district);
    }

    public boolean updateDistrict(District district) {
        return getConnection() == null ?
                false :
                getDistrictsEntity().update(district);
    }

    // TRABAJO - JOB ******************************************************************************

    public Job findJobById(int id) {
        return getConnection() == null ?
                null :
                getJobsEntity().findById(id);
    }
    public List<Job> findAllJobs (){
        return getConnection() == null ? null : getJobsEntity().findAll();
    }

    public Job createJob (String name){
        return getConnection() == null ?
                null :
                getJobsEntity().create(name);
    }

    public boolean eraseJob (Job job) {
        return getConnection() == null ?
                false :
                getJobsEntity().erase(job);
    }

    public boolean updateJob(Job job) {
        return getConnection() == null ?
                false :
                getJobsEntity().update(job);
    }

    // ESPECIALIDAD - ESPECIALTY********************************************************************

    public Especialty findEspecialtyById(String id) {
        return getConnection() == null ?
                null :
                getEspecialtiesEntity().findById(id, getJobsEntity(), getTechnicianEntity());
    }

    public List<Especialty> findAllEspecialties (){
        return getConnection() == null ? null : getEspecialtiesEntity().findAll(getEspecialtiesEntity());
    }

    // TECNICO - TECHNICIAN ****************************************************************

    public Technician findTechnicianById(String id) {
        return getConnection() == null ?
        null :
        getTechnicianEntity().findById(id, getDistrictsEntity(), getDetailScheduleEntity(), getContractEntity(), getTypeQuotation ());
        }

    public List<Technician> findAllTechnicians (){
        return getConnection() == null ? null : getTechnicianEntity().findAll(getTechnicianEntity());
        }

    //  DETALLE HORARIO - DETAILSCHEDULE ****************************************************************

    public DetailSchedule findDetailScheduleById(String id) {
        return getConnection() == null ?
                null :
                getDetailScheduleEntity().findById(id, getTechnicianEntity(), getScheduleEntity());
    }

    public List<DetailSchedule> findAllDetailSchedules (){
        return getConnection() == null ? null : getDetailScheduleEntity().findAll(getDetailScheduleEntity());
    }

    // HORARIO - SCHEDULE *******************************************************************************

    public Schedule findScheduleyId(String id) {
        return getConnection() == null ?
                null :
                getScheduleEntity().findById(id, getQuotationEntity());
    }

    public List<Schedule> findAllSchedules (){
        return getConnection() == null ? null : getScheduleEntity().findAll(getScheduleEntity());
    }

    // DETALLE RESPUESTA - ANSWER *******************************************************************************

    public Answer findAnswerById(String id) {
        return getConnection() == null ?
                null :
                getAnswerEntity().findById(id, getTechnicianEntity(), getClientEntity());
    }

    public List<Answer> findAllAnswers (){
        return getConnection() == null ? null : getAnswerEntity().findAll(getAnswerEntity());
    }

    // CONTRATO - CONTRACT **************************************************************************************

    public Contract findContractById(String id) {
        return getConnection() == null ?
                null :
                getContractEntity().findById(id);
    }

    public List<Contract> findAllContract (){
        return getConnection() == null ? null : getContractEntity().findAll(getContractEntity());
    }

    // CLIENTE - CLIENT **************************************************************************************

    public Client findClientById(String id) {
        return getConnection() == null ?
                null :
                getClientEntity().findById(id, getDistrictsEntity(), getContractEntity(), getTypeQuotationEntity());
    }

    public List<Client> findAllClient (){
        return getConnection() == null ? null : getClientEntity().findAll(getClientEntity());
    }

   // COTIZACION - QUOATATION **************************************************************************************

    public Quotation findQuotationById(String id) {
        return getConnection() == null ?
                null :
                getQuotationEntity().findById(id, getAnswerEntity());
    }

    public List<Quotation> findAllQuotation (){
        return getConnection() == null ? null : getQuotationEntity().findAll(getQuotationEntity());
    }

    // TYPO DE COTIZACION - TYPEQUOTATION **************************************************************************************

    public TypeQuotation findTypeQuotationById(String id) {
        return getConnection() == null ?
                null :
                getTypeQuotationEntity().findById(id, getQuotationEntity());
    }

    public List<TypeQuotation> findAllTypeQuotation (){
        return getConnection() == null ? null : getTypeQuotationEntity().findAll(getTypeQuotationEntity());
    }

}