package bc.databases.registrar.objects;

import java.util.Date;

public class Tuition_Payment {
    int emplid;
    int amount_paid;
    Date date_paid;

    public int getEmplid() {
        return emplid;
    }

    public void setEmplid(int emplid) {
        this.emplid = emplid;
    }

    public int getAmount_paid() {
        return amount_paid;
    }

    public void setAmount_paid(int amount_paid) {
        this.amount_paid = amount_paid;
    }

    public Date getDate_paid() {
        return date_paid;
    }

    public void setDate_paid(Date date_paid) {
        this.date_paid = date_paid;
    }
}
