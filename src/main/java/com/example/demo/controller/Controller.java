package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.models.Emp;
import com.example.demo.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {
  @Autowired
  Repo repository;

    @GetMapping("/getemployees")
    public  List<Emp> getAllEmp() {
        return repository.findAll();

    }
    @PostMapping("/saveemployees")
    public Emp createEmp(@Valid @RequestBody Emp emp){
        return repository.save(emp);
    }

    public Emp getEmpById(@PathVariable(value = "id") Long id){
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Emp","id",id));
    }

    @RequestMapping("/updateemployees/{id}")
    public Emp updateEmp(@PathVariable(value = "id") Long id, @Valid@RequestBody Emp empDetails){
        Emp emp = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Emp","id",id));
        emp.setId(empDetails.getId());
        emp.setName(empDetails.getName());
        emp.setAge(empDetails.getAge());

        Emp updateEmp = repository.save(emp);
        return updateEmp;
    }

    public ResponseEntity<?> deleteEmp(@PathVariable(value = "id") Long empId){
        Emp emp = repository.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Emp","id",empId));
        repository.delete(emp);
        return ResponseEntity.ok().build();
    }
}