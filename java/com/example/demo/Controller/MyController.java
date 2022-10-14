package com.example.demo.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Model.Student;
import com.example.demo.Tester.StudentService;

@Controller
public class MyController {
@Autowired	
StudentService service;
@RequestMapping("/")
public String shoehomepage(Model model) {
	System.out.println("display is called");
	List<Student> list=service.displayData();
    model.addAttribute("abc", list);
	return "show";
}
@RequestMapping("/addData")
public String newData(Model model) {
	Student student=new Student();
	model.addAttribute("student", student);
	return "add_pro";
}

@RequestMapping(value="/save1",method = RequestMethod.POST)
public String saveAfter(@ModelAttribute("student") Student student) {
	service.saveStudent(student);
	return "redirect:/";
	
}
@RequestMapping("/edit/{id}")
public ModelAndView editData(@PathVariable(name = "id")int id) {
	ModelAndView modelAndView=new ModelAndView("edit_data");
	Student student=service.getStudent(id);
	modelAndView.addObject("student",student);
	return modelAndView;
	
}
@RequestMapping("/delete/{id}")
public String deleteData(@PathVariable(name = "id")int id) {
	service.deleteStudent(id);
	return "redirect:/";
	
}
}
