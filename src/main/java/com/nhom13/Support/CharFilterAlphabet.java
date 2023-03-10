
package com.nhom13.Support;

import java.nio.charset.StandardCharsets;
import javax.swing.text.*;


public class CharFilterAlphabet extends DocumentFilter{
private final String regex = new String("[\\p{L} \\p{Mn}]*".getBytes(), StandardCharsets.UTF_8);

    @Override
    public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
        if (text.matches(regex)) {
            super.insertString(fb, offset, text, attr);
        }
    }

    @Override
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (text.matches(regex)) {
            super.replace(fb, offset, length, text, attrs);
        }
    }
}
