package com.epam.fundamentals;

import java.util.Scanner;

public class DataTypeTask {
    public static void main(String [] args) {
        String[]array = initArrayNumbers();
        findValueWithOrderedNumbers(array);
        printNumbersWithAverageSize(array);
    }

    public static String[] initArrayNumbers() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input some lines: ");
        String line = in.nextLine();
        String []array = line.split(" ");
        return array;
    }

    public static void printNumbersWithAverageSize(String[] array) {
        int minSize = array[0].length();
        int maxSize = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i].length()> maxSize) {
                maxSize = array[i].length();
            }
            if(array[i].length() < minSize) {
                minSize = array[i].length();
            }
        }
        int averageSize = (minSize + maxSize) / 2;
        for (int i = 0; i < array.length; i++) {
            if(array[i].length() < averageSize) {
                System.out.println(array[i] + "  - size: " + array.length);
            }
        }
    }

    public static void findValueWithOrderedNumbers(String[] arrayValues) {
        int[] arrayNumber = new int[arrayValues.length];
        for(int i = 0; i < arrayValues.length; i++){
            arrayNumber[i] = Integer.parseInt(arrayValues[i]);
        }
        for(int i = 0; i < arrayNumber.length; i++) {
            boolean flag = true;
            int lastNumber = arrayNumber[i] % 10;
            int currentValue = arrayNumber[i] / 10;
            while(currentValue > 0) {
                if(currentValue%10 > lastNumber  ) {
                    flag = false;
                    currentValue = 0;
                }
                lastNumber = currentValue % 10;
                currentValue = currentValue / 10;
            }
            if(flag) {
                System.out.println(arrayNumber[i]);
                break;
            }
        }
    }
}
