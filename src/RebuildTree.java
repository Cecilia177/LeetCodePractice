public class RebuildTree {
    /*根据层次遍历顺序重构二叉树*/
    public TreeNode rebuild(String[] nodes) {
        if(nodes.length <= 1) {
            return null;
        }
        return getSubTree(nodes, 0);
    }

    public TreeNode getSubTree(String[] nodes, int index) {
        if(index > nodes.length || nodes[index].equals("#")) {
            return null;
        }
        TreeNode t = new TreeNode(Integer.valueOf(nodes[index]));
        t.left = getSubTree(nodes, index * 2);
        t.right = getSubTree(nodes, index * 2 + 1);
        return t;
    }
}

class RebuildTreeTest {
    public void test() {
        String[] nodes = new String[]{"1", "2", "3", "#", "#", "4"};
    }
}