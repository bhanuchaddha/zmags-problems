package com.zmags.problem2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by ben on 21-05-2017.
 */
public class FileParserTest {

    private FileParser fileParser;
    private final String path="src/test/resources/InputFile.txt";
    private final String nonExitingFile="src/test/resources/InputFile1.txt";
    private final String all_utf_8="src/test/resources/All-UTF-8-Chars";
    private final String large_file="src/test/resources/LargeFile.txt";

    @Before
    public void setup(){
        fileParser= new FileParser();
    }

    @Test
    public void test_file_is_parsed_correctly(){
        List<String> words=fileParser.getMostOccurrenceWords(path);
        Assert.assertFalse("Return list should be non empty if file is parsed correctly",words.isEmpty());
    }
    @Test
    public void test_no_more_than_10_words_are_returned(){
        List<String> words=fileParser.getMostOccurrenceWords(path);
        Assert.assertTrue("Return list  can not have more than 10 words",words.size()<=10);
    }

    @Test
    public void test_all_words_should_be_sequence_of_either_numbers_or_characters(){
        List<String> words=fileParser.getMostOccurrenceWords(path);
        Pattern pattern= Pattern.compile("[A-Za-z0-9]+");
        words.stream().forEach(a->Assert.assertTrue("All Words should march regex [A-Za-z0-9]+",pattern.matcher(a).matches()));
    }
    @Test
    public void test_words_should_be_sorted_in_descending_order_of_occurrence(){
        List<String> words=fileParser.getMostOccurrenceWords(path);
        Assert.assertEquals("23 should be first element as it has 5 occurrence","23",words.get(0));
        Assert.assertEquals("Foo should be second element as it has 3 occurrence","Foo",words.get(1));
    }

    @Test
    public void test_code_should_be_able_to_handle_all_utf_8_chars(){
        List<String> words=fileParser.getMostOccurrenceWords(all_utf_8);
        Assert.assertFalse("Return list should be non empty if file is parsed correctly",words.isEmpty());
    }

    /*
    * Test also prints time taken in console
    * */
    @Test
    public void test_large_files_should_be_read_efficiently(){
        long startTime=System.currentTimeMillis();
        fileParser.getMostOccurrenceWords(large_file);
        long timeTakenInParallelProcessing=System.currentTimeMillis()-startTime;
        startTime=System.currentTimeMillis();
        fileParser.getMostOccurrenceWordsSequentialFileRead(large_file,"[^A-Za-z0-9]",10, StandardCharsets.UTF_8);
        long timeTakenInSequentialProcessing=System.currentTimeMillis()-startTime;
        Assert.assertTrue("Parrallel stream take benefit of parallel processing thus file are processed efficiently." +
                "for this file input timeTakenInSequentialProcessing is between 130-200 ms " +
                "and timeTakenInParallelProcessing is between 1-10 ms"
                ,timeTakenInSequentialProcessing>timeTakenInParallelProcessing);
    }

    @Test
    public void test_empty_list_is_return_if_IO_exception_occur(){
        List<String> words=fileParser.getMostOccurrenceWords(nonExitingFile);
        Assert.assertTrue(words.isEmpty());
    }

}