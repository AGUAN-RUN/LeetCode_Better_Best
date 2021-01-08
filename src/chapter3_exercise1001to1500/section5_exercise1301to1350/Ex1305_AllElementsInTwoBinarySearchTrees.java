package chapter3_exercise1001to1500.section5_exercise1301to1350;

import java.util.ArrayList;
import java.util.List;
/*
Given two binary search trees root1 and root2.

Return a list containing all the integers from both trees sorted in ascending order.

 

Example 1:


Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]
Example 2:

Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
Output: [-10,0,0,1,2,5,7,10]
Example 3:

Input: root1 = [], root2 = [5,1,7,0,2]
Output: [0,1,2,5,7]
Example 4:

Input: root1 = [0,-10,10], root2 = []
Output: [-10,0,10]
Example 5:


Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]
 

Constraints:

Each tree has at most 5000 nodes.
Each node's value is between [-10^5, 10^5].


* */

/*
给你 root1 和 root2 这两棵二叉搜索树。

请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.

 

示例 1：



输入：root1 = [2,1,4], root2 = [1,0,3]
输出：[0,1,1,2,3,4]
示例 2：

输入：root1 = [0,-10,10], root2 = [5,1,7,0,2]
输出：[-10,0,0,1,2,5,7,10]
示例 3：

输入：root1 = [], root2 = [5,1,7,0,2]
输出：[0,1,2,5,7]
示例 4：

输入：root1 = [0,-10,10], root2 = []
输出：[-10,0,10]
示例 5：



输入：root1 = [1,null,8], root2 = [8,1]
输出：[1,1,8,8]
 

提示：

每棵树最多有 5000 个节点。
每个节点的值在 [-10^5, 10^5] 之间。


* */
public class Ex1305_AllElementsInTwoBinarySearchTrees {
    class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> rootList1=new ArrayList<Integer>();
        List<Integer> rootList2=new ArrayList<Integer>();
        getMidList(root1,rootList1);
        getMidList(root2,rootList2);
        int length1=0;
        int length2=0;
        if(rootList1!=null)length1=rootList1.size();
        if(rootList2!=null)length2=rootList2.size();
        if(length1==0&&length2==0){
            return null;
        }else if(length1==0){
            return rootList2;
        }else if(length2==0){
            return rootList1;
        }else{
            int j=0;
            int k=0;
            List<Integer> result=new ArrayList<Integer>();
            while(j<length1||k<length2){
                if(j<length1&&k<length2) {
                    if(rootList1.get(j)>rootList2.get(k)){
                        result.add(rootList2.get(k));
                        k++;
                    }else{
                        result.add(rootList1.get(j));
                        j++;
                    }
                }else if(j<length1){
                    result.add(rootList1.get(j));
                    j++;
                }else if(k<length2){
                    result.add(rootList2.get(k));
                    k++;
                }
            }
            return result;
        }
    }
    public void getMidList(TreeNode node,List<Integer> list){
        if(node==null){
            return;
        }
        getMidList(node.left,list);
        list.add(node.val);
        getMidList(node.right,list);
    }
}
