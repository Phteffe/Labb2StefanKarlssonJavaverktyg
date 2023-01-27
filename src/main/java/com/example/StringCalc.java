package com.example;

public class StringCalc {

    public int add(String numbers){
        String[] stringNums = numbers.split(",| \n");
        int sum = 0;

        if (numbers.isEmpty())
            return 0;
        if (numbers.length() == 1) {
            return stringToInt(numbers);
        }
        else {
            for (String stringNum : stringNums) {
                sum += stringToInt(stringNum);
            }
            return sum;
        }

    }

    public int stringToInt(String input) {
        return Integer.parseInt(input);
    }

}
