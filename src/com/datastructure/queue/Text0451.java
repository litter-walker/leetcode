package com.datastructure.queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 优先队列
 */
public class Text0451 {

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        StringBuilder ansSb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> poll = pq.poll();
            for (int i = 0; i < poll.getValue(); i++) {
                ansSb.append(poll.getKey());
            }
        }
        return ansSb.toString();
    }

}
