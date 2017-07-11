import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Valued Customer on 7/5/2017.
 *
 * 535. Encode and Decode TinyURL
 *
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it
 * returns a short URL such as http://tinyurl.com/4e9iAk.

 Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm
 should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 */
public class p535 {
    Map<String, String> long2Short;
    Map<String, String> short2Long;
    String alphanumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public p535() {
        long2Short = new HashMap<>();
        short2Long = new HashMap<>();
    }
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (!long2Short.containsKey(longUrl)) {
            Random random = new Random();
            String output = "";
            for (int i = 0; i < 6; i++) {
                int rand = random.nextInt(alphanumeric.length()-1);
                output += alphanumeric.substring(rand, rand+1);
            }
            long2Short.put(longUrl, "http://tinyurl.com/" + output);
            short2Long.put(output, longUrl);
        }
        return long2Short.get(longUrl);

    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return short2Long.get(shortUrl.substring(shortUrl.length()-6));
    }
}
