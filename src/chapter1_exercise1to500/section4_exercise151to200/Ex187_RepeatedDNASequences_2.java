package chapter1_exercise1to500.section4_exercise151to200;

import java.util.*;

/*
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
*/

//以下算法  6ms 击败100%的java提交
public class Ex187_RepeatedDNASequences_2 {
    //使用数组来做辅助容器，数组共1<<20位，数组下标转化20位2进制数，对应A，C，T，G四个字符能组成的所有十位字符串
    //两位二进制对应一个字符  00--'A'  01--'C'  10--'T'  11 --'G'
    public List<String> findRepeatedDnaSequences(String s) {
        if(s==null||s.length()<11)return new ArrayList<>();
        Set<String> set= new HashSet<>();
        boolean [] ifExist=new boolean[1<<20];
        char[]chs=s.toCharArray();
        int num=0;
        for(int i=0;i<10;i++){
            num=num<<2;
            if(chs[i]=='C'){
                num|=1;
            }else if(chs[i]=='T'){
                num|=2;
            }else if(chs[i]=='G'){
                num|=3;
            }
        }
        ifExist[num]=true;
        //用掩码截取  新的前20位二进制数
        //由于减法的优先级高于位移运算所以要加括号 先进行位移再减去1  int mask=1<<20-1 等价于  int mask=1<<(20-1);
        int mask=(1<<20)-1;
        for(int i=10;i<chs.length;i++){
            num = num << 2;
            if (chs[i] == 'C') {
                num |= 1;
            } else if (chs[i] == 'T') {
                num |= 2;
            } else if (chs[i] == 'G') {
                num |= 3;
            }
            num=num&mask;
            if(ifExist[num]==true){
                set.add(s.substring(i-9,i+1));
            }else {
                ifExist[num]=true;
            }
        }
        return new ArrayList<>(set);
    }
}
