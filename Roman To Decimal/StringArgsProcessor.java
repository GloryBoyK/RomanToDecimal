public class StringArgsProcessor{
    public static int romanToDecimal(String roman){
        //parse roman letter by letter
        //find raw point value based on the letter
        //sum point values
        //return values of roman
        //return decimal value of roman
        //"XI" ==> 11
        //"IV" ==> 6
        int sum=0;
        for(int i=0; i<roman.length(); i++){
            char temp= roman.charAt(i);
            if(temp=='i'){
                sum++;
            }
            else if(temp=='V'){
                sum+=5;
            }
            else if(temp=='X'){
                sum+=10;
            }
            else if(temp=='C'){
                sum+=100;
            }
            else if(temp=='M'){
                sum+=1000;
            }
            else{
                throw new IllegalArgumentException("This is not a valid Roman Numeral");
            }
        }
        return sum;
    }
}