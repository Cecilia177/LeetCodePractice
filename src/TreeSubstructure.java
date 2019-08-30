public class TreeSubstructure {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null) {
            return false;
        }
        return treeEqual(root1, root2) || treeEqual(root1.left, root2)
                || treeEqual(root1.right, root2);
    }
    private boolean treeEqual(TreeNode root1, TreeNode root2) {
        if(root2 == null) {
            return true;
        }
        if(root1 == null) {
            return false;
        }

        return root1.val == root2.val && treeEqual(root1.left, root2.left)
                && treeEqual(root1.right, root2.right);
    }
}
