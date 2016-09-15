/**
 * Created by Valued Customer on 9/14/2016.
 * 374. Guess Number Higher or Lower
 * We are playing the Guess Game. The game is as follows:

 I pick a number from 1 to n. You have to guess which number I picked.

 Every time you guess wrong, I'll tell you whether the number is higher or lower.

 You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

 -1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
 Example:
 n = 10, I pick 6.

 Return 6.
 */
public class p374 {
    int k;
    public p374(int k) {this.k = k;}
    private int guess(int g){
        if (g < k) return 1;
        else if (g > k) return -1;
        else return 0;
    }

    public int guessNumber(int n) {
        int begin = 1;
        int end = n;

        while (begin < n) {
            int mid = begin / 2 + end / 2 + (begin % 2 + end % 2) / 2;
            int result = guess(mid);
            if (result == 1) {
                begin = mid + 1;
            } else if (result == -1) {
                end = mid - 1;
            } else return mid;
        }
        return end;
    }

}
