package com.data;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.Constraint;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Students  {

    private Integer id;
    private String studentName;
    private Integer studentAge;
    private Address address;
    private Department department;
}
