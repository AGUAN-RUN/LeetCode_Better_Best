package chapter1.section1_99;

import java.util.Arrays;
    //在二的基础上优化了空间，时间复杂度依然为  m*n
public class UniquePath3 {
    public int uniquePaths(int m, int n) {
        int[] cur =new int[n];
        Arrays.fill(cur,1);
        for(int i =1;i<m;i++){
            for(int j =1;j<n;j++){
                cur[j]+=cur[j-1];
            }
        }
        return cur[n-1];
    }
}
