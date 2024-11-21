package com.data;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
//@Component
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Student extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private Integer id;
    private String studentName;
    private Integer studentAge;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity = Address.class)
    @JoinColumn(name = "address_id",referencedColumnName = "addressId" )
    private Address address;
    //@JsonBackReference //or @JsonIgnore
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //@JsonIgnore
    @JsonIgnoreProperties("student")
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id",referencedColumnName = "departmentId",nullable = true)
    private Department department;
    @JsonIgnoreProperties("students")
    @ManyToMany(fetch = FetchType.EAGER,targetEntity = Courses.class,cascade = CascadeType.ALL)
    @JoinTable(name = "student_course",
    joinColumns = {@JoinColumn(name = "id",referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "course_id",referencedColumnName = "courseId")})
    private List<Courses> courses ;


}
