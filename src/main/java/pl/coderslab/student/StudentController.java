package pl.coderslab.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/add")
    public String add(){
        return "student/add";
    }

    @PostMapping("/add")
    public String save(Student student, Model model){
       model.addAttribute("student", student);
        return "student/save";
    }
}
