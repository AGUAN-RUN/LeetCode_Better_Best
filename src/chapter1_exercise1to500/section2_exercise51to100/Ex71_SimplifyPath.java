package chapter1_exercise1to500.section2_exercise51to100;

import java.util.ArrayList;
import java.util.List;

public class Ex71_SimplifyPath {
    //遍历几遍解决
    //注意  .  /  两个特殊字符,    记录上一个/的位置(不一定需要)
    //假定输入字符串的格式都是正确的
    public String simplifyPath(String path) {
        int len=path.length();
        List<Character> sb=new ArrayList<Character>();
        sb.add('/');
        for(int i=1;i<len;i++){
            if(path.charAt(i)=='/'){
                if(sb.get(sb.size()-1)!='/'){
                    sb.add('/');
                }
            }else if(path.charAt(i)=='.'){
                if((i+1)<len&&path.charAt(i+1)=='.'&&sb.get(sb.size()-1)=='/'&&((i+2)>=len||path.charAt(i+2)=='/')){
                    removeRange(sb);
                    i++;
                }else if(sb.get(sb.size()-1)!='/'||((i+1)<len&&path.charAt(i+1)!='/')){
                    sb.add(path.charAt(i));
                }
            }else{
                sb.add(path.charAt(i));
            }
        }
        if(sb.size()>1&&sb.get(sb.size()-1)=='/')sb.remove(sb.size()-1);
        StringBuilder result=new StringBuilder();
        for(int i=0;i<sb.size();i++){
            result.append(sb.get(i));
        }
        return result.toString();
    }
    public void removeRange(List<Character>sb){
        if(sb.size()>1){
            sb.remove(sb.size()-1);
            while(sb.size()>1&&sb.get(sb.size()-1)!='/'){
                sb.remove(sb.size()-1);
            }
        }
    }
}
