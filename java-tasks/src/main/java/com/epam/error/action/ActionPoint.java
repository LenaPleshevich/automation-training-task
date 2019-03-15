package com.epam.error.action;


import com.epam.error.entity.Point;

public class ActionPoint {
    public static double calculateDistance(Point pointA, Point pointB) {
        return Math.hypot(Math.hypot(pointA.getX()- pointB.getX(), pointA.getY() - pointB.getY()), pointA.getZ() - pointB.getZ());
    }
}
