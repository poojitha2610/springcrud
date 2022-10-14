package com.example.demo.Tester;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Student;
import com.example.demo.Repo.MyRepo;



@Service
public class StudentService {
@Autowired
MyRepo myRepo;
public List<Student> displayData(){
	return myRepo.findAll();
	
}
public void saveStudent(Student student) {
	myRepo.save(student);
}
public Student getStudent(int id) {
return myRepo.findById((long) id).get();

}
public void deleteStudent(int id) {
	myRepo.deleteById((long) id);;
	
}
}
