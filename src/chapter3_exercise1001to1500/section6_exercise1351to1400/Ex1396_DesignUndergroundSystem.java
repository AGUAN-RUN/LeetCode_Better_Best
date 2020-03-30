package chapter3_exercise1001to1500.section6_exercise1351to1400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* Implement the class UndergroundSystem that supports three methods:

1. checkIn(int id, string stationName, int t)

A customer with id card equal to id, gets in the station stationName at time t.
A customer can only be checked into one place at a time.
2. checkOut(int id, string stationName, int t)

A customer with id card equal to id, gets out from the station stationName at time t.
3. getAverageTime(string startStation, string endStation) 

Returns the average time to travel between the startStation and the endStation.
The average time is computed from all the previous traveling from startStation to endStation that happened directly.
Call to getAverageTime is always valid.
You can assume all calls to checkIn and checkOut methods are consistent. That is, if a customer gets in at time t1 at some station, then it gets out at time t2 with t2 > t1. All events happen in chronological order.

Constraints:

There will be at most 20000 operations.
1 <= id, t <= 10^6
All strings consist of uppercase, lowercase English letters and digits.
1 <= stationName.length <= 10
Answers within 10^-5 of the actual value will be accepted as correct.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/design-underground-system
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class Ex1396_DesignUndergroundSystem{
    private Map<Integer,String> checkInRecords=new HashMap<>();
    private Map<String, List<Integer>>averageTimeRecords=new HashMap<>();
    public Ex1396_DesignUndergroundSystem() {
    }
    public void checkIn(int id, String stationName, int t) {
        checkInRecords.put(id,stationName+","+t);
    }

    public void checkOut(int id, String stationName, int t) {
        String checkInRecord=checkInRecords.get(id);
        String[]temp=checkInRecord.split(",");
        int time=t-Integer.parseInt(temp[1]);
        String name=temp[0]+"-"+stationName;
        List<Integer>averageTimeRecord=averageTimeRecords.get(name);
        if(averageTimeRecord==null){
            averageTimeRecord=new ArrayList<>();
            averageTimeRecord.add(time);
            averageTimeRecords.put(name,averageTimeRecord);
        }else {
            averageTimeRecord.add(time);
        }
        checkInRecords.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String name=startStation+"-"+endStation;
        List<Integer>averageTimeRecord=averageTimeRecords.get(name);
        if(averageTimeRecord==null){
            return -1;
        }
        double sum=0;
        for(double a:averageTimeRecord){
            sum+=a;
        }
        return (sum/(double)averageTimeRecord.size());
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */