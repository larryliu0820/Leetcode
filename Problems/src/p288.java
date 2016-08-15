import java.util.*;

/**
 * Created by Valued Customer on 8/13/2016.
 * 288. Unique Word Abbreviation
 * An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

 a) it                      --> it    (no abbreviation)

      1
 b) d|o|g                   --> d1g

               1    1  1
      1---5----0----5--8
 c) i|nternationalizatio|n  --> i18n

               1
      1---5----0
 d) l|ocalizatio|n          --> l10n
 Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary.
 A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

 Example:
 Given dictionary = [ "deer", "door", "cake", "card" ]

 isUnique("dear") -> false
 isUnique("cart") -> true
 isUnique("cane") -> false
 isUnique("make") -> true
 */
public class p288 {
    private Map<String, Set<String>> dict;
    public p288(String[] dictionary) {
        dict = new HashMap<>();
        for (String word: dictionary) {
            String key;
            if (word.length() <= 2) {
                key = word;
            } else {
                key = word.substring(0, 1) + (word.length() - 2) + word.substring(word.length() - 1);
            }
            Set<String> words;
            if (dict.containsKey(key))
                words = dict.get(key);
            else
                words = new HashSet<>();
            if(!words.contains(word))
                words.add(word);
            dict.put(key, words);
        }
    }

    public boolean isUnique(String word) {
        if(word.length() <= 2) {
            return true;
        }
        String key = word.substring(0, 1) + (word.length() - 2) + word.substring(word.length() - 1);
        if (dict.containsKey(key)) return (dict.get(key).size() == 1) && (dict.get(key).contains(word));
        else return true;
    }

    public static void main(String[] args) {
        p288 sol = new p288(new String[]{"dog"});
        System.out.println(sol.isUnique("dig"));
    }
}
