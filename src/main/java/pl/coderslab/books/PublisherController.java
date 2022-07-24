package pl.coderslab.books;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

    private final PublisherDao publisherDao;

    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String savePublisher() {
        Publisher publisher = Publisher.builder().
                name("Znak").
                build();
        publisherDao.save(publisher);
        return "";
    }

    @RequestMapping("/update/{id}/{name}")
    @ResponseBody
    public String updatePublisher(@PathVariable long id, @PathVariable String name) {
        Publisher publisher = publisherDao.findById(id);
        publisher.setName(name);
        publisherDao.update(publisher);
        return publisher.toString();
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getPublisher(@PathVariable Long id) {
        Publisher publisher = publisherDao.findById(id);
        return publisher.toString();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        Publisher publisher = publisherDao.findById(id);
        publisherDao.delete(publisher);
        return "deleted";
    }
    @RequestMapping("/all")
    @ResponseBody
    public String showAll(){
        publisherDao.findAll().forEach(p -> System.out.println(p.getName()));
        return "list";
    }
}
