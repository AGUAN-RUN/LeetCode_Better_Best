package chapter1_exercise1to500.section2_exercise51to100;

import java.util.ArrayList;
import java.util.List;

public class Ex56_MergeIntervals {
    //先把所有数据按照二维数组的第一位用从小到大快排排好，然后再遍历一趟解决，时间复杂度O(nlgn)
    //先试试插入排序，排序后处理，暴力一点
    //空间利用打败了88%，leetcode测试用例运行时间打败了9.8% -->该算法效率低下，
    // 有待改进-->如1:排序改为快排   2:不排序，直接遍历过程中处理
    public int[][] merge(int[][] intervals) {
        if(intervals==null||intervals.length<2)return intervals;
        for(int i=1;i<intervals.length;i++){
            for(int j=i;j>0;j--){
                if(intervals[j][0]<intervals[j-1][0]){
                    replaceNums(intervals,j,j-1);
                }else{
                    break;
                }
            }
        }
        //开始合并
        List<int[]> result=new ArrayList<int[]>();
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]==intervals[i-1][0]){
                if(intervals[i][1]<intervals[i-1][1]){
                    intervals[i][1]=intervals[i-1][1];
                }
            }else{
                if(intervals[i][0]<=intervals[i-1][1]){
                    intervals[i][0]=intervals[i-1][0];
                    if(intervals[i][1]<intervals[i-1][1])intervals[i][1]=intervals[i-1][1];
                }else{
                    result.add(intervals[i-1]);
                }
            }
        }
        result.add(intervals[intervals.length-1]);
        int[][]resultArr=new int[result.size()][2];
        for(int i=0;i<resultArr.length;i++){
            resultArr[i]=(int[])result.get(i);
        }
        return resultArr;
    }
    public void replaceNums(int[][]intervals,int i,int j){
        int[]num=intervals[j];
        intervals[j]=intervals[i];
        intervals[i]=num;
    }

    public static void main(String[] args) {
        int[][]nums={{1,3},{2,6},{8,10},{15,18}};
        new Ex56_MergeIntervals().merge(nums);
    }
}
