package chapter1_exercise1to500.section2_exercise51to100;

import java.util.ArrayList;
import java.util.List;
/*
以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。

在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径

请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。

 

示例 1：

输入："/home/"
输出："/home"
解释：注意，最后一个目录名后面没有斜杠。
示例 2：

输入："/../"
输出："/"
解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
示例 3：

输入："/home//foo/"
输出："/home/foo"
解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
示例 4：

输入："/a/./b/../../c/"
输出："/c"
示例 5：

输入："/a/../../b/../c//.//"
输出："/c"
示例 6：

输入："/a//b////c/d//././/.."
输出："/a/b/c"


* */

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
