package com.example.asyncrestservice.reflective.visitor.pattern;

import java.lang.reflect.InvocationTargetException;

public class DownVisitor extends ReflectiveVisitor {
    @Override
    public void visit(Object object) {
        try {
            getMethod(object.getClass()).invoke(this, object);
        } catch (Exception e) {
            System.out.printf("DownVisitor: no appropriate visit() method\n");
        }
    }

    public void visitThat(That element) {
        System.out.printf("DownVisitor:  do down on " + element.that() + "\n");
    }
}
