package bc.databases.registrar.objects;

import java.util.Date;

public class Student {
    int emplid;
    String last_name;
    String first_name;
    Date dob;
    int credits;
    String gender;
    int unpaid_tuition;
    String email;
    String phone;
    String starting_semester;
    String expected_graduation;
    String address;
    String major;

    public int getEmplid() {
        return emplid;
    }

    public void setEmplid(int emplid) {
        this.emplid = emplid;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getUnpaid_tuition() {
        return unpaid_tuition;
    }

    public void setUnpaid_tuition(int unpaid_tuition) {
        this.unpaid_tuition = unpaid_tuition;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStarting_semester() {
        return starting_semester;
    }

    public void setStarting_semester(String starting_semester) {
        this.starting_semester = starting_semester;
    }

    public String getExpected_graduation() {
        return expected_graduation;
    }

    public void setExpected_graduation(String expected_graduation) {
        this.expected_graduation = expected_graduation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
