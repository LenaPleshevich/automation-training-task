package com.epam.classes.sweet.creator;

import com.epam.classes.sweet.exception.IncorrectDataException;
import com.epam.classes.sweet.entity.*;
import org.apache.commons.lang3.StringUtils;

public class SweetFactory {
    public Chocolate createChocolate(String name, double cost, double weight, Color color) throws IncorrectDataException {
        if(StringUtils.isEmpty(name)){
            throw new IncorrectDataException("Name is not correct");
        }
        if(cost < 0){
            throw new IncorrectDataException("Cost can't be negative");
        }

        if(weight < 0){
            throw new IncorrectDataException("Weight can't be negative");
        }
        if(color == null){
            throw new IncorrectDataException("Color is not correct");
        }
        return new Chocolate(name, cost, weight, color);
    }

    public Cookie createCookie(String name, double cost, double weight, String filling) throws IncorrectDataException {
        if(StringUtils.isEmpty(name)){
            throw new IncorrectDataException("Name is not correct");
        }
        if(cost < 0){
            throw new IncorrectDataException("Cost can't be negative");
        }

        if(weight < 0){
            throw new IncorrectDataException("Weight can't be negative");
        }

        if(StringUtils.isEmpty(filling)){
            throw new IncorrectDataException("Filling is not correct");
        }

        return new Cookie(name, cost, weight, filling);
    }

    public Candy createCandy(String name, double cost, double weight, String flavor, Type type) throws IncorrectDataException {
        if(StringUtils.isEmpty(name)){
            throw new IncorrectDataException("Name is not correct");
        }
        if(cost < 0){
            throw new IncorrectDataException("Cost can't be negative");
        }

        if(weight < 0){
            throw new IncorrectDataException("Weight can't be negative");
        }

        if(StringUtils.isEmpty(flavor)){
            throw new IncorrectDataException("Flavor is not correct");
        }

        if(StringUtils.isEmpty(name)){
            throw new IncorrectDataException("Name is not correct");
        }
        if(cost < 0){
            throw new IncorrectDataException("Cost can't be negative");
        }

        if(weight < 0){
            throw new IncorrectDataException("Weight can't be negative");
        }

        if(type == null){
            throw new IncorrectDataException("Type is not correct");
        }

        return new Candy(name, cost, weight, flavor, type);
    }


}
