package com.example.demo;

import com.example.demo.controller.Controller;
import com.example.demo.models.Emp;
import com.example.demo.repository.Repo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class NewApplicationTests {

	@Autowired
	private Controller controller;
	@MockBean
	private Repo repository;
	@Test
	public void getModel0Test(){
		when(repository.findAll()).thenReturn(Stream.of(new Emp(1L,"nishchay",2L),new Emp (1345L,"nishchay",23543L)).collect(Collectors.toList()));
		assertEquals(2,controller.getAllEmp().size());
	}
	@Test
	void contextLoads() {
	}

}
