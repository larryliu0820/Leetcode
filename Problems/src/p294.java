/**
 * Created by Valued Customer on 8/29/2016.
 * 294. Flip Game II
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -,
 * you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a
 * move and therefore the other person will be the winner.

 Write a function to determine if the starting player can guarantee a win.

 For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".

 Follow up:
 Derive your algorithm's runtime complexity.
 */
public class p294 {
    public boolean canWin(String s) {
        boolean[] winable = new boolean[s.length()+1];
        winable[2] = true;
        winable[3] = true;
        if (s.length() <= 3) return winable[s.length()];
        for (int i = 4; i <= s.length(); i++) {
            for (int j = 0; j < s.length() / 2; j++) {
                // divide and conquer
                int leftLen = j;
                int rightLen = i - j - 1;
                if (!winable[leftLen] ^ winable[rightLen]) {
                    winable[i] = true;
                    break;
                }
            }
        }
        return winable[s.length()];
    }
}
