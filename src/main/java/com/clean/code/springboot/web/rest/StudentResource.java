package com.clean.code.springboot.web.rest;

import com.clean.code.springboot.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")

public class StudentResource {
    @GetMapping("/learner")
    public ResponseEntity getAll(){
        Student student=new Student(1,"Axbor","A'zamov","5-kurs");
        Student student1=new Student(2,"Dilshod","Nabiyev","5-kurs");
        Student student2=new Student(3,"Arman","Ergashov","5-kurs");
        List<Student> students=new ArrayList<>();
        students.add(student);
        students.add(student1);
        students.add(student2);
        return ResponseEntity.ok(students);
    }
    @GetMapping("/students/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        Student student=new Student(id,"Axbor","A'zamov","5-kurs");
        return ResponseEntity.ok(student);
    }
    @PostMapping("/students")
    public ResponseEntity create(@RequestBody Student student){
        return ResponseEntity.ok(student);
    }
    @GetMapping("/students")
    public ResponseEntity getOne(@RequestParam Long id,
                                 @RequestParam String name,
                                 @RequestParam String lastName,
                                 @RequestParam String course){
        Student student=new Student(id,name,lastName,course);
        return ResponseEntity.ok(student);
    }
    @DeleteMapping("/students/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.ok("Ma'lumot o'chirildi");
    }
    @PutMapping("/students/{id}")
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestBody Student studentNew) {
        Student student = new Student(1, "Axbor", "A'zamov", "5-kurs");
        student.setId(id);
        student.setName(studentNew.getName());
        student.setLastName(studentNew.getLastName());
        return ResponseEntity.ok(student);
    }
}
