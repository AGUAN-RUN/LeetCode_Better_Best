package chapter1_exercise1to500.section3_exercise101to150;

import commons.Node;

import java.sql.SQLOutput;

/*Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 
Follow up:

You may only use constant extra space.
Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.

Constraints:

The number of nodes in the given tree is less than 6000.
-100 <= node.val <= 100
*/

/*
给定一个二叉树

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有 next 指针都被设置为 NULL。

 

进阶：

你只能使用常量级额外空间。
使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 

示例：



输入：root = [1,2,3,4,5,null,7]
输出：[1,#,2,3,#,4,5,7,#]
解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 

提示：

树中的节点数小于 6000
-100 <= node.val <= 100
 

* */
public class Ex117_PopulatingNextRightPointersInEachNodeII {
    //普通二叉树的处理
    public Node connect(Node root) {
        if(root==null||(root.left==null&&root.right==null))return root;
        //左右子树不为空
        if(root.left!=null&&root.right!=null){
            root.left.next=root.right;
            //连接左右子树
            Node tpl=null;
            Node tpr=null;
            if(root.left.right!=null){
                tpl=root.left.right;
            }else{
                tpl=root.left.left;
            }
            if(root.right.left!=null){
                tpr=root.right.left;
            }else {
                tpr=root.right.right;
            }
            int deep=1;
            while(tpl!=null&&tpr!=null){
                tpl.next=tpr;
                //右空左找，左空右找
                tpl=tpl.right==null?tpl.left:tpl.right;
                tpr=tpr.left==null?tpr.right:tpr.left;
                deep++;
            }
            //继续用方法找有没有下层连接，有则连接
            if(deep>1) {
                tpl = searchDeepNode(root.left, deep, "left");
                tpr = searchDeepNode(root.right, deep, "right");
                while (tpl != null && tpr != null) {
                    tpl.next = tpr;
                    deep++;
                    tpl = searchDeepNode(root.left, deep, "left");
                    tpr = searchDeepNode(root.right, deep, "right");
                }
            }
            connect(root.left);
            connect(root.right);
        }else if(root.left==null){
            connect(root.right);
        }else {
            connect(root.left);
        }
        //打印测试
        printTreeNext(root);
        System.out.println("++++++++++++++++++++++++++");
        return root;
    }
    //增加一个寻找左子树不同层数最右节点和右子树不同层数最左节点的方法
    public Node searchDeepNode(Node root,int deep,String status){
        if (deep == 0) return root;
        if (root == null) return null;
        if(status=="left") {
            Node right=searchDeepNode(root.right,deep-1,"left");
            if(right!=null)return right;
            Node left=searchDeepNode(root.left,deep-1,"left");
            if(left!=null)return left;
        }else {
            //右子树的遍历status为right。标志位错误使得产生了错误的左右连接
            Node left=searchDeepNode(root.left,deep-1,"right");
            if(left!=null)return left;
            Node right=searchDeepNode(root.right,deep-1,"right");
            if(right!=null)return right;
        }
        return null;
    }
    public void printTreeNext(Node node){
        if(node!=null) {
            if(node.left!=null) System.out.println("left"+node.left.val);
            if(node.right!= null) System.out.println("right"+node.right.val);
            if(node.next!=null){
                System.out.println("next"+node.val+"-"+node.next.val);
                //查找连接的连接
                if(node.next.next!=null) {
                    System.out.println("next.next"+node.next.val+"-"+node.next.next.val);
                }else {
                    System.out.println("next.next"+node.next.val+"-"+"null");
                }

            }

            if(node.next==null) System.out.println("next"+node.val+"-"+"null");
            printTreeNext(node.left);
            printTreeNext(node.right);
        }
    }
    //测试bug
    public static void main(String[] args) {
        Node node=new Node(2);
         node.left=new Node(1);
         node.right=new Node(3);
         node.left.left=new Node(0);
         node.left.right=new Node(7);
         node.left.left.left=new Node(2);
         node.left.right.left=new Node(1);
         node.left.right.right=new Node(0);
         node.right.left=new Node(9);
         node.right.right=new Node(1);
         node.right.right.left=new Node(8);
         node.right.right.right=new Node(8);
         Ex117_PopulatingNextRightPointersInEachNodeII test=new Ex117_PopulatingNextRightPointersInEachNodeII();
         test.connect(node);
    }
}






















