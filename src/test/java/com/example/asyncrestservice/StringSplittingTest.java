package com.example.asyncrestservice;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class StringSplittingTest {

    String text = "The day was <Catalog>very</Catalog> long <and> hard";

    @Test
    public void extractSubstringWithSplit() {
        String catalogId = new StringUnmarshaller().getCatalogId(text);
        assertEquals("very", catalogId);
    }

    @Test
    public void extractSubstringWithRegexIsMoreBrittle() {
        Pattern pattern = Pattern.compile("(Catalog>(.*)<)");
        Matcher matcher = pattern.matcher(text);
        matcher.find();
        assertFalse(matchesString("very", matcher.group(2)));
    }

    private boolean matchesString(String expected, String actual) {
        return expected == actual;
    }
}
