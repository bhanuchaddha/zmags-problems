1) As per requirement Bag should support duplicate elements and all the operations of Collection interface.We have similar interface
    in Java collections as List. thus in the implementation class Bag , I have implemented Collection interface and forwarded its operations to
    internal instance of ArrayList.
2) For each instance of Bag internally one instance of ArrayList is created.
2) Bag collection supports generics
3) only operations of Collection interface are  available and not all operations of List interface.
4) zmags-problems\src\test\java\com\zmags\problem3\BagTest.java   contains all the tests
