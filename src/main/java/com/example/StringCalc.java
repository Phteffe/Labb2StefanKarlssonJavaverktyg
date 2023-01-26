package com.example;

public class StringCalc {

    public static int add(String numbers){
        int sum = 0;

        if (numbers.equals(""))
            return 0;
        else if (numbers.contains(",")) {
            String[] stringNums = numbers.split(",");
            for (String stringNum : stringNums) {
                sum += Integer.parseInt(stringNum);
            }

        } else {
            int number = Integer.parseInt(numbers);
            return number;
        } return sum;



    }

}
