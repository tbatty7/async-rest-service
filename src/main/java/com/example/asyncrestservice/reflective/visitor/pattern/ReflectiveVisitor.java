package com.example.asyncrestservice.reflective.visitor.pattern;

import java.lang.reflect.Method;

public abstract class ReflectiveVisitor {
     abstract public void visit(Object object);

    public void visitTheOther(TheOther e) {
        System.out.println("ReflectiveVisitor: do Base on " + e.theOther());
    }

    protected Method getMethod(Class source) {
        Class clazz = source;
        Method methodName = null;

        while (methodName == null && clazz != Object.class) {
            String clazzname = clazz.getName();
            String classMethodName = "visit" + clazzname.substring(clazzname.lastIndexOf('.') + 1);
            try {
                methodName = getClass().getMethod(classMethodName, clazz);
            } catch (NoSuchMethodException e) {
                clazz = clazz.getSuperclass();
            }
        }
        if (clazz == Object.class) {
            System.out.printf("Searching for interfaces...");
            Class[] interfaces = source.getInterfaces();
            for (Class intrface : interfaces) {
                String interfaceName = intrface.getName();
                String interfaceMethodName = "visit" + interfaceName.substring(interfaceName.lastIndexOf('.') + 1);
                try {
                    methodName = getClass().getMethod(interfaceMethodName, intrface);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
        if (methodName == null) {
            try {
                methodName = getClass().getMethod("visitObject", Object.class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return methodName;
    }
}
