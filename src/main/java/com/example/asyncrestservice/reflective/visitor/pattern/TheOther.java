package com.example.asyncrestservice.reflective.visitor.pattern;

public class TheOther implements Element {
    @Override
    public void accept(ReflectiveVisitor v) {
        v.visit(this);
    }

    public String theOther() {
        return "TheOther method in TheOther class";
    }
}
