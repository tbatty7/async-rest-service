package com.example.asyncrestservice.visitor.pattern;

import com.example.asyncrestservice.visitor.pattern.Liquor;

public interface Visitor {
    public double visit(Liquor liquorItem);
    public double visit(Tobacco tobaccoItem);
    public double visit(Necessity necessityItem);
}
