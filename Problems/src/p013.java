/**
 * Created by Valued Customer on 7/27/2017.
 * 13. Roman to Integer
 */
public class p013 {
    public int romanToInt(String s) {
        String units = "IVXLCDM";

        int result = 0;
        for  (int index = 0;index < s.length();index++) {
            char curr = s.charAt(index);

            int i = units.indexOf(curr);
            if (i == 6) {
                result += 1000;
            } else if (i % 2 == 1) {
                result += 5 * Math.pow(10, i >> 1);

            } else {
                if (index < s.length() - 1 &&
                        (s.charAt(index+1) == units.charAt(i+1) || s.charAt(index+1) == units.charAt(i+2))) {
                    result -= Math.pow(10, i >> 1);
                } else {
                    result += Math.pow(10, i >> 1);
                }


            }
        }
        return result;
    }
}
