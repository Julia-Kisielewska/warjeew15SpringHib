package pl.coderslab.books;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
@RequestMapping("/validate")
//@RequiredArgsConstructor
public class ValidationController {

    private final Validator validator;

    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping
//    @ResponseBody
    public String validate(Model model) {
        Book book = new Book();
        book.setPages(1);
        Set<ConstraintViolation<Book>> validationResult = validator.validate(book);

        if (!validationResult.isEmpty()) {
            validationResult.forEach(violation -> {
                System.out.println(violation.getPropertyPath() + " " + violation.getMessage());
            });
        }
//        return validationResult.stream()
//                .map(s -> s.getPropertyPath() + " "+ s.getMessage())
//                .collect(Collectors.joining("\n"));
        model.addAttribute("validationResult", validationResult);

        return "/validate/validate";
    }

    @GetMapping("/author")
//    @ResponseBody
    public String validateAuthor(Model model) {
        Author author = new Author();
//        author.setFirstName("Joanna");
        author.setLastName("Bator");
        author.setPesel("90010806301a");
        author.setEmail("joanna.batorgmail.com");
        Set<ConstraintViolation<Author>> validationResult = validator.validate(author);
        model.addAttribute("validationResult", validationResult);

        return "/validate/validateAuthor";
    }

    @GetMapping("/publisher")
//    @ResponseBody
    public String validatePublisher(Model model) {
        Publisher publisher = new Publisher();
        publisher.setNip("5213650730");
        publisher.setRegon("146734507");
        Set<ConstraintViolation<Publisher>> validationResult = validator.validate(publisher);
        model.addAttribute("validationResult", validationResult);

        return "/validate/validatePublisher";
    }
}
