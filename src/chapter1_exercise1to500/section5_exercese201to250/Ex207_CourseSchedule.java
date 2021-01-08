package chapter1_exercise1to500.section5_exercese201to250;

import java.util.*;

/**
 There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 Example 1:

 Input: numCourses = 2, prerequisites = [[1,0]]
 Output: true
 Explanation: There are a total of 2 courses to take.
              To take course 1 you should have finished course 0. So it is possible.
 Example 2:

 Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 Output: false
 Explanation: There are a total of 2 courses to take.
              To take course 1 you should have finished course 0, and to take course 0 you should
              also have finished course 1. So it is impossible.
  

 Constraints:
 The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 You may assume that there are no duplicate edges in the input prerequisites.
 1 <= numCourses <= 10^5
* */
/*
你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。

在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]

给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？

 

示例 1:

输入: 2, [[1,0]]
输出: true
解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
示例 2:

输入: 2, [[1,0],[0,1]]
输出: false
解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 

提示：

输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
你可以假定输入的先决条件中没有重复的边。
1 <= numCourses <= 10^5


* */
    //tips ：
    // 欧拉通路：能不重复的通过所有边的通路     哈密尔顿通路 ：能不重复的通过所有顶点的通路
    //list of edges （边缘列表） 从第i个顶点可以到达第j个顶点且距离为1  则把  [i,j]加入list
    //adjacency matrices （邻接矩阵） 第i，j个元素为1  则表示第i个顶点和第j个顶点相连且距离为1
public class Ex207_CourseSchedule {
    //有向图  a能到达b则b不能到达a，否则返回false
    //基本思路是正确的，算法不是这么写的
   /* public boolean canFinish(int numCourses, int[][] prerequisites) {
         //使用hashTable和hashset
        Map<Integer, Set<Integer>>map=new HashMap<>();
        for(int i=0;i<prerequisites.length;i++){
            int a=prerequisites[i][0];
            int b=prerequisites[i][1];
            //判断是否有从b到a的路径的通路 不能存在环(长度为1，2，3......)
            Set<Integer>set1=map.get(b);
            //此处未完成
            while(set1!=null){
                if(set1.contains(a))return false;
            }
            //没有则把该通路保存到map中
            Set<Integer>set2=map.get(a);
            if(set2==null){
                set2=new HashSet<>();
                set2.add(b);
                map.put(a,set2);
            }else{
                set2.add(b);
            }

        }
        return  true;
    }*/
   /* 拓扑排序算法分析     无环有向图
    从DGA图中找到一个没有前驱的顶点输出。(可以遍历，也可以用优先队列维护)
    删除以这个点为起点的边。(它的指向的边删除，为了找到下个没有前驱的顶点)
    重复上述，直到最后一个顶点被输出。如果还有顶点未被输出，则说明有环！*/

    //用时5ms  击败88%的提交
    //int[][] prerequisites 是个边缘列表
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //入度数组
        int[]indegrees=new int [numCourses];
        //邻接列表
        List<Integer>[]neibor=new List[numCourses];
        //填充数据
        for(int i=0;i<prerequisites.length;i++){
            indegrees[prerequisites[i][0]]++;
            List<Integer> list=neibor[prerequisites[i][1]];
            if(list==null){
                list=new ArrayList<>();
                list.add(prerequisites[i][0]);
                neibor[prerequisites[i][1]]=list;
            }else {
                list.add(prerequisites[i][0]);
            }
        }
        LinkedList<Integer>temp=new LinkedList<>();
        //获取入度为0的数据放到列表中
        for(int i=0;i<indegrees.length;i++){
            if(indegrees[i]==0)temp.add(i);
        }
        //计算拓扑排序时出栈的元素数量
        int num=0;
        while (temp.size()>0){
            int a=temp.pop();
            num++;
            List<Integer>list=neibor[a];
            if(list!=null){
                for(int b:list){
                    indegrees[b]--;
                    if(indegrees[b]==0){
                        temp.add(b);
                    }
                }
            }
        }
        if(num!=numCourses)return false;
        return true;
    }
}
