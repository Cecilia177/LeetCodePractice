public class BtreeReconstruction {
    /*根据前序遍历和中序遍历重建二叉树*/
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 0) {
            return null;
        }
        return reConstruct(pre, in, 0, pre.length - 1, 0, in.length - 1);

    }
    private TreeNode reConstruct(int[] pre, int[] in, int preL, int preR, int inL, int inR) {
        System.out.println("pre: " + preL + "~" + preR + " in: " + inL + "~" + inR);

        if(preL > preR) {

            return null;
        }
        TreeNode tn = new TreeNode(pre[preL]);
        int rootIndex = findRootIndex(in, inL, inR, pre[preL]);
        System.out.println("root: " + rootIndex);

        tn.left = reConstruct(pre, in, preL + 1, preL + rootIndex - inL, inL, rootIndex - 1);
        tn.right = reConstruct(pre, in, preL + rootIndex - inL + 1, preR, rootIndex + 1, inR);
        return tn;

    }
    private int findRootIndex(int[] in, int inL, int inR, int root) {
        for(int i = inL; i <= inR; i++) {
            if(in[i] == root) {
                return i;
            }
        }
        return -1;
    }
    public void preOrder(TreeNode t) {
        if(t == null) {
            return;
        }
        System.out.println(t.val);
        preOrder(t.left);
        preOrder(t.right);
    }
}

class BinaryReconstructionTest {
    public void test() {
        int[] pre = new int[]{1,2,4,3,5,6};
        int[] in = new int[]{4,2,1,5,3,6};
        TreeNode root = new BtreeReconstruction().reConstructBinaryTree(pre, in);
        new BtreeReconstruction().preOrder(root);
    }
}