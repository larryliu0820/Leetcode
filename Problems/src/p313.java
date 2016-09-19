import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Valued Customer on 9/17/2016.
 * 313. Super Ugly Number
 * Write a program to find the nth super ugly number.

 Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
 For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

 Note:
 (1) 1 is a super ugly number for any given primes.
 (2) The given numbers in primes are in ascending order.
 (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 */
public class p313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int [] res = new int[n];
        res[0] = 1;
        int [] cur = new int[primes.length];

        for(int i = 1; i < n; i++){
            res[i] = Integer.MAX_VALUE;
            for(int j = 0; j < primes.length; j++){
                if (primes[j] * res[cur[j]] == res[i-1]) {
                    cur[j]++;
                }
                res[i] = Math.min(res[i], primes[j]*res[cur[j]]);
            }
        }
        return res[n-1];
    }

    public int nthMethod2(int n, int[] primes) {
        int[] result = new int[n];
        result[0] = 1;
        PriorityQueue<Num> pq = new PriorityQueue<>();
        for (int p : primes) {
            pq.offer(new Num(p, 1, p));
        }
        for (int i = 1; i < n; i++) {
            result[i] = pq.peek().val;
            while (result[i] == pq.peek().val) {
                Num next = pq.poll();
                pq.offer(new Num(next.val * result[next.ind], next.ind+1, next.prime));
            }
        }
        return result[n-1];
    }

    private class Num implements Comparable<Num> {
        int val;
        int ind;
        int prime;
        public int compareTo(Num n) {
            return val - n.val;
        }
        public Num(int val, int ind, int prime) {
            this.val = val;
            this.ind = ind;
            this.prime = prime;
        }
    }
}
