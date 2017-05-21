package com.zmags.problem3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ben on 21-05-2017.
 *
 * All Tests are done for Person type elements
 */
public class BagTest {

    private Bag<Person> bag;

    @Before
    public void setup(){
        bag= new Bag<>();
    }

    @Test
    public void test_Add() {
        Person person= new Person("Robb");
        bag.add(person);
        Assert.assertEquals("bag should contain one element",1,bag.size());
    }

    @Test
    public void test_Add_duplicate() {
        Person person= new Person("Robb");
        bag.add(person);
        bag.add(person);
        Assert.assertEquals("bag should support duplicate elements thus contain 2 element",2,bag.size());
    }

    @Test
    public void test_Size(){
        Person person= new Person("Robb");
        bag.add(person);
        Assert.assertEquals("bag should contain one element",1,bag.size());
    }

    @Test
    public void test_IsEmpty(){
        Assert.assertTrue("as bag is just created thus should be empty",bag.isEmpty());
        Person person= new Person("Robb");
        bag.add(person);
        Assert.assertFalse("bag contain person object now thus its not empty now",bag.isEmpty());
    }

    @Test
    public void test_Contains(){
        Person person= new Person("Robb");
        Person person2= new Person("Anders");
        bag.add(person);
        bag.add(person2);
        Assert.assertTrue("Bag contains Person Name Anders",bag.contains(person2));
    }

    @Test
    public void test_Iterator()  {
        Person person= new Person("Robb");
        Person person2= new Person("Anders");
        bag.add(person);
        bag.add(person2);
        Assert.assertTrue("Iterator should be iterable",bag.iterator().hasNext());
    }

    @Test
    public void test_ToArray(){
        Person person= new Person("Robb");
        Person person2= new Person("Anders");
        bag.add(person);
        bag.add(person2);
        Assert.assertEquals("Returned array should be valid and have length of 2",2,bag.toArray().length);
    }



    @Test
    public void test_Remove()  {
        Person person= new Person("Robb");
        Person person2= new Person("Anders");
        bag.add(person);
        bag.add(person2);
        bag.remove(person2);
        Assert.assertFalse("Bag should not contains Person Name Anders",bag.contains(person2));
    }

    @Test
    public void test_ContainsAll(){
        Person person= new Person("Robb");
        Person person2= new Person("Anders");
        bag.add(person);
        bag.add(person2);
        List<Person> persons= Arrays.asList(person,person2);
        Assert.assertTrue("Bag contains Person Name Anders and Robb",bag.containsAll(persons));

    }

    @Test
    public void test_AddAll(){
        Person person= new Person("Robb");
        Person person2= new Person("Anders");
        List<Person> persons= Arrays.asList(person,person2);
        bag.addAll(persons);
        Assert.assertTrue("Bag contains Person Name Anders and Robb",bag.containsAll(persons));
    }

    @Test
    public void test_RemoveAll(){
        Person person= new Person("Robb");
        Person person2= new Person("Anders");
        List<Person> persons= Arrays.asList(person,person2);
        bag.addAll(persons);
        bag.removeAll(persons);
        Assert.assertFalse("Bag should not contains Person Name Anders and Robb",bag.containsAll(persons));
    }

    @Test
    public void test_RetainAll(){
        Person person= new Person("Robb");
        Person person2= new Person("Anders");
        Person person3= new Person("Mavrik");
        List<Person> persons= Arrays.asList(person,person2);
        bag.addAll(persons);
        bag.add(person3);
        bag.retainAll(persons);
        Assert.assertTrue("Bag contains Person Name Anders and Robb",bag.containsAll(persons));
    }

    @Test
    public void test_Clear(){
        Person person= new Person("Robb");
        Person person2= new Person("Anders");
        Person person3= new Person("Mavrik");
        List<Person> persons= Arrays.asList(person,person2);
        bag.addAll(persons);
        bag.add(person3);
        bag.clear();
        Assert.assertTrue("Bag should be empty",bag.isEmpty());
    }
}