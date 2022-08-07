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
import java.util.stream.Collectors;

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

        return categoryName
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

    @Transactional
    @RequestMapping("/title2")
    public String getByTitle2(@RequestParam(value = "title") String title) {
        return bookRepository.findByTitle2(title).stream()
                .map(Book::toString)
                .collect(Collectors.joining(toString()));
    }
//    @RequestMapping("/title2")
//    public List<Book> getByTitle2(@RequestParam(value = "title") String title) {
//        return bookRepository.findByTitle2(title);
//    }
//    //nie ma biblioteki Jackson - konwersja na JSONa dlatego nie działa

    //    @Transactional
    @RequestMapping("/category")
    public String getByCategory(@RequestParam(value = "category") String category) {
        return bookRepository.findByCategory(category).stream()
                .map(Book::toString)
                .collect(Collectors.joining(toString()));
    }

    @Transactional
    @RequestMapping("/rating")
    public String getByRatingRange(@RequestParam("min") String min,
                                   @RequestParam("max") String max) {
        int minVal= Integer.parseInt(min);
        int maxVal= Integer.parseInt(max);
        return bookRepository.findByRatingRange(minVal, maxVal).stream()
                .map(Book::toString)
                .collect(Collectors.joining(toString()));
    }

    @Transactional
    @RequestMapping("/publisher")
    public String getByPublisherName(@RequestParam("publisher") String publisher) {

        return bookRepository.findByPublisherName(publisher).stream()
                .map(Book::toString)
                .collect(Collectors.joining(toString()));
    }
}
