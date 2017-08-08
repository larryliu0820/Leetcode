/**
 * Created by Valued Customer on 7/27/2017.
 * 13. Roman to Integer
 */
public class p013 {
    public int romanToInt(String s) {
        String units = "IVXLCDM";

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = units.indexOf(s.charAt(i));
            if ( index % 2 == 0) {
                int value = (int) Math.pow(10, index/2);
                if (i < s.length()-1 &&
                        units.indexOf(s.charAt(i+1)) - index <= 2 &&
                        units.indexOf(s.charAt(i+1)) - index > 0) {
                    value *= -1;
                }
                result += value;
            } else {
                int value = (int) (5 * Math.pow(10, (index-1)/2));
                result += value;
            }
        }
        return result;
    }
}
