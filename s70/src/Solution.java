/* https://leetcode-cn.com/problems/even-odd-tree/ */
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static final TreeNode empty = new TreeNode(0);
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(empty);
        int level = 0;
        int pre = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == empty) {
                level++;
                pre = 0;
                if(!queue.isEmpty()) queue.offer(empty);
                continue;
            }

            if (level % 2 == 1) { // 奇数
                if (node.val % 2 == 1 || pre != 0 && node.val >= pre) return false;
            } else {
                if (node.val % 2 == 0 || pre != 0 && node.val <= pre) return false;
            }
            pre = node.val;
            if (null != node.left) queue.offer(node.left);
            if (null != node.right) queue.offer(node.right);
        }

        return true;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

