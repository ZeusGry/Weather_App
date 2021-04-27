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
