package com.datastructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 双向链表-哈希表
 */
public class Text0432 {

}

class AllOne {

    // 链表头节点
    private final Node head;
    // 记录数量
    private final Map<String, Node> map;

    public AllOne() {
        head = new Node(-1, null);
        head.next = head;
        head.pre = head;
        map = new HashMap<>();
    }

    public void inc(String key) {
        if (!map.containsKey(key)) {
            Node newNode = new Node(1, key);
            Node insert = head.insert(newNode);
            map.put(key, insert);
        } else {
            Node node = map.get(key);
            Node newNode = new Node(node.count + 1, key);
            Node insert = node.insert(newNode);
            map.put(key, insert);
            node.delete(key);
        }
    }

    public void dec(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            Node newNode = new Node(node.count - 1, key);
            if (newNode.count != 0) {
                if (node.pre.count == node.count - 1) {
                    map.put(key, node.pre.pre.insert(newNode));
                } else {
                    map.put(key, node.pre.insert(newNode));
                }
            } else {
                map.remove(key);
            }
            node.delete(key);
        }
    }

    public String getMaxKey() {
        if (head.pre.keys == null) {
            return "";
        }
        return head.pre.keys.iterator().next();
    }

    public String getMinKey() {
        if (head.next.keys == null) {
            return "";
        }
        return head.next.keys.iterator().next();
    }
}

class Node {
    int count;
    Set<String> keys;
    Node next, pre;


    public Node(int count, String key) {
        this.count = count;
        if (key != null && !key.equals("")) {
            this.keys = new HashSet<>();
            this.keys.add(key);
        }
    }

    /**
     * this 节点后面插入一个节点
     * @param node 插入的节点
     * @return 返回插入位置对应的节点
     */
    public Node insert(Node node) {
        if (this.next.count == node.count) {
            this.next.keys.addAll(node.keys);
            return this.next;
        } else {
            node.next = this.next;
            this.next = node;
            node.pre = this;
            node.next.pre = node;
            return node;
        }
    }

    /**
     * Key, 删除后如果不存在元素，就将节点删除掉
     * @param key 元素
     */
    public void delete(String key) {
        if (!this.keys.contains(key)) {
            return;
        }
        this.keys.remove(key);
        if (this.keys.size() == 0) {
            this.pre.next = this.next;
            this.next.pre = this.pre;
        }
    }
}