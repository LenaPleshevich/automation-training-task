package com.epam.error.entity;

public class Sphere {
    private Point centre;
    private double radius;

    public Sphere(Point point, double radius) {
        this.centre = point;
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Point getCentre() {
        return centre;
    }

    public void setCentre(Point centre) {
        this.centre = centre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sphere sphere = (Sphere) o;

        if (Double.compare(sphere.radius, radius) != 0) return false;
        return centre.equals(sphere.centre);

    }

    public boolean equalsSphere(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sphere sphere = (Sphere) o;

        return (Double.compare(sphere.radius, radius) != 0);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = centre.hashCode();
        temp = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "centre=" + centre +
                ", radius=" + radius +
                '}';
    }
}
