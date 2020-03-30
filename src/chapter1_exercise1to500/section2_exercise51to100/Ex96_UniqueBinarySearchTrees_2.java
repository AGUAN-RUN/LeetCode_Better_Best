package chapter1_exercise1to500.section2_exercise51to100;

import java.util.HashMap;
import java.util.Map;

/*Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
*/
public class Ex96_UniqueBinarySearchTrees_2 {
    //将把已计算的n,numTrees(int n)保存在map中，如果map中能直接取到对于输入n，函数的值，将直接在map中取值。避免冗余的计算，大大提升效率
    /*执行用时 :
            0 ms
, 在所有 Java 提交中击败了
100.00%
    的用户*/
    public int numTrees(int n) {
        Map<Integer,Integer>temp=new HashMap<>();
        return  numTreesWork(n,temp);
    }
    public int numTreesWork(int n, Map<Integer,Integer> temp){
        if(n==0||n==1)return 1;
        int result=0;
        for (int i = 1; i <= n; i++) {
            int key1 = i - 1;
            int key2 = n - i;
            Integer value1 = temp.get(key1);
            if (value1 == null) {
                value1 = numTreesWork(key1, temp);
                temp.put(key1, value1);
            }
            Integer value2 = temp.get(key2);
            if (value2 == null) {
                value2 = numTreesWork(key2, temp);
                temp.put(key2, value2);
            }
            result +=value1 * value2;
        }
        return result;
    }
}
