package com.example.asyncrestservice;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SysOutTest {
    @Test
    public void testingSystemOutPrintln() {
        // You can write a test for anything you can put into a sysout.

        String line = "You can test this line";
        System.out.println(line);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(output);
        out.println(line);
        assertEquals(line, output.toString().trim());
    }

    @Test
    public void anObjectPassedIntoAListCanBeChangedInThatList() {
        Thing one = new Thing(1); // The number is 1

        List<Thing> things = Arrays.asList(one);
        things.get(0).number = 0;
        
        assertFalse(one.number == 1); // The number in Thing one object is no longer 1
        assertEquals(one.number, 0);  // The original object has changed!
    }

    @Test
    public void anObjectPassedIntoAClassCanBeChangedByThatClass() {
        Thing one = new Thing(1); // The number is 1

        ClassToTest classToTest = new ClassToTest(one);
        classToTest.increaseNumber();

        assertNotEquals(1, one.number); // The number in Thing one object is no longer 1
        assertEquals(one.number, 2);  // The object passed into the classToTest has changed!
    }

    private class Thing {
        public int number;

        public Thing(int number) {
            this.number = number;
        }
    }

    private class ClassToTest {
        private Thing thing;

        public ClassToTest(Thing thing) {
            this.thing = thing;
        }

        public void increaseNumber() {
            thing.number++;
        }
    }
}
