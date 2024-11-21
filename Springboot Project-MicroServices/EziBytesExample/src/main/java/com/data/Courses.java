package com.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Courses extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer courseId;
    private String courseName;
    @JsonIgnoreProperties("courses")
    @ManyToMany(mappedBy = "courses",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
   /* @JoinTable(name = "student_course",
            inverseJoinColumns = {@JoinColumn(name = "id",referencedColumnName = "id")},
            joinColumns = {@JoinColumn(name = "course_id",referencedColumnName = "courseId") })*/
    private List<Student> students ;

}
