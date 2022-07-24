package pl.coderslab.dwarfs;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/dwarf")
public class DwarfController {

    private final DwarfService dwarfService;

    public DwarfController(DwarfService dwarfService) {
        this.dwarfService = dwarfService;
    }

    @RequestMapping("/create")
    @ResponseBody
    public String saveDwarf() {
        Dwarf dwarf = new Dwarf();
        dwarf.setName("Konstruktor");
        dwarfService.save(dwarf);
        return "ok";
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getDwarf(@PathVariable Long id) {
        Dwarf byId = dwarfService.findById(id);
        System.out.println(byId.getName());
        return "";
    }

    @GetMapping("/all")
    @ResponseBody
    public String showAll() {
        dwarfService.findAll().
                forEach(d -> System.out.println(d.getName()));
        return "list";
    }

}