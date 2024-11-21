package com.data;

import com.data.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    Integer addressId;
String addressLine1;
String addressLine2;
String city;
String state;
String country;
@JsonIgnore
@OneToOne(mappedBy = "address",targetEntity = Student.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
Student student;

}
