import java.util.HashMap;

/**
 * Created by Valued Customer on 7/27/2016.
 * 12. Integer to Roman
 * Given an integer, convert it to a roman numeral.

 Input is guaranteed to be within the range from 1 to 3999.
 */
public class p012 {
    public String intToRoman(int num) {
        String result = "";
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"I");
        map.put(5,"V");
        map.put(10,"X");
        map.put(50,"L");
        map.put(100,"C");
        map.put(500,"D");
        map.put(1000,"M");

        // Deal with 1000 first
        int numThousand = num / 1000;
        for (int i = 0; i < numThousand; i++) result += "M";
        int residual = num % 1000;

        int[] digits = new int[]{100,10,1};
        for (int d: digits) {
            int numDigit = residual / d;
            residual -= numDigit * d;
            if (numDigit == 9) {
                result += map.get(d) + map.get(10 * d);
            } else if (numDigit < 9 && numDigit >= 5) {
                result += map.get(5 * d);
                for (int i = 0; i < numDigit - 5; i++) result += map.get(d);
            } else if (numDigit == 4) {
                result += map.get(d) + map.get(5 * d);
            } else {
                for (int i = 0; i < numDigit; i++) result += map.get(d);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        p012 sol = new p012();
        String result = sol.intToRoman(3999);
        System.out.println(result);
    }
}
