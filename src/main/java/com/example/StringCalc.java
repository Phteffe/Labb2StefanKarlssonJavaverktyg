package com.example;

import java.util.Arrays;

public class StringCalc {

    public int add(String numbers) {
        String[] stringNums = numbers.split(",|\n");
        int sum = 0;

        int[] numArray = new int[0];


        if (numbers.isEmpty())
            return 0;
        if (numbers.length() == 1) {
            return stringToInt(numbers);
        }
        if (numbers.startsWith("//")) {
            numArray = getNumArray(numbers);
            return Arrays.stream(numArray).filter(num -> num <1000).sum();

        }
        numArray = Arrays.stream(numbers.split("[,\\n]")).mapToInt(Integer::parseInt).toArray();
        negativeNumCheck(numArray);
        return Arrays.stream(numArray).filter(num -> num <1000).sum();


    }

    private int[] getNumArray(String numbers) {
        numbers = numbers.substring(2);
        String[] stringArray = numbers.split("\\n",2);
        numbers = stringArray[1];
        String delimiter = stringArray[0];
        delimiter = delimiter.replace("[","");
        delimiter = delimiter.replace("]","");
        if (delimiter.contains("*"))
            delimiter = delimiter.replace("*","\\*");
        int[] numArray;
        numArray = Arrays.stream(numbers.split("[,\\n]|" + delimiter)).
                        mapToInt(Integer::parseInt).toArray();
        negativeNumCheck(numArray);
        return numArray;
    }


    private void negativeNumCheck(int[] numArray) {
        numArray = Arrays.stream(numArray).filter(num -> num < 0).toArray();
        if (numArray.length != 0){
            throw new IllegalArgumentException("negatives not allowed: " + Arrays.toString(numArray));
        }
    }

    public int stringToInt(String input) {
        return Integer.parseInt(input);
    }

}
