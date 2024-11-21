package com.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Primary;

@Data
//@AllArgsConstructor
public class StudentAddress {




    private String houseno;
    private String city;
    {
        System.out.println("Instance Student Adress");
    }
    public StudentAddress(){
        System.out.println("Student Adress");
    }
    public StudentAddress(String houseno,String city){
        this.city =city;
        this.houseno = houseno;
        System.out.println("parameterized student address");
    }
}
