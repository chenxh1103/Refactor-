package org.chenxh.refactor;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest extends MovieTest {
    private Customer customer;
    @Before
    public void buildCustomer() {
        this.customer = new Customer("张三");
        Movie movie1 = new Movie("巨人", Movie.CHILDRENS);
        Rental rental1 = new Rental(movie1, 2);
        Movie movie2 = new Movie("movie2", Movie.NEW_RELEASE);
        Rental rental2 = new Rental(movie2, 20);
        customer.addRental(rental1);
        customer.addRental(rental2);
    }
    @Test
    public void statement() throws Exception {
        String statement = customer.statement();
        System.out.println(statement);
    }

}