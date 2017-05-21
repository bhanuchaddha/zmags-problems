package com.zmags.problem1;



/**
 * Created by ben on 19-05-2017.
 */
public class TriangleUtil {


    /*
    * Return integer flag corresponding triangle type
    * @param sideA first side
    * @param sideB second side
    * @param sideC third side
    *
    * @return 1 for SCALENE triangle
    *         2 for ISOSCELES triangle
    *         3 for EQUILATERAL triangle
    *         4 for any Error situation
    * */
    public int getTriangleType(int sideA,int sideB,int sideC){
        TriangleType triangleType=TriangleType.ERROR;
        if(isValidTriangle(sideA,sideB,sideC)){
            if(sideA==sideB && sideB==sideC) {
                triangleType=TriangleType.EQUILATERAL;
            }else if(sideA==sideB ||sideB==sideC||sideC==sideA){
                triangleType=TriangleType.ISOSCELES;
            }else {
                triangleType=TriangleType.SCALENE;
            }
        }else{
            //log that invalid input have been passed.use logging framework in production environment
            System.out.println("Invalid triangle sides have been passed." +
                    "Value passed are SideA "+sideA+" sideB "+sideB+" SideC "+sideC+" .All sides must be greater than zero");
        }

        return triangleType.getValue();
    }

    /*
    * Validate if triangle is valid or not.
    * Valid triangle should have all sides greater than 0
    * @param sideA first side
    * @param sideB second side
    * @param sideC third side
    *
    * @return true if valid triangle
    *           false if invalid triangle
    * */
    private boolean isValidTriangle(int sideA, int sideB, int sideC) {
        return sideA>0 && sideB>0 && sideC>0;
    }


}
