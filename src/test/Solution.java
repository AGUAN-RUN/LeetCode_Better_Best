package test;


import java.util.*;

public  class Solution{
    public static int[] getOrder(int[][] tasks) {
        int[]res=new int[tasks.length];
        //保存所有信息
        Map<Integer,int[]> allMap=new HashMap<>();
        List<Integer>allMapIndex=new LinkedList<>();
        //可运行列表，保存下标和运行时间
        List<int[]>runList=new LinkedList<>();
        int time=0;
        //加载数据。
        for(int i=0;i<tasks.length;i++){
            allMap.put(i,tasks[i]);
            allMapIndex.add(i);
        }
        int index=0;
        //第一次加载最小时间
        while (allMap.size() != 0 || runList.size() != 0) {
            if(allMap.size() !=0) {
                for (int i = 0; i < allMapIndex.size(); i++) {
                    int[] temp = allMap.get(allMapIndex.get(i));
                    if (temp[0] <= time) {
                        allMap.remove(allMapIndex.get(i));
                        temp[0] = allMapIndex.get(i);
                        allMapIndex.remove(i);
                        i--;
                        if (runList.size() != 0) {
                            int len=runList.size();
                            for (int j = 0; j < len; j++) {
                                if (temp[1] < runList.get(j)[1]
                                        || (temp[1] == runList.get(j)[1] && temp[0] < runList.get(j)[0])) {
                                    runList.add(j, temp);
                                    break;
                                }
                                if(j == len-1){
                                    runList.add(temp);
                                }
                            }
                        } else {
                            runList.add(temp);
                        }

                    }
                }

            }
            if(runList.size() != 0) {
                res[index++] = runList.get(0)[0];
                time += runList.get(0)[1];
                runList.remove(0);
            }else {
                //没数据找最小
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < allMapIndex.size(); i++) {
                    if (allMap.get(allMapIndex.get(i))[0] < min) min = allMap.get(allMapIndex.get(i))[0];
                }
                time=min;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        //[[1,2],[2,4],[3,2],[4,1]]
        int[][] input={{1,2},{2,4},{3,2},{4,1}};
        int [] result = getOrder(input);
        System.out.println(result);

    }
}
