/**
 * Created by Larry Liu on 11/4/2017.
 * 541. Reverse String II
 */
public class p541 {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i+= 2*k) {
            int end = i + k > s.length() ? s.length()-1:i+k-1;
            reverse(arr, i, end);
        }
        return String.valueOf(arr);
    }

    private void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
