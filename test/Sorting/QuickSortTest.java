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
public class QuickSortTest {
    private int[] numbers;
    private static int SIZE = 7;
    private final static int MAX = 6;
    
    @Test
    public void QuickSortTest() {
        long startTime = System.currentTimeMillis();

        QuickSort sorter = new QuickSort(numbers);
        sorter.sort();

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("QuickSort: " + elapsedTime);

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
//                System.out.println("Sorted array failure: "+Arrays.toString(numbers));
                fail("Should not happen");
            }
        }
        assertTrue(true);
    }
    
    @Before
    public void setUp() {
        Random randomGenerator = new Random();
        SIZE = randomGenerator.nextInt(MAX)+1;
        numbers = new int[SIZE];
        for(int i=0; i<numbers.length; i++){
            int num = randomGenerator.nextInt(MAX);
            int mult = (int) Math.pow(-1, num);
            numbers[i]= num*mult;
        }
        System.out.println("Unsorted Array: "+Arrays.toString(numbers));
    }
    
    @Test
    public void repeatedTests(){
        for(int i=0;i<200;i++){
            setUp();
            QuickSortTest();
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
