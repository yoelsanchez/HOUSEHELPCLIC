package pe.com.houseclic.services;

import pe.com.houseclic.models.HouseClicDataStore;
import pe.com.houseclic.models.District;
import pe.com.houseclic.models.Job;

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

    // DISTRITO - DISTRICT

    public District findDistrictById(int id) { return dataStore.findDistrictById(id); }

    public List<District> findAllDistricts() { return dataStore.findAllDistricts();}

    public District createDistrict(String name) { return dataStore.createDistrict(name);}

    public boolean eraseDistrict(District district) { return dataStore.eraseDistrict(district);}

    public boolean updateDistrict(District district) { return dataStore.updateDistrict(district);}

    // TRABAJO - JOB

    public Job findJobById(int id) { return dataStore.findJobById(id); }

    public List<Job> findAllJobs() { return dataStore.findAllJobs();}

    public Job createJob(String name) { return dataStore.createJob(name);}

    public boolean eraseJob(Job job) { return dataStore.eraseJob(job);}

    public boolean updateJob(Job job) { return dataStore.updateJob(job);}
}
