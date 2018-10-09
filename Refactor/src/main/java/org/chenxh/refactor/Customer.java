package org.chenxh.refactor;

import java.util.*;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental){
        this.rentals.add(rental);
    }

    public String statement(){
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Iterator rental = rentals.iterator();
        String result = "Rental record for " + getName() + "\n";
        while (rental.hasNext()){
            double thisAmout = 0;
            Rental each = (Rental) rental.next();
            switch (each.getMovie().getPriceCode()){
                case  Movie.REGULAR:
                thisAmout += 2;
                if(each.getDaysRented() > 2){
                    thisAmout = (each.getDaysRented() - 2) * 1.5;
                }
                break;
                case Movie.NEW_RELEASE:
                    thisAmout = each.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmout += 1.5;
                    if(each.getDaysRented() > 3){
                        thisAmout += (each.getDaysRented() - 3) * 1.5;
                    }
                    break;
            }
            frequentRenterPoints ++ ;
            if(each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDaysRented() > 1)
                frequentRenterPoints ++;
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmout) + "\n";
            totalAmount += thisAmout;
        }
        result += "Amount owed is" + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + "frequent renter points";
        return result;

    }
}
