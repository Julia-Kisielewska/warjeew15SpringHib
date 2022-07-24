package pl.coderslab.person;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "details")
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private int streetNumber;
    private String street;
    private String city;
}
