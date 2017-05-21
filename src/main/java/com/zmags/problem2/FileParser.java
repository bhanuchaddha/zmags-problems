package com.zmags.problem2;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Created by ben on 19-05-2017.
 */
public class FileParser {

    /*
    * Read the file at given path and return top 10 most occurred words in descending order
    * resulted words only contain digits and characters
    * line are read in parallel  and split using [^A-Za-z0-9] to get words.
    * UTF-8 CharacterSet is used
    * File is read in stream thus whole file is not read at once
    *
    * @param  filePath
    *           location of file to be read
    * @return List<String>
    *           List of top 10 words in descending order on the basis of occurrence
    *           Empty List if there is any IOException
    *
    * */
    public List<String> getMostOccurrenceWords(String filePath){
        return getMostOccurrenceWordsConcurrentFileRead(filePath,"[^A-Za-z0-9]",10,StandardCharsets.UTF_8);
    }


    /*
    Read the file at given path and return top n most occurred words in descending order
    * line are read in parallel  and split using given regex to get words.
    * given CharacterSet is used
    * This method use create parallel stream to make use of multi core processor.Provide better performance
    * File is read in stream thus whole file is not read at once
    *
    * @param filePath
    *           location file to be read
    * @param  regex
                regex used to split the lines in the file to get words
      @param  limit
                maximum number of string returned
      @param  charset
              charset  used
    * @return List<String>
    *           List of top 10 words in descending order on the basis of occurrence
    *           Empty List if there is any IOException
    * */
    public List<String> getMostOccurrenceWordsConcurrentFileRead(String filePath,String regex,long limit, Charset charset){
        long startTime=System.currentTimeMillis();
        List<String> words= Collections.emptyList();
        try (Stream<String> lines=Files.lines(Paths.get(filePath),charset).unordered().parallel()){
            words=lines.map(s->s.split(regex))
                    .flatMap(Arrays::stream)
                    .filter(s->s.length()>0)//filter empty string which might occur if continuous character match the regex
                    .collect(groupingBy(identity(),counting()))
                    .entrySet()
                    .stream().unordered().parallel()//parallel stream
                    .sorted((a,b)->b.getValue().compareTo(a.getValue()))
                    .map(Map.Entry::getKey)
                    .limit(limit)
                    .collect(Collectors.toList())
                    ;
            System.out.println("Time Taken in Concurrent Parsing: "+(System.currentTimeMillis()-startTime));  //logging
        }catch (IOException e){
            System.out.println("Error while reading a file "+e.getMessage());
        }
        return words;
    }


    /*
    Read the file at given path and return top n most occurred words in descending order
    * line are read in sequence  and split using given regex to get words.
    * given CharacterSet is used
    * This method use sequential  stream .its not the most efficient way refer {@link FileParser#getMostOccurrenceWordsConcurrentFileRead}
    * File is read in stream thus whole file is not read at once
    *
    * @param filePath
    *           location file to be read
    * @param  regex
                regex used to split the lines in the file to get words
      @param  limit
                maximum number of string returned
      @param  charset
              charset  used
    * @return List<String>
    *           List of top 10 words in descending order on the basis of occurrence
    *           Empty List if there is any IOException
    * */
    public List<String> getMostOccurrenceWordsSequentialFileRead(String filePath,String regex,long limit, Charset charset){
        long startTime=System.currentTimeMillis();
        List<String> words= Collections.emptyList();
        try (Stream<String> lines=Files.lines(Paths.get(filePath),charset)){
            words=lines.map(s->s.split(regex))
                    .flatMap(Arrays::stream)
                    .filter(s->s.length()>0)//filter empty string which might occur if continuous character match the regex
                    .collect(groupingBy(identity(),counting()))
                    .entrySet()
                    .stream()
                    .sorted((a,b)->b.getValue().compareTo(a.getValue()))
                    .map(Map.Entry::getKey)
                    .limit(limit)
                    .collect(Collectors.toList())
            ;
            System.out.println("Time Taken in Sequential Parsing "+(System.currentTimeMillis()-startTime));  //logging
        }catch (IOException e){
            System.out.println("Error while reading a file "+e.getMessage());
        }
        return words;
    }
}
