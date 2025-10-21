package com.zerocode.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractWordsRegex {
	
	public static void main(String[] args) {
        String inputA = "hi my name is $$himaja$$.I am from $$Hyderabad$$.";
        String inputB = "@098#$himaja$$%&";
        System.out.println(extractWords(inputA, "\\$\\$"));
        System.out.println(extractWords(inputB, "\\$\\$"));
    }
    public static String extractWords(String sentence, String encloser) {
        Pattern p = Pattern.compile(encloser + "(.*?)" + encloser);
        Matcher m = p.matcher(sentence);
        String result = "";
        boolean found = false;
        while (m.find()) {              
            result = result + m.group(1) + " ";//group(1) match only inside parentheses without $$
            found = true;
        }
        if (!found)
            return "0"; 
        return result;  
    }
}
