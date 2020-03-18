package chapter1.section1_99;

public class AddBinary2 {
    //和第一个相比，leetCode测试用例运行时间从4ms优化到2ms，击败98%
    public String addBinary(String a, String b) {
        //保证a串要大于b串，如若不然，交换字符串
        if(b.length() > a.length()){
            String tmp = a;
            a = b;
            b = tmp;
        }
        int flag=0;
        int value=0;
        int lengthA=a.length()-1;
        int lengthB=b.length()-1;
        StringBuilder sb = new StringBuilder();
        for(int i=lengthB;i>=0;i--){
            value=(int)a.charAt(lengthA-lengthB+i)+(int)b.charAt(i)-96+flag;
            flag=value/2;
            value=value%2;
            sb.append(value);
        }
        for(int i=lengthA-lengthB-1;i>=0;i--){
            if(flag==0){
                sb.append(a.charAt(i));
            }else{
                value=(int)a.charAt(i)-48+flag;
                flag=value/2;
                value=value%2;
                sb.append(value);
            }
        }
        if(flag==1)sb.append(1);
        return sb.reverse().toString();
    }
}
