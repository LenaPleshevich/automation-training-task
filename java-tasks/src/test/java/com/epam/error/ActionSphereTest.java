package com.epam.error;

import by.pleshevich.action.ActionSphere;
import by.pleshevich.entity.Point;
import by.pleshevich.entity.Sphere;
import com.epam.error.action.ActionSphere;
import com.epam.error.entity.Point;
import com.epam.error.entity.Sphere;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionSphereTest {
    @Test
    public void calculateSphereVolumeTest() {
        double radius = 2;
        Point point = new Point(1,1,2);
        Sphere sphere = new Sphere(point,radius);
        double expected =  33.510;
        double actual = ActionSphere.calculateSphereVolume(sphere);
        Assert.assertEquals(actual, expected, 0.01);
    }
    @Test
    public void checkSphereTest() {
        double radius = 2;
        Point centre = new Point(1,2,3);
        Sphere sphere = new Sphere(centre,radius);
        boolean actual = ActionSphere.checkSphere(sphere);
        Assert.assertTrue(actual);
    }
    @Test
    public void areaSphereTest() {
        double radius = 2;
        Point centre = new Point(1,1,1);
        Sphere sphere = new Sphere(centre,radius);
        double actual = ActionSphere.calculateSphereArea(sphere);
        double expected = 50.265;
        Assert.assertEquals(actual, expected, 0.01);
    }
    @Test
    public void definePositionXYTest() {
        double radius = 3;
        Point centre = new Point(2,-6, -3);
        Sphere sphere = new Sphere(centre,radius);
        int actual = ActionSphere.definePositionXY(sphere);
        int expected = 0;
        Assert.assertEquals(actual, expected, 0.01);
    }
    @Test
    public void definePositionXZTest() {
       double radius = 2;
        Point centre = new Point(1,-2,1);
        Sphere sphere = new Sphere(centre,radius);
        int actual = ActionSphere.definePositionXZ(sphere);
        int expected = 0;
        Assert.assertEquals(actual, expected, 0.01);
    }

    @Test
    public void definePositionYZTest() {
        double radius = 2;
        Point centre = new Point(-2,-2,1);
        Sphere sphere = new Sphere(centre,radius);
        int actual = ActionSphere.definePositionXZ(sphere);
        int expected = 0;
        Assert.assertEquals(actual, expected, 0.01);
    }
    @Test
    public void segmentsRatioDividedXYTest() {
        double radius = 2;
        Point centre = new Point(-2,-2,0);
        Sphere sphere = new Sphere(centre,radius);
        double actual = ActionSphere.segmentsRatioDividedXY(sphere);
        double expected = 1.0;
        Assert.assertEquals(actual, expected, 0.01);
    }
    @Test
    public void rationPlaneXZTest() {
        double radius = 2;
        Point centre = new Point(-2,0,3);
        Sphere sphere = new Sphere(centre,radius);
        double actual = ActionSphere.segmentsRatioDividedXZ(sphere);
        double expected = 1.0;
        Assert.assertEquals(actual, expected, 0.01);
    }

    @Test
    public void segmentsRatioDividedYZTest() {
        double radius = 2;
        Point centre = new Point(0,-2,5);
        Sphere sphere = new Sphere(centre,radius);
        double actual = ActionSphere.segmentsRatioDividedYZ(sphere);
        double expected = 1.0;
        Assert.assertEquals(actual, expected, 0.01);
    }

    @Test
    public void checkLineData() {
        String stringValues = new String("22.0 22.0 -22.2 2.2");
        boolean actual = ActionSphere.checkData(stringValues);
        Assert.assertTrue(actual);
    }

    @Test
    public void creatorSphereTest() {
        double data[] = {1.0, 2.3, 4.5, 5.5};
        Point centre = new Point(2.3, 4.5, 5.5);
        Sphere actual = ActionSphere.createSphere(data);
        Sphere expected = new Sphere(centre, 1.0);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void lineCompileTest() {
        double []data = {1.0, 2.3, 4.5, 5.5};
        String stringValues = "1.0, 2.3, 4.5, 5.5";
        double []actual = ActionSphere.splitLine(stringValues);
        double []expected = data;
        Assert.assertEquals(actual, expected);
    }
}
