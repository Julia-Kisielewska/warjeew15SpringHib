package pl.coderslab.books;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/publisher-form")
public class PublisherFormController {

private final PublisherDao publisherDao;

    public PublisherFormController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }


    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("publishers", publisherDao.findAll());
        return "publisher-form/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
       Publisher publisher = new Publisher();
        model.addAttribute("publisher", publisher);
        return "publisher-form/add";
    }
    @PostMapping("/add")
    public String save(Publisher publisher, Model model) {
        publisherDao.save(publisher);
        //save
        return "redirect:/publisher-form/list";
    }
    @GetMapping("/edit")
    public String edit(Model model, @RequestParam(name = "id") String id) {
        long idVal = Long.parseLong(id);
        Publisher publisher = publisherDao.findById(idVal);
        model.addAttribute("publisher", publisher);
        return "publisher-form/add";
    }

    @PostMapping("/edit")
    public String edit (Publisher publisher, Model model){
        publisherDao.update(publisher);
        return "redirect:/publisher-form/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") String id, Model model) {
        long idVal = Long.parseLong(id);
        Publisher publisher = publisherDao.findById(idVal);
        model.addAttribute("publisher", publisher);
        return "/publisher-form/delete";
    }

    @PostMapping("/delete")
    public String delete(Publisher publisher, Model model){
        publisherDao.delete(publisher);
        return "redirect:/publisher-form/list";
    }
}
