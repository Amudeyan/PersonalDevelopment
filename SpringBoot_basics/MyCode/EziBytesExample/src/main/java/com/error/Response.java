package com.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Response {
    Integer statusCode;
    String statusMsg;

    public Response(){

    }
}
