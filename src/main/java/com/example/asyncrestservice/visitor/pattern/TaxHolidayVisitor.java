package com.example.asyncrestservice.visitor.pattern;

import java.text.DecimalFormat;

public class TaxHolidayVisitor implements Visitor {

    DecimalFormat decimalFormat = new DecimalFormat("#.##");

    public TaxHolidayVisitor() {
    }

    @Override
    public double visit(Liquor liquorItem) {
        liquorItem.getPrice();
        double totalWithTax = (liquorItem.getPrice() * 0.10) + liquorItem.getPrice();
        return Double.parseDouble(decimalFormat.format(totalWithTax));
    }

    @Override
    public double visit(Tobacco tobaccoItem) {
        tobaccoItem.getPrice();
        double totalWithTax = (tobaccoItem.getPrice() * 0.22) + tobaccoItem.getPrice();
        return Double.parseDouble(decimalFormat.format(totalWithTax));
    }

    @Override
    public double visit(Necessity necessityItem) {
        necessityItem.getPrice();
        double totalWithTax = (necessityItem.getPrice() * 0.0) + necessityItem.getPrice();
        return Double.parseDouble(decimalFormat.format(totalWithTax));
    }
}
