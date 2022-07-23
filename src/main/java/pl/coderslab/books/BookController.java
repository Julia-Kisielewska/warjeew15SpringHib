package pl.coderslab.books;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String saveBook() {
        Book book = Book.builder().
                title("Harry Potter i Czara Ognia").
                rating(5).
                description("Czwarta część przygód Harry'ego").
                build();

        bookDao.save(book);
        return "";
    }

    @RequestMapping("/update/{id}/{title}")
    @ResponseBody
    public String updateBook(@PathVariable long id, @PathVariable String title) {
        Book book = bookDao.findById(id);
        book.setTitle(title);
        bookDao.update(book);
        return book.toString();
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable Long id) {
        Book byId = bookDao.findById(id);
        return byId.toString();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        return "deleted";
    }

    @ResponseBody
    @GetMapping("save-publisher-book")
    public String savePublisherAndBook() {
        Publisher publisher = new Publisher();
        publisher.setName("Helion");
        publisherDao.save(publisher);

        Book book = new Book();
        book.setTitle("Ania z Zielonego Wzgórza");
        book.setPublisher(publisher);
        bookDao.save(book);

        return "";
    }

    @ResponseBody
    @GetMapping("save-author-book/{id1}/{id2}")
    public String saveAuthorAndBook(@PathVariable Long id1,
                                    @PathVariable Long id2) {

        Author author1 = authorDao.findById(id1);
        Author author2 = authorDao.findById(id2);
//        List<Author> authors = List.of(author1, author2);
        List<Author> authors = new ArrayList<>();
        authors.add(author1);
        authors.add(author2);

//        Book book = bookDao.findById(3L);
        Book book = new Book();
        book.setTitle("To");
        book.setAuthors(authors);
        bookDao.save(book);

        return "";
    }

}
