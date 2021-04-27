package Entity;

import hibernate_core.HibernateHelper;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Localization {
    @Id
    Long ID;
    String city;
    String region;
    String country;
    Double longitude;
    Double latitude;

    public Localization(String city, String country) {
        this.city = city;
        this.country = country;
//TODO
        try (Session session = HibernateHelper.INSTANCE.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(this);
            transaction.commit();
        }
    }

    @Override
    public String toString() {
        return "Miasto='" + city + '\'' +
                ", kraj='" + country + '\'';
    }

    public Localization() {
    }

    public static List<Localization> getList() {
        try (Session session = HibernateHelper.INSTANCE.getSession()) {
            return session.createQuery("SELECT s FROM Localization s", Localization.class)
                    .getResultList();
        }
    }

    public Long getID() {
        return ID;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }
}
