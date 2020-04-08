package chapter1_exercise1to500.section3_exercise101to150;

import java.util.List;

/*Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/
public class Ex120_Triangle {
    //自顶向下，逐层计算
    //运行7ms，击败18
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null||triangle.size()==0)return 0;
        if(triangle.size()==1)return triangle.get(0).get(0);
        int result=Integer.MAX_VALUE;
        for(int i=1;i<triangle.size();i++){
            List<Integer>temp=triangle.get(i-1);
            List<Integer>tempNext=triangle.get(i);
            for(int j=0;j<tempNext.size();j++){
                if(j==0){
                    tempNext.set(j,tempNext.get(0)+temp.get(0));
                }else if(j==tempNext.size()-1){
                    tempNext.set(j,tempNext.get(j)+temp.get(j-1));
                }else{
                    int min=temp.get(j-1)>temp.get(j)?temp.get(j):temp.get(j-1);
                    tempNext.set(j,tempNext.get(j)+min);
                }
                if(i==triangle.size()-1){
                    int value=tempNext.get(j);
                    result=value<result?value:result;
                }
            }
        }
        return result;
    }
}
