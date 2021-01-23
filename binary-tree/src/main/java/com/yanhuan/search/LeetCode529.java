package com.yanhuan.search;

/**
 * 扫雷游戏
 *
 * @author YanHuan
 * @date 2021-01-24 0:49
 */
public class LeetCode529 {

    //定义8个方向
    int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};

    /**
     * 解法1. 深度优先
     * 时间复杂度：O(mn)
     * 空间复杂度：O(mn)
     *
     * @param board 二维数组
     * @param click 点
     * @return 点击结果
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            //1. 找到雷
            board[x][y] = 'X';
        } else {
            //没找到雷 dfs处理当前节点
            dfs(board, x, y);
        }
        return board;
    }

    private void dfs(char[][] board, int x, int y) {
        //地雷数量
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            //判断周围元素的值
            int tx = x + dx[i];
            int ty = y+ dy[i];
            if (tx < 0 || ty < 0 || tx >= board.length || ty >= board[0].length) {
                //越界 忽略
                continue;
            }
            if (board[tx][ty] == 'M') {
                cnt++;
            }
        }
        if (cnt > 0) {
            //2.周围存在雷
            board[x][y] = (char) (cnt + '0');
        } else {
            //3.周围没有雷  当前节点标记为B  处理周围节点
            board[x][y] = 'B';
            for (int i = 0; i < 8; i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];
                //保证周围不越界且没有被扫过
                if (tx < 0 || ty < 0 || tx >= board.length || ty >= board[0].length || board[tx][ty] != 'E') {
                    continue;
                }
                //不是雷，递归处理周围的节点，逻辑相同
                dfs(board, tx, ty);
            }
        }
    }
}
