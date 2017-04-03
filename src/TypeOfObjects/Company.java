package TypeOfObjects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by Diabolo on 02.04.2017.
 */
public class Company {
    private int id;
    private String name;
    private double capital;
    private Date dateOfCreation;
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public Company() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setId(String id) {
        int intId = Integer.parseInt(id);
        this.id = intId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }
    public void setCapital(String capital) {
        double capitalToDouble = Double.parseDouble(capital);
        this.capital = capitalToDouble;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public void setDateOfCreation(String dateOfCreation) throws ParseException {
        Date dateOfCreationDate = formatter.parse(dateOfCreation);
        this.dateOfCreation = dateOfCreationDate;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capital=" + capital +
                ", dateOfCreation=" + dateOfCreation +
                ", formatter=" + formatter +
                '}';
    }
}
