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
/*
现在你总共有 n 门课需要选，记为 0 到 n-1。

在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]

给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。

可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。

示例 1:

输入: 2, [[1,0]]
输出: [0,1]
解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
示例 2:

输入: 4, [[1,0],[2,0],[3,1],[3,2]]
输出: [0,1,2,3] or [0,2,1,3]
解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
     因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
说明:

输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
你可以假定输入的先决条件中没有重复的边。
提示:

这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
拓扑排序也可以通过 BFS 完成。


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
