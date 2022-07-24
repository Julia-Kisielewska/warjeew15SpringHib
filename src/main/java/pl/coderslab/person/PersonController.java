package pl.coderslab.person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/person")
public class PersonController {
    private final PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("persons", personDao.findAll());
        return "person/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("person", new Person());
        return "person/add";
    }

    @PostMapping("/add")
    public String save(Person person) {
        personDao.save(person);
        return "redirect:/person/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam long id) {
        personDao.delete(personDao.findById(id));
        return "redirect:/person/list";
    }
}
