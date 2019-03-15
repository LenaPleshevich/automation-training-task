package com.epam.classes.sweet;

import com.epam.classes.sweet.action.ActionGiftBox;
import com.epam.classes.sweet.creator.SweetFactory;
import com.epam.classes.sweet.exception.IncorrectDataException;
import com.epam.classes.sweet.gift.GiftBox;
import com.epam.classes.sweet.entity.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.ArrayList;

public class ActionGiftTest {
    private GiftBox giftBox;
    private ArrayList<Sweet> foundListSweets;
    private ArrayList<Sweet> sortedSweetByCost;
    private ArrayList<Sweet> sortedSweetByWeight;

    @BeforeClass
    public void initData() throws IncorrectDataException {
        SweetFactory sweetFactory = new SweetFactory();
        giftBox = new GiftBox();
        Chocolate chocolate = sweetFactory.createChocolate("Milka",2.50,100, Color.WHITE);
        Candy candy = sweetFactory.createCandy("Chupa Chups",0.70,25,"strawberry", Type.LOLLIPOP);
        Cookie cookie = sweetFactory.createCookie("Choco Pie",1.24,180,"caramel");
        foundListSweets = new ArrayList<Sweet>();
        foundListSweets.add(candy);
        foundListSweets.add(cookie);
        sortedSweetByCost = new ArrayList<Sweet>();
        sortedSweetByCost.add(candy);
        sortedSweetByCost.add(cookie);
        sortedSweetByCost.add(chocolate);
        sortedSweetByWeight = new ArrayList<Sweet>();
        sortedSweetByWeight.add(candy);
        sortedSweetByWeight.add(chocolate);
        sortedSweetByWeight.add(cookie);
        ActionGiftBox.addSweet(giftBox,chocolate);
        ActionGiftBox.addSweet(giftBox,candy);
        ActionGiftBox.addSweet(giftBox,cookie);
        ActionGiftBox.calculateFullCostGift(giftBox);
        ActionGiftBox.calculateFullWeightGift(giftBox);

    }

    @Test
    public void calculateAllCostGiftTest() {
        double price = 4.44;
        Assert.assertEquals(price, giftBox.getFullCost());
    }

    @Test
    public void calculateAllWeightGiftTest() {
        double fullWeightGift = 305.0 ;
        Assert.assertEquals(fullWeightGift, giftBox.getFullWeight());
    }

    @Test
    public void findSweetByCostTest() {
        Assert.assertEquals(foundListSweets,ActionGiftBox.findSweetByCost(0.50,2.0, giftBox));
    }

    @Test
    public void sortGiftByCostTest() {
        ActionGiftBox.sortGiftByCost(giftBox);
        Assert.assertEquals(sortedSweetByCost,giftBox.getSweetsList());
    }

    @Test
    public void sortGiftByWeightTest() {
        ActionGiftBox.sortGiftByWeight(giftBox);
        Assert.assertEquals(sortedSweetByWeight,giftBox.getSweetsList());
    }
}
