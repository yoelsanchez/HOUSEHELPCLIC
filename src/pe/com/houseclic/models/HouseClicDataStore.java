package pe.com.houseclic.models;

import java.sql.Connection;
import java.util.List;

public class HouseClicDataStore {
    private Connection connection;
    private DistrictsEntity districtsEntity;
    private JobsEntity jobsEntity;

    public HouseClicDataStore (Connection connection) {
        this.setConnection(connection);
    }

    public Connection getConnection() { return connection; }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

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

    // TRABAJO - JOB

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
}
