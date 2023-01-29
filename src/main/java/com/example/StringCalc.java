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
            System.out.println(numbers);
            numArray = Arrays.stream(numbers.substring(4).
                            split("[,\\n" + numbers.charAt(2) + "]")).
                            mapToInt(Integer::parseInt).toArray();
            negativeNumCheck(numArray);
            return Arrays.stream(numArray).sum();

        }
        numArray = Arrays.stream(numbers.split("[,\\n]")).mapToInt(Integer::parseInt).toArray();
        negativeNumCheck(numArray);
        return Arrays.stream(numArray).sum();


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
