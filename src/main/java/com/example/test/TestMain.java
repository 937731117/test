package com.example.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMain {
    public static void main(String[] args) {
        String str = "23";
        List<String> list = getPhoneNumberChar(str);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static List<String> getPhoneNumberChar(String digits) {
        List<String> coms = new ArrayList<String>();
        if (digits == null || "".equals(digits) || digits.length() == 0) {
            return coms;
        }
        Map<Character, String> phoneNumMap = new HashMap<Character, String>();
        phoneNumMap.put('2', "abc");
        phoneNumMap.put('3', "def");
        phoneNumMap.put('4', "ghi");
        phoneNumMap.put('5', "jkl");
        phoneNumMap.put('6', "mno");
        phoneNumMap.put('7', "pqrs");
        phoneNumMap.put('8', "tuv");
        phoneNumMap.put('9', "wxyz");
        combinationNum(coms, phoneNumMap, digits, 0, new StringBuffer());
        return coms;
    }

    public static void combinationNum(List<String> coms, Map<Character, String> phoneNumMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            coms.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String phoneNumString = phoneNumMap.get(digit);
            int length = phoneNumString.length();
            for (int i = 0; i < length; i++) {
                combination.append(phoneNumString.charAt(i));
                combinationNum(coms, phoneNumMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
