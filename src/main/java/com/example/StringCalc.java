package com.example;

import java.util.Arrays;

public class StringCalc {

    public int add(String numbers) {
        String[] stringNums = numbers.split(",|\n");
        int sum = 0;

        if (numbers.isEmpty())
            return 0;
        if (numbers.length() == 1) {
            return stringToInt(numbers);
        }
        if (numbers.startsWith("//")) {
            System.out.println(numbers);
            return Arrays.stream(numbers.substring(4).
                            split("[,\\n" + numbers.charAt(2) + "]")).
                            mapToInt(Integer::parseInt).sum();

        } else {
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
