package com.epam.classes.sweet.entity;

public class Cookie extends Sweet {
    private String filling;

    public Cookie(String name, double cost, double weight, String filling) {
        super(name, cost, weight);
        this.filling = filling;
    }

    public String getFilling() {
        return filling;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Cookie cookie = (Cookie) o;

        return filling != null ? filling.equals(cookie.filling) : cookie.filling == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (filling != null ? filling.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cookie{" +
                "filling='" + filling + '\'' +
                "} " + super.toString();
    }
}
