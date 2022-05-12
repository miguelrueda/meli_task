package com.example.melitask.helper;

import com.example.melitask.dto.Position;

public class MathHelper {

    /**
     * Return the norm of a set of coordinates
     * @param p the position to calculate
     * @return the norm of the coordinates
     */
    public static double getPositionNorm(Position p) {
        return Math.pow(Math.pow(p.getX(), 2) + Math.pow(p.getY(), 2), 0.5);
    }
}
