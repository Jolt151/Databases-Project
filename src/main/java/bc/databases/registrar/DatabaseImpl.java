package bc.databases.registrar;

import bc.databases.registrar.objects.Department;
import bc.databases.registrar.objects.Financial_Aid;
import bc.databases.registrar.objects.Tuition_Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class DatabaseImpl {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //METHODS FOR ADDING TO DATABASE

    public int addStudent(int emplid, String last_name, String first_name, Date dob, int credits, String gender, int unpaid_tuition, String email, String phone,
                          String starting_semester, String expected_graduation, String address, String major){
        return jdbcTemplate.update("INSERT INTO students (emplid, last_name, first_name, dob, credits, gender, unpaid_tuition, email, phone, starting_semester," +
                        " expected_graduation, address, major)" +
                        " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);",
                emplid, last_name, first_name, dob, credits, gender, unpaid_tuition, email, phone, starting_semester, expected_graduation, address, major);
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

    //METHODS FOR RETURNING ROWS FROM THE TABLE
    public SqlRowSet getStudents(){
        return jdbcTemplate.queryForRowSet("SELECT * FROM STUDENT");
    }

    public List<Department> getDepartments(){
        return jdbcTemplate.query("SELECT * FROM DEPARTMENT", new RowMapper<Department>() {
            @Override
            public Department mapRow(ResultSet resultSet, int i) throws SQLException {
                Department department = new Department();
                department.setDepartment(resultSet.getString("DEPARTMENT"));
                department.setDepartment_chair(resultSet.getString("DEPARTMENT_CHAIR"));
                department.setBudget(resultSet.getInt("BUDGET"));
                return department;
            }
        });
    }

    public List<Financial_Aid> getFinancialAid(){
        return jdbcTemplate.query("SELECT * FROM FINANCIAL_AID", new RowMapper<Financial_Aid>() {
            @Override
            public Financial_Aid mapRow(ResultSet resultSet, int i) throws SQLException {
                Financial_Aid financial_aid = new Financial_Aid();
                financial_aid.setEmplid(resultSet.getInt("EMPLID"));
                financial_aid.setGrant_money(resultSet.getInt("GRANT_MONEY"));
                financial_aid.setGrant_name(resultSet.getString("GRANT_NAME"));
                financial_aid.setDate_applied(resultSet.getDate("date_applied"));
                return financial_aid;
            }
        });
    }

    public List<Tuition_Payment> getTuition_Payments(){
        return jdbcTemplate.query("SELECT * FROM TUITION_PAYMENTS", new RowMapper<Tuition_Payment>() {
            @Override
            public Tuition_Payment mapRow(ResultSet resultSet, int i) throws SQLException {
                Tuition_Payment tuition_payment = new Tuition_Payment();
                tuition_payment.setEmplid(resultSet.getInt("EMPLID"));
                tuition_payment.setAmount_paid(resultSet.getInt("AMOUNT_PAID"));
                tuition_payment.setDate_paid(resultSet.getDate("DATE_PAID"));
                return tuition_payment;
            }
        });
    }
}
