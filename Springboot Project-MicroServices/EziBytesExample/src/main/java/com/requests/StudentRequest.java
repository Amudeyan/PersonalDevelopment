package com.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Optional;
@Data
@AllArgsConstructor
public class StudentRequest {
    Optional<Integer> id;
    Optional<String> studentName;
    Optional<Integer> studentAge;
}
