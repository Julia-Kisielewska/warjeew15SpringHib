package pl.coderslab.books;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/book-form")
public class BookFormController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;

    private final AuthorDao authorDao;

    public BookFormController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("books", bookDao.findAll());
        return "book-form/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        model.addAttribute("publishers", publisherDao.findAll());
        model.addAttribute("authors", authorDao.findAll());
        return "book-form/add";
    }
    @ModelAttribute("authors")
    public List<Author> authors() {
        return this.authorDao.findAll();
    }

    @PostMapping("/add")
    public String save(Book book, Model model) {
        bookDao.save(book);
        //save
        return "redirect:/book-form/list";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam(name = "id") String id) {
        long idVal = Long.parseLong(id);
        Book book = bookDao.findById(idVal);
        model.addAttribute("book", book);
//        model.addAttribute("publishers", publisherDao.findAll());
        return "book-form/add";
    }

    @PostMapping("/edit")
    public String edit (Book book, Model model){
        bookDao.update(book);
        return "redirect:/book-form/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") String id, Model model) {
        long idVal = Long.parseLong(id);
        Book book = bookDao.findById(idVal);
        model.addAttribute("book", book);
        model.addAttribute("publishers", publisherDao.findAll());
        model.addAttribute("authors", authorDao.findAll());
        return "/book-form/delete";
    }

    @PostMapping("/delete")
    public String delete(Book book, Model model){
        bookDao.delete(book);
        return "redirect:/book-form/list";

    }
}