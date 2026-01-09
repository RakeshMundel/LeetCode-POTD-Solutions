import java.util.HashMap;
import java.util.Map;

class POTD_865
 {
    Map<Integer, Integer> mp = new HashMap<>();
    int maxD = 0;

    public class TreeNode {
 int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        depth(root, 0);
        return LCA(root);
    }

    public TreeNode LCA(TreeNode root) {
        if (root == null || mp.get(root.val) == maxD) {
            return root;
        }
        TreeNode left = LCA(root.left);
        TreeNode right = LCA(root.right);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    public void depth(TreeNode root, int d) {
        if (root == null) {
            return;
        }
        maxD = Math.max(maxD, d);
        mp.put(root.val, d);
        depth(root.left, d + 1);
        depth(root.right, d + 1);
    }

}