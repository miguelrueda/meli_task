package com.example.melitask.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SplitSecretRequest {
    private Double distance;
    private String [] message;
}
