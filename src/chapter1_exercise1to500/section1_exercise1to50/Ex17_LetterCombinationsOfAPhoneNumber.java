package chapter1_exercise1to500.section1_exercise1to50;

import java.util.ArrayList;
import java.util.List;
/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。


* */
public class Ex17_LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String>result=new ArrayList<String>();
        //未判断输入是否合法
        if(digits==null||digits.equals(""))return result;
        char tm=digits.charAt(0);
        if(tm=='7'){
            result.add("p");
            result.add("q");
            result.add("r");
            result.add("s");
        }else if(tm=='8'){
            result.add("t");
            result.add("u");
            result.add("v");
        }else if(tm=='9'){
            result.add("w");
            result.add("x");
            result.add("y");
            result.add("z");
        }else{
            char a=(char)(tm*3-53);
            char b=(char)(a+1);
            char c=(char)(b+1);
            result.add(a+"");
            result.add(b+"");
            result.add(c+"");
        }
        for(int i=1;i<digits.length();i++){
            char tempchar=digits.charAt(i);
            char a;
            char b;
            char c;
            char d=0;
            if(tempchar=='7'){
                a='p';
                b='q';
                c='r';
                d='s';
            }else if(tempchar=='8'){
                a='t';
                b='u';
                c='v';
            }else if(tempchar=='9'){
                a='w';
                b='x';
                c='y';
                d='z';
            }else{
                a=(char)(tempchar*3-53);
                b=(char)(a+1);
                c=(char)(b+1);
            }
            List<String> tempList = result;
            result=new ArrayList<String>();
            for(int j=0;j<tempList.size();j++){
                String temStrg=tempList.get(j);
                result.add(temStrg+a);
                result.add(temStrg+b);
                result.add(temStrg+c);
                if(d!=0){
                    result.add(temStrg+d);
                }
            }
        }
        return result;
    }
}
