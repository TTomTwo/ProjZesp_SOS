package WWSIS.controller;

import WWSIS.entity.Student;
import WWSIS.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/studenci")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student dodajStudenta(@RequestBody Student student) {
        return studentService.zapiszStudenta(student);
    }

    @GetMapping("/{email}")
    public Student getByEmail(@PathVariable String email) {
        return studentService.znajdzPoEmail(email);
    }
}