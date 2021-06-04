package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DailyReport {
    private List<Product> madeProducts = new ArrayList<>();
    private Date date;
    private String responsiblePerson;

    public List<Product> getMadeProducts() {
        return madeProducts;
    }

    public void setMadeProducts(List<Product> madeProducts) {
        this.madeProducts = madeProducts;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(String user) {
        this.responsiblePerson = user;
    }
}
