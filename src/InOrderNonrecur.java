import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderNonrecur {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode p = root;
        while(p != null) {
            stack.push(p);
            p = p.left;
        }
        while(!stack.isEmpty()) {
            TreeNode top = stack.pop();

            list.add(top.val);
            p = top.right;

            while(p != null) {
                stack.push(p);
                p = p.left;
            }

        }
        return list;
    }
}

class InOrderNonrecurTest {
    public void test() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t3.left = t4; t1.left = t2; t1.right = t3;
        System.out.println(new InOrderNonrecur().inorderTraversal(t1));
    }
}
