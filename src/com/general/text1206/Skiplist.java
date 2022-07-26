package com.general.text1206;

/**
 * 参考链接：
 *   <a href="https://leetcode.cn/problems/design-skiplist/solution/javashou-xie-shi-xian-tiao-biao-by-feng-omdm0/">
 *   Java手写实现跳表
 *   </a>
 */
public class Skiplist {
    /**
     * 最大层数
     */
    private static final int MAX_LEVEL = 32;
    /**
     * 随机层数因子
     */
    private static final double P_FACTOR = 0.25;

    /**
     * 当前层数
     */
    private int curLevel;

    /**
     * 头指针
     */
    Node head;

    /**
     * 初始化
     */
    public Skiplist() {
        curLevel = 1;
        head = new Node(Integer.MIN_VALUE, MAX_LEVEL);
    }

    /**
     * 查询 target 是否存在
     * @param target 查询的数据
     * @return 查询结果
     */
    public boolean search(int target) {
        Node curNode = head;
        // 遍历层数
        for (int i = curLevel - 1; i >= 0; i--) {
            curNode = findClosest(curNode, i, target);
            if (curNode.next[i] != null && curNode.next[i].val == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * 添加 num
     * @param num 添加的数据
     */
    public void add(int num) {
        int high = randomLevel();
        Node newNode = new Node(num, high);
        Node curNode = head;
        // 遍历层数
        for (int i = curLevel - 1; i >= 0; i--) {
            curNode = findClosest(curNode, i, num);
            if (i < high) {
                if (curNode.next[i] != null) {
                    newNode.next[i] = curNode.next[i];
                }
                curNode.next[i] = newNode;
            }
        }

        if (high > curLevel) {
            for (int i = curLevel; i < high; i++) {
                head.next[i] = newNode;
            }
            curLevel = high;
        }
    }

    /**
     * 删除 num
     * @param num 删除的数据
     * @return 删除结果
     */
    public boolean erase(int num) {
        boolean ans = false;
        Node curNode = head;
        // 遍历层数
        for (int i = curLevel - 1; i >= 0; i--) {
            curNode = findClosest(curNode, i, num);
            if (curNode.next[i] != null && curNode.next[i].val == num) {
                curNode.next[i] = curNode.next[i].next[i];
                ans = true;
            }
        }
        return ans;
    }

    /**
     * 查找指定节点(node) level 层中，后面不大于 value 的最大节点
     * @param node 查询的起始节点
     * @param level 查询的层数
     * @param value 查询的值
     * @return 查询节点
     */
    private Node findClosest(Node node, int level, int value) {
        while (node.next[level] != null && node.next[level].val < value) {
            node = node.next[level];
        }
        return node;
    }

    /**
     * 随机生成 level
     * @return 随机层数
     */
    private int randomLevel() {
        int level = 1;
        while (Math.random() < P_FACTOR && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }
}