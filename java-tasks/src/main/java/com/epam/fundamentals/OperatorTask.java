package com.epam.fundamentals;

import java.util.Scanner;

public class OperatorTask {
    private static final int NUMBER_OF_VARIABLES = 3;
    private static final int NUMBER_FIRST_MONTH = 1;
    private static final int NUMBER_LAST_MONTH = 12;

    public static void main(String []args) {
        printNameMonth();
        checkWhichIntervalExistNumber();
    }

    public static void checkWhichIntervalExistNumber() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input left limit, right limit and number: ");
        String line = in.nextLine();
        String[] dataFromConsole = line.split(" ");
        System.out.println(dataFromConsole.length);
        if(dataFromConsole.length < NUMBER_OF_VARIABLES) {
           throw new IllegalArgumentException("Data from console not correct");
        }
        int leftLimit = Integer.parseInt(dataFromConsole[0]);
        int rightLimit = Integer.parseInt(dataFromConsole[1]);
        int number = Integer.parseInt(dataFromConsole[2]);
        if(leftLimit > rightLimit){
            throw new IllegalArgumentException("Interval not correct");
        }
        if(number > leftLimit && number <= rightLimit) {
            System.out.println(number + " exist in interval " + "(" + leftLimit + ", " + rightLimit + "]");
        } else {
            System.out.println(number + " does not exist in interval " + "(" + leftLimit + ", " + rightLimit + "]");
        }
        if(number >= leftLimit && number < rightLimit) {
            System.out.println(number + " exist in interval " + "[" + leftLimit + ", " + rightLimit + ")");
        } else {
            System.out.println(number + " does not exist in interval " + "[" + leftLimit + ", " + rightLimit + ")");
        }
        if(number > leftLimit && number < rightLimit) {
            System.out.println(number + " exist in interval " + "(" + leftLimit + ", " + rightLimit + ")");
        } else {
            System.out.println(number + " does not exist in interval " + "(" + leftLimit + ", " + rightLimit + ")");
        }
        if(number >= leftLimit && number <= rightLimit) {
            System.out.println(number + " exist in interval " + "[" + leftLimit + ", " + rightLimit + "]");
        } else {
            System.out.println(number + " does not exist in interval " + "[" + leftLimit + ", " + rightLimit + "]");
        }
    }

    public enum Month {
        January, February, March,April, May, June, July, August,September,October, November,December
    }

    public static void printNameMonth() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input number month: ");
        String line = in.nextLine();
        int numberMonth = Integer.parseInt(line);
        if(numberMonth < NUMBER_FIRST_MONTH || numberMonth > NUMBER_LAST_MONTH){
            throw new IllegalArgumentException("Number not correct");
        }
        System.out.println(Month.values()[numberMonth-1]);
    }
}
