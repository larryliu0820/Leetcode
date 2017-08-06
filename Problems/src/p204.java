/**
 * Created by Valued Customer on 7/28/2017.
 * 204. Count Primes
 */
public class p204 {
    public int countPrimes(int n) {
        if (n <= 3) return n-1;
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) isPrime[n] = true;
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i*i; j < n; j += i) isPrime[j] = false;
        }
        int count = 0;
        for (int i = 2; i < n; i++) if (isPrime[i]) count++;
        return count;
    }
}
