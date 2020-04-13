package chapter1_exercise1to500.section3_exercise101to150;
/*There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.

Note:
If there exists a solution, it is guaranteed to be unique.
Both input arrays are non-empty and have the same length.
Each element in the input arrays is a non-negative integer.
*/
public class Ex134_GasStation_2 {
    //第一次提交的简化
    //用时0ms   击败100%用户
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int index=0;
        int isResult=0;
        int sum=0;
        for(int i=0;i<gas.length;i++){
            isResult=isResult+gas[i]-cost[i];
            if(sum>0){
                //大于0，就继续叠加
                sum+=gas[i]-cost[i];
            }else{
                //小于0，重新指派起点
                sum=gas[i]-cost[i];
                index=i;
            }
        }
        //油量和耗油量差额之和大于等于0，则一定存在链条
        return isResult>=0?index:-1;
    }
    public static void main(String[] args) {
        int []a={1,2,3,4,5};
        int []b={3,4,5,1,2};
        Ex134_GasStation_2 test=new Ex134_GasStation_2();
        System.out.println(test.canCompleteCircuit(a,b));
    }
}
