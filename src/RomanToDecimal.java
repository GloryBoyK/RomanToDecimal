import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class RomanToDecimal {

    public static String decimalToRoman(int decimal) {
        HashMap<Integer, String> digitConverter = new HashMap<>();
        digitConverter.put(1, "I");
        digitConverter.put(4, "IV");
        digitConverter.put(5, "V");
        digitConverter.put(9, "IX");
        digitConverter.put(10, "X");
        digitConverter.put(40, "XL");
        digitConverter.put(50, "L");
        digitConverter.put(90, "XC");
        digitConverter.put(100, "C");
        digitConverter.put(400, "CD");
        digitConverter.put(500, "D");
        digitConverter.put(900, "CM");
        digitConverter.put(1000, "M");

        String roman = "";
        while (decimal > 0) {
            //System.out.println("DEBUG: " + decimal);
            if (decimal >=1000) {
                roman += digitConverter.get(1000);
                decimal -= 1000;
            }
            else if (decimal >= 900) {
                roman += digitConverter.get(900);
                decimal -= 900;
            }
            else if (decimal >= 500) {
                roman += digitConverter.get(500);
                decimal -= 500;
            }
            else if (decimal >= 400) {
                roman += digitConverter.get(400);
                decimal -= 400;
            }
            else if (decimal >= 100) {
                roman += digitConverter.get(100);
                decimal -= 100;
            }
            else if (decimal > 90) {
                roman += digitConverter.get(90);
                decimal -= 90;
            }
            else if (decimal >= 50) {
                roman += digitConverter.get(50);
                decimal -= 50;
            }
            else if (decimal >= 40) {
                roman += digitConverter.get(40);
                decimal -= 40;
            }
            else if (decimal >= 10) {
                roman += digitConverter.get(10);
                decimal -= 10;
            }
            else if (decimal >= 9) {
                roman += digitConverter.get(9);
                decimal -= 9;
            }
            else if (decimal >= 5) {
                roman += digitConverter.get(5);
                decimal -= 5;
            }
            else if (decimal >= 4) {
                roman += digitConverter.get(4);
                decimal -= 4;
            }
            else if (decimal >= 1) {
                roman += digitConverter.get(1);
                decimal -= 1;
            }
        }
        //System.out.println("DEBUG: " + roman);
        return roman;
    }

    /**
     * Take in a string and use each character as a key and find its value, then add for the answer
     *
     * @param roman
     * @return variable type int
     */
    public static int romanToDecimal(String roman){
        HashMap<Character, Integer> digitConverter = new HashMap<>();

        digitConverter.put('I', 1);
        digitConverter.put('V', 5);
        digitConverter.put('X', 10);
        digitConverter.put('L', 50);
        digitConverter.put('C', 100);
        digitConverter.put('D', 500);
        digitConverter.put('M', 1000);
        //digitConverter.put('IV', -2);

        roman = roman.toUpperCase();

        ArrayList<Character> testCase = new ArrayList<>();
        testCase.add('I');
        testCase.add('V');
        testCase.add('X');
        testCase.add('L');
        testCase.add('C');
        testCase.add('D');
        testCase.add('M');

        //charAt() and .contains() methods used here
        for (int i = 0; i < roman.length(); i++) {
            if (testCase.contains(roman.charAt(i))) {
                //System.out.println(testCase.indexOf(i));
                continue;
            } else {
                return -1;
            }
        }

        int result = 0;
        //INVARIANTS
        //.charAt() method used here
        for (int i = 0; i < roman.length(); i++) {
            result += digitConverter.get(roman.charAt(i));
            /*if (i > 0 && digitConverter.get(roman.charAt(i)) > digitConverter.get(roman.charAt(i - 1)))
                result += digitConverter.get(roman.charAt(i)) - 2 * digitConverter.get(roman.charAt(i - 1));
            else {
                if(digitConverter.get(roman.charAt(i)) == null)
                    return -1;
            }*/
        }
        if(roman.indexOf("IV") != -1)
            result -= 2;
        if(roman.indexOf("IX") != -1)
            result -= 2;
        if(roman.indexOf("XL") != -1)
            result -= 20;
        if(roman.indexOf("XC") != -1)
            result -= 20;
        if(roman.indexOf("CD") != -1)
            result -= 200;
        if(roman.indexOf("CM") != -1)
            result -= 200;
        //System.out.println("DEBUG: " + result);
        if (!roman.equals(decimalToRoman(result)))
            return -2;
        return result;
    }

    private static void extra(int x) {
        if (x > 2022) {
            int BC = x - 2022;
            System.out.println("If you were " + x + " years old, your birth year would be " + BC + " BC!");
        } else {
            System.out.println("If you were " + x + " years old, your birth year would be " + (2022 - x) + "!");
        }
    }

    public static void main(String[] args) {
        //Scanner s = new Scanner(System.in);
        //System.out.print("Enter your Roman number: ");
        //String input = s.nextLine();
        //extra(romanToDecimal(input));

        for (String roman : args) {
            //roman = roman.toUpperCase();
            if (romanToDecimal(roman) == -1) {
                System.out.println("Input: " + roman + " ==> Output: invalid");
            }
            else if (romanToDecimal(roman) == -2) {
                System.out.println("Input: " + roman + " ==> Output: logically incorrect");
            }
            else{
                    System.out.println("Input: " + roman + " ==> Output: " + romanToDecimal(roman));
                }
            }
        }
    }