package com.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ResponseDTO<T> {
    public record Head(int statuscode, String status){  }
    ResponseDTO.Head head;
    private T body;

}
