import java.util.Arrays;

/**
 * Created by Valued Customer on 8/20/2016.
 * 274. H-Index
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

 According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h
 citations each, and the other N − h papers have no more than h citations each."

 For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had
 received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the
 remaining two with no more than 3 citations each, his h-index is 3.

 Note: If there are several possible values for h, the maximum one is taken as the h-index.
 */
public class p274 {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        Arrays.sort(citations);
        for (int i = citations.length; i >= 0; i--) {
            if (i == citations.length ) {
                if(citations[0] >= citations.length) return citations.length;
            } else if (i == 0) {
                if (citations[citations.length-1] <= 0) return 0;
            }
            else {if (citations[citations.length - i] >= i && citations[citations.length - 1 - i] <= i) return i;}
        }
        return 0;
    }
}
