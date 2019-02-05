package com.example.asyncrestservice.reflective.visitor.pattern;

public class That implements Element {
    @Override
    public void accept(ReflectiveVisitor v) {
        v.visit(this);
    }

    public String that() {
        return "That";
    }
}
