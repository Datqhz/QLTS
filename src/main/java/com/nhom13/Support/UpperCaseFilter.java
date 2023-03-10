package com.nhom13.Support;

import javax.swing.JTextField;



public class UpperCaseFilter {
    public static void convertToUpperCase(JTextField textField) {
    String text = textField.getText();
    text = text.toUpperCase();
    textField.setText(text);
}
}
