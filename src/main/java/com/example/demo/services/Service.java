package com.example.demo.services;

import com.example.demo.models.Emp;
import com.example.demo.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private Repo repository;

    public Emp addEmp(Emp emp){
        return repository.save(emp);
    }

    public List<Emp> getEmpLists(){
      List<Emp> empLists = repository.findAll();
      return empLists;
    }

    public Optional<Emp> getEmpById(Long id){
        return repository.findById(id);
    }

}
