package pl.coderslab.books;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "books")
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(min = 5)
    @NotBlank
    private String title;
    //    @Range(min = 1, max = 10)
    //range jako int jest nullem, dlatego pojawia się błąd
    private int rating;
    @Length(max = 600)
    @NotBlank
    private String description;

    @Min(2)
    @Column(name = "pages")
    private Integer pages;

    @ManyToOne
//    @NotNull
    private Publisher publisher;

    @ManyToMany
//    @NotEmpty
    private List<Author> authors;

    @ManyToOne
    private Category category;
}
