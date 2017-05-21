1) Solution is available in class FileParser
2) Class contain 3 method
    a)getMostOccurrenceWordsConcurrentFileRead
    b)getMostOccurrenceWordsSequentialFileRead
    c)getMostOccurrenceWords
3) All methods have their documentation available above them
4) getMostOccurrenceWords is main method which internally calls getMostOccurrenceWordsConcurrentFileRead.
5) getMostOccurrenceWordsSequentialFileRead is present just to show the tremendous performance  difference when parallel stream are used in place of sequential
6) All TestCases are available in FileParserTest
7) Words are identified correctly by splitting lines using regex [^A-Za-z0-9].
8) getMostOccurrenceWordsConcurrentFileRead generic method is also provided in which different parameters of problems can be made configurable
   like: file location, Regex to identify splitter, max number of element in final result and CharacterSet.
9) Java 8 Streams is used to read the file. stream reads the file, line by line thus complete file is not loaded into memory
10) parallel streams are used in the solution to deal with large files.there is test in testClass to demonstrate the diffrence
11) zmags-problems\src\test\java\com\zmags\problem2\FileParserTest.java contain all the tests
