package com.epam.error.action;

import com.epam.error.entity.Point;
import com.epam.error.entity.Sphere;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActionSphere {
    public static final String LINE_REGEX = "(\\-?\\d+(\\.\\d{0,})\\s?){4}?";
    public static final int CONST_FOR_AREA = 4;
    public static final double CONST_FOR_VOLUME = 4.0 / 3.0;
    public static final double CONST_FOR_HEIGHT_SPHERE = 1.0 / 3.0;
    public static double calculateSphereArea(Sphere sphere) {
        return CONST_FOR_AREA * Math.PI * Math.pow(sphere.getRadius(), 2);
    }

    public static double calculateSphereVolume(Sphere sphere) {
        return CONST_FOR_VOLUME * (Math.PI * Math.pow(sphere.getRadius(), 3));
    }

    public static boolean checkSphere(Sphere sphere) {
        return sphere.getRadius() > 0;
    }

    public static int definePositionXY(Sphere sphere) {
        int result = -1;
        if  (Math.pow(sphere.getCentre().getZ(), 2) < Math.pow(sphere.getRadius(), 2)) {
            result = 1;
        } else if (Math.pow(sphere.getCentre().getZ(), 2) == Math.pow(sphere.getRadius(), 2)) {
            result = 0;
        }
        return result;
    }

    public static int definePositionXZ(Sphere sphere) {
        int result = -1;
        if  (Math.pow(sphere.getCentre().getY(), 2) < Math.pow(sphere.getRadius(), 2)) {
            result = 1;
        } else if (Math.pow(sphere.getCentre().getY(), 2) == Math.pow(sphere.getRadius(), 2)) {
            result = 0;
        }
        return result;
    }

    public static int definePositionZY(Sphere sphere) {
        int result = -1;
        if  (Math.pow(sphere.getCentre().getX(), 2) < Math.pow(sphere.getRadius(), 2)) {
            result = 1;
        } else if (Math.pow(sphere.getCentre().getX(), 2) == Math.pow(sphere.getRadius(), 2)) {
            result = 0;
        }
        return result;
    }

    public static double segmentsRatioDividedXY(Sphere sphere) {
        double result = 0;
        double heightPart;
        double heightSphere;
        double volumePart;

        Point projectionXY = new Point(sphere.getCentre().getX(), sphere.getCentre().getY(), 0.0);

        if (definePositionXY(sphere) == 1)
        {
            Point highestPoint = new Point(sphere.getCentre().getX(), sphere.getCentre().getY() , sphere.getCentre().getZ() + sphere.getRadius());
            heightPart = ActionPoint.calculateDistance(projectionXY, highestPoint);
            if (heightPart > sphere.getRadius()) {
                heightSphere = 2 * sphere.getRadius() - heightPart;
            } else {
                heightSphere = heightPart;
            }
            volumePart = Math.PI * Math.pow(heightSphere, 2) * (sphere.getRadius() - CONST_FOR_HEIGHT_SPHERE * heightSphere);
            result = volumePart / (calculateSphereVolume(sphere) - volumePart);
        }
        return result;
    }

    public static double segmentsRatioDividedXZ(Sphere sphere) {
        double result = 0;
        double heightPart;
        double heightSphere;
        double volumePart;
        Point projectionXZ = new Point(sphere.getCentre().getX(), 0, sphere.getCentre().getZ());
        if (definePositionXZ(sphere) == 1) {
            Point highestPoint = new Point(sphere.getCentre().getX(), sphere.getCentre().getY() + sphere.getRadius(), sphere.getCentre().getZ());
            heightPart = ActionPoint.calculateDistance(projectionXZ, highestPoint);
            if(heightPart > sphere.getRadius()) {
                heightSphere = 2 * sphere.getRadius() - heightPart;
            } else {
                heightSphere = heightPart;
            }
            volumePart = Math.PI * Math.pow(heightSphere, 2) * (sphere.getRadius() - 1.0/3.0 * heightSphere);
            result = volumePart / (calculateSphereVolume(sphere) - volumePart);
        }
        return result;
    }

    public static double segmentsRatioDividedYZ(Sphere sphere) {
        double result = 0;
        double heightPart;
        double heightSphere;
        double volumePart;
        Point projectionYZ = new Point(0, sphere.getCentre().getY() , sphere.getCentre().getZ());
        if (definePositionZY(sphere) == 1) {
            Point highestPoint = new Point(sphere.getCentre().getX() + sphere.getRadius(), sphere.getCentre().getY() , sphere.getCentre().getZ());
            heightPart = ActionPoint.calculateDistance(projectionYZ, highestPoint);
            if(heightPart > sphere.getRadius()) {
                heightSphere = 2 * sphere.getRadius() - heightPart;
            } else {
                heightSphere = heightPart;
            }
            volumePart = Math.PI * Math.pow(heightSphere, 2) * (sphere.getRadius() - CONST_FOR_HEIGHT_SPHERE * heightSphere);
            result = volumePart / (calculateSphereVolume(sphere) - volumePart);
        }
        return result;
    }

    public static boolean checkData(String line) {
        Pattern pattern = Pattern.compile(LINE_REGEX);
        Matcher matcher = pattern.matcher(line);
        return matcher.matches();
    }

    public static Sphere createSphere(double[] coordinates) {
        Point centre = new Point(coordinates[1], coordinates[2], coordinates[3]);
        return new Sphere(centre, coordinates[0]);
    }

    public static double[] splitLine(String line) {
        final String SPLIT_DATA = " ";
        double []arrayValues = new double[4];
        String []arrayData = line.split(SPLIT_DATA);
        arrayValues[0] = Double.parseDouble(arrayData[0]);
        arrayValues[1] = Double.parseDouble(arrayData[1]);
        arrayValues[2] = Double.parseDouble(arrayData[2]);
        arrayValues[3] = Double.parseDouble(arrayData[3]);
        return arrayValues;
    }
}
