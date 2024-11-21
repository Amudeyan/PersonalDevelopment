package com.repository;

import com.data.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    Optional<Department> findByDeptName(String deptName);
    Optional<Department> findDistinctByDeptName(String deptName);




}
