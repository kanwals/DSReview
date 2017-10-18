/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;

import java.util.Arrays;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gurkanwal
 */
public class MergeSortTest {
    private int[] numbers;
    private static int SIZE = 7;
    private final static int MAX = 20;
    
    @Test
    public void MergeSortTest() {
        long startTime = System.currentTimeMillis();

        MergeSort sorter = new MergeSort();
        sorter.sort(numbers);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("MergeSort: " + elapsedTime);

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {  
                fail("Should not happen");
            }
        }
        assertTrue(true);
    }
    
    @Before
    public void setUp() {
        Random randomGenerator = new Random();
        SIZE = randomGenerator.nextInt(MAX);
        numbers = new int[SIZE];
        for(int i=0; i<numbers.length; i++){
            int num = randomGenerator.nextInt(MAX);
            int mult = (int) Math.pow(-1, num);
            numbers[i]= num*mult;
        }
    }
    
    @Test
    public void repeatedTests(){
        for(int i=0;i<200;i++){
            setUp();
            MergeSortTest();
        }
    }

    @Test
    public void testStandardSort() {
        long startTime = System.currentTimeMillis();
        Arrays.sort(numbers);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Standard Java sort " + elapsedTime);

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                fail("Should not happen");
            }
        }
        assertTrue(true);
    }
    
}
