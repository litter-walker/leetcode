package com.general.text0535;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表 + 自增id
 */
public class Codec {
    private Map<Integer, String> map = new HashMap<>();
    private int id = -1;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        id++;
        map.put(id, longUrl);
        return "http://tinyurl.com/" + id;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int idx = shortUrl.lastIndexOf("/");
        String idStr = shortUrl.substring(idx + 1);
        return map.get(Integer.valueOf(idStr));
    }
}
