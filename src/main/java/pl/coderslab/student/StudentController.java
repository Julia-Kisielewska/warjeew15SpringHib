package pl.coderslab.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/add")
    public String add(Model model) {

        model.addAttribute("student", new Student());
        return "student/add";
    }

    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }
    @ModelAttribute("programmingSkills")
    public List<String> programmingSkills() {
        return Arrays.asList("Java", "Python", "PHP", "Ruby", "SQL");
    }
    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("Reading", "Music", "Jogging", "Programming", "Singing");
    }


    @PostMapping("/add")
    public String save(Student student, Model model) {
        model.addAttribute("student", student);
        return "student/save";
    }
}
