package bc.databases.registrar;

import bc.databases.registrar.objects.*;
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
        return jdbcTemplate.update("INSERT INTO student (emplid, last_name, first_name, dob, credits, gender, unpaid_tuition, email, phone, starting_semester," +
                        " expected_graduation, address, major)" +
                        " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                emplid, last_name, first_name, dob, credits, gender, unpaid_tuition, email, phone, starting_semester, expected_graduation, address, major);
    }

    public int addCourse(int class_number, String dept, int course_number, String class_title,
                         String instructor_name, String beginning_time, String end_time, String room,
                         int num_credits, String sections, String mode_inst, int capacity, String semester, String si){
        return jdbcTemplate.update("INSERT INTO course (class_number, DEPARTMENT_NAME, course_number, " +
                "TITLE, instructor_name, TIME_BEGIN, TIME_END, room, CREDITS, SECTIONs, " +
                "MODE_OF_INSTRUCTION, class_capacity, semester, SPECIAL_INFORMATION) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                class_number, dept, course_number, class_title, instructor_name, beginning_time, end_time,
                room, num_credits, sections, mode_inst, capacity, semester, si
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
        return jdbcTemplate.update("INSERT INTO FINANCIAL_AID(EMPLID, GRANT_MONEY, GRANT_NAME, DATE_APPLIED) VALUES " +
                "(?, ?, ?, ?)", emplid, grant_money, grant_name, date_applied);
    }

    //METHODS FOR RETURNING ROWS FROM THE TABLE

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

    public List<Instructor> getInstructors(){
        return jdbcTemplate.query("SELECT * FROM INSTRUCTOR", new RowMapper<Instructor>() {
            @Override
            public Instructor mapRow(ResultSet resultSet, int i) throws SQLException {
                Instructor instructor = new Instructor();
                instructor.setDepartment(resultSet.getString("DEPARTMENT"));
                instructor.setGender(resultSet.getString("GENDER"));
                instructor.setInstructor_name(resultSet.getString("INSTRUCTOR_NAME"));
                instructor.setSalary(resultSet.getInt("SALARY"));
                instructor.setTitle(resultSet.getString("TITLE"));
                return  instructor;
            }
        });
    }

    public List<Registered_Classes> getRegisteredClasses(){
        return jdbcTemplate.query("SELECT * FROM REGISTERED_CLASSES", new RowMapper<Registered_Classes>() {
            @Override
            public Registered_Classes mapRow(ResultSet resultSet, int i) throws SQLException {
                Registered_Classes registeredClasses = new Registered_Classes();
                registeredClasses.setEmplid(resultSet.getInt("EMPLID"));
                registeredClasses.setGrade(resultSet.getString("GRADE"));
                registeredClasses.setCredits(resultSet.getInt("CREDITS"));
                registeredClasses.setDepartment(resultSet.getString("DEPARTMENT"));
                registeredClasses.setClass_number(resultSet.getInt("CLASS_NUMBER"));
                return registeredClasses;
            }
        });
    }

    public List<Course> getCourses(){
        return jdbcTemplate.query("SELECT * FROM COURSE", new RowMapper<Course>() {
            @Override
            public Course mapRow(ResultSet resultSet, int i) throws SQLException {
                Course course = new Course();
                course.setClass_number(resultSet.getInt("CLASS_NUMBER"));
                course.setDept(resultSet.getString("DEPARTMENT_NAME"));
                course.setCourse_number(resultSet.getInt("COURSE_NUMBER"));
                course.setClass_title(resultSet.getString("TITLE"));
                course.setInstructor_name(resultSet.getString("INSTRUCTOR_NAME"));
                course.setBeginning_time(resultSet.getString("TIME_BEGIN"));
                course.setEnd_time(resultSet.getString("TIME_END"));
                course.setRoom(resultSet.getString("ROOM"));
                course.setNum_credits(resultSet.getInt("CREDITS"));
                course.setSections(resultSet.getString("SECTIONS"));
                course.setMode_inst(resultSet.getString("MODE_OF_INSTRUCTION"));
                course.setCapacity(resultSet.getInt("CLASS_CAPACITY"));
                course.setSemester(resultSet.getString("SEMESTER"));
                course.setSi(resultSet.getString("SPECIAL_INFORMATION"));
                return course;
            }
        });
    }

    public List<Student> getStudents(){
        return jdbcTemplate.query("SELECT * FROM STUDENT", new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student student = new Student();
                student.setEmplid(resultSet.getInt("EMPLID"));
                student.setFirst_name(resultSet.getString("FIRST_NAME"));
                student.setLast_name(resultSet.getString("LAST_NAME"));
                student.setDob(resultSet.getDate("DOB"));
                student.setCredits(resultSet.getInt("CREDITS"));
                student.setGender(resultSet.getString("GENDER"));
                student.setUnpaid_tuition(resultSet.getInt("UNPAID_TUITION"));
                student.setEmail(resultSet.getString("EMAIL"));
                student.setPhone(resultSet.getString("PHONE"));
                student.setStarting_semester(resultSet.getString("STARTING_SEMESTER"));
                student.setExpected_graduation(resultSet.getString("EXPECTED_GRADUATION"));
                student.setAddress(resultSet.getString("ADDRESS"));
                student.setMajor(resultSet.getString("MAJOR"));
                return student;
            }
        });
    }



}
