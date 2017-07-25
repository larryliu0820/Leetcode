/**
 * Created by larryliu on 7/21/17.
 * 273. Integer to English Words
 */
public class p273 {
    public String numberToWords(int num) {
        String[] unit = new String[]{"", "Thousand", "Million", "Billion"};
        String[] tens = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] digits = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] teens = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; num > 0; num /= 1000, i++) {
            String temp = "";
            int belowThousand = num % 1000;
            int belowHundred = belowThousand;
            int belowTen;
            if (belowThousand >= 100) {
                temp += " " + digits[belowThousand/100] + " Hundred" ;
                belowHundred = belowThousand % 100;
            }
            if (belowHundred >= 10 && belowHundred < 20) {
                temp += " " + teens[belowHundred % 10];
            } else {
                if (belowHundred >= 20) temp += " " + tens[belowHundred / 10];
                belowTen = belowHundred % 10;
                if (belowTen > 0) temp += " " + digits[belowTen];
            }

            if (i > 0 && belowThousand > 0) temp += " " + unit[i];
            sb.insert(0, temp);
        }
        if (sb.length() == 0) return "Zero";
        if (sb.charAt(0) == ' ') sb.deleteCharAt(0);
        if (sb.charAt(sb.length()-1) == ' ') sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
