package com.example.melitask.dto;

import com.example.melitask.dto.Position;

public class Satellite {

    private String name;
    private Position position;

    public Satellite(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
