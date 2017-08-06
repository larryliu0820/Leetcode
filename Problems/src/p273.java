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
        StringBuilder result = new StringBuilder();
        for (int i = 0; num > 0; num /= 1000, i++) {
            StringBuilder sb = new StringBuilder();
            int belowThousand = num % 1000;
            if (belowThousand >= 100)
                sb.append(" ").append(digits[belowThousand/100]).append(" Hundred");

            int belowHundred = belowThousand % 100;
            if (belowHundred > 10 && belowHundred < 20) {
                sb.append(" ").append(teens[belowHundred%10]);
            } else {
                if (belowHundred >= 20)
                    sb.append(" ").append(tens[belowHundred/10]);
                if (belowHundred % 10 >= 0)
                    sb.append(" ").append(digits[belowHundred % 10]);
            }



            if (belowThousand > 0 && i > 0)
                sb.append(" ").append(unit[i]);

            result.insert(0, sb.toString());
        }
        if (result.length() == 0)
            result.append("Zero");
        else if (result.charAt(0) == ' ')
            result.deleteCharAt(0);
        return result.toString();
    }
}
