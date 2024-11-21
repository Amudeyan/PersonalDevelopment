package com.repository;

import com.data.Department;
import com.data.Student;
import com.data.Students;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student,Integer> {

  // @Modifying
    Optional<Student> findByStudentName(String studentName);
    @Query("select s from Student s join fetch s.department")
     List<Student> findAllStudentsWithDepartments();
    Optional<Student> findByStudentNameIgnoreCase(String studentName);
    List<Student> findByStudentNameOrderByStudentNameAsc(String studentName);

   // Page<Student> findAll(Pageable pageable);



}
