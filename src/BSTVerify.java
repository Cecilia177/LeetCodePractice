public class BSTVerify {
/*错解：根节点左孩子<根节点<根节点右孩子 且 左右子树也为BST
* 正解：中序遍历为递增顺序*/

    private int temp;

    public boolean isValidBST(TreeNode root) {
        TreeNode t = root;
        if(root == null) {
            return true;
        } else {
           while (t.left != null) {
               t = t.left;
           }
           temp = t.val;

        }
        System.out.println("temp: " + temp);
        return inOrder(root);
    }
    private boolean inOrder(TreeNode t) {
        if(t != null) {
            if(inOrder(t.left)) {
                System.out.println("temp: " + temp);
                if(temp >= t.val) {
                    return false;
                } else {
                    temp = t.val;
                    return inOrder(t.right);
                }
            }

        }
        return true;
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
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(4);

        TreeNode t3 = new TreeNode(5);
        t3.left = t1; t3.right = t2;

        TreeNode t4 = new TreeNode(3);

        TreeNode t5 = new TreeNode(6);
        t2.left = t4; t2.right = t5;

        BSTVerify bstVerify = new BSTVerify();
        System.out.println(bstVerify.isValidBST(t5));
    }


}