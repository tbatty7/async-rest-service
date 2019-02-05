package com.example.asyncrestservice.reflective.visitor.pattern;

import java.lang.reflect.InvocationTargetException;

public class UpVisitor extends ReflectiveVisitor {
    @Override
    public void visit(Object object) {
        try {
            getMethod(object.getClass()).invoke(this, object);
        } catch (Exception e) {
            System.out.printf("UpVisitor: no appropriate visit method");
        }
    }

    public void visitThis(This element) {
        System.out.printf("Do upVisit on : " + element.thiss() + "\n");
    }

    public void visitObject(Object o) {
        System.out.printf("UpVisitor generic visitObject() method");
    }
}
