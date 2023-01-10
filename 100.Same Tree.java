/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        /**
            Case 1: p == null && q == null => same
            Case 2: p != null && q == null => not same
            Case 3: p == null && q != null => not same
            Case 4: p != null && q != null
                if p.val == q.val:
                    recursively check issame of p.left & q.left
                                                p.right & q.right
                if p.val != q.val => not same
         */

         if (p == null && q == null) return true;
         if (p != null && q == null) return false;
         if (p == null && q != null) return false;
         
         if (p.val != q.val) return false;
         return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

         // TC: O(n) | SC: O(h)
    }
}
