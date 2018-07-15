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
class Solution \{\
    public TreeNode deleteNode(TreeNode root, int key) \{\
        //binary search in BST, Iterative\
        //BST: left <= root < right\
        \
        //Find key TreeNode\
        if(root == null)return null;\
        TreeNode cul = root;\
        TreeNode dummy = new TreeNode(0);//dummy\
        dummy.left=root;\
        TreeNode par = dummy;\
        boolean left = true;\
       \
        while(cul!=null)\{\
            if(cul.val == key)break;\
            if(cul.val<key)\{par=cul; cul=cul.right;left = false;\}\
            else if(cul.val>key)\{par=cul; cul=cul.left; left = true;\}\
        \}\
        if(cul==null)return dummy.left; // key not found;\
        //Delete Node\
        // only right child\
        if(cul.left==null)\{\
            if(left)\{\
                par.left=cul.right;\
                System.out.println('O');\
            \}\
            else par.right=cul.right;\
            return dummy.left;\
        \}\
        //only left child\
        if(cul.right==null)\{\
            if(left)par.left=cul.left;\
            else par.right=cul.left;\
            return dummy.left;\
        \}\
        \
        //both\
        TreeNode leftTree = cul.left;\
        TreeNode rightTree = cul.right;\
        if(left)par.left=leftTree;\
        else par.right=leftTree;\
        \
        while(leftTree!=null)\{\
            if(rightTree.val<= leftTree.val)\{\
                if(leftTree.left==null)\{\
                    leftTree.left = rightTree;\
                    return dummy.left;\
                \}\
                leftTree=leftTree.left;\
            \}\
            else\{\
                if(leftTree.right==null)\{\
                    leftTree.right=rightTree;\
                    return dummy.left;\
                \}\
                leftTree=leftTree.right;\
            \}\
        \}\
        return dummy.left;\
        \
    \}\
\}}