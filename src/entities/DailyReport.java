package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DailyReport {
    private List<Product> madeProducts = new ArrayList<>();
    private Date date;
    private User responsiblePerson;

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

    public User getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(User responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }
}
