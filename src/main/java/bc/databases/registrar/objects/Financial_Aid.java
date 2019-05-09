package bc.databases.registrar.objects;

import java.util.Date;

public class Financial_Aid {
    int emplid;
    int grant_money;
    String grant_name;
    Date date_applied;

    public int getEmplid() {
        return emplid;
    }

    public void setEmplid(int emplid) {
        this.emplid = emplid;
    }

    public int getGrant_money() {
        return grant_money;
    }

    public void setGrant_money(int grant_money) {
        this.grant_money = grant_money;
    }

    public String getGrant_name() {
        return grant_name;
    }

    public void setGrant_name(String grant_name) {
        this.grant_name = grant_name;
    }

    public Date getDate_applied() {
        return date_applied;
    }

    public void setDate_applied(Date date_applied) {
        this.date_applied = date_applied;
    }
}
