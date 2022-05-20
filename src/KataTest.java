import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class KataTest {

    public static void main(String[] args) throws Exception {
        int result = 0;
        String input = new BufferedReader(new InputStreamReader(System.in)).readLine();

        input = input.replaceAll(" ","");

        if (Character.isDigit(input.charAt(0))) {
            result = arabicNumbers(input);
            System.out.println(result);
        } else if ( input.charAt(0) == 'X' || input.charAt(0) == 'V' || input.charAt(0) == 'I' ) {
            romeNumbers(input);
        } else throw new Exception();
    }

    public static int arabicNumbers(String input) throws Exception {
        int a;
        int b;
        int result;
        char noun = 0;
        String[] numbers;

        if (input.replaceFirst("[+\\-/*]", "").matches(".*[^0-9].*")) {
            throw new Exception();
        }

        numbers = input.split("[+\\-/*]");
        if (numbers.length > 2 || Integer.parseInt(numbers[0]) > 10 || Integer.parseInt(numbers[1]) > 10) {
            throw new Exception();
        }

        if (numbers[0].length() == 2) { noun = input.charAt(2); }
        else { noun = input.charAt(1); }

        a = Integer.parseInt(numbers[0]);
        b = Integer.parseInt(numbers[1]);

        if (noun == '+') { result = a + b; }
        else if (noun == '-') { result = a - b; }
        else if (noun == '*') { result = a * b; }
        else if (noun == '/') { result = (a / b); }
        else throw new Exception();

        return result;
    }

    public static void romeNumbers(String input) throws Exception {
        int result;
        String romeDec = "";
        String romeEd = "";
        String romeResult = "";

        if (input.matches(".+[0-9]")) {
                throw new Exception();
        }
        input = input.replaceAll("VIII", "8");
        input = input.replaceAll("VII", "7");
        input = input.replaceAll("VI", "6");
        input = input.replaceAll("IV", "4");
        input = input.replaceAll("V", "5");
        input = input.replaceAll("IX", "9");
        input = input.replaceAll("X", "10");
        input = input.replaceAll("III", "3");
        input = input.replaceAll("II", "2");
        input = input.replaceAll("I", "1");

       result = arabicNumbers(input);

       if (result < 1) throw new Exception();

       if (result == 100) {
           romeResult = "C";
       }

       else  {
           int resultDec = result / 10;
           int resultEd = result % 10;

           if (resultDec == 9) { romeDec = "XC"; }
           if (resultDec == 8) { romeDec = "LXXX"; }
           if (resultDec == 7) { romeDec = "LXX"; }
           if (resultDec == 6) { romeDec = "LX"; }
           if (resultDec == 5) { romeDec = "L"; }
           if (resultDec == 4) { romeDec = "XL"; }
           if (resultDec == 3) { romeDec = "XXX"; }
           if (resultDec == 2) { romeDec = "XX"; }
           if (resultDec == 1) { romeDec = "X"; }

           if (resultEd == 9) { romeEd = "IX"; }
           if (resultEd == 8) { romeEd = "VIII"; }
           if (resultEd == 7) { romeEd = "VII"; }
           if (resultEd == 6) { romeEd = "VI"; }
           if (resultEd == 5) { romeEd = "V"; }
           if (resultEd == 4) { romeEd = "IV"; }
           if (resultEd == 3) { romeEd = "III"; }
           if (resultEd == 2) { romeEd = "II"; }
           if (resultEd == 1) { romeEd = "I"; }

           romeResult = romeDec.concat(romeEd);
       }

        System.out.println(romeResult);
    }
}
