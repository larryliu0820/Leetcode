/**
 * Created by Valued Customer on 8/3/2016.
 * 69. Sqrt(x)
 * Implement int sqrt(int x).

 Compute and return the square root of x.
 * */
public class p069 {
    public int mySqrt(int x) {
        double eps = 0.0001;
        if (x < 2) return x;
//        float guess = x/2 < overflowLimit? x/2:overflowLimit;
        double guess = x/2;
        double lastGuess = 0;
        while ( Math.abs(guess - lastGuess) > eps) {
            //System.out.println("guess = " + guess);
            lastGuess = guess;
            guess = (lastGuess + x / lastGuess) / 2;
        }
        return (int)guess;
    }

    public static void main(String[] args) {
        p069 sol = new p069();
        System.out.println(sol.mySqrt(2147395599));
    }
}
