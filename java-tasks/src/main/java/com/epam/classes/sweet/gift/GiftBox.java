package com.epam.classes.sweet.gift;

import com.epam.classes.sweet.entity.Sweet;

import java.util.ArrayList;

public class GiftBox {
    private ArrayList<Sweet> sweetsList;
    private double fullCost;
    private double fullWeight;

    public GiftBox() {
        sweetsList = new ArrayList<Sweet>();
    }

    public ArrayList<Sweet> getSweetsList() {
        return sweetsList;
    }

    public void setSweetsList(ArrayList<Sweet> sweetsList) {
        this.sweetsList = sweetsList;
    }

    public double getFullCost() {
        return fullCost;
    }

    public void setFullCost(double fullCost) {
        this.fullCost = fullCost;
    }

    public double getFullWeight() {
        return fullWeight;
    }

    public void setFullWeight(double fullWeight) {
        this.fullWeight = fullWeight;
    }
}
