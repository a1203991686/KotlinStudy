package leetcode.difficult;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 297. 二叉树的序列化与反序列化
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */

class TreeNodeJava {
    int val;
    TreeNodeJava left;
    TreeNodeJava right;

    TreeNodeJava(int x) {
        val = x;
    }
}

class CodecJava {
    public String rserialize(TreeNodeJava root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += root.val + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

    public String serialize(TreeNodeJava root) {
        return rserialize(root, "");
    }

    public TreeNodeJava rdeserialize(List<String> l) {
        if (l.get(0).equals("None")) {
            l.remove(0);
            return null;
        }

        TreeNodeJava root = new TreeNodeJava(Integer.parseInt(l.get(0)));
        l.remove(0);
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);

        return root;
    }

    public TreeNodeJava deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<>(Arrays.asList(data_array));
        return rdeserialize(data_list);
    }
}
