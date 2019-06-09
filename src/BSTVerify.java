public class BSTVerify {


        public boolean isValidBST(TreeNode root) {
            if(root == null) {
                return true;
            }
            if(root.left == null && root.right == null) {
                return true;
            }
            if(root.left != null && root.right != null) {
                if(root.val > root.left.val && root.val < root.right.val) {
                    return isValidBST(root.left) && isValidBST(root.right);
                }
            }
            if(root.left != null && root.right == null) {
                return root.val > root.left.val && isValidBST(root.left);
            }
            if(root.right != null && root.left == null) {
                return root.val < root.right.val && isValidBST(root.right);
            }
            return false;
        }

}



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        this.val = x;
    }
}

class BSTVerifyTest {

    public void test() {
        TreeNode t1 = new TreeNode(6);
        TreeNode t2 = new TreeNode(20);

        TreeNode t3 = new TreeNode(15);
        t3.left = t1; t3.right = t2;

        TreeNode t4 = new TreeNode(5);

        TreeNode t5 = new TreeNode(10);
        t5.left = t4; t5.right = t3;

        BSTVerify bstVerify = new BSTVerify();
        System.out.println(bstVerify.isValidBST(t5));
    }


}