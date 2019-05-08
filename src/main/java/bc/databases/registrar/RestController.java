package bc.databases.registrar;

import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    DatabaseImpl database;

    public RestController(DatabaseImpl database){
        this.database = database;
    }

    @PostMapping("/rest/addStudent")
    public int addStudent(@RequestParam(name = "emplid", required = true) int emplid,
                          @RequestParam(name = "last_name", required = true) String last_name,
                          @RequestParam(name = "first_name", required = true) String first_name,
                          @RequestParam(name = "dob", required = true) Date dob,
                          @RequestParam(name = "credits", required = true) int credits,
                          @RequestParam(name = "gender", required = true) String gender,
                          @RequestParam(name = "unpaid_tuition", required = true) int unpaid_tuition,
                          @RequestParam(name = "email", required = true) String email,
                          @RequestParam(name = "phone", required = true) String phone,
                          @RequestParam(name = "starting_semester", required = true) String startting_semester,
                          @RequestParam(name = "expected_graduation", required = true) String expected_graduation,
                          @RequestParam(name = "address", required = true) String address,
                          @RequestParam(name = "major", required = true) String major){
        return database.addStudent(emplid, last_name, first_name, dob, credits, gender, unpaid_tuition, email, phone, startting_semester, expected_graduation, address, major);
    }

    @PostMapping("/rest/addCourse")
    public int addCourse(@RequestParam(name = "class_number", required = true) int class_number,
                         @RequestParam(name = "dept", required = true) String dept,
                         @RequestParam(name = "course_number", required = true) int course_number,
                         @RequestParam(name = "class_title", required = true) String class_title,
                         @RequestParam(name = "instructor_name", required = true) String instructor_name,
                         @RequestParam(name = "beginning_time", required = true) String beginning_time,
                         @RequestParam(name = "end_time", required = true) String end_time,
                         @RequestParam(name = "room", required = true) String room,
                         @RequestParam(name = "num_credits", required = true) int num_credits,
                         @RequestParam(name = "section", required = true) String section,
                         @RequestParam(name = "mode_inst", required = true) String mode_inst,
                         @RequestParam(name = "capacity", required = true) int capacity,
                         @RequestParam(name = "semester", required = true) String semester,
                         @RequestParam(name = "si", required = false) String si){
        return database.addCourse(class_number, dept, course_number, class_title, instructor_name,
                beginning_time, end_time, room, num_credits, section, mode_inst, capacity, semester, si);
    }

    @PostMapping("/rest/addRegisteredClass")
    public int addRegisteredClass(@RequestParam(name = "emplid", required = true) int emplid,
                                  @RequestParam(name = "grade", required = true) String grade,
                                  @RequestParam(name = "credits", required = true) int credits,
                                  @RequestParam(name = "department", required = true) String department,
                                  @RequestParam(name = "class_number", required = true) int class_number){
        return database.addRegisteredClass(emplid, grade, credits, department, class_number);
    }

    @PostMapping("/rest/addInstructor")
    public int addInstructor(@RequestParam(name = "title", required = true) String title,
                             @RequestParam(name = "instructor_name", required = true) String instructor_name,
                             @RequestParam(name = "gender", required = true) String gender,
                             @RequestParam(name = "department", required = true) String department,
                             @RequestParam(name = "salary", required = true) int salary){
        return database.addInstructor(title, instructor_name, gender, department, salary);
    }

    @PostMapping("/rest/addDepartment")
    public int addDepartment(@RequestParam(name = "department", required = true) String department,
                             @RequestParam(name = "department_chair", required = true) String department_chair,
                             @RequestParam(name = "budget", required = true) int budget){

        return database.addDepartment(department, department_chair, budget);
    }

    @PostMapping("/rest/addTuitionPayment")
    public int addTuitionPayment(@RequestParam(name = "emplid", required = true) int emplid,
                                 @RequestParam(name = "amount_paid", required = true) int amount_paid,
                                 @RequestParam(name = "date_paid", required = true) Date date_paid){
        return database.addTuitionPayment(emplid, amount_paid, date_paid);
    }

    @PostMapping("/rest/addFinancialAid")
    public int addFinancialAid(@RequestParam(name = "emplid", required = true) int emplid,
                               @RequestParam(name = "grant_money", required = true) int grant_money,
                               @RequestParam(name = "grant_name", required = true) String grant_name,
                               @RequestParam(name = "date_applied", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date_applied){

        //date_applied = new SimpleDateFormat("yyyy-MM-dd").parse(date_applied);

        return database.addFinancialAid(emplid, grant_money, grant_name, date_applied);
    }
}
