package com.example.asyncrestservice;

public class StringUnmarshaller {
    String getCatalogId(String xml) {
        String openingTag = "Catalog>";
        int startingIndexOfCatalogId = xml.indexOf(openingTag) + openingTag.length();
        String splitXml = xml.substring(startingIndexOfCatalogId);
        String closingTag = "<";
        return splitXml.substring(0, splitXml.indexOf(closingTag));
    }
}
