package chapter1_exercise1to500.section1_exercise1to50;

public class Ex28_ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if(haystack==null || needle==null)return -1;
        /*java String类 封装的indexOf()方法 ,返回调用方法的String1包含参数String2的起始索引,如果没有String1不包含String2，返回-1  */
        return haystack.indexOf(needle);
    }
}
