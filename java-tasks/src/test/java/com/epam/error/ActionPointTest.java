package com.epam.error;

import com.epam.error.action.ActionPoint;
import com.epam.error.entity.Point;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActionPointTest {
    private static final double expectedDistance = 5.196;
    private Point pointA;
    private Point pointB;

    @BeforeClass
    public void initPoint(){
        pointA = new Point(1.0, 1.0, 1.0);
        pointB = new Point(4.0, 4.0, 4.0);
    }
    @Test
    public void calculateDistanceTest(){
        double actual = ActionPoint.calculateDistance(pointA, pointB);
        Assert.assertEquals(expectedDistance, actual, 0.01);
    }
}
