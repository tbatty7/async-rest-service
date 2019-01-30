package com.example.asyncrestservice;

import com.example.asyncrestservice.visitor.pattern.*;
import org.junit.Test;

public class VisitorPatternTest {
    @Test
    public void regularTaxCalculation() {
        TaxVisitor taxCalculator = new TaxVisitor();
        Necessity milk = new Necessity(2.42);
        Liquor sherry = new Liquor(15.55);
        Tobacco cigars = new Tobacco(32.22);

        System.out.printf("Milk with tax: " + milk.accept(taxCalculator) + "\n");
        System.out.printf("Sherry with tax: " + sherry.accept(taxCalculator) + "\n");
        System.out.printf("Cigars with tax: " + cigars.accept(taxCalculator) + "\n");
        double total = milk.accept(taxCalculator) + sherry.accept(taxCalculator) + cigars.accept(taxCalculator);
        System.out.printf("Total: " + total);
    }

    @Test
    public void holidayTaxCalculation() {
        TaxHolidayVisitor taxCalculator = new TaxHolidayVisitor();
        Necessity milk = new Necessity(2.42);
        Liquor sherry = new Liquor(15.55);
        Tobacco cigars = new Tobacco(32.22);

        System.out.printf("Milk with tax: " + milk.accept(taxCalculator) + "\n");
        System.out.printf("Sherry with tax: " + sherry.accept(taxCalculator) + "\n");
        System.out.printf("Cigars with tax: " + cigars.accept(taxCalculator) + "\n");
        double total = milk.accept(taxCalculator) + sherry.accept(taxCalculator) + cigars.accept(taxCalculator);
        System.out.printf("Total: " + total);
    }
}
