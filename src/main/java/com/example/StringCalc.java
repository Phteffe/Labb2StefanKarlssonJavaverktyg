package com.example;

public class StringCalc {

    public static int add(String numbers){
        String[] stringNums = numbers.split(",");
        int sum = 0;

        if (numbers.isEmpty())
            return 0;
        if (numbers.length() == 1) {
            return Integer.parseInt(numbers);
        }
        else {
            for (int i = 0; i < stringNums.length; i++) {
                sum += Integer.parseInt(stringNums[i]);
            }
            return sum;
        }

    }

}
