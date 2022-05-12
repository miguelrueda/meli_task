package com.example.melitask.service;

import com.example.melitask.dto.Position;

public interface LocationService {

    Position getLocation(Double [] distances);

    String getMessage(String [] messages);

}
