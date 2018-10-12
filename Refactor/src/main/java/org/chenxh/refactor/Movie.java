package org.chenxh.refactor;

import org.chenxh.refactor.Price.ChildrensPrice;
import org.chenxh.refactor.Price.NewReleasePrice;
import org.chenxh.refactor.Price.Price;
import org.chenxh.refactor.Price.RegularPrice;

public class Movie{
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private Price price;

    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    void setPriceCode(int priceCode) {
        switch (priceCode){
            case REGULAR:
                price = new RegularPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            case CHILDRENS:
                price = new ChildrensPrice();
                break;
        }
    }

    double getCharge(int daysRented){
        return price.getCharge(daysRented);
    }

    int getFrequentRenterPoints(int daysRented){
        return price.getFrequentRenterPoints(daysRented);
    }
}
