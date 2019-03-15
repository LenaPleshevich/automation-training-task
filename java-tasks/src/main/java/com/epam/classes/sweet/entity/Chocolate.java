package com.epam.classes.sweet.entity;

public class Chocolate extends Sweet {
    private Color color;

    public Chocolate(String name, double cost, double weight, Color color) {
        super(name, cost, weight);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Chocolate chocolate = (Chocolate) o;

        return color == chocolate.color;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Chocolate{" +
                "color=" + color +
                "} " + super.toString();
    }
}
