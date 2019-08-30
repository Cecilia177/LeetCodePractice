import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderNonrecur {
    public List<Integer> postorderTraversal(TreeNode root) {
        /*二叉树的后序遍历非递归方法：修改先序遍历中左右孩子进栈的次序，访问次序倒置几位后序遍历次序*/
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        stack1.push(root);
        TreeNode t;
        while (!stack1.isEmpty()) {
            t = stack1.pop();
            stack2.push(t.val);

            if(t.left != null) {
                stack1.push(t.left);
            }
            if(t.right != null) {
                stack1.push(t.right);
            }
        }
        while (!stack2.isEmpty()) {
            list.add(stack2.pop());
        }
        return list;
    }

//    public List<Integer> postOrderTraversal2(TreeNode root) {
//        /**/
//    }
}

class PostOrderNonrecurTest {

    public void test() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);

        TreeNode t3 = new TreeNode(3);
        t2.left = t3;
        t1.right = t2;

        PostOrderNonrecur postOrderNonrecur = new PostOrderNonrecur();
        System.out.println(postOrderNonrecur.postorderTraversal(t1));
    }


}