import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BSTgeneration {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) {
            return new LinkedList<>();
        }
        return  getTrees(1, n);
    }

    private List<TreeNode> getTrees(int start, int end) {
        List<TreeNode> tt = new LinkedList<>();
        if(start > end) {
            tt.add(null);

        }
        for(int i = start; i <= end; i ++) {

            List<TreeNode> leftTrees = getTrees(start, i - 1);
            List<TreeNode> rightTrees = getTrees(i + 1, end);
            for(TreeNode left : leftTrees) {
                for(TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    tt.add(root);
                }
            }


        }
        return tt;
    }
}
