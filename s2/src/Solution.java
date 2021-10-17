/* https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/ */
public class Solution {


    static class TreeNode {
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

    public int kthSmallest(TreeNode root, int k) {
        this.cur = 0;
        this.target = k;
        find(root);
        return answer;
    }

    int answer;
    int cur;
    int target;

    public void find(TreeNode root) {
        if (root == null || cur == target) return;

        find(root.left);
        cur++;
        if (cur == target) answer = root.val;
        find(root.right);
    }
}
