package chapter1_exercise1to500.section5_exercese201to250;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
There are a total of n courses you have to take, labeled from 0 to n-1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
Example 1:

Input: 2, [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
             course 0. So the correct course order is [0,1] .
Example 2:
Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
* */
public class Ex210_CourseScheduleII {
    //拓扑排序题

    //用时5ms 击败94%的提交
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //储存所有顶点入度的数据
        int[]indegrees=new int[numCourses];
        //邻接列表
        List<Integer>[]neibor=new List[numCourses];
        //根据边缘列表 往入度数组和邻接列表中添加数据
        for(int i=0;i<prerequisites.length;i++){
            indegrees[prerequisites[i][0]]++;
            List<Integer>list = neibor[prerequisites[i][1]];
            if(list==null){
                list=new ArrayList<>();
                list.add(prerequisites[i][0]);
                neibor[prerequisites[i][1]]=list;
            }else {
                list.add(prerequisites[i][0]);
            }
        }
        LinkedList<Integer>temp=new LinkedList<>();
        for(int i=0;i<indegrees.length;i++){
            if(indegrees[i]==0)temp.add(i);
        }
        int i=0;
        int[]result = new int [numCourses];
        while(temp.size()>0){
            int value=temp.pop();
            result[i++]=value;
            List<Integer>list=neibor[value];
            if(list!=null){
                for(int a:list){
                    indegrees[a]--;
                    if(indegrees[a]==0)temp.add(a);
                }
            }
        }
        if(i==numCourses){
            return result;
        }
        return new int []{};

        /*List<List<Integer>>result=new ArrayList<>();
        findOrderWorker(result,new ArrayList<Integer>(),temp,indegrees,neibor);
        if(result.size()==0)return  new int[].........;
        return result;*/
    }
    //审题错误浪费表情
   /* public void findOrderWorker(List<List<Integer>>result,List<Integer>nums,LinkedList<Integer>temp,int []indegrees,List<Integer>[]neibor){
        if(temp.size()==0){
            if(nums.size()!=indegrees.length)return;
            result.add(new ArrayList<>(nums));
            return;
        }
        for(int i=0;i<temp.size();i++){
            int value=temp.remove(i);
            nums.add(value);
            List<Integer>list=neibor[value];
            if(list!=null){
                for(int a:list){
                    indegrees[a]--;
                    if(indegrees[a]==0){
                        temp.add(a);
                    }
                }
            }
            findOrderWorker(result,nums,temp,indegrees,neibor);
            nums.remove(nums.size());
            temp.add(i,value);
        }
    }*/


}
