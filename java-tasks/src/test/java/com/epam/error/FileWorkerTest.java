package com.epam.error;

import by.pleshevich.entity.Point;
import by.pleshevich.entity.Sphere;
import by.pleshevich.exception.FileWorkerException;
import by.pleshevich.fileworker.FileWorker;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class FileWorkerTest {
    private static String fileName;
    @BeforeTest
    public void initFileName() {
        fileName = "input.txt";
    }

    @Test
    public void checkFileTest() {
        boolean actual = FileWorker.checkFileExist(fileName);
        Assert.assertTrue(actual, "File not exist.");
    }

    @Test
    public void checkFileEmptyTest() throws FileWorkerException {
        File file = new File(fileName);
        boolean actual = FileWorker.checkFileEmpty(file);
        Assert.assertFalse(actual, "File is empty.");
    }

    @Test
    public void readDataTest() throws FileWorkerException {
        String expected = "2.0 1.0 2.0 3.0";
        String actual = FileWorker.readData(fileName);
        Assert.assertEquals(actual, expected);

    }

    @Test(expectedExceptions = FileWorkerException.class)
    public void checkFileEmptyThrowsException() throws FileWorkerException {
        File file = new File(fileName + "2");
        FileWorker.checkFileEmpty(file);
    }

    @Test(expectedExceptions = FileWorkerException.class)
    public void readDataThrowsException() throws FileWorkerException {
        FileWorker.readData(fileName + "2");
    }

    @Test (timeOut = 5000)
    public void readFileTest() throws FileWorkerException, FileNotFoundException {
        Point pointA = new Point(1.0, 2.0, 3.0);
        Point pointB = new Point(2.0, 3.0, 4.0);
        Sphere sphereA = new Sphere(pointA, 2.0);
        Sphere sphereB = new Sphere(pointB, 3.0);
        ArrayList <Sphere> list = new ArrayList();
        list.add(sphereA);
        list.add(sphereB);
        ArrayList <Sphere> expected = list;
        FileWorker fileWorker = new FileWorker();
        ArrayList <Sphere> actual = fileWorker.readFile(fileName);
        Assert.assertEquals(actual, expected);
    }
}
