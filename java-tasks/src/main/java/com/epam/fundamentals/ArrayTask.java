package com.epam.fundamentals;

import java.util.Random;
import java.util.Scanner;

public class ArrayTask {
    public static void main(String []args) {
        findMaxElementAndDeleteAllLineWith(initMatrix());
        sumElementsBetweenFirstAndSecondPositive(initMatrix());
    }

    public static int[][] initMatrix() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input number: ");
        int matrixSize = in.nextInt();
        int matrix[][]= new int[matrixSize][matrixSize];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < matrixSize; i++){
            for (int j = 0; j < matrixSize; j++){
                matrix[i][j] = - matrixSize + random.nextInt(2*matrixSize  + 1);
            }
        }
        for (int i = 0; i < matrixSize; i++){
            for (int j = 0; j < matrixSize; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(" ");
        }
        return matrix;
    }

    public static void findMaxElementAndDeleteAllLineWith(int [][]matrix) {
        int maxElement = matrix[0][0];
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] > maxElement) {
                    maxElement = matrix[i][j];
                }
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == maxElement){
                    matrix[0][j] = maxElement*maxElement;
                    matrix[i][0] = maxElement*maxElement;
                }
            }
        }
        int countLineWithMaxElement = 0;
        int countColumnWithMaxElement = 0;
        for (int i = 0; i < matrix[0].length; i++) {
           if(matrix[i][0] == maxElement*maxElement) {
               countLineWithMaxElement++;
           }
           if(matrix[0][i] == maxElement*maxElement) {
               countColumnWithMaxElement++;
           }
        }
        int [][]matrixWithoutMaxElement = new int[matrix[0].length -
                countLineWithMaxElement][matrix[0].length - countColumnWithMaxElement];
        int newIndexLine = 0;
        int newIndexColumn = 0;
        int countGoodLine = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][0] != maxElement*maxElement && matrix[0][j] != maxElement*maxElement) {
                    matrixWithoutMaxElement[newIndexLine][newIndexColumn] = matrix[i][j];
                    newIndexColumn++;
                    countGoodLine++;
                }
            }
            if(countGoodLine > 0) {
                newIndexLine++;
            }
            newIndexColumn = 0;
            countGoodLine = 0;
        }
        for (int i = 0; i < matrix[0].length - countLineWithMaxElement; i++) {
            for (int j = 0; j < matrix[0].length - countColumnWithMaxElement; j++) {
                System.out.print(matrixWithoutMaxElement[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void sumElementsBetweenFirstAndSecondPositive(int [][]matrix) {
        int sumElements = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            int indexFirstElement = -1;
            int indexSecondElement = -1;
            int countFoundElement = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] > 0){
                    if(countFoundElement == 0) {
                        indexFirstElement = j;
                    }
                    if(countFoundElement == 1 && indexSecondElement == -1) {
                        indexSecondElement = j;
                    }
                    countFoundElement++;
                }
                if(countFoundElement == 2) {
                    indexFirstElement++;
                    while (indexFirstElement < indexSecondElement) {
                        sumElements += matrix[i][indexFirstElement];
                        indexFirstElement++;
                    }
                }
            }
        }
        System.out.println("Sum = " + sumElements);
    }
}
