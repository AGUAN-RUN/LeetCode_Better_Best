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
//用时2ms 击败42.12%的用户
public class Ex165_CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[]a1=version1.split("\\.");
        String[]a2=version2.split("\\.");
        int length=a1.length>a2.length?a1.length:a2.length;
        for(int i=0;i<length;i++){
            if(i<a1.length&&i<a2.length){
                int a=Integer.parseInt(a1[i]);
                int b=Integer.parseInt(a2[i]);
                if(a>b)return 1;
                if(a<b)return -1;
            }else if(i<a1.length){
                if(Integer.parseInt(a1[i])!=0)return 1;
            }else {
                if(Integer.parseInt(a2[i])!=0)return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        //"0.1"
        //"1.1"
        Ex165_CompareVersionNumbers test=new Ex165_CompareVersionNumbers();
        test.compareVersion("0.1","1.1");
    }

}
