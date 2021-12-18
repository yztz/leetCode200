/* https://leetcode-cn.com/problems/battleships-in-a-board/ */
public class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int answer = 0;
        for (int i = 0; i < m; i++) {
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    flag = false;
                    continue;
                }
                if (flag || i > 0 && board[i - 1][j] == 'X') continue;
                flag = true;
                answer++;
            }
        }
        return answer;
    }
}
