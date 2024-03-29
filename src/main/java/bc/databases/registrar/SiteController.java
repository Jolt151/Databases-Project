package bc.databases.registrar;

import bc.databases.registrar.objects.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SiteController {

    DatabaseImpl database;
    @Autowired
    public SiteController(DatabaseImpl database){
        this.database = database;
    }

    @GetMapping({"/", "/index.html", "/home", "/home.html"})
    public String index(){
        return "home";
    }

    @GetMapping("/extractingData.html")
    public String viewTable(Model model){

        List<Department> departments = database.getDepartments();
        model.addAttribute("departments", departments);

        List<Financial_Aid> financial_aids = database.getFinancialAid();
        model.addAttribute("finAid", financial_aids);

        List<Tuition_Payment> tuition_payments = database.getTuition_Payments();
        model.addAttribute("tuition", tuition_payments);

        List<Registered_Classes> classes = database.getRegisteredClasses();
        model.addAttribute("classes", classes);

        List<Instructor> instructors = database.getInstructors();
        model.addAttribute("instructors", instructors);

        List<Course> courses = database.getCourses();
        model.addAttribute("courses", courses);

        List<Student> students = database.getStudents();
        model.addAttribute("students", students);

        return "extractingData";
    }

}
