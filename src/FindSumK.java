import java.util.ArrayList;
import java.util.Arrays;

public class FindSumK {
    private ArrayList<ArrayList<Integer>> results;
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        results = new ArrayList<>();
        addList(root, target, new ArrayList<>());
        return results;
    }

    private void addList(TreeNode root, int target, ArrayList<Integer> subList) {
        if(target == 0 && root == null) {
            results.add(new ArrayList<>(subList));
            return;
        }
        if(root != null && target > 0) {
            subList.add(root.val);
            addList(root.left, target - root.val, subList);
            if(root.left != null) {
                addList(root.right, target - root.val, subList);
            }
            subList.remove(subList.size() - 1);

        }
    }
}

class FindSumKTest {
    public void test() {
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(12);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(7);
        t2.left = t4; t2.right = t5;
        t1.right = t3; t1.left = t2;

        ArrayList<ArrayList<Integer>> results = new FindSumK().FindPath(t1, 22);
        for(ArrayList<Integer> result : results) {
            System.out.println(result);
        }
    }
}