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
    

    public int addStudent(Date dob, String last, String first, int credits, String gender){
        return jdbcTemplate.update("INSERT INTO students (dob, last_name, first_name, credits, gender)" +
                        " VALUES (?, ?, ?, ?, ?);",
                new Object[] {new Date()}, "levi", "michael", "85", "male");
    }

    public int addCourse(int class_number, String dept, int course_number, String class_title,
                         String instructor_name, String beginning_time, String end_time, String room,
                         int num_credits, String section, String mode_inst, int capacity, String semester, String si){
        return jdbcTemplate.update("INSERT INTO courses (class_number, dept, course_number, " +
                "class_title, instructor_name, beginning_time, end_time, room, num_credits, section, " +
                "mode_inst, capacity, semester, si) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                class_number, dept, course_number, class_title, instructor_name, beginning_time, end_time,
                room, num_credits, section, mode_inst, capacity, semester, si
                );
    }

    public int addRegisteredClass(int emplid, String grade, int credits, String department, int class_number){
        return jdbcTemplate.update("INSERT INTO registered_classes (emplid, grade, credits, department, class_number) " +
                "VALUES (?, ?, ?, ?, ?)", emplid, grade, credits, department, class_number);
    }

    public int addInstructor(String title, String instructor_name, String gender, String department, int salary ){
        return jdbcTemplate.update("INSERT INTO instructor (title, instructor_name, gender, department, salary)" +
                " VALUES (?, ?, ?, ?, ?)", title, instructor_name, gender, department, salary);
    }

    public int addDepartment(String department, String department_chair, int budget){
        return jdbcTemplate.update("INSERT INTO department (department, department_chair, budget) " +
                "VALUES (?, ?, ?)", department, department_chair, budget);
    }

    public int addTuitionPayment(int emplid, int amount_paid, Date date_paid){
        return jdbcTemplate.update("INSERT INTO TUITION_PAYMENTS (EMPLID, AMOUNT_PAID, DATE_PAID) VALUES " +
                "(?, ?, ?)", emplid, amount_paid, date_paid);
    }

    public int addFinancialAid(int emplid, int grant_money, String grant_name, Date date_applied){
        return jdbcTemplate.update("INSERT INTO FINANICAL_AID(EMPLID, GRANT_MONEY, GRANT_NAME, DATE_APPLIED) VALUES " +
                "(?, ?, ?, ?)", emplid, grant_money, grant_name, date_applied);
    }
}
