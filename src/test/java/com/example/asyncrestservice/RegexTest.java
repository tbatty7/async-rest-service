package com.example.asyncrestservice;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegexTest {
    @Test
    public void canMatchString() {
        assertEquals(2, countOfMatches("foo", "foofoo"));
    }

    @Test
    public void canMatchAnyCharacter() {
        assertEquals(6, countOfMatches(".", "foofoo"));
    }

    @Test
    public void dotAfterTextMeansAnyCharacter() {
        // This means that it is looking for how many times the word "foo" followed by any character is found,
        // which is only once.
        assertEquals(1, countOfMatches("foo.", "foofoo"));
    }

    @Test
    public void matchingOneCharacterOrAnother() {
        // The brackets mean it is matching if any letter inside it is in the text
        assertEquals(1, countOfMatches("[abc]", "have"));
        assertEquals(3, countOfMatches("[abc]", "cab"));
        // This matches if it is IL, IC, ID, or IM
        assertEquals(4, countOfMatches("[I][LCDM]", "IL IC ID IM"));
        // You don't need the brackets if you are only maching one though
        assertEquals(4, countOfMatches("I[LCDM]", "IL IC ID IM"));
        // This matches only these combinations: IL IC ID IM VL VC VD VM, not IV or LCDM
        assertEquals(8, countOfMatches("[IV][LCDM]", "IL IC ID IM VL VC VD VM. Not IV IX LCDM"));
    }

    @Test
    public void matchingNorCharacter() {
        // This matches each character that is not a, b, or c in a string of text
        assertEquals(1, countOfMatches("[^abc]", "g"));
        assertEquals(2, countOfMatches("[^abc]", "gt"));
        assertEquals(3, countOfMatches("[^abc]", "gte"));
        assertEquals(3, countOfMatches("[^abc]", "agte"));
        assertEquals(0, countOfMatches("[^abc]", "cba"));
        // To match only words that don't start with a certain letter
        assertEquals(1, countOfMatches("[^c]at", "cat rat"));
        assertEquals(0, countOfMatches("[^c]at", "cat car"));
        // The Nor operator ^ can only be used in the brackets, otherwise is is looking for the characters to be
        // found at the beginning of the sentence
        assertEquals(0, countOfMatches("^a", "xa"));
        assertEquals(1, countOfMatches("^a", "ax"));
    }

    @Test
    public void matching_a_range() {
        assertEquals(2, countOfMatches("[A-Z]", "Two Uppercase alphabets 34 overall"));
        // negating a range in this example matches on every character that is not an uppercase letter,
        // including spaces, numbers, and punctuation
        assertEquals(8, countOfMatches("[^A-Z]", "THIS ONLY HAS oNE LOWERCASE BUT SEVEN SPACES"));
        // matching only uppercase and lowercase letters
        assertEquals(9, countOfMatches("[A-Za-z]", "I have nine 934...??"));
        // matching a range of numbers
        assertEquals(3, countOfMatches("[4-9]", "1234560"));
        // matching a union of numbers can be used to skip 4,5, and 6
        assertEquals(4, countOfMatches("[1-3[7-9]]", "2345678"));
    }

    @Test
    public void matchingAnIntersectionWithTwoRangesOnlyWorksWithNumbers() {
        // This only matches the intersection of two sets of numbers ignoring spaces
        // it is matching 12, 23, and 32
        assertEquals(3, countOfMatches("[1-3&&[2-5]]", "12 32"));

        // It does not work with letters
        assertEquals(0, countOfMatches("[V-W&&[C-D]]", "VL VC VD VM IL IC ID IM"));
    }

    @Test
    public void matchingTextAtBeginningOfString() {
        // This matches because "cat" is at the beginning of the sentence
        assertEquals(1, countOfMatches("^cat", "cats are nice"));
        // This does not match because "cat" is not at the beginning of the sentence
        assertEquals(0, countOfMatches("^cat", "I like cats"));
    }

    @Test
    public void matchingDuplicateCharacters() {
        // This is matching any combination of 4 I or X, so IXIX would match, IIII would match, ect.
        assertEquals(3, countOfMatches("[IX]{4}", "IIII XXXX XXII"));
    }

    @Test
    public void matchingValueOrAnotherValue() {
        // This is only matching 4 of a kind of X OR 4 of a kind of I, not mixed.
        assertEquals(2, countOfMatches("X{4}|I{4}", "IIII XXXX XIII"));
        assertEquals(1, countOfMatches("X{4}|I{4}", "IIII"));
        assertEquals(1, countOfMatches("X{4}|I{4}", "XXXX"));
    }

    private int countOfMatches(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
