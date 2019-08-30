import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int currentLevel = 1, nextLevel = 0;
        TreeNode t = root;
        queue.add(t);
        List<Integer> subList = new ArrayList<>();
        while(!queue.isEmpty()) {
            if(currentLevel == 0) {
                result.add(subList);
                subList = new ArrayList<>();
                currentLevel = nextLevel;
                nextLevel = 0;
            }
            t = queue.poll();
            currentLevel--;

            subList.add(t.val);
            if(t.left != null) {
                queue.add(t.left);
                nextLevel++;
            }
            if(t.right != null) {
                queue.add(t.right);
                nextLevel++;
            }
        }
        if(subList.size() > 0) {
            result.add(subList);
        }
        return result;
    }
}
