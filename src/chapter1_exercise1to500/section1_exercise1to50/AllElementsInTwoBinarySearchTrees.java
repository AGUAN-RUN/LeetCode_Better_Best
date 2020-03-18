package chapter1_exercise1to500.section1_exercise1to50;

import java.util.ArrayList;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees {
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
