package bc.databases.registrar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class DatabaseImpl {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    

    public int addStudent(){
        return jdbcTemplate.update("INSERT INTO students dob, last_name, first_name, credits, gender VALUES ?, ?, ?, ?, ?);",
                new Date(), "levi", "michael", "85", "male");
    }

    public int addCourse(){
        return 0;
        //TODO: NOT IMPLEMENTED YET
    }

    public int addRegisteredClass(){
        return 0;
        //TODO: NOT IMPLEMENTED YET
    }

    public int addInstructor(){
        return 0;
        //TODO: not implemented yet
    }

    public int addDepartment(){
        return 0;
        //todo: not implemented yet
    }

    public int addTuitionPayment(){
        return 0;
        //todo implement
    }

    public int addFinancialAid(){
        return 0;
        //todo implement
    }
}
