package chapter1.section1;
/*给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
        最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
        你可以假设除了整数 0 之外，这个整数不会以零开头。*/
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if(digits==null||digits.length==0)return null;
        //从个位开始增加1，如果加的结果是10，说明有进位，上一位加一，循环，如果最后首位进位，返回新的数组
        for(int i=digits.length-1;i>=0;i--){
            digits[i]=(digits[i]+1)%10;
            if(digits[i]!=0)return digits;
        }
        if(digits[0]==0){
            int[]result=new int[digits.length+1];
            result[0]=1;
            return result;
        }
        return null;
    }
}
