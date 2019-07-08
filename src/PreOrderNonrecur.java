import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderNonrecur {
    /*二叉树先序遍历的非递归方法：
    *   1. 根节点进栈
    *   2. 从栈中出栈一个节点并访问；若该节点有右孩子；则右孩子进栈，若该节点有左孩子，则左孩子进栈
    *   3. 重复2直至栈空*/
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> order = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) {
            return order;
        }
        stack.push(root);
        TreeNode visitNode;
        while(!stack.isEmpty()) {
            visitNode = stack.pop();
            order.add(visitNode.val);

            if(visitNode.right != null) {
                stack.push(visitNode.right);
            }
            if(visitNode.left != null) {
                stack.push(visitNode.left);
            }
        }
        return order;

    }
}

class PreOrderNonrecurTest {

    public void test() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);

        TreeNode t3 = new TreeNode(3);
        t2.left = t3;
        t1.right = t2;

        PreOrderNonrecur preOrderNonrecur = new PreOrderNonrecur();
        System.out.println(preOrderNonrecur.preorderTraversal(t1));
    }


}