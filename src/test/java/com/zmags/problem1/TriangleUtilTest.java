package com.zmags.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ben on 19-05-2017.
 */
public class TriangleUtilTest{


    TriangleUtil triangleUtil;

    @Before
    public void setup(){
        triangleUtil= new TriangleUtil();
    }

    @Test
    public void test_equilateral_is_correctly_identified(){
        int triangleType=triangleUtil.getTriangleType(3,3,3);
        Assert.assertEquals("Equilateral triangle should return 3",3,triangleType);
    }

    @Test
    public void test_isosceles_triangle_is_identified_correctly_1(){
        int triangleType=triangleUtil.getTriangleType(3,3,1);
        Assert.assertEquals("Isosceles triangle should return 2",2,triangleType);
    }

    @Test
    public void test_isosceles_triangle_is_identified_correctly_2(){
        int triangleType=triangleUtil.getTriangleType(3,1,1);
        Assert.assertEquals("Isosceles triangle should return 2",2,triangleType);
    }

    @Test
    public void test_isosceles_triangle_is_identified_correctly_3(){
        int triangleType=triangleUtil.getTriangleType(3,4,3);
        Assert.assertEquals("Isosceles triangle should return 2",2,triangleType);
    }

    @Test
    public void test_valid_non_isosceles_non_equilateral_triangle_should_be_identified_correctly(){
        int triangleType=triangleUtil.getTriangleType(1,2,3);
        Assert.assertEquals("Valid Non Isosceles Non Equilateral triangle should return 1",1,triangleType);
    }

    @Test
    public void test_triangle_having_zero_length_side_should_be_identified_as_incorrect_triangle_1(){
        int triangleType=triangleUtil.getTriangleType(0,0,0);
        Assert.assertEquals("If any of the triangle side provided is zero, Then triangle is invalid and should return 4",4,triangleType);
    }

    @Test
    public void test_triangle_having_zero_length_side_should_be_identified_as_incorrect_triangle_2(){
        int triangleType=triangleUtil.getTriangleType(0,3,4);
        Assert.assertEquals("If any of the triangle side provided is zero, Then triangle is invalid and should return 4",4,triangleType);
    }

    @Test
    public void test_triangle_having_negative_length_side_should_be_identified_as_incorrect_triangle_1(){
        int triangleType=triangleUtil.getTriangleType(-1,-1,-1);
        Assert.assertEquals("If any of the triangle side provided is negative, Then triangle is invalid and should return 4",4,triangleType);
    }

    @Test
    public void test_triangle_having_negative_length_side_should_be_identified_as_incorrect_triangle_2(){
        int triangleType=triangleUtil.getTriangleType(-1,10,23);
        Assert.assertEquals("If any of the triangle side provided is negative, Then triangle is invalid and should return 4",4,triangleType);
    }


}