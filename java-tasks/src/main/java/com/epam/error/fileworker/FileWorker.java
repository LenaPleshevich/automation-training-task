package com.epam.error.fileworker;

import com.epam.error.action.ActionSphere;
import com.epam.error.entity.Sphere;
import com.epam.error.exception.FileWorkerException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileWorker {
   public static boolean checkFileExist(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }

    public static boolean checkFileEmpty(File file) throws FileWorkerException {
        try {
            Scanner scanner = new Scanner(file);
            return !scanner.hasNext();
        } catch (FileNotFoundException exception) {
            System.out.println(file + " file not found");
            throw new FileWorkerException(exception);
        }
    }

    public static String readData(String fileName) throws FileWorkerException {
        File file = new File(fileName);
        String line;
        try {
            Scanner scanner = new Scanner(file);
            line = scanner.nextLine();
        } catch (FileNotFoundException exception) {
            System.out.println(fileName + " file not found");
            throw new FileWorkerException(exception);
        }
        return line;
    }

    public static ArrayList readFile(String fileName) throws FileWorkerException {
        File file = new File(fileName);
        ArrayList <Sphere> list = new ArrayList();
        String line;
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                if (ActionSphere.checkData(line)) {
                    Sphere sphere = ActionSphere.createSphere(ActionSphere.splitLine(line));
                    if(ActionSphere.checkSphere(sphere)) {
                        list.add(sphere);
                    } else {
                        System.out.println("Negative radius");
                    }
                } else {
                    System.out.println(line + " line not correct");
                }
            }
        } catch (FileNotFoundException exception) {
            System.out.println(fileName + " file not found");
            throw new FileWorkerException(exception);
        }
        return list;
    }
}
