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
        Iterator rental = rentals.iterator();
        String result = "Rental record for " + getName() + "\n";
        while (rental.hasNext()){
            Rental each = (Rental) rental.next();
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getgetFrequentRenterPoints()) + " frequent renter points";
        return result;

    }

    private double getTotalCharge(){
        Iterator rental = rentals.iterator();
        double result = 0;
        while (rental.hasNext()){
            Rental each = (Rental) rental.next();
            result += each.getCharge();
        }
        return result;
    }

    private int getgetFrequentRenterPoints(){
        Iterator rental = rentals.iterator();
        int result = 0;
        while (rental.hasNext()){
            Rental each = (Rental) rental.next();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}
