package chapter1_exercise1to500.section3_exercise101to150;

import java.util.List;

/*Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/
public class Ex120_Triangle_2 {
    //自底部向上加，简洁效率很多
    //6ms,  击败22%  。。。。。。。  革命尚未成功
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null||triangle.size()==0)return 0;
        for(int i=triangle.size()-2;i>=0;i--){
            List<Integer>temp=triangle.get(i);
            List<Integer>tempNext=triangle.get(i+1);
            for(int j=0;j<temp.size();j++){
                int min=tempNext.get(j)>tempNext.get(j+1)?tempNext.get(j+1):tempNext.get(j);
                temp.set(j,temp.get(j)+min);
                }
            }
        return triangle.get(0).get(0);
    }
}
