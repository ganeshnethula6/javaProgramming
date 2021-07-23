package com.javaacademy;

import com.javaacademy.arrays.ArrayService;
import com.javaacademy.arrays.ArrayServiceImpl;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //Array rotation Method1
        ArrayService arrayService=new ArrayServiceImpl();
        int[] arrayRotationResult=arrayService.arrayRotation(new int[]{10,9,8,7,6,5,4,3,2,1},2);
        System.out.println("Array left Rotation Method 1");
        Arrays.stream(arrayRotationResult).forEach(System.out::println);
        //Array rotation Method 2
        System.out.println("Array right Rotation Method 2");
        int[] arrayRotationResult2=arrayService.arrayRotationUsingJava8(new int[]{1,2,3,4,5,6,7,8,9,10},13);
        Arrays.stream(arrayRotationResult2).forEach(System.out::println);
        //Array rotation Method3
        System.out.println("Array left Rotation Method 3");
        int[] arrayRotationResult3=arrayService.arrayRotationReverseMethod(new int[]{1,2,3,4,5,6,7,8,9,10},13);
        Arrays.stream(arrayRotationResult3).forEach(System.out::println);
        //find the index of the elements after the rotation.
        System.out.println("Array left Rotation Method 3");
        int arrayRotationIndex=arrayService.arrayRotationFindIndex(new int[]{1,2,3,4,5,6,7,8,9,10},13,3);
        System.out.println("Index of the element 3 after the rotation is:"+ arrayRotationIndex);
        //Given a sorted and rotated array, find if there is a pair with a given sum
        final int pairCount=arrayService.findPairForSum(new int[]{11, 15, 6, 7, 9, 10},16);
        System.out.println("Sorted and rotated array, find if there is a pair with a given sum=15:"+pairCount);
        String countArrayFrequency=arrayService.countArrayFrequency(new int[]{1,1,1,1,2,2,2,3,3,3,3,3,3,3,4,5,6,6,7,7,7,8,8,8,9,});
        System.out.println(countArrayFrequency);

    }
}
