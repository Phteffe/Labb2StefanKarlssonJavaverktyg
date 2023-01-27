package com.example;

public class StringCalc {

    public static int add(String numbers){
        int sum = 0;
        String[] stringNums = numbers.split(",");

        if (numbers.isEmpty())
            return 0;
        if (numbers.length() == 1) {
            return Integer.parseInt(numbers);
        }
        else {
            return Integer.parseInt(stringNums[0]) + Integer.parseInt(stringNums[1]);
        }

    }

}
