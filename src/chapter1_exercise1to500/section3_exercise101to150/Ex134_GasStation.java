package chapter1_exercise1to500.section3_exercise101to150;
/*There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.

Note:
If there exists a solution, it is guaranteed to be unique.
Both input arrays are non-empty and have the same length.
Each element in the input arrays is a non-negative integer.
*/
public class Ex134_GasStation {
    //用时1ms  击败52.42的用户
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i=0;i<cost.length;i++){
             cost[i]=gas[i]-cost[i];
        }
        //循环数组，寻找可能的2起点
        int i=0,start=0,sum=0;
        boolean status=false;
        while(true){
            sum=sum+cost[i];
            if(sum<0){
                if(i==cost.length-1||status==true)return -1;
                i++;
                start=i;
                sum=0;
            }else {
                if(i==cost.length-1){
                    i=0;
                    status=true;
                }else {
                    i++;
                }
                if(i==start)return start;
            }
        }
    }

    public static void main(String[] args) {
        int []a={1,2,3,4,5};
        int []b={3,4,5,1,2};
        Ex134_GasStation test=new Ex134_GasStation();
        System.out.println(test.canCompleteCircuit(a,b));
    }
}
