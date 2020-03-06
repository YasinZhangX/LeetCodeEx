package offersword;

import common.TreeNode;

/**
 * 序列化二叉树
 * @author Yasin Zhang
 */
public class SerializeAndDeserializeTree {

    String Serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        return serializeInline(root, str).toString();
    }

    private StringBuilder serializeInline(TreeNode curNode, StringBuilder str) {
        if (curNode == null) {
            return str.append("#!");
        }

        str.append(curNode.val).append("!");
        serializeInline(curNode.left, str);
        serializeInline(curNode.right, str);

        return str;
    }

    TreeNode Deserialize(String str) {
        if (str == null || str.trim().equals("")) {
            return null;
        }

        String[] strArray = str.split("!");
        return deserializeInline(strArray);
    }

    int index = -1;
    private TreeNode deserializeInline(String[] strArray){
        index++;
        if (index < strArray.length && !strArray[index].equals("#")) {
            TreeNode cur = new TreeNode(Integer.parseInt(strArray[index]));
            cur.left = deserializeInline(strArray);
            cur.right = deserializeInline(strArray);
            return cur;
        }
        return null;
    }
}
