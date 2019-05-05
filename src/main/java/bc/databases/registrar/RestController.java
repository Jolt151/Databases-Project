package bc.databases.registrar;

import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    DatabaseImpl database;

    public RestController(DatabaseImpl database){
        this.database = database;
    }

    @PostMapping("/rest/addStudent")
    public int addStudent(){
        return database.addStudent();
    }

    @PostMapping("/rest/addCourse")
    public int addCourse(){
        return database.addCourse();
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
