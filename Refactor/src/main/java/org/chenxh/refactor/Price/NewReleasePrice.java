package org.chenxh.refactor.Price;

import org.chenxh.refactor.Movie;

public class NewReleasePrice extends Price{
    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }

    public int getFrequentRenterPoints(int daysRented){
        return (daysRented > 1) ? 2:1;
    }
}
