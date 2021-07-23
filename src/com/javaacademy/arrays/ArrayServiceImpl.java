package com.javaacademy.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayServiceImpl implements ArrayService{
    @Override
    public int[] arrayRotation(int[] intArray, int shifts) {
        shifts=shifts%intArray.length;
        Arrays.sort(intArray);
        int[] tempArray =new int[shifts];
        for (int i=0;i<intArray.length;i++)
        {
            if(i<shifts)
            {
                tempArray[i]=intArray[i];
                intArray[i]=intArray[i+shifts];
            }
            else if(i< intArray.length-shifts){
                intArray[i]=intArray[i+shifts];
            }
            else
            {
                intArray[i]=tempArray[i-(intArray.length-shifts)];
            }
        }
        return intArray;
    }

    @Override
    public String countArrayFrequency(int[] initialArray) {
        Map<Integer,Integer> countArrayFrequency=new HashMap<>();
        for (int value:initialArray)
        {
            if(countArrayFrequency.containsKey(value))
            {
                countArrayFrequency.put(value,countArrayFrequency.get(value)+1);
            }
            else
            {
                countArrayFrequency.put(value,1);
            }
        }
        return countArrayFrequency.toString();
    }

    @Override
    public int[] arrayRotationUsingJava8(int[] initialArray, int shifts) {
        //to check  that if the shifts load factor is greater than array length, then it will minimize the rotations
        shifts=shifts%initialArray.length;
        if(shifts>0)
        {
            for (int i=0;i<shifts;i++)
            {
               // leftRotateByOne(initialArray);
                rightRotateByOne(initialArray);
            }
        }
        return initialArray;
    }

    @Override
    public int[] arrayRotationReverseMethod(int[] intArray, int shifts) {
        shifts=shifts%intArray.length;
        if(shifts>0)
        {
            reverseArray(intArray,0,shifts-1);
            reverseArray(intArray,shifts,intArray.length-1);
            reverseArray(intArray,0,intArray.length-1);
        }
        return intArray;
    }

    @Override
    public int arrayRotationFindIndex(int[] intArray, int shifts, int element) {
        if(shifts>0)
        {
            Arrays.sort(intArray);
            this.arrayRotation(intArray,shifts);
        }
        for (int i=0;i<intArray.length;i++)
        {
            if(intArray[i]==element)
            {
                return i;
            }
        }

        return 0;
    }

    @Override
    public int findPairForSum(int[] initialArray, int sum) {
        //sort the array
        int count=0;
        Arrays.sort(initialArray);
        for (int i=0;i<initialArray.length-1;i++)
        {
            for (int j=i+1;j<initialArray.length-1;j++)
            {
               if(sum== initialArray[i]+initialArray[j])
               {
                   count++;
               }
            }
        }

        return count;
    }

    //to reverse the array with first and last index using temp variable.
    private void reverseArray(int[] intArray, int firstIndex, int lastIndex) {
        int temp;
      while (firstIndex<lastIndex){
          temp=intArray[firstIndex];
          intArray[firstIndex]=intArray[lastIndex];
          intArray[lastIndex]=temp;
          lastIndex--;
          firstIndex++;
      }
    }

    private void leftRotateByOne(int[] initialArray) {
        int temp = 0;
        for(int i=0;i<initialArray.length;i++)
        {
            if (i==0)
            {
                temp=initialArray[i];
                initialArray[i]=initialArray[i+1];
            }
            else if(i != initialArray.length - 1)
            {
                initialArray[i]=initialArray[i+1];
            }
            else if (i==initialArray.length-1)
            {
                initialArray[i]=temp;
            }
        }
    }
    private void rightRotateByOne(int[] initialArray)
    {
        int temp=0;
        for(int i=initialArray.length-1;i>=0;i--)
        {
            if(i==initialArray.length-1)
            {
                temp=initialArray[i];
                initialArray[i]=initialArray[i-1];
            }
            else if(i>0)
            {
                initialArray[i]=initialArray[i-1];
            }
            else if(i==0)
            {
                initialArray[i]=temp;
            }
        }
    }
}
