import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * class EnglishNumber
 * @version 10.13.2022
 * @author 25pandey
 */
class EnglishNumber{
    /**
     * Take in a string and use each character as a key and find its value, then add for the answer
     * @param roman
     * @return variable type int
     */
    public static int romanToDecimal(String roman){
        HashMap<Character, Integer> digitConverter=new HashMap<>();

        digitConverter.put('I', 1);
        digitConverter.put('V', 5);
        digitConverter.put('X', 10);
        digitConverter.put('L', 50);
        digitConverter.put('C', 100);
        digitConverter.put('D', 500);
        digitConverter.put('M', 1000);

        roman=roman.toUpperCase();

        ArrayList<Character> testCase=new ArrayList<>();
        testCase.add('I');
        testCase.add('V');
        testCase.add('X');
        testCase.add('L');
        testCase.add('C');
        testCase.add('D');
        testCase.add('M');

        //charAt() method used here
        for(int i=0; i<roman.length(); i++){
            if(testCase.contains(roman.charAt(i))==true){
                //System.out.println(testCase.indexOf(i));
                continue;
            }
            else{
                return -1;
            }
        }

        int result=0;
        //INVARIANTS
        //.charAt() method used here
        for(int i=0; i<roman.length(); i++){
            if(i>0 && digitConverter.get(roman.charAt(i))>digitConverter.get(roman.charAt(i-1)))
                result+=digitConverter.get(roman.charAt(i))-2*digitConverter.get(roman.charAt(i-1));
            else
                result+=digitConverter.get(roman.charAt(i));
        }
        return result;
    }
}

/**
 * Document this class
 * @version 10.13.2022
 * @author 25pandey
 */
public class Answer extends EnglishNumber{
    //PROJECT EXTRA
    private static void extra(int x){
        if(x>2022){
            int BC=x-2022;
            System.out.println("If you were "+x+" years old, your birth year would be "+BC+" BC!");
        }
        else{
            System.out.println("If you were "+x+" years old, your birth year would be "+(2022-x)+"!");
        }
    }

    /**
     * Main method for class RomanToDecimal
     * @param args
     * @return no variable type, method is void
     */
    public static void main(String[] args){
        EnglishNumber Answer=new EnglishNumber();
        Scanner s=new Scanner(System.in);
        System.out.print("Enter your Roman number: ");
        String input = s.nextLine();
        s.close();
        if(Answer.romanToDecimal(input)==-1){
            System.out.println("You have input an invalid input, your Roman number is not a valid Roman number.");
        }
        else{
            System.out.println(Answer.romanToDecimal(input));
        }
        extra(Answer.romanToDecimal(input));
    }
}
