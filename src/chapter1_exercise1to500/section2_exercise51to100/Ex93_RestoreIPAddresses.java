package chapter1_exercise1to500.section2_exercise51to100;

import java.util.ArrayList;
import java.util.List;
/*
给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。

 

示例 1：

输入：s = "25525511135"
输出：["255.255.11.135","255.255.111.35"]
示例 2：

输入：s = "0000"
输出：["0.0.0.0"]
示例 3：

输入：s = "1111"
输出：["1.1.1.1"]
示例 4：

输入：s = "010010"
输出：["0.10.0.10","0.100.1.0"]
示例 5：

输入：s = "101023"
输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 

提示：

0 <= s.length <= 3000
s 仅由数字组成


* */
public class Ex93_RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        //暴力且无脑
        //打败了7.38的用户   该算法有待优化
        List<String>result=new ArrayList<>();
        if(s==null||s.length()<4||s.length()>12)return result;
        char[]strs=s.toCharArray();
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        for(int i=0;i<3;i++){
            if(i==2&&(strs[0]>'2'||(strs[0]=='2'&&strs[1]>'5')||(strs[0]=='2'&&strs[1]=='5'&&strs[2]>'5')))continue;
            sb1=sb1.append(strs[i]+"");
            sb2=new StringBuilder();
            for(int j=i+1;j<i+4&&j<strs.length-2;j++){
                if(j==i+3&&(strs[i+1]>'2'||(strs[i+1]=='2'&&strs[i+2]>'5')||(strs[i+1]=='2'&&strs[i+2]=='5'&&strs[i+3]>'5')))continue;
                sb2=sb2.append(strs[j]+"");
                sb3=new StringBuilder();
                for(int k=j+1;k<j+4&&k<strs.length-1;k++){
                    sb3=sb3.append(strs[k]+"");
                    if(k<=strs.length-5)continue;
                    if(strs.length==k+4&&(strs[k+1]>'2'||(strs[k+1]=='2'&&strs[k+2]>'5')||(strs[k+1]=='2'&&strs[k+2]=='5'&&strs[k+3]>'5')))continue;
                    if(k==j+3&&(strs[j+1]>'2'||(strs[j+1]=='2'&&strs[j+2]>'5')||(strs[j+1]=='2'&&strs[j+2]=='5'&&strs[j+3]>'5')))continue;
                    sb4=new StringBuilder();
                    for(int l=k+1;l<strs.length;l++){
                        sb4.append(strs[l]+"");
                    }
                    String st1=sb1.toString();
                    String st2=sb2.toString();
                    String st3=sb3.toString();
                    String st4=sb4.toString();
                    if((st1.length()>1&&st1.charAt(0)=='0')||(st2.length()>1&&st2.charAt(0)=='0')||(st3.length()>1&&st3.charAt(0)=='0')||(st4.length()>1&&st4.charAt(0)=='0'))continue;
                    result.add(st1+"."+st2+"."+st3+"."+st4);
                }
            }
        }
        return result;
    }
}
