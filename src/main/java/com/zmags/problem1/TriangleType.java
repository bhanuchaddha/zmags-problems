package com.zmags.problem1;

/**
 * Created by ben on 19-05-2017.
 * Defines type of Triangle and corresponding return value
 */
public enum TriangleType {
    SCALENE(1),
    ISOSCELES(2),
    EQUILATERAL(3),
    ERROR(4)
    ;

    private int value;

    TriangleType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }


}
