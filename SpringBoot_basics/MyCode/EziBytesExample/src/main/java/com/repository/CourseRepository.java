package com.repository;

import com.data.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface CourseRepository extends JpaRepository<Courses,Integer> {

    List<Courses> findDistinctByCourseName(String courseName);


}
