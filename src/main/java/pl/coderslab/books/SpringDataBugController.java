package pl.coderslab.books;

import org.hibernate.mapping.Set;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.repository.BookRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/spring-data-bug")
public class SpringDataBugController {

    private final BookRepository bookRepository;

    public SpringDataBugController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    @Transactional
    public String getBookByCategory(@RequestParam(value = "categoryName", required = false) Optional<String> categoryName) {

     return    categoryName
                .map(bookRepository::findByCategoryName)
                .map(List::toString)
                .orElse("Brak");
    }
//    @GetMapping("/author")
//    @Transactional
//    public String getBookByAuthor(@RequestParam(value = "authorName", required = false) Optional<String> authorName) {
//todo pobrac obiekt i wygenerować author repo
//
//        return    authorName
//                .map(bookRepository::findByAuthorsIsStartingWith)
//                .map(List::toString)
//                .orElse("Brak");
//    }
}
