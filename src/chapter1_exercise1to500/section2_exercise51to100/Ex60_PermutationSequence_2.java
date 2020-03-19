package chapter1_exercise1to500.section2_exercise51to100;

public class Ex60_PermutationSequence_2 {
    //开始优化(偷别人的思路))
    //思路：n个数有n!个排列,如果(m-1)!<k<m!且k/(m-1)!为y,则说明排列的情况中第1个数到第n-m个数的位置没有变动,接下来一个数为剩下的数中的第y+1个
    public String getPermutation(int n, int k) {
        //布尔数组用来标识某个数是否已经被选择（被拼接）
        boolean [] ifNotExsit=new boolean[n];
        int[]nums=new int[n];
        nums[n-1]=1;
        //1-(n-1)个数的排列数，逆序保存在nums中
        for(int i=2;i<n;i++){
            nums[n-i]=nums[n-i+1]*i;
        }
        k--;
        StringBuilder res=new StringBuilder();
        for(int i=1;i<n;i++){
            int j=k/nums[i];
            int  m=-1;
            while(j>=0){
                m++;
                if(!ifNotExsit[m]){
                    j--;
                }
            }
            res.append(m+1);
            ifNotExsit[m]=true;
            k=k%nums[i];
        }
        //加上最后一个数
        for(int i=0;i<n;i++){
            if(!ifNotExsit[i]){
                res.append(i+1);
            }
        }
        return res.toString();
    }
}
