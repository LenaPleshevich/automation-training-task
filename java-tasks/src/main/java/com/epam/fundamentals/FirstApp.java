package com.epam.fundamentals;

import java.util.Scanner;

public class FirstApp {
    public static void main(String[] args)  {
        sayHelloToUser();
        reverseLineFromConsole();
    }

    public static void sayHelloToUser(){
        Scanner in = new Scanner(System.in);
        System.out.print("Input a name user: ");
        String nameUser = in.nextLine();
        System.out.println("Hello "  + nameUser + " !" );
    }

    public static void reverseLineFromConsole() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input some line: ");
        String line = in.nextLine();
        String[] arrayArgument;
        arrayArgument = line.split(" ");
        for (int i = arrayArgument.length - 1; i >= 0; i--) {
            System.out.print(arrayArgument[i] + " ");
        }
    }


}
