{\rtf1\ansi\ansicpg1252\cocoartf1561\cocoasubrtf400
{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\f0\fs24 \cf0 /**\
 * Definition for a binary tree node.\
 * public class TreeNode \{\
 *     int val;\
 *     TreeNode left;\
 *     TreeNode right;\
 *     TreeNode(int x) \{ val = x; \}\
 * \}\
 */\
public class Codec \{\
\
    // Encodes a tree to a single string.\
    public String serialize(TreeNode root) \{\
        if(root==null)return "#";\
        Queue<TreeNode> A = new LinkedList<TreeNode>();\
        Queue<TreeNode> B = new LinkedList<TreeNode>();\
        StringBuilder strb = new StringBuilder();\
        boolean ifA = true;\
        A.offer(root);\
        \
        while(!A.isEmpty() || !B.isEmpty())\{\
            if(ifA)\{\
                while(!A.isEmpty())\{\
                    TreeNode cul = A.poll();\
                    if(cul!=null)strb.append(cul.val+",");\
                    else strb.append("#,");\
                    if(cul!=null)\{B.offer(cul.left);B.offer(cul.right);\}\
                \}\
                ifA = false;\
            \}\
            else\{\
                while(!B.isEmpty())\{\
                    TreeNode cul = B.poll();\
                    if(cul!=null)strb.append(cul.val+",");\
                    else strb.append("#,");\
                    if(cul!=null)\{A.offer(cul.left);A.offer(cul.right);\}\
                \}\
                ifA = true;\
            \}\
        \}\
        System.out.println(strb.toString());\
        return strb.toString();\
    \}\
\
    // Decodes your encoded data to tree.\
    public TreeNode deserialize(String data) \{\
        if(data==null || data.length()==0)return null;\
        String[] arr = data.split(",");\
        int len = arr.length;\
        int culIndex = 0;\
        \
        Queue<TreeNode> A = new LinkedList<TreeNode>();\
        Queue<TreeNode> B = new LinkedList<TreeNode>();\
        StringBuilder strb = new StringBuilder();\
        boolean ifA = true;\
        if(arr[culIndex].equals("#"))return null;\
        TreeNode root = new TreeNode(Integer.parseInt(arr[culIndex])); \
        A.offer(root);\
        culIndex++;\
        \
        while(!A.isEmpty() || !B.isEmpty())\{\
            if(ifA)\{\
                while(!A.isEmpty())\{\
                    TreeNode cul = A.poll();\
                    if(arr[culIndex].equals("#"))\{\
                        cul.left=null;\
                    \}else\{\
                        cul.left = new TreeNode(Integer.parseInt(arr[culIndex]));    \
                        B.offer(cul.left);\
                    \}\
                    culIndex++;\
                    \
                    if(arr[culIndex].equals("#"))\{\
                        cul.right=null;\
                    \}else\{\
                        cul.right = new TreeNode(Integer.parseInt(arr[culIndex]));    \
                        B.offer(cul.right);\
                    \}\
                    culIndex++;\
                \}\
                ifA = false;\
            \}\
            else\{\
               while(!B.isEmpty())\{\
                    TreeNode cul = B.poll();\
                    if(arr[culIndex].equals("#"))\{\
                        cul.left=null;\
                    \}else\{\
                        cul.left = new TreeNode(Integer.parseInt(arr[culIndex]));    \
                        A.offer(cul.left);\
                    \}\
                    culIndex++;\
                   \
                   if(arr[culIndex].equals("#"))\{\
                        cul.right=null;\
                    \}else\{\
                        cul.right = new TreeNode(Integer.parseInt(arr[culIndex]));    \
                        A.offer(cul.right);\
                    \}\
                    culIndex++;\
                \}\
                ifA = true;\
            \}\
        \}\
        return root;\
    \}\
\}\
\
// Your Codec object will be instantiated and called as such:\
// Codec codec = new Codec();\
// codec.deserialize(codec.serialize(root));\
\
//7/14/2018\
/**\
 * Definition for a binary tree node.\
 * public class TreeNode \{\
 *     int val;\
 *     TreeNode left;\
 *     TreeNode right;\
 *     TreeNode(int x) \{ val = x; \}\
 * \}\
 */\
public class Codec \{\
\
    // Encodes a tree to a single string.\
    public String serialize(TreeNode root) \{\
        StringBuilder strb = new StringBuilder();\
        serializeDFS(root, strb);\
        return strb.toString();\
    \}\
    \
    public void serializeDFS(TreeNode root, StringBuilder strb)\{\
        if(root==null)\{strb.append("#,");return;\};\
        strb.append(root.val+",");\
        serializeDFS(root.left, strb);\
        serializeDFS(root.right,strb);\
        return;\
    \}\
\
    // Decodes your encoded data to tree.\
    public TreeNode deserialize(String data) \{\
        if(data==null || data.length()==0)return null;\
        String[] arr = data.split(",");\
        Queue<String> q = new LinkedList<String>();\
        for(int i=0;i<arr.length;i++)q.offer(arr[i]);\
        return deserializeDFS(q);\
    \}\
    \
    public TreeNode deserializeDFS(Queue<String> q)\{\
        if(q.size()==0)return null;\
        String cul = q.poll();\
        if(cul.equals("#"))return null;\
        TreeNode node = new TreeNode(Integer.parseInt(cul));\
        node.left=deserializeDFS(q);\
        node.right=deserializeDFS(q);\
        return node;\
    \}\
\}\
\
// Your Codec object will be instantiated and called as such:\
// Codec codec = new Codec();\
// codec.deserialize(codec.serialize(root));}