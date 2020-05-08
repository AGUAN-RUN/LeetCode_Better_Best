package chapter1_exercise1to500.section6_exercese251to300;
/*
You are a product manager and currently leading a team to develop a new product.
Unfortunately, the latest version of your product fails the quality check.
Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example:

Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version. 
* */

///* The isBadVersion API is defined in the parent class VersionControl.
//      boolean isBadVersion(int version); */
public class Ex278_FirstBadVersion_2 {
    //二分法优化  写出更加简洁而又优雅的二分代码  好好学习以后二分都这样写，简明扼要

    //依然40ms  击败5%
    public int firstBadVersion(int n) {
        int st=1;
        int end=n;

        while(st<end){
            //寻找中点，对于偶数位 取靠左边的中点  这种写法和上一种相比较 索引不会由于加法产生溢出
            int mid=st+(end-st)/2;
            if(isBadVersion(mid)&&!isBadVersion(mid-1)){
                return mid;
            }else if(isBadVersion(mid)&&isBadVersion(mid-1)){
                end=mid;
            }else {
                //子循环  确保循环会终止
                st=mid+1;
            }
        }
        return st;
    }
    //这个没有
    public boolean isBadVersion(int n){
        if(n<100)return true;
        return false;
    }
}
