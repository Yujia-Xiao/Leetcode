/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder strb = new StringBuilder();
        dfsSer(strb,root);
        return strb.toString();
    }
    
    public void dfsSer(StringBuilder strb, TreeNode root){
        if(root == null){
            strb.append("#,"); return;
        }
        strb.append(Integer.toString(root.val)+",");
        dfsSer(strb, root.left);
        dfsSer(strb, root.right);
        return;
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] arr = data.split(",");
        Queue<String> queue = new LinkedList<String>();
        for(int i=0; i< arr.length; i++) queue.offer(arr[i]);
        return dfsDes(queue);
    }
    
    public TreeNode dfsDes(Queue<String> queue){
        if(queue.isEmpty())return null;
        String str = queue.poll();
        if(str.equals("#")) return null;
        //System.out.println(str);
        TreeNode root = new TreeNode(Integer.parseInt(str));
        root.left = dfsDes(queue);
        root.right = dfsDes(queue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));