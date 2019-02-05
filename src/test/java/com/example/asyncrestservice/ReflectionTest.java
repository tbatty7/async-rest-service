package com.example.asyncrestservice;

import com.example.asyncrestservice.reflective.visitor.pattern.TheOther;
import com.example.asyncrestservice.reflective.visitor.pattern.This;
import com.example.asyncrestservice.reflective.visitor.pattern.UpVisitor;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class ReflectionTest {

    @Test
    public void getCompleteClassNameUsingReflection() {
        String className = getClassName(String.class);
        System.out.printf("class name: " + className + "\n");
    }

    @Test
    public void getClassNameUsingReflection() {
        String className = getClassName(String.class);
        String result = recreatedClassName(className);
        System.out.printf("recreated class name: " + result + "\n");
    }

    @Test
    public void getParentClassNameUsingReflection() {
        String className = getParentClassName(ArrayList.class);
        System.out.printf("parent class name: " + className + "\n");
    }

    @Test
    public void getMethodNameFromCurrentClass() {
        Method methodName = null;
        try {
            methodName = getClass().getMethod("visitObject", Object.class);
            System.out.printf("Method name is: " + methodName.getName());
        } catch (NoSuchMethodException e) {
            System.out.printf("No such method");
        }

    }

    @Test
    public void getMethodTest() {
        UpVisitor upVisitor = new UpVisitor();
        Class<? extends UpVisitor> aClass = upVisitor.getClass();
        System.out.printf("UpVisitor class is : " + aClass + "\n");
        System.out.printf("Specified class is : " + UpVisitor.class);
    }

    @Test
    public void getClassTest() {
        Class<? extends ReflectionTest> aClass = getClass();
        System.out.printf("getClass() returns : " + aClass);
    }

    @Test
    public void getMethodFromGetClass() {
        try {
            getClass().getMethod("runTest", String.class).invoke(new ReflectionTest(), "I'm from a reflective call");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void getMethodWithNoArgumentsFromSpecifiedClass() {
        try {
            Object theOther = TheOther.class.getMethod("theOther", null).invoke(new TheOther(), null);
            System.out.printf("Result is : " + theOther);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getInterfaces() {
        Class<?>[] interfaces = This.class.getInterfaces();
        int length = interfaces.length;
        System.out.printf("There are " + length + " interfaces. \n");
        String name = interfaces[0].getName();
        System.out.printf("The interface is named " + name);
    }

    public void runTest(String arg) {
        System.out.printf("This runTest method said: " + arg);
    }

    private String getParentClassName(Class aClass) {
        return aClass.getSuperclass().getName();
    }

    private String recreatedClassName(String clazzname) {
        return "visit" + clazzname.substring(clazzname.lastIndexOf('.') + 1);
    }


    private String getClassName(Class clazz) {
        return clazz.getName();
    }
}
