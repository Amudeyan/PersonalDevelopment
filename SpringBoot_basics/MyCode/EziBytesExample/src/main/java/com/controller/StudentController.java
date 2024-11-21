package com.controller;
import com.data.*;
import com.repository.CourseRepository;
import com.repository.DepartmentRepository;
import com.repository.StudentRepository;

import com.responses.ResponseDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@Slf4j
@AllArgsConstructor
public class StudentController {

private StudentRepository studentRepository;

private DepartmentRepository departmentRepository;

private CourseRepository courseRepository;



/*@GetMapping("/getAge")
public Student getStudent(){
    student.setStudentName("sundu");
    student.setStudentAge(15);
    return student;

}*/
    @PostMapping("/student")
public ResponseEntity<ResponseDTO<Student>> insertStudentDetails(@RequestBody Student student){
        log.error("Entered in post student mapping");
        ResponseDTO<Student> responseDTO = new ResponseDTO<>();
       Optional<Student> studentOptional =studentRepository.findByStudentName(student.getStudentName());
       Optional<Department> departmentOptional = departmentRepository.findByDeptName(student.getDepartment().getDeptName());
        if(studentOptional.isPresent()){

            departmentOptional.ifPresent(student::setDepartment);
            responseDTO.setBody(student);
            responseDTO.setHead(new ResponseDTO.Head(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase()));
            return ResponseEntity.ok(responseDTO);
       }
       else{
         departmentOptional.ifPresent(student::setDepartment);
       }
       Student student1=studentRepository.save(student);
        log.info(student1.toString());
        log.error(student1.toString());

        log.debug(student1.toString());
        log.warn(student1.toString());
        log.trace(student1.toString());
       responseDTO.setBody(student1);
       responseDTO.setHead(new ResponseDTO.Head(HttpStatus.CREATED.value(), HttpStatus.CREATED.getReasonPhrase()));

    return ResponseEntity.ok(responseDTO);
}
    @GetMapping("/student")
    public List<Student>  getStudentDetails(){
       /* List<Student> students = studentRepository.findAll();
        students.forEach(System.out::println);
        students.forEach(student -> {



        });*/
       // List<Student> students = studentRepository.findAll();
       //Student student = students.get(0);
    return studentRepository.findAll();
      //  return studentRepository.findAllStudentsWithDepartments();
    }
    @GetMapping("/departments")
    public List<Department> getDepartmentDetails(){
        log.error("Entered in get department mapping");
        List<Department> department = departmentRepository.findAll();
       // List<Departments> departments = ;
       // departments.forEach(department -> department.getStudent().forEach(student -> student.setDepartment(null)));
        return department;
    }
    @GetMapping("/department")
    public ResponseEntity<ResponseDTO<Optional<Department>>> getDepartment(@RequestParam String dept){
        ResponseDTO<Optional<Department>> responseDTO = new ResponseDTO<>();
         Optional<Department> department =(departmentRepository.findByDeptName(dept));
         List<Student> students = studentRepository.findAll();
        /*department.ifPresent((value -> value.getStudent()
                .forEach(student -> student.setDepartment(null))));*/
        ResponseDTO.Head head = new ResponseDTO.Head(HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase());
        responseDTO.setHead(new ResponseDTO.Head(HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase()));
        responseDTO.setBody(department);
         return ResponseEntity.ofNullable(responseDTO);
    }
    @PatchMapping("/student")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        Optional<Student> updateStu = studentRepository.findByStudentName(student.getStudentName());
        updateStu.ifPresent(value -> {
            student.setId(value.getId());
            student.setStudentAge(student.getStudentAge());
            if(value.getDepartment().getDeptName().equalsIgnoreCase(student.getDepartment().getDeptName()))
                student.getDepartment().setDepartmentId(value.getDepartment().getDepartmentId());
            student.getAddress().setAddressId(value.getAddress().getAddressId());
        });

        Student upStudent = studentRepository.save(student);
        return ResponseEntity.ok(upStudent);
    }

    @GetMapping("/getStudentAddress")
    public StudentAddress getStudentAddr(){
       return null;
    }

    /*@Bean
    public StudentAddress studentAddress(){

        StudentAddress st =new StudentAddress("502","Chennai");
        System.out.println(st.getCity());
        return st;

    }*/

    @PostMapping("/course")
    public Courses createCourse(@RequestBody Courses course){
        return courseRepository.save(course);
    }
    @GetMapping("/courses")
    public List<Courses> createCourse(){
       // return courseRepository.findAll();
        return courseRepository.findAll(Sort.by("courseName").descending());
    }
    @GetMapping("/studentsp/{id}")
    public List<Student> getCourse(@PathVariable Integer id){
        // return courseRepository.findAll();
        Pageable pageable = PageRequest.of(id-1,2,Sort.by("studentName").descending());
        Page<Student> page = studentRepository.findAll(pageable);
        return page.stream().toList();
    }
}
