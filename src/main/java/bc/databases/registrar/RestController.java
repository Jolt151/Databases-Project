package bc.databases.registrar;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    DatabaseImpl database;

    public RestController(DatabaseImpl database){
        this.database = database;
    }

    @PostMapping("/rest/addStudent")
    public int addStudent(@RequestParam(name = "dob", required = true) Date dob,
                          @RequestParam(name = "last", required = true) String first,
                          @RequestParam(name = "first", required = true) String last,
                          @RequestParam(name = "credits", required = true) int credits,
                          @RequestParam(name = "gender", required = true) String gender){
        return database.addStudent(dob, first, last, credits, gender);
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
    public int addRegisteredClass(){
        return database.addRegisteredClass();
    }

    @PostMapping("/rest/addInstructor")
    public int addInstructor(){
        return database.addInstructor();
    }

    @PostMapping("/rest/addDepartment")
    public int addDepartment(){
        return database.addDepartment();
    }

    @PostMapping("/rest/addTuitionPayment")
    public int addTuitionPayment(){
        return database.addTuitionPayment();
    }

    @PostMapping("/rest/addFinancialAid")
    public int addFinancialAid(){
        return database.addFinancialAid();
    }
}
