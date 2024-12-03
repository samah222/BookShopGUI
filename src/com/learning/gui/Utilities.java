package com.learning.gui;

/**
 *
 * @author Samah Mahdi (samah.mahdi.hassan@gmail.com)
 */

public  class Utilities {
    
    //check if a string is a valid number or not
    
    public static final int CURRENT_YEAR = 24;
    
    public static boolean isNumeric(String str) {
    if (str == null || str.isBlank()) {
        return false;
    }

    for (int i = 0; i < str.length(); i++) {
        if (!Character.isDigit(str.charAt(i))) {
            return false;
        }
    }

    try {
        Integer.parseInt(str); 
        return true;
    } catch (NumberFormatException e) {       
        return false;
    }
}
}
