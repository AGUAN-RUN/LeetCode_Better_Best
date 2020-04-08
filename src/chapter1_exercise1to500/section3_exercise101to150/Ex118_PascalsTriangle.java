package chapter1_exercise1to500.section3_exercise101to150;

import java.util.ArrayList;
import java.util.List;

/*Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.
*/
public class Ex118_PascalsTriangle {
    //击败88%
    //由于杨辉三角的对称性，代码可以从这方面优化
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>result=new ArrayList<>();
        if(numRows<1)return result;
        List<Integer>temp=new ArrayList<>();
        temp.add(1);
        result.add(temp);
        generateWorker(result,temp,numRows-1);
        return result;
    }
    public void generateWorker(List<List<Integer>>result,List<Integer>temp,int numRows){
        if(numRows==0)return;
        List<Integer>next=new ArrayList<>();
        next.add(temp.get(0));
        for(int i=0;i<temp.size()-1;i++){
            next.add(temp.get(i)+temp.get(i+1));
        }
        next.add(temp.get(0));
        result.add(next);
        generateWorker(result,next,numRows-1);
    }
}
