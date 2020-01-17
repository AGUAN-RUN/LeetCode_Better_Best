package chapter1.section1;

public class MergeIntervals2 {
    //遍历过过程中实现范围合并，把一个被合并置空，另一个更新为合并后的范围
    public int[][] merge(int[][] intervals) {
        if(intervals==null||intervals.length<2)return intervals;
        int len=intervals.length;
        //开始遍历合并
        for(int i=0;i<intervals.length;i++){
            for(int j=i+1;j<intervals.length;j++){
                int totallh=intervals[i][1]-intervals[i][0]+intervals[j][1]-intervals[j][0];
                int left=Math.min(intervals[i][0],intervals[j][0]);
                int right=Math.max(intervals[i][1],intervals[j][1]);
                //如果两个范围的距离之和大于等于两个范围的最最大值和最小值，可得出两个范围可以合并
                if(totallh>=right-left){
                    intervals[i]=null;
                    intervals[j][0]=left;
                    intervals[j][1]=right;
                    len--;
                    break;
                }
            }
        }
        if(len==intervals.length)return intervals;
        int[][]result=new int[len][2];
        int st=0;
        for(int i=0;i<intervals.length;i++){
            if(intervals[i]!=null)result[st++]=intervals[i];
        }
        return result;
    }
}
