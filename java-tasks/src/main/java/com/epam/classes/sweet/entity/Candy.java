package com.epam.classes.sweet.entity;

public class Candy extends Sweet {
    private String flavor;
    private Type type;

    public Candy(String name, double cost, double weight, String flavor,Type type) {
        super(name, cost, weight);
        this.flavor = flavor;
        this.type = type;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Candy candy = (Candy) o;

        if (flavor != null ? !flavor.equals(candy.flavor) : candy.flavor != null) return false;
        return type == candy.type;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (flavor != null ? flavor.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Candy{" +
                "flavor='" + flavor + '\'' +
                ", type=" + type +
                "} " + super.toString();
    }
}
