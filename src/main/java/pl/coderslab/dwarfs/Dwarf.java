
package pl.coderslab.dwarfs;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "dwarfs")
public class Dwarf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "latitude")
    private String lat;
    private String lng;

    private String street;
    private String nearestNumber;

    @Transient
    private long distanceFromPapa;

//    @PrePersist
//    public void prePersist() {
//        LocalDateTime createdOn = LocalDateTime.now();
//    }
    //todo sprawdzić działanie

}