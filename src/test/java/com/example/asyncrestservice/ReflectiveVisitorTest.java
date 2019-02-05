package com.example.asyncrestservice;

import com.example.asyncrestservice.reflective.visitor.pattern.*;
import org.junit.Test;

public class ReflectiveVisitorTest {
    @Test
    public void testIt() {
        Element[] list = {new This(), new That(), new TheOther()};
        UpVisitor up = new UpVisitor();
        DownVisitor down = new DownVisitor();
        for (Element element : list) {
            element.accept(up);
        }
        for (Element element : list) {
            element.accept(down);
        }
    }

    @Test
    public void testThisWithUpVisitor() {
        This aThis = new This();
        UpVisitor upVisitor = new UpVisitor();
        aThis.accept(upVisitor);
    }

    @Test
    public void testThatWithUpVisitor() {
        That that = new That();
        UpVisitor upVisitor = new UpVisitor();
        that.accept(upVisitor);
    }

    @Test
    public void testTheOtherWithUpVisitor() {
        TheOther theOther = new TheOther();
        UpVisitor upVisitor = new UpVisitor();
        theOther.accept(upVisitor);
    }


}
