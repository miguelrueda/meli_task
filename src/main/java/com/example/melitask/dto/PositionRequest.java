package com.example.melitask.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionRequest {

    private String name;
    private Double distance;
    private String [] message;

    @Override
    public String toString() {
        return "PositionRequest{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                ", message=" + Arrays.toString(message) +
                '}';
    }
}
