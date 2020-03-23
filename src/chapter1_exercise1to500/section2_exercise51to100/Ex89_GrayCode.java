package chapter1_exercise1to500.section2_exercise51to100;

import java.util.ArrayList;
import java.util.List;

public class Ex89_GrayCode {
    //以下算法击败91%  --  --建议修改为用固定大小的静态数组实现，而不是使用java封装动态数组
    public List<Integer> grayCode(int n) {
        List<Integer>result=new ArrayList<>();
        if(n==0){
            result.add(0);
            return result;
        }
        int base=1;
        result.add(base-1);
        result.add(base);
        int lt=1;
        while(lt<n){
            base=(int)Math.pow(2,lt);
            int size=result.size();
            for(int i=size-1;i>=0;i--){
                result.add(base+result.get(i));
            }
            lt++;
        }
        return  result;
    }
}
