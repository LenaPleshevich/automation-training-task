package com.epam.classes.sweet.action;

import com.epam.classes.sweet.entity.Sweet;

import java.util.Comparator;

public class SweetCostComparator implements Comparator<Sweet> {
    @Override
    public int compare(Sweet o1, Sweet o2) {
        return (int) (o1.getCost() - o2.getCost());
    }
}
