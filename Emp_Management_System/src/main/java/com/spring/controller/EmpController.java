package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.Entity.EmployeeEntity;
import com.spring.service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
	@Autowired
	private EmpService service;
	
	@GetMapping("/")
	public String home(Model m) {
		List<EmployeeEntity> emp = service.getAllEmp();
		m.addAttribute("emp", emp);
		
		return "index";
	}
	
	@GetMapping("/add_emp")
	public String add_emp() {
		return "add_emp";
	}
	
	@PostMapping("/register")
	public String addEmployee(@ModelAttribute EmployeeEntity e, HttpSession session) {
		service.addEmp(e);
		System.out.println(e);
		session.setAttribute("msg", "Emp added successfully ....");
		return "add_emp";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		EmployeeEntity e = service.getEmpById(id);
		m.addAttribute("emp", e);
		return "edit";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, HttpSession session) {
		service.deleteEmp(id);
		session.setAttribute("msg", "Emp deleted successfully ...");
		
		return "redirect:/";
	}
}
