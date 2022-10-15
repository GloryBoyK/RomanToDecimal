import java.util.HashMap;

/**
 * class EnglishNumber
 * @version 10.13.2022
 * @author 25pandey
 */
class EnglishNumber{
	/**
	 * Take in a string and use each character as a key and find its value, then add for the Answer
	 * @param s
	 * @return variable type int
	 */
	public int romanToDecimal(String s){
		HashMap<Character, Integer> digitConverter=new HashMap<>();

		digitConverter.put('I', 1);
		digitConverter.put('V', 5);
		digitConverter.put('X', 10);
		digitConverter.put('L', 50);
		digitConverter.put('C', 100);
		digitConverter.put('D', 500);
		digitConverter.put('M', 1000);

		s=s.toUpperCase();

		int result=0;
		//INVARIANTS
		for(int i=0; i<s.length(); i++){
			if(i>0 && digitConverter.get(s.charAt(i))>digitConverter.get(s.charAt(i-1)))
				result+=digitConverter.get(s.charAt(i))-2*digitConverter.get(s.charAt(i-1));
			else 
				result+=digitConverter.get(s.charAt(i));
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

	/**
	 * Main method for class Answer
	 * @param args
	 * @return no variable type, method is void
	 */
	public static void main(String[] args){
		EnglishNumber Answer=new EnglishNumber();
		System.out.println(Answer.romanToDecimal("mcxlii"));
	}
}