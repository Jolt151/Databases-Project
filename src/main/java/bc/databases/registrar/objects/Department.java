package bc.databases.registrar.objects;

public class Department {
    String department;
    String department_chair;
    int budget;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment_chair() {
        return department_chair;
    }

    public void setDepartment_chair(String department_chair) {
        this.department_chair = department_chair;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}
