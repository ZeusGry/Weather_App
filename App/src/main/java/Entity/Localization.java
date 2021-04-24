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
}
