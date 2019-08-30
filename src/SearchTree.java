import java.util.ArrayList;
import java.util.Arrays;

public class SearchTree {
    ArrayList<ArrayList<Integer>> results = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        //sortTree(root);
        if(root == null) {
            return results;
        }
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(root.val);
        addList(root, target, new ArrayList<>());
        return results;
    }

    private void addList(TreeNode root, int target, ArrayList<Integer> subList) {
        System.out.println("target: " + target + " currentList: " + subList);
        if(root == null) {
            return;
        }
        subList.add(root.val);
        if(target - root.val < 0) {
            //
            return;
        }
        if(target - root.val == 0) {
            results.add(new ArrayList<>(subList));
            System.out.println("found one ... " + subList);
            return;
        }


        addList(root.left, target - root.val, subList);

        addList(root.right, target - root.val, subList);

        subList.remove(subList.size() - 1);

    }
    private void sortTree(TreeNode root){
        if(root == null) {
            return;
        }
        if(root.left != null && root.right != null && root.left.val > root.right.val) {
            int temp = root.left.val;
            root.left.val = root.right.val;
            root.right.val = temp;
        }
        sortTree(root.left);
        sortTree(root.right);
    }
}

class SearchTreeTest {
    public void test() {
        TreeNode root = new TreeNode(10);
        TreeNode tr1 = new TreeNode(5); TreeNode tr2 = new TreeNode(12);
        TreeNode tr3 = new TreeNode(4); TreeNode tr4 = new TreeNode(7);
        tr1.left = tr3; tr1.right = tr4;
        root.left = tr1; root.right = tr2;
        for(ArrayList<Integer> result : new SearchTree().FindPath(root, 22)) {
            System.out.println(result);
        }
    }
}