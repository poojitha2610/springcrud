package com.example.demo.Repo;





import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Student;

 public interface MyRepo extends JpaRepository<Student, Long>
{

}
