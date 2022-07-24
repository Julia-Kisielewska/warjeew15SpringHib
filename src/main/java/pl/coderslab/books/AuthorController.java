package pl.coderslab.books;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/author")
public class AuthorController {
    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String saveAuthor() {
        Author author = Author.builder().
                firstName("J.K.").
                lastName("Rowling").
                build();

        authorDao.save(author);
        return "";
    }

    @RequestMapping("/update/{id}/{lastName}")
    @ResponseBody
    public String updateAuthor(@PathVariable Long id, @PathVariable String lastName) {
        Author byId = authorDao.findById(id);
        byId.setLastName(lastName);
        authorDao.update(byId);
        return byId.toString();
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getAuthor(@PathVariable Long id) {
        Author byId = authorDao.findById(id);
        return byId.toString();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteAuthor(@PathVariable long id) {
        Author byId = authorDao.findById(id);
        authorDao.delete(byId);
        return "deleted";
    }
    @RequestMapping("/all")
    @ResponseBody
    public String showAll(){
        authorDao.findAll().forEach(a -> System.out.println(a.getFirstName()));
        return "list";
    }

}
