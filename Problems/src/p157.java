/**
 * Created by Valued Customer on 8/11/2016.
 * 157. Read N Characters Given Read4
 * The API: int read4(char *buf) reads 4 characters at a time from a file.

 The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

 By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

 Note:
 The read function will only be called once for each test case.
 */
public class p157 {

    public int read4(char[] buf) { return 4;}
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int total = 0;
        while (total < n) {
            char[] out = new char[4];
            int num = read4(out);
            int min = num < (n - total) ? num : (n - total);
            for (int i = 0; i < min; i++) buf[total+i] = out[i];
            total += min;
            if (min < 4) return total;
        }
        return total;
    }
}