/* https://leetcode-cn.com/problems/binary-tree-tilt/ */
public class Solution {
    int answer = 0;
    public int findTilt(TreeNode root) {
        dfs(root);
        return answer;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);
        answer += Math.abs(left - right);

        return left + right + root.val;
    }
}


// Definition for a binary tree node.
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
