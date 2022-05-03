package com.general.text0427;

/**
 * 递归
 */
public class Text0427 {

    public Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length, grid.length);
    }

    // (x1, y1),(x2,y2)表示左上角和右下角的点(左闭右开，上闭下开；即(x2,y2)不是区间内)
    private Node construct(int[][] grid, int x1, int y1, int x2, int y2) {
        boolean isLeaf = true;
        int flag = grid[x1][y1];
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                if (grid[i][j] != flag) {
                    isLeaf = false;
                    break;
                }
            }
        }
        if (isLeaf) {
            return new Node(flag == 1, true);
        }
        int midX = x1 + (x2 - x1) / 2;
        int midY = y1 + (y2 - y1) / 2;
        Node topLeft = construct(grid, x1, y1, midX, midY);
        Node topRight = construct(grid, x1, midY, midX, y2);
        Node bottomLeft = construct(grid, midX, y1, x2, midY);
        Node bottomRight = construct(grid, midX, midY, x2, y2);
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }

}