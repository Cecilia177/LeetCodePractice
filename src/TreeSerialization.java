import java.util.*;

public class TreeSerialization {
    String Serialize(TreeNode root) {
        if(root == null) {
            return "#,";
        } else {
            return root.val + "," + Serialize(root.left) + Serialize(root.right);
        }

    }

    TreeNode Deserialize(String str) {
        if(str.equals("#")) {
            return null;
        }
        String[] nodes = str.split(",");
        return deserial(nodes);

    }
    private int index = -1;
    TreeNode deserial(String[] nodes) {
        if(index >= nodes.length) {
            return null;
        }
        index++;
        if(!nodes[index].equals("#")) {

            TreeNode t = new TreeNode(Integer.valueOf(nodes[index]));
            t.left = deserial(nodes);
            t.right = deserial(nodes);
            return t;
        }

        return null;
    }

}

class TreeSerializationTest {
    public void test() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t3.left = t4; t1.left = t2; t1.right = t3;
        TreeSerialization treeSerialization = new TreeSerialization();
        String str = treeSerialization.Serialize(t1);
        System.out.println(str);
        TreeNode t = treeSerialization.Deserialize(str);
        System.out.println(treeSerialization.Serialize(t));
    }
}