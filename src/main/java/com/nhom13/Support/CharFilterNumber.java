
package com.nhom13.Support;

import javax.swing.text.*;

/**
 *
 * @author baam0
 */
public class CharFilterNumber extends DocumentFilter{
    @Override
    public void insertString(FilterBypass fb, int offset, String string,
                             AttributeSet attr) throws BadLocationException {
        StringBuilder sb = new StringBuilder(string);
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (!Character.isDigit(c)) {
                sb.deleteCharAt(i);
            }
        }
        super.insertString(fb, offset, sb.toString(), attr);
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text,
                        AttributeSet attrs) throws BadLocationException {
        if (text != null) {
            StringBuilder sb = new StringBuilder(text);
            for (int i = sb.length() - 1; i >= 0; i--) {
                char c = sb.charAt(i);
                if (!Character.isDigit(c)) {
                    sb.deleteCharAt(i);
                }
            }
            text = sb.toString();
        }
        super.replace(fb, offset, length, text, attrs);
    }
}
