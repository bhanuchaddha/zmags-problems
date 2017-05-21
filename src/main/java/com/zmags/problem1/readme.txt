1) TriangleType is domain level enum which defines type of Triangles and corresponding return value
2) TriangleUtil contain getTriangleType method which takes 3 sides of triangle and return integer value corresponding to triangle type
3) TriangleType is used to make code more understandable and maintainable
4) getTriangleType validates the input using private isValidTriangle method for correct triangle sides and then return triangle type
5) zmags-problems\src\test\java\com\zmags\problem1\TriangleUtilTest.java contain all the tests