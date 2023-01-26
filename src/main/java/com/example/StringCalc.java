package com.example;

public class StringCalc {

    public static int add(String numbers){
        int sum = 0;
        String[] stringNums = numbers.split(",");

        if (numbers.equals(""))
            return 0;
        else if (numbers.contains(",")) {
            for (String stringNum : stringNums) {
                sum += Integer.parseInt(stringNum);
            }
        } else {
            int number = Integer.parseInt(numbers);
            return number;

        } return sum;



    }

}
