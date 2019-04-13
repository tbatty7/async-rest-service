package com.example.asyncrestservice;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

public class StringSplittingTest {

    String text = "The day was <Catalog>very</Catalog> long <and> hard";

    @Test
    public void extractSubstringWithSplit() {
        String catalogId = getCatalogId(text);
        assertEquals("very", catalogId);
    }

    private String getCatalogId(String xml) {
        String openingTag = "Catalog>";
        int startingIndexOfCatalogId = xml.indexOf(openingTag) + openingTag.length();
        String catalogId = xml.substring(startingIndexOfCatalogId);
        String closingTag = "<";
        return catalogId.substring(0, catalogId.indexOf(closingTag));
    }

    @Test
    public void extractSubstringWithRegex() {
        Pattern pattern = Pattern.compile("(Catalog>(.*)<)");
        Matcher matcher = pattern.matcher(text);
        matcher.find();
        assertEquals("very", matcher.group(2));
    }
}
