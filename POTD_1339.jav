class POTD_1339 {
    long maxProduct = 0;
    long MOD = 1_000_000_007;
    long totalSum = 0;

    public int maxProduct(TreeNode root) {
        totalSum = getTotalSum(root);   // 1st DFS
        dfs(root);                      // 2nd DFS
        return (int)(maxProduct % MOD);
    }

    // Computes subtree sums and updates max product
    private long dfs(TreeNode root) {
        if (root == null) return 0;

        long leftSum = dfs(root.left);
        long rightSum = dfs(root.right);

        long subTreeSum = root.val + leftSum + rightSum;

        long product = subTreeSum * (totalSum - subTreeSum);
        maxProduct = Math.max(maxProduct, product);

        return subTreeSum;
    }

    // Computes total sum of the tree
    private long getTotalSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + getTotalSum(root.left) + getTotalSum(root.right);
    }
}
