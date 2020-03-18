package chapter1.section1_99;
/*给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式*/
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if(num1==null||num2==null)return null;
        if(num1.equals("0")||num2.equals("0"))return "0";
        char[]char1=num1.toCharArray();
        char[]char2=num2.toCharArray();
        //初始化result数组
        int[]result=new int[char1.length+char2.length];
        for(int i=0;i<result.length;i++){
            result[i]=0;
        }
        int flag=0;
        int val;
        int index=0;
        //将字符串相乘分解为两个字符串的每一位相乘的结果相加，用result数组添加实现每次运算后的结果，flag为进位
        for(int i=char1.length-1;i>=0;i--){
            for(int j=char2.length-1;j>=0;j--){
                index=char1.length+char2.length-2-i-j;
                val=(int)((char1[i]-48)*(char2[j]-48))+flag+result[index];
                result[index]=val%10;
                flag=val/10;
            }
            if(flag!=0)result[++index]=flag;
            flag=0;
        }
        //使用StringBuild来拼接字符串，最终只产生一个String，而不是拼接很多个String对象，增加效率，避免创建很多不必要的String
        StringBuilder sb=new StringBuilder();
        for(int i=index;i>=0;i--){
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s1="123";
        String s2="456";
        String result=new MultiplyStrings().multiply(s1,s2);
        System.out.println(result);
    }
}
