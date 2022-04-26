package Design.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Shuhua Song
 */
public class _535_EncodeAndDecodeTinyURL {

    // Encodes a URL to a shortened URL.
    static final Map<String, String> shortToLongMap = new HashMap<>();
    static final Map<String, String> longToShortMap = new HashMap<>();
    static final String baseHost = "http://tinyurl.com/";
    // the length of the code is fixed to 6 only
    static final int k = 6;
    Random random = new Random();
    public String encode(String longUrl) {
        if(longToShortMap.containsKey(longUrl)){
            return longToShortMap.get(longUrl);
        }
        String shortUrl = getRandomShortUrl();
        longToShortMap.put(longUrl, shortUrl);
        shortToLongMap.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortToLongMap.get(shortUrl);
    }

    private String getRandomShortUrl(){
        final String base62 = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<k; i++){
            int randIdx = random.nextInt(62);
            sb.append(base62.charAt(randIdx));
        }
        String shortUrl = baseHost + sb.toString();
        return shortUrl;
    }

    /*
     // Encodes a URL to a shortened URL.
    Map<Long, String> map;
    Random random = new Random();

    public String encode(String longUrl) {
        map = new HashMap<>();
        long key = random.nextLong(Long.MAX_VALUE);
        while(map.containsKey(key)){
            key = random.nextLong(Long.MAX_VALUE);
        }
        map.put(key, longUrl);
        String shortUrl = "https://songsite.com/"+key;
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int last = shortUrl.lastIndexOf('/');
        String code = shortUrl.substring(last+1);
        long key = Long.parseLong(code);
        return map.get(key);
    }
     */
}

/*
Solution-1: counter
Problems
1) The number of URLs that can be encoded is limited by the range of int

Solution-2: Assign A randon base-62 id of K digits

*/

