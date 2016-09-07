
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Valued Customer on 9/6/2016.
 * 293. Flip Game
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters:
 * + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no
 * longer make a move and therefore the other person will be the winner.

 Write a function to compute all possible states of the string after one valid move.

 For example, given s = "++++", after one move, it may become one of the following states:

 [
 "--++",
 "+--+",
 "++--"
 ]
 If there is no valid move, return an empty list [].
 */
public class p293 {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new LinkedList<>();
        if (s == null || s.length() == 0) return result;
        for (int i = 0; i < s.length()-1; i++) {
            if (s.startsWith("++",i)) {
                result.add(s.substring(0,i) + "--" + s.substring(i+2));
            }
        }
        return result;
    }
}
