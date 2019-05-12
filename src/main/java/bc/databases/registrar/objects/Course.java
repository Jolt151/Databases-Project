package bc.databases.registrar.objects;

public class Course {
    int class_number;
    String dept;
    int course_number;
    String class_title;
    String instructor_name;
    String beginning_time;
    String end_time;
    String room;
    int num_credits;
    String sections;
    String mode_inst;
    int capacity;
    String semester;
    String si;

    public int getClass_number() {
        return class_number;
    }

    public void setClass_number(int class_number) {
        this.class_number = class_number;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getCourse_number() {
        return course_number;
    }

    public void setCourse_number(int course_number) {
        this.course_number = course_number;
    }

    public String getClass_title() {
        return class_title;
    }

    public void setClass_title(String class_title) {
        this.class_title = class_title;
    }

    public String getInstructor_name() {
        return instructor_name;
    }

    public void setInstructor_name(String instructor_name) {
        this.instructor_name = instructor_name;
    }

    public String getBeginning_time() {
        return beginning_time;
    }

    public void setBeginning_time(String beginning_time) {
        this.beginning_time = beginning_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getNum_credits() {
        return num_credits;
    }

    public void setNum_credits(int num_credits) {
        this.num_credits = num_credits;
    }

    public String getSections() {
        return sections;
    }

    public void setSections(String sections) {
        this.sections = sections;
    }

    public String getMode_inst() {
        return mode_inst;
    }

    public void setMode_inst(String mode_inst) {
        this.mode_inst = mode_inst;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getSi() {
        return si;
    }

    public void setSi(String si) {
        this.si = si;
    }
}
