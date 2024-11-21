package com.data;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
/*@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "departmentId")*/
@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Department extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer departmentId;
    @Column(nullable = false,unique = true)
    private String deptName;
    //@JsonManagedReference
    @JsonIgnoreProperties("department")
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Student.class,mappedBy = "department")
     private List<Student> student;



}

