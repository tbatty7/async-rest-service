package com.example.asyncrestservice.reflective.visitor.pattern;

import java.lang.reflect.Method;

public abstract class ReflectiveVisitor {
     abstract public void visit(Object object);

    public void visitTheOther(TheOther e) {
        System.out.println("ReflectiveVisitor: do Base on " + e.theOther() + "\n");
    }

    protected Method getMethod(Class source) {
        Class clazz = source;
        Method methodToReturn = null;

        while (methodToReturn == null && clazz != Object.class) {
            String clazzname = clazz.getName();
            System.out.printf("Now object is: " + clazzname + "\n");
            String methodName = "visit" + clazzname.substring(clazzname.lastIndexOf('.') + 1);
            try {
                System.out.printf("getClass called by ReflectiveVisitor returns " + getClass().getName() + "\n");
                methodToReturn = getClass().getMethod(methodName, clazz);
            } catch (NoSuchMethodException e) {
                clazz = clazz.getSuperclass();
            }
        }
        if (clazz == Object.class) {
            System.out.printf("Searching for interfaces...\n");
            Class[] interfaces = source.getInterfaces();
            for (Class intrface : interfaces) {
                String interfaceName = intrface.getName();
                String interfaceMethodName = "visit" + interfaceName.substring(interfaceName.lastIndexOf('.') + 1);
                try {
                    System.out.printf("Interface method name of: " + interfaceMethodName + "\n");
                    methodToReturn = getClass().getMethod(interfaceMethodName, intrface);
                } catch (NoSuchMethodException e) {
                    System.out.printf("No method named " + interfaceMethodName + " in " + getClass().getName() + "\n");
                    e.printStackTrace();
                }
            }
        }
        if (methodToReturn == null) {
            try {
                methodToReturn = getClass().getMethod("visitObject", Object.class);
                System.out.printf("It found the visitObject Method in " + getClass().getName());
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return methodToReturn;
    }
}
