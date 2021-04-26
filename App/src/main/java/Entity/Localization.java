package Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Localization {
    @Id
    Long ID;
    String city;
    String region;
    String country;
    Double longitude;
    Double latitude;

    public Long getID() {
        return ID;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }
}
