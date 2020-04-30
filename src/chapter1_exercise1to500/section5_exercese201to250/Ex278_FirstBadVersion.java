package chapter1_exercise1to500.section5_exercese201to250;
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
public class Ex278_FirstBadVersion{
    //二分法  用时39.5ms  击败5%
    public int firstBadVersion(int n) {
        if(n==1)return 1;
        //isBadVersion这里暂用下面定义的isBadVersion方法定义
        if(isBadVersion(1))return 1;
        if(isBadVersion(n)&&!isBadVersion(n-1))return n;
        //为了防止溢出采用了 long类型
        long st=1;
        long end=(long)n;
        while(st+1<end){
            long mid=(st+end)/2;
            if(isBadVersion((int)mid)&&!isBadVersion((int)mid-1)){
                return (int)mid;
            }else if(isBadVersion((int)mid)&&isBadVersion((int)mid-1)){
                end=mid;
            }else {
                st=mid;
            }
        }
        return -1;
    }
    //这个没有
    public boolean isBadVersion(int n){
        if(n<100)return true;
        return false;
    }
}
