package com.epam.classes.sweet.action;

import com.epam.classes.sweet.gift.GiftBox;
import com.epam.classes.sweet.entity.Sweet;
import java.util.ArrayList;
import java.util.Collections;

public class ActionGiftBox {
    public static void sortGiftByCost(GiftBox giftBox) {
        Collections.sort(giftBox.getSweetsList(), new SweetCostComparator());
    }

    public static void sortGiftByWeight(GiftBox giftBox) {
        Collections.sort(giftBox.getSweetsList(), new SweetWeightComparator() );
    }

    public static void addSweet(GiftBox giftBox, Sweet sweet) {
        giftBox.getSweetsList().add(sweet);
        calculateFullCostGift(giftBox);
        calculateFullWeightGift(giftBox);
    }

    public static void removeSweet(GiftBox giftBox, Sweet sweet) {
        giftBox.getSweetsList().remove(sweet);
        calculateFullCostGift(giftBox);
        calculateFullWeightGift(giftBox);
    }

    public static ArrayList<Sweet> findSweetByCost(double minCost, double maxCost, GiftBox giftBox) {
        ArrayList<Sweet> resultList = new ArrayList<Sweet>();
        for (Sweet sweet : giftBox.getSweetsList()) {
            if(sweet.getCost() >= minCost && sweet.getCost() <= maxCost){
                resultList.add(sweet);
            }
        }
        return resultList;
    }

    public static void calculateFullWeightGift(GiftBox giftBox) {
        double fullWeight = 0;
        for (Sweet sweet : giftBox.getSweetsList()) {
            fullWeight += sweet.getWeight();
        }
        giftBox.setFullWeight(fullWeight);
    }

    public static void calculateFullCostGift(GiftBox giftBox) {
        double fullCost = 0;
        for (Sweet sweet : giftBox.getSweetsList()) {
            fullCost += sweet.getCost();
        }
        giftBox.setFullCost(fullCost);
    }
}
