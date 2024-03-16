package kz.bitlab.techordaC3.springproject.controllers;

import kz.bitlab.techordaC3.springproject.models.DBManager;
import kz.bitlab.techordaC3.springproject.models.DBManagerStudents;
import kz.bitlab.techordaC3.springproject.models.Item;
import kz.bitlab.techordaC3.springproject.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
@Controller
public class StudentHomeController {
    @GetMapping(value = "/students")
    public String index(Model model){
        ArrayList<Student> students = DBManagerStudents.getAllStudents();
        model.addAttribute("students",students);
        return "students/students";
    }
    @GetMapping(value = "/addStudent")
    public String addStudent() {
        return "students/addStudent";
    }
    @PostMapping(value = "/addStudent")
    public String addStudent(@RequestParam(name = "name") String name,
                             @RequestParam(name = "surname") String surname,
                             @RequestParam(name = "exam") int exam,
                             Model model) {
        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setExam(exam);
        DBManagerStudents.addStudent(student);
        return "redirect:/students";
    }
    @GetMapping(value = "/findStudent")
    public String findStudent()
}
