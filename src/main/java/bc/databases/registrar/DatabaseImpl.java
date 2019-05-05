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

/*    public void getStudent(){
        return jdbcTemplate.q
    }*/

    public int addStudent(){
        return jdbcTemplate.update("INSERT INTO students dob, last_name, first_name, credits, gender VALUES ?, ?, ?, ?, ?);",
                new Date(), "levi", "michael", "85", "male");
    }
}
