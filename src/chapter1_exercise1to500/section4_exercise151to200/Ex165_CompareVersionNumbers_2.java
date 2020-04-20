package chapter1_exercise1to500.section4_exercise151to200;
/*Compare two version numbers version1 and version2.
If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
You may assume the default revision number for each level of a version number to be 0. For example, version number 3.4 has a revision number of 3 and 4 for its first and second level revision number. Its third and fourth level revision number are both 0.

Note:
Version strings are composed of numeric strings separated by dots . and this numeric strings may have leading zeroes.
Version strings do not start or end with dots, and they will not be two consecutive dots.*/

public class Ex165_CompareVersionNumbers_2 {
    //不用java的 String 封装的split方法 和Integer 把字符串解析成数字的方法

    //用时0ms  击败100的用户
    public int compareVersion(String version1, String version2) {
        char[]s1=version1.toCharArray();
        char[]s2=version2.toCharArray();
        int i=0;
        int j=0;
        while(i<s1.length||j<s2.length){
            int value1=0;
            while(i<s1.length&&s1[i]!='.'){
                value1=value1*10+s1[i]-'0';
            };
            int value2=0;
            while(i<s2.length&&s2[i]!='.'){
                value2=value2*10+s2[i]-'0';
            }
            if(value1>value2){
                return 1;
            }else if(value1<value2){
                return -1;
            }
            i++;
            j++;
        }
        return 0;
    }

}
